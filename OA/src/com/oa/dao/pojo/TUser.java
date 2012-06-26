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
	private TData department = new TData();
	private TData job = new TData();
	private String password;
	private String realname;
	private Date addtime;
	private String sex;
	private TData city;
	private Boolean married;
	private String idcard;
	private String phone;
	private String handset;
	private String email;
	private String address;
	private Boolean del;

	private Set<TRole> roles = new HashSet<TRole>();
	private Set<OaQuestionnaire> questionnaires = new HashSet<OaQuestionnaire>();
	private Set<OaQuestionnaire> fkquestionnaire = new HashSet<OaQuestionnaire>();
	private TTips tips;

	@Override
	public int hashCode() {
		return userid.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof TUser) {
			return obj.hashCode() == this.hashCode();
		}
		return false;
	}

	// Constructors

	/** default constructor */
	public TUser() {
	}

	public TUser(String userid) {
		this.userid = userid;
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

	public void setCity(TData city) {
		this.city = city;
	}

	public TData getCity() {
		return city;
	}

	public Set<OaQuestionnaire> getQuestionnaires() {
		return questionnaires;
	}

	public void setQuestionnaires(Set<OaQuestionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}

	public Set<OaQuestionnaire> getFkquestionnaire() {
		return fkquestionnaire;
	}

	public void setFkquestionnaire(Set<OaQuestionnaire> fkquestionnaire) {
		this.fkquestionnaire = fkquestionnaire;
	}

}