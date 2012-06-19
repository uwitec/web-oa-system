package com.oa.dao.pojo;

/**
 * CenNaireQuestion entity. @author MyEclipse Persistence Tools
 */

public class CenNaireQuestion implements java.io.Serializable {

	// Fields

	private CenNaireQuestionId id;

	// Constructors

	/** default constructor */
	public CenNaireQuestion() {
	}

	/** full constructor */
	public CenNaireQuestion(CenNaireQuestionId id) {
		this.id = id;
	}

	// Property accessors

	public CenNaireQuestionId getId() {
		return this.id;
	}

	public void setId(CenNaireQuestionId id) {
		this.id = id;
	}

}