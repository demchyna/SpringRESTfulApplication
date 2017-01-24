package com.softserve.academy.mappers;

import com.softserve.academy.models.Phone;
import com.softserve.academy.models.Role;
import com.softserve.academy.models.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    String ADD_USER = "INSERT INTO user(login, password, create_date, phone_id) VALUES (#{login}, #{password}, #{createDate}, #{phone.id})";
    String GET_USER_BY_ID = "SELECT id, login, password, create_date, phone_id FROM user WHERE id = #{id}";
    String UPDATE_USER = "UPDATE user SET login = #{login}, password = #{password}, create_date = #{createDate}, phone_id = #{phone.id} WHERE id = #{id}";
    String DELETE_USER = "DELETE FROM user WHERE id = #{id}";
    String GET_ALL_USERS = "SELECT id, login, password, create_date, phone_id FROM user";

    @Insert(ADD_USER)
    public void addUser(User user);

    @Select(GET_USER_BY_ID)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "phone", column = "phone_id", javaType = Phone.class, one = @One(select = "com.softserve.academy.mappers.PhoneMapper.getPhoneByUserId")),
            @Result(property = "posts", column = "id", javaType = List.class, many = @Many(select = "com.softserve.academy.mappers.BlogMapper.getPostsByUserId")),
            @Result(property = "roles", column = "id", javaType = List.class, many = @Many(select = "com.softserve.academy.mappers.RoleMapper.getRolesByUserId"))
    })
    public User getUserById(int id);

    @Update(UPDATE_USER)
    public void updateUser(User user);

    @Delete(DELETE_USER)
    public void deleteUser(int id);

    @Select(GET_ALL_USERS)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "phone", column = "phone_id", javaType = Phone.class, one = @One(select = "com.softserve.academy.mappers.PhoneMapper.getPhoneByUserId")),
            @Result(property = "posts", column = "id", javaType = List.class, many = @Many(select = "com.softserve.academy.mappers.BlogMapper.getPostsByUserId")),
            @Result(property = "roles", column = "id", javaType = List.class, many = @Many(select = "com.softserve.academy.mappers.RoleMapper.getRolesByUserId"))
    })
    public List<User> getAllUsers();



    String GET_USERS_BY_ROLE_ID = "SELECT user.id, login, password, create_date, phone_id FROM user_role JOIN user ON user_id = user.id JOIN role ON role_id=role.id  WHERE role.id = #{roleId}";

    @Select(GET_USERS_BY_ROLE_ID)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "phone", column = "phone_id", javaType = Phone.class, one = @One(select = "com.softserve.academy.mappers.PhoneMapper.getPhoneByUserId")),
            @Result(property = "posts", column = "id", javaType = List.class, many = @Many(select = "com.softserve.academy.mappers.BlogMapper.getPostsByUserId")),
    })
    public List<User> getUsersByRoleId(int roleId);

    String GET_USER_BY_POST_ID = "SELECT id, login, password, create_date, phone_id FROM user WHERE id = #{postId}";

    @Select(GET_USER_BY_POST_ID)
    @Results(value = {
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "phone", column = "phone_id", javaType = Phone.class, one = @One(select = "com.softserve.academy.mappers.PhoneMapper.getPhoneByUserId")),
            @Result(property = "roles", column = "id", javaType = List.class, many = @Many(select = "com.softserve.academy.mappers.RoleMapper.getRolesByUserId"))
    })
    public User getUserByPostId(int postId);
}
