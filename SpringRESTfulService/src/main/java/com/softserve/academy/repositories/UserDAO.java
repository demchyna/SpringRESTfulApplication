package com.softserve.academy.repositories;

import com.softserve.academy.factories.ConnectionFactory;
import com.softserve.academy.factories.dbconnection.ConnectionType;
import com.softserve.academy.models.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {

    Connection connect = ConnectionFactory.getDBConnection(ConnectionType.CONNECTION_POOL);

    public void addUser(User user) {

        try {
            PreparedStatement pstmt = connect.prepareStatement("INSERT INTO user(login, password, createDate) VALUES (?, ?, ?)");
            pstmt.setString(1, user.getLogin());
            pstmt.setString(2, user.getPassword());
            pstmt.setTimestamp(3, new Timestamp(user.getCreateDate().getTime()));
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int id) {

        User user = null;

        try {
            PreparedStatement pstmt = connect.prepareStatement("SELECT id, login, password, createDate FROM user WHERE id = ?");
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setLogin(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setCreateDate(rs.getTimestamp(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateUser(int id, User user) {

        try {
            PreparedStatement pstmt = connect.prepareStatement("UPDATE user SET login = ?, password = ?, createDate = ? WHERE id = ?");
            pstmt.setString(1, user.getLogin());
            pstmt.setString(2, user.getPassword());
            pstmt.setTimestamp(3, user.getCreateDate());
            pstmt.setInt(4, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int deleteUser(int id) {

        int rowCount = 0;

        try {
            PreparedStatement pstmt = connect.prepareStatement("DELETE FROM user WHERE id = ?");
            pstmt.setInt(1, id);
            rowCount = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public List<User> getAllUsers() {

        List<User> users = null;
        User user;

        try {
            PreparedStatement pstmt = connect.prepareStatement("SELECT id, login, password, createDate FROM user");
            ResultSet rs = pstmt.executeQuery();

            users = new ArrayList<>();

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setLogin(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setCreateDate(rs.getTimestamp(4));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}