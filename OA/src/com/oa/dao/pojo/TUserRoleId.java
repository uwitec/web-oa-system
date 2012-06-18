package com.oa.dao.pojo;

/**
 * TUserRoleId entity. @author MyEclipse Persistence Tools
 */

public class TUserRoleId implements java.io.Serializable {

	// Fields

	private TUser TUser;
	private TRole TRole;

	// Constructors

	/** default constructor */
	public TUserRoleId() {
	}

	/** full constructor */
	public TUserRoleId(TUser TUser, TRole TRole) {
		this.TUser = TUser;
		this.TRole = TRole;
	}

	// Property accessors

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public TRole getTRole() {
		return this.TRole;
	}

	public void setTRole(TRole TRole) {
		this.TRole = TRole;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TUserRoleId))
			return false;
		TUserRoleId castOther = (TUserRoleId) other;

		return ((this.getTUser() == castOther.getTUser()) || (this.getTUser() != null
				&& castOther.getTUser() != null && this.getTUser().equals(
				castOther.getTUser())))
				&& ((this.getTRole() == castOther.getTRole()) || (this
						.getTRole() != null
						&& castOther.getTRole() != null && this.getTRole()
						.equals(castOther.getTRole())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTUser() == null ? 0 : this.getTUser().hashCode());
		result = 37 * result
				+ (getTRole() == null ? 0 : this.getTRole().hashCode());
		return result;
	}

}