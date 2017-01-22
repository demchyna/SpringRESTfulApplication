package com.softserve.academy.mappers;

import com.softserve.academy.models.Phone;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper {

    String getById = "SELECT id, role_name FROM role WHERE id = #{id}";

    @Select(getById)
    public Phone getRoleById(int id);
}
