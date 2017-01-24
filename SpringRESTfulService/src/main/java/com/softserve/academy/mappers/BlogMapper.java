package com.softserve.academy.mappers;

import com.softserve.academy.models.Blog;
import com.softserve.academy.models.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BlogMapper {

    String GET_POST_BY_ID = "SELECT id, post_name, post_text, user_id FROM blog WHERE id = #{id}";

    @Select(GET_POST_BY_ID)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "postName", column = "post_name"),
            @Result(property = "postText", column = "post_text"),
            @Result(property = "user", column = "user_id", javaType = User.class, one = @One(select = "com.softserve.academy.mappers.UserMapper.getUserByPostId"))
    })
    public Blog getPostById(int id);


    String GET_POST_BY_USER_ID = "SELECT id, post_name, post_text FROM blog WHERE user_id = #{userId}";

    @Select(GET_POST_BY_USER_ID)
    @Results(value = {
            @Result(property = "postName", column = "post_name"),
            @Result(property = "postText", column = "post_text")
    })
    public List<Blog> getPostsByUserId(int userId);

}
