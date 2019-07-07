package com.haoyi.educlass.mapper;

import com.haoyi.educlass.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id=#{id}")
    User findById(@Param("id") int id);

    @Select("select * from user where openid=#{openid}")
    User findByopenid(@Param("openid") int openid);

    @Insert("INSERT INTO `user`( `openid`, `name`, `head_img`, `phone`, `sign`, `sex`, `city`, `create_time`) " +
            "VALUES (#{openid},#{name},#{headImg},#{phone},#{sign},#{sex},#{city},#{createTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int save(User user);
}
