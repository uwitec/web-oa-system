package com.oa.dao.pojo;

import java.sql.Clob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



/**
 * TEmail entity. @author MyEclipse Persistence Tools
 */

public class TEmail implements java.io.Serializable {

	// Fields

	private Integer emailid;
	private TUser senduser;
	private String title;
	private Clob content;
	private String strContent;
	private String receusers;
	private Date sendtime;
	private Boolean hasfile;
	private Set<TEmailFile> emailFiles = new HashSet<TEmailFile>(0);
	private Set<TUserEmail> userEmails = new HashSet<TUserEmail>(0);

	// Constructors

	/** default constructor */
	public TEmail() {
	}

	/** full constructor */

	// Property accessors

	public Integer getEmailid() {
		return this.emailid;
	}

	public TEmail(Integer emailid, TUser tUser, String title, String content,
			String receusers, Date sendtime, Boolean hasfile,
			Set<TEmailFile> emailFiles, Set<TUserEmail> userEmails) {
		super();
		this.emailid = emailid;
		this.title = title;
		this.receusers = receusers;
		this.sendtime = sendtime;
		this.hasfile = hasfile;
		this.emailFiles = emailFiles;
		this.userEmails = userEmails;
	}

	public void setEmailid(Integer emailid) {
		this.emailid = emailid;
	}


	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getReceusers() {
		return this.receusers;
	}

	public void setReceusers(String receusers) {
		this.receusers = receusers;
	}

	public Date getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	public Boolean getHasfile() {
		return this.hasfile;
	}

	public void setHasfile(Boolean hasfile) {
		this.hasfile = hasfile;
	}


	public void setEmailFiles(Set<TEmailFile> emailFiles) {
		this.emailFiles = emailFiles;
	}

	public Set<TEmailFile> getEmailFiles() {
		return emailFiles;
	}

	public void setSenduser(TUser senduser) {
		this.senduser = senduser;
	}

	public TUser getSenduser() {
		return senduser;
	}


	public void setStrContent(String strContent) {
		this.strContent = strContent;
	}

	public String getStrContent() {
		return strContent;
	}


	public void setContent(Clob content) {
		this.content = content;
	}

	public Clob getContent() {
		return content;
	}

	public void setUserEmails(Set<TUserEmail> userEmails) {
		this.userEmails = userEmails;
	}

	public Set<TUserEmail> getUserEmails() {
		return userEmails;
	}



}