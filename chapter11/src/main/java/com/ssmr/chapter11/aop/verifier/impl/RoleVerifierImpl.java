package com.ssmr.chapter11.aop.verifier.impl;

import com.ssmr.chapter11.aop.verifier.RoleVerifier;
import com.ssmr.chapter11.game.pojo.Role;

public class RoleVerifierImpl implements RoleVerifier {
    @Override
    public boolean verify(Role role) {
        return role != null;
    }
}
