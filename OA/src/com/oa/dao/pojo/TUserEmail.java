package com.oa.dao.pojo;

/**
 * TUserEmail entity. @author MyEclipse Persistence Tools
 */

public class TUserEmail implements java.io.Serializable {

	// Fields

	private TUserEmailId id;
	private Boolean type;
	private Boolean isread;

	// Constructors

	/** default constructor */
	public TUserEmail() {
	}

	/** minimal constructor */
	public TUserEmail(TUserEmailId id) {
		this.id = id;
	}

	/** full constructor */
	public TUserEmail(TUserEmailId id, Boolean type, Boolean isread) {
		this.id = id;
		this.type = type;
		this.isread = isread;
	}

	// Property accessors

	public TUserEmailId getId() {
		return this.id;
	}

	public void setId(TUserEmailId id) {
		this.id = id;
	}

	public Boolean getType() {
		return this.type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public Boolean getIsread() {
		return this.isread;
	}

	public void setIsread(Boolean isread) {
		this.isread = isread;
	}

}