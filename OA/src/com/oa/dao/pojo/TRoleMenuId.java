package com.oa.dao.pojo;

/**
 * TRoleMenuId entity. @author MyEclipse Persistence Tools
 */

public class TRoleMenuId implements java.io.Serializable {

	// Fields

	private TRole TRole;
	private TMenu TMenu;

	// Constructors

	/** default constructor */
	public TRoleMenuId() {
	}

	/** full constructor */
	public TRoleMenuId(TRole TRole, TMenu TMenu) {
		this.TRole = TRole;
		this.TMenu = TMenu;
	}

	// Property accessors

	public TRole getTRole() {
		return this.TRole;
	}

	public void setTRole(TRole TRole) {
		this.TRole = TRole;
	}

	public TMenu getTMenu() {
		return this.TMenu;
	}

	public void setTMenu(TMenu TMenu) {
		this.TMenu = TMenu;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TRoleMenuId))
			return false;
		TRoleMenuId castOther = (TRoleMenuId) other;

		return ((this.getTRole() == castOther.getTRole()) || (this.getTRole() != null
				&& castOther.getTRole() != null && this.getTRole().equals(
				castOther.getTRole())))
				&& ((this.getTMenu() == castOther.getTMenu()) || (this
						.getTMenu() != null
						&& castOther.getTMenu() != null && this.getTMenu()
						.equals(castOther.getTMenu())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTRole() == null ? 0 : this.getTRole().hashCode());
		result = 37 * result
				+ (getTMenu() == null ? 0 : this.getTMenu().hashCode());
		return result;
	}

}