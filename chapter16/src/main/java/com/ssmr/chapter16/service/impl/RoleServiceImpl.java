package com.ssmr.chapter16.service.impl;

import com.ssmr.chapter16.dao.RoleDao;
import com.ssmr.chapter16.pojo.Role;
import com.ssmr.chapter16.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    @Override
    public Role getRole(Long id) {
        return roleDao.getRole(id);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    @Override
    public int updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    @Override
    public int updateRoleArr(List<Role> roleList) {
        int count = 0;
        for (Role role: roleList) {
            count += this.updateRole(role);
        }
        return count;
    }
}
