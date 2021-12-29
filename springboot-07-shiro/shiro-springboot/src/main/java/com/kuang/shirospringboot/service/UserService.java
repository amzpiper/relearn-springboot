package com.kuang.shirospringboot.service;

import com.kuang.shirospringboot.pojo.User;

public interface UserService {

    public User queryUserByName(String username);
}
