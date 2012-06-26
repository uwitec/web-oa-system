package com.oa.dao.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * TData entity. @author MyEclipse Persistence Tools
 */

public class TData implements java.io.Serializable {

	// Fields

	private Integer dataid;
	private String dataname;
	private Boolean del;
	private Integer type;
	private Set TUsersForJob = new HashSet(0);
	private Set<TUser> departmentUsers = new HashSet<TUser>(0); 
	private Set<TData> datas = new HashSet<TData>(0);

	// Constructors

	/** default constructor */
	public TData() {
		dataid = 0;
	}

	/** full constructor */
	public TData(TData TData, String dataname, Boolean del, Integer type,
			Set TUsersForJob, Set TUsersForDepartment, Set datas) {
		this.dataname = dataname;
		this.del = del;
		this.setType(type);
		this.TUsersForJob = TUsersForJob;
		this.datas = datas;
	}

	// Property accessors

	public Integer getDataid() {
		return this.dataid;
	}

	public void setDataid(Integer dataid) {
		this.dataid = dataid;
	}


	public String getDataname() {
		return this.dataname;
	}

	public void setDataname(String dataname) {
		this.dataname = dataname;
	}

	public Boolean getDel() {
		return this.del;
	}

	public void setDel(Boolean del) {
		this.del = del;
	}


	public Set getTUsersForJob() {
		return this.TUsersForJob;
	}

	public void setTUsersForJob(Set TUsersForJob) {
		this.TUsersForJob = TUsersForJob;
	}



	public void setDatas(Set<TData> datas) {
		this.datas = datas;
	}

	public Set<TData> getDatas() {
		return datas;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	public void setDepartmentUsers(Set<TUser> departmentUsers) {
		this.departmentUsers = departmentUsers;
	}

	public Set<TUser> getDepartmentUsers() {
		return departmentUsers;
	}

}