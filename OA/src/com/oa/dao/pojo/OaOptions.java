package com.oa.dao.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * OaOptions entity. @author MyEclipse Persistence Tools
 */

public class OaOptions implements java.io.Serializable {

	// Fields

	private Integer optionId;
	private OaQuestion oaQuestion;
	private String potionName;
	private Set<TUser> users = new HashSet<TUser>();

	// Constructors

	/** default constructor */
	public OaOptions() {
	}

	/** minimal constructor */
	public OaOptions(Integer optionId) {
		this.optionId = optionId;
	}

	/** full constructor */
	public OaOptions(
			String potionName) {
		this.potionName = potionName;
		
	}

	// Property accessors

	public Integer getOptionId() {
		return this.optionId;
	}

	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}

	public OaQuestion getOaQuestion() {
		return this.oaQuestion;
	}

	public void setOaQuestion(OaQuestion oaQuestion) {
		this.oaQuestion = oaQuestion;
	}

	public String getPotionName() {
		return this.potionName;
	}

	public void setPotionName(String potionName) {
		this.potionName = potionName;
	}

	public Set<TUser> getUsers() {
		return users;
	}

	public void setUsers(Set<TUser> users) {
		this.users = users;
	}

	

}