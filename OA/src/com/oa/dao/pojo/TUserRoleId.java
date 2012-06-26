package com.oa.dao.pojo;

/**
 * TUserRoleId entity. @author MyEclipse Persistence Tools
 */

public class TUserRoleId implements java.io.Serializable {

	// Fields

	private TUser user;
	private TRole role;

	// Constructors

	/** default constructor */
	public TUserRoleId() {
	}

	/** full constructor */
	public TUserRoleId(TUser user, TRole role) {
		this.setUser(user);
		this.setRole(role);
	}

	// Property accessors


	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TUserRoleId))
			return false;
		TUserRoleId castOther = (TUserRoleId) other;

		return ((this.getUser() == castOther.getUser()) || (this.getUser() != null
				&& castOther.getUser() != null && this.getUser().equals(
				castOther.getUser())))
				&& ((this.getRole() == castOther.getRole()) || (this
						.getRole() != null
						&& castOther.getRole() != null && this.getRole()
						.equals(castOther.getRole())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUser() == null ? 0 : this.getUser().hashCode());
		result = 37 * result
				+ (getRole() == null ? 0 : this.getRole().hashCode());
		return result;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	public TUser getUser() {
		return user;
	}

	public void setRole(TRole role) {
		this.role = role;
	}

	public TRole getRole() {
		return role;
	}

}