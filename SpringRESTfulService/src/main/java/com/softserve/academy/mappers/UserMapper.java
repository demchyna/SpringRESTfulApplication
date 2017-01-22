package com.softserve.academy.mappers;

import com.softserve.academy.models.Phone;
import com.softserve.academy.models.Role;
import com.softserve.academy.models.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    String addUser = "INSERT INTO user(login, password, create_date) VALUES (#{login}, #{password}, #{createDate})";
    String getUserById = "SELECT user.id, login, password, phone_number FROM user LEFT JOIN phone ON user.phone_id = phone.id WHERE user.id = #{id}";
    String updateUser = "UPDATE user SET login = #{login}, password = #{password}, create_date = #{createDate} WHERE id = #{id}";
    String deleteUser = "DELETE FROM user WHERE id = #{id}";
    String getAllUsers = "SELECT * FROM user";
    String getUserByPhone = "SELECT user.id, login, create_date, phone.phone_number FROM phone LEFT JOIN user ON phone.id = user.phone_id WHERE phone_number = #{phoneNumber}";
    String getUsersByRole = "SELECT user.id, login, create_date, role.role_name FROM role LEFT JOIN user ON role.id = user.role_id WHERE role_name = #{roleName}";

    @Insert(addUser)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void addUser(User user);

    @Select(getUserById)
    @Results(value = {
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "phone", column = "phone_id", javaType = Phone.class, one = @One(select = "com.softserve.academy.mappers.PhoneMapper.getPhoneById"))
    })

    public User getUserById(int id);

    @Update(updateUser)
    public void updateUser(User user);

    @Delete(deleteUser)
    public void deleteUser(int id);

    @Select(getAllUsers)
    @Results(value = { @Result(property = "createDate", column = "create_date") })
    public List<User> getAllUsers();

    @Select(getUserByPhone)
    @Results(value = {
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "phone", column = "phone_id", javaType = Phone.class, one = @One(select = "com.softserve.academy.mappers.PhoneMapper.getPhoneById"))
    })
    public User getUserByPhone(int phone);

    @Select(getUsersByRole)
    @Results(value = {
            @Result(property = "createDate", column = "create_date"),
            @Result(property="role", column="role_id", javaType = Role.class,  one = @One(select="com.softserve.academy.mappers.PhoneMapper.getRole"))
    })
    public List<User> getUsersByRole(String role);




}
