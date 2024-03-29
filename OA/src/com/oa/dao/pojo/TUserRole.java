package com.oa.dao.pojo;

/**
 * TUserRole entity. @author MyEclipse Persistence Tools
 */

public class TUserRole implements java.io.Serializable {

	// Fields

	private TUserRoleId id;

	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return id.equals(obj);
	}

	// Constructors

	/** default constructor */
	public TUserRole() {
	}

	/** full constructor */
	public TUserRole(TUserRoleId id) {
		this.id = id;
	}

	// Property accessors

	public TUserRoleId getId() {
		return this.id;
	}

	public void setId(TUserRoleId id) {
		this.id = id;
	}

}