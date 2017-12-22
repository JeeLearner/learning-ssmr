package com.ssmr.chapter05.dao;

import com.ssmr.chapter05.pojo.User;

import java.util.List;

public interface UserDao {
    public User getUser(Long id);

    public List<User> findUserByRoleId(Long roleId);
}
