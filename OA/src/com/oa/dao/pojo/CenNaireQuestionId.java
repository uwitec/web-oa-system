package com.oa.dao.pojo;

/**
 * CenNaireQuestionId entity. @author MyEclipse Persistence Tools
 */

public class CenNaireQuestionId implements java.io.Serializable {

	// Fields

	private OaQuestion oaQuestion;
	private OaQuestionnaire oaQuestionnaire;

	// Constructors

	/** default constructor */
	public CenNaireQuestionId() {
	}

	/** full constructor */
	public CenNaireQuestionId(OaQuestion oaQuestion,
			OaQuestionnaire oaQuestionnaire) {
		this.oaQuestion = oaQuestion;
		this.oaQuestionnaire = oaQuestionnaire;
	}

	// Property accessors

	public OaQuestion getOaQuestion() {
		return this.oaQuestion;
	}

	public void setOaQuestion(OaQuestion oaQuestion) {
		this.oaQuestion = oaQuestion;
	}

	public OaQuestionnaire getOaQuestionnaire() {
		return this.oaQuestionnaire;
	}

	public void setOaQuestionnaire(OaQuestionnaire oaQuestionnaire) {
		this.oaQuestionnaire = oaQuestionnaire;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CenNaireQuestionId))
			return false;
		CenNaireQuestionId castOther = (CenNaireQuestionId) other;

		return ((this.getOaQuestion() == castOther.getOaQuestion()) || (this
				.getOaQuestion() != null
				&& castOther.getOaQuestion() != null && this.getOaQuestion()
				.equals(castOther.getOaQuestion())))
				&& ((this.getOaQuestionnaire() == castOther
						.getOaQuestionnaire()) || (this.getOaQuestionnaire() != null
						&& castOther.getOaQuestionnaire() != null && this
						.getOaQuestionnaire().equals(
								castOther.getOaQuestionnaire())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getOaQuestion() == null ? 0 : this.getOaQuestion()
						.hashCode());
		result = 37
				* result
				+ (getOaQuestionnaire() == null ? 0 : this.getOaQuestionnaire()
						.hashCode());
		return result;
	}

}