package com.ssmr.chapter03.dao;

import com.ssmr.chapter03.pojo.Role;
import org.apache.ibatis.annotations.Select;

public interface RoleDao_anno {

    /**
     * 注解实现映射器(不推荐)
     * @param id
     * @return
     */
    @Select("select id, role_name as roleName, note from t_role where id=#{id}")
    public Role getRole(Long id);
}
