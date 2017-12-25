package com.ssmr.chapter05.testcache;

import com.ssmr.chapter05.pojo.User;

import java.io.Serializable;
import java.util.List;

public class Role2 implements Serializable {

    private static final long serialVersionUID = 598736524547906734L;

    private Long id;
    private String roleName;
    private String note;

    /** getter/setter **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}

