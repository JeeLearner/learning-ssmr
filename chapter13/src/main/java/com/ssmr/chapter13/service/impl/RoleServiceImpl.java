package com.ssmr.chapter13.service.impl;

import com.ssmr.chapter13.dao.RoleDao;
import com.ssmr.chapter13.pojo.Role;
import com.ssmr.chapter13.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public int insertRole(Role role) {
        return roleDao.insertRole(role);
    }
}
