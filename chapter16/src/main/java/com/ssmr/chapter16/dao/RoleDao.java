package com.ssmr.chapter16.dao;

import com.ssmr.chapter16.pojo.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao {

    public Role getRole(Long id);

    public int updateRole(Role role);
}
