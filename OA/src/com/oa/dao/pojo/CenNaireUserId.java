package com.oa.dao.pojo;

/**
 * CenNaireUserId entity. @author MyEclipse Persistence Tools
 */

public class CenNaireUserId implements java.io.Serializable {

	// Fields

	private TUser user;
	private OaQuestionnaire oaQuestionnaire;

	// Constructors

	/** default constructor */
	public CenNaireUserId() {
	}

	/** full constructor */
	public CenNaireUserId(TUser user, OaQuestionnaire oaQuestionnaire) {
		this.user = user;
		this.oaQuestionnaire = oaQuestionnaire;
	}

	// Property accessors

	

	public OaQuestionnaire getOaQuestionnaire() {
		return this.oaQuestionnaire;
	}

	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	public void setOaQuestionnaire(OaQuestionnaire oaQuestionnaire) {
		this.oaQuestionnaire = oaQuestionnaire;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CenNaireUserId))
			return false;
		CenNaireUserId castOther = (CenNaireUserId) other;

		return ((this.getUser() == castOther.getUser()) || (this.getUser() != null
				&& castOther.getUser() != null && this.getUser().equals(
				castOther.getUser())))
				&& ((this.getOaQuestionnaire() == castOther
						.getOaQuestionnaire()) || (this.getOaQuestionnaire() != null
						&& castOther.getOaQuestionnaire() != null && this
						.getOaQuestionnaire().equals(
								castOther.getOaQuestionnaire())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUser() == null ? 0 : this.getUser().hashCode());
		result = 37
				* result
				+ (getOaQuestionnaire() == null ? 0 : this.getOaQuestionnaire()
						.hashCode());
		return result;
	}

}