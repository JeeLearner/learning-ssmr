package com.ssmr.chapter05.pojo;

import java.util.Date;

public class PdCountRoleParams {

	private String roleName;
	private int total;
	private Date execDate;

	/** getter/setter **/
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Date getExecDate() {
		return execDate;
	}
	public void setExecDate(Date execDate) {
		this.execDate = execDate;
	}
	
}
