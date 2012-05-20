package com.oa.dao.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable {

	// Fields

	private String userid;
	private TData department;
	private TData job;
	private String password;
	private String realname;
	private Date addtime;
	private String sex;
	private Integer city;
	private Boolean married;
	private String idcard;
	private String phone;
	private String handset;
	private String email;
	private String address;
	private Boolean del;

	private Set<TRole> roles = new HashSet<TRole>(0);
	private TTips tips;

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(String userid, String password) {
		this.userid = userid;
		this.password = password;
	}

	public TUser(String userid, String realname, TData department, TData job,
			Date addtime) {
		this.userid = userid;
		this.realname = realname;
		this.department = department;
		this.job = job;
		this.addtime = addtime;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public TData getDepartment() {
		return department;
	}

	public void setDepartment(TData department) {
		this.department = department;
	}

	public TData getJob() {
		return job;
	}

	public void setJob(TData job) {
		this.job = job;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public Boolean getMarried() {
		return married;
	}

	public void setMarried(Boolean married) {
		this.married = married;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHandset() {
		return handset;
	}

	public void setHandset(String handset) {
		this.handset = handset;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getDel() {
		return del;
	}

	public void setDel(Boolean del) {
		this.del = del;
	}

	public Set<TRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<TRole> roles) {
		this.roles = roles;
	}

	public TTips getTips() {
		return tips;
	}

	public void setTips(TTips tips) {
		this.tips = tips;
	}

}