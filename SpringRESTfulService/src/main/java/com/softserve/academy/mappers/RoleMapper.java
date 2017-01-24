package com.softserve.academy.mappers;

import com.softserve.academy.models.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleMapper {

    String GET_ROLE_BY_ID = "SELECT id, role_name FROM role WHERE id = #{id}";

    @Select(GET_ROLE_BY_ID)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "users", column = "id", javaType = List.class, many = @Many(select = "com.softserve.academy.mappers.UserMapper.getUsersByRoleId"))
    })
    public Role getRoleById(int id);


    String GET_ROLES_BY_USER_ID ="SELECT role.id, role_name FROM user_role JOIN role ON role_id = role.id JOIN user ON user_id = user.id WHERE user.id = #{userId}";

    @Select(GET_ROLES_BY_USER_ID)
    @Results(value = {
            @Result(property = "roleName", column = "role_name")
    })
    public List<Role> getRolesByUserId(int userId);
}
