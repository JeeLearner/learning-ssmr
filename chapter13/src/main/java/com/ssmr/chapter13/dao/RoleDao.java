package com.ssmr.chapter13.dao;

import com.ssmr.chapter13.pojo.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao {

    public int insertRole(Role role);
}
