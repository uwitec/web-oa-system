package com.oa.dao.pojo;

/**
 * TUserPost entity. @author MyEclipse Persistence Tools
 */

public class TUserPost implements java.io.Serializable {

	// Fields

	private TUserPostId id;

	// Constructors

	/** default constructor */
	public TUserPost() {
	}

	/** full constructor */
	public TUserPost(TUserPostId id) {
		this.id = id;
	}

	// Property accessors

	public TUserPostId getId() {
		return this.id;
	}

	public void setId(TUserPostId id) {
		this.id = id;
	}

}