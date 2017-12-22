package com.ssmr.chapter05.dao;

import com.ssmr.chapter05.pojo.WorkCard;

public interface WorkCardDao {

	public WorkCard getWorkCardByEmpId(Long empId);
}
