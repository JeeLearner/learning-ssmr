package com.ssmr.chapter10.el.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("elBean")
public class ElBean {
	
    //通过beanName获取bean，然后注入
	@Value("#{role}")
	private Role role;
	
    //获取bean的属性id
	@Value("#{role.id}")
	private Long id;
	
    //调用bean的getNote方法，获取角色名称
	@Value("#{role.getNote()?.toString()}")
	private String note;

	/**
	 * 使用类的静态常量和方法
	 */
	//@Value("#{T(Math).PI}")
	@Value("#{T(java.lang.Math).PI}")
	private double pi;

	@Value("#{T(Math).random()}")
	private double random;

	/**
	 * Spring EL运算
	 */
	@Value("#{role.id+1}")
	private int num;
	@Value("#{role.roleName + role.note}")
	private String str;

	@Value("#{role.id == 1}")
	private boolean equalNum;
	@Value("#{role.note eq 'note_1'}")
	private boolean equalString;
	@Value("#{role.id > 2}")
	private boolean greater;
	@Value("#{role.id < 2}")
	private boolean less;

	//int max = (role.getId()>1? 5:1);
	@Value("#{role.id >1? 5:1}")
	private int max;

	//String getDefaultString = (role.getNote() == null? "hello" : role.getNote());
	@Value("#{role.note?: 'hello'}")
	private String defaultString;



	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public double getPi() {
		return pi;
	}

	public void setPi(double pi) {
		this.pi = pi;
	}

	public double getRandom() {
		return random;
	}

	public void setRandom(double random) {
		this.random = random;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public boolean isEqualNum() {
		return equalNum;
	}

	public void setEqualNum(boolean equalNum) {
		this.equalNum = equalNum;
	}

	public boolean isEqualString() {
		return equalString;
	}

	public void setEqualString(boolean equalString) {
		this.equalString = equalString;
	}

	public boolean isGreater() {
		return greater;
	}

	public void setGreater(boolean greater) {
		this.greater = greater;
	}

	public boolean isLess() {
		return less;
	}

	public void setLess(boolean less) {
		this.less = less;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public String getDefaultString() {
		return defaultString;
	}

	public void setDefaultString(String defaultString) {
		this.defaultString = defaultString;
	}
}
