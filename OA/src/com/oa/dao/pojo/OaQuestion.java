package com.oa.dao.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * OaQuestion entity. @author MyEclipse Persistence Tools
 */

public class OaQuestion implements java.io.Serializable {

// Fields

	
	private Integer questionId;
	private String questionName;
	private String questionType;
	private String questionDeltype;	
	private Set<OaQuestionnaire> questionnaires = new HashSet<OaQuestionnaire>();
	private Set<OaOptions> oaOptionses = new HashSet<OaOptions>();
	private Set<OaUserAnswers> oaUserAnswerses= new HashSet<OaUserAnswers>();
	// Constructors

	/** default constructor */
	public OaQuestion() {
	}

	/** full constructor */
	public OaQuestion(String questionName, String questionType,
			String questionDeltype) {
		this.questionName = questionName;
		this.questionType = questionType;
		this.questionDeltype = questionDeltype;
		
	}

	public String getQuestionDeltype() {
		return questionDeltype;
	}

	public void setQuestionDeltype(String questionDeltype) {
		this.questionDeltype = questionDeltype;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public Set<OaQuestionnaire> getQuestionnaires() {
		return questionnaires;
	}

	public void setQuestionnaires(Set<OaQuestionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}

	public Set<OaOptions> getOaOptionses() {
		return oaOptionses;
	}

	public void setOaOptionses(Set<OaOptions> oaOptionses) {
		this.oaOptionses = oaOptionses;
	}

	public Set<OaUserAnswers> getOaUserAnswerses() {
		return oaUserAnswerses;
	}

	public void setOaUserAnswerses(Set<OaUserAnswers> oaUserAnswerses) {
		this.oaUserAnswerses = oaUserAnswerses;
	}


}