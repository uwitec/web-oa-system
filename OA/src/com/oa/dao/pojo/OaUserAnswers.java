package com.oa.dao.pojo;



/**
 * OaUserAnswers entity. @author MyEclipse Persistence Tools
 */

public class OaUserAnswers implements java.io.Serializable {

	// Fields

	private Integer oaUserAnswerid;
	private OaQuestion oaQuestion;
	private TUser user;
	private OaQuestionnaire oaQuestionnaire;
	private OaOptions oaOptions;
	private String questionanswer;

	// Constructors

	/** default constructor */
	public OaUserAnswers() {
	
	}

	/** full constructor */
	public OaUserAnswers(OaQuestion oaQuestion, TUser user,
			OaQuestionnaire oaQuestionnaire, OaOptions oaOptions,
			String questionanswer) {
		this.oaQuestion = oaQuestion;
		this.user = user;
		this.oaQuestionnaire = oaQuestionnaire;
		this.oaOptions = oaOptions;
		this.questionanswer = questionanswer;
	}

	// Property accessors

	public Integer getOaUserAnswerid() {
		return this.oaUserAnswerid;
	}

	public void setOaUserAnswerid(Integer oaUserAnswerid) {
		this.oaUserAnswerid = oaUserAnswerid;
	}

	public OaQuestion getOaQuestion() {
		return this.oaQuestion;
	}

	public void setOaQuestion(OaQuestion oaQuestion) {
		this.oaQuestion = oaQuestion;
	}

	

	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	public OaQuestionnaire getOaQuestionnaire() {
		return this.oaQuestionnaire;
	}

	public void setOaQuestionnaire(OaQuestionnaire oaQuestionnaire) {
		this.oaQuestionnaire = oaQuestionnaire;
	}

	public OaOptions getOaOptions() {
		return this.oaOptions;
	}

	public void setOaOptions(OaOptions oaOptions) {
		this.oaOptions = oaOptions;
	}

	public String getQuestionanswer() {
		return this.questionanswer;
	}

	public void setQuestionanswer(String questionanswer) {
		this.questionanswer = questionanswer;
		
	}

}