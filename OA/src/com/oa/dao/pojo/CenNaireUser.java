package com.oa.dao.pojo;

/**
 * CenNaireUser entity. @author MyEclipse Persistence Tools
 */

public class CenNaireUser implements java.io.Serializable {

	// Fields

	private CenNaireUserId id;
	private String naireAnswer;
	// Constructors

	/** default constructor */
	public CenNaireUser() {
	}

	/** full constructor */
	public CenNaireUser(CenNaireUserId id) {
		this.id = id;
	}

	// Property accessors

	public CenNaireUserId getId() {
		return this.id;
	}

	public void setId(CenNaireUserId id) {
		this.id = id;
	}

	public String getNaireAnswer() {
		return naireAnswer;
	}

	public void setNaireAnswer(String naireAnswer) {
		this.naireAnswer = naireAnswer;
	}

}