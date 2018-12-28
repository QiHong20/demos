package com.qihong.demomybatis.mapper;

import com.qihong.demomybatis.dto.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    @Insert("insert into tb_user(name) values(#{user.name})")
    @Options(useGeneratedKeys=true,keyColumn = "id",keyProperty = "user.id")
    int insert(@Param("user") User user);
}
