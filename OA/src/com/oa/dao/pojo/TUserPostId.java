package com.oa.dao.pojo;

/**
 * TUserPostId entity. @author MyEclipse Persistence Tools
 */

public class TUserPostId implements java.io.Serializable {

	// Fields

	private TUser tUser;
	private TPost tPost;

	// Constructors

	/** default constructor */
	public TUserPostId() {
	}

	/** full constructor */
	public TUserPostId(TUser tUser, TPost tPost) {
		this.tUser = tUser;
		this.tPost = tPost;
	}

	// Property accessors



	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TUserPostId))
			return false;
		TUserPostId castOther = (TUserPostId) other;

		return ((this.gettUser() == castOther.gettUser()) || (this.gettUser() != null
				&& castOther.gettUser() != null && this.gettUser().equals(
				castOther.gettUser())))
				&& ((this.gettPost() == castOther.gettPost()) || (this
						.gettPost() != null
						&& castOther.gettPost() != null && this.gettPost()
						.equals(castOther.gettPost())));
	}

	public TUser gettUser() {
		return tUser;
	}

	public void settUser(TUser tUser) {
		this.tUser = tUser;
	}

	public TPost gettPost() {
		return tPost;
	}

	public void settPost(TPost tPost) {
		this.tPost = tPost;
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (gettUser() == null ? 0 : this.gettUser().hashCode());
		result = 37 * result
				+ (gettPost() == null ? 0 : this.gettPost().hashCode());
		return result;
	}

}