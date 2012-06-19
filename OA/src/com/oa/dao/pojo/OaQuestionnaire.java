package com.oa.dao.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * OaQuestionnaire entity. @author MyEclipse Persistence Tools
 */

public class OaQuestionnaire implements java.io.Serializable {

	// Fields

	private Integer qid;
	private TUser user;
	private String qname;
	private Date createtime;
	private Date startdate;
	private Date stopdate;
	private String explain;
	private String publish;
	private String naireDelid;
	private Set<OaQuestion> questions = new HashSet<OaQuestion>();
	private Set<TUser> users = new HashSet<TUser>();
	private Set cenNaireUsers = new HashSet(0);

	// Constructors

	/** default constructor */
	public OaQuestionnaire() {
	}

	/** minimal constructor */
	public OaQuestionnaire(Integer qid) {
		this.qid = qid;
	}

	/** full constructor */
	public OaQuestionnaire(Integer qid,  String qname,
			Date createtime, Date startdate, Date stopdate, String explain,
			String publish, String naireDelid) {
		this.qid = qid;
		
		this.qname = qname;
		this.createtime = createtime;
		this.startdate = startdate;
		this.stopdate = stopdate;
		this.explain = explain;
		this.publish = publish;
		this.naireDelid = naireDelid;
		
	}

	// Property accessors

	public Integer getQid() {
		return this.qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getStopdate() {
		return stopdate;
	}

	public void setStopdate(Date stopdate) {
		this.stopdate = stopdate;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public String getNaireDelid() {
		return naireDelid;
	}

	public void setNaireDelid(String naireDelid) {
		this.naireDelid = naireDelid;
	}

	public Set<OaQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<OaQuestion> questions) {
		this.questions = questions;
	}

	public Set<TUser> getUsers() {
		return users;
	}

	public void setUsers(Set<TUser> users) {
		this.users = users;
	}

	public Set getCenNaireUsers() {
		return cenNaireUsers;
	}

	public void setCenNaireUsers(Set cenNaireUsers) {
		this.cenNaireUsers = cenNaireUsers;
	}

	

}