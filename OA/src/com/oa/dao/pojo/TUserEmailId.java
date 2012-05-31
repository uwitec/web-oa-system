package com.oa.dao.pojo;

/**
 * TUserEmailId entity. @author MyEclipse Persistence Tools
 */

public class TUserEmailId implements java.io.Serializable {

	// Fields

	private TUser user;
	private TEmail email;

	// Constructors

	/** default constructor */
	public TUserEmailId() {
	}

	/** full constructor */

	// Property accessors


	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TUserEmailId))
			return false;
		TUserEmailId castOther = (TUserEmailId) other;

		return ((this.getUser() == castOther.getUser()) || (this.getUser() != null
				&& castOther.getUser() != null && this.getUser().equals(
				castOther.getUser())))
				&& ((this.getEmail() == castOther.getEmail()) || (this
						.getEmail() != null
						&& castOther.getEmail() != null && this.getEmail()
						.equals(castOther.getEmail())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUser() == null ? 0 : this.getUser().hashCode());
		result = 37 * result
				+ (getEmail() == null ? 0 : this.getEmail().hashCode());
		return result;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	public TUser getUser() {
		return user;
	}

	public void setEmail(TEmail email) {
		this.email = email;
	}

	public TEmail getEmail() {
		return email;
	}

}