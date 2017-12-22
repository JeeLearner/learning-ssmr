package com.ssmr.chapter05.dao;

import com.ssmr.chapter05.pojo.EmployeeTask;

public interface EmployeeTaskDao {

	public EmployeeTask getEmployeeTaskByEmpId(Long empId);
}
