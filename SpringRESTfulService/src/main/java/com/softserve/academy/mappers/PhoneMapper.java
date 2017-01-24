package com.softserve.academy.mappers;

import com.softserve.academy.models.Phone;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface PhoneMapper {

    String GET_PHONE_BY_USER_ID = "SELECT id, phone_number FROM phone WHERE id = #{userId}";

    @Select(GET_PHONE_BY_USER_ID)
    @Results(value = {
            @Result(property = "phoneNumber", column = "phone_number")
    })
    public Phone getPhoneByUserId(int userId);
}
