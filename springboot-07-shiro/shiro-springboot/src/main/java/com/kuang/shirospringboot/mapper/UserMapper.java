package com.kuang.shirospringboot.mapper;

import com.kuang.shirospringboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author guoyh
 */
@Repository
@Mapper
public interface UserMapper {

    public User queryUserByName(String username);
}
