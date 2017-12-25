package com.ssmr.chapter06.mapper;

import com.ssmr.chapter06.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    public List<Role> findRoles1(@Param("roleName") String roleName);
    public List<Role> findRoles2(Role role);
    public List<Role> findRoles3(Role role);
    public List<Role> findRoles4(@Param("roleName") String roleName);

    public int updateRole(Role role);
    public List<Role> findRolesByIds(@Param("idList") List<String> idList);

    public List<Role> getRoleTest(@Param("type") String type);

    public List<Role> findRoles5(String roleName);
    public List<Role> findRoles6(@Param("roleName") String roleName, @Param("note") String note);
    public List<Role> findRoles7(Role role);
}
