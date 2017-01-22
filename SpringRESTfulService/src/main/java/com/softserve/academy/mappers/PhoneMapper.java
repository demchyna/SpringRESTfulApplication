package com.softserve.academy.mappers;

import com.softserve.academy.models.Phone;
import org.apache.ibatis.annotations.Select;

public interface PhoneMapper {

    String getById = "SELECT id, phone_number FROM phone WHERE id = #{id}";

    @Select(getById)
    public Phone getPhoneById(int id);
}
