package com.oa.dao.pojo;

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
	private String content;
	private String receusers;
	private Date sendtime;
	private Boolean hasfile;
	private Set<TEmailFile> emailFiles = new HashSet<TEmailFile>(0);
	private Set TUserEmails = new HashSet(0);

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
			Set<TEmailFile> emailFiles, Set tUserEmails) {
		super();
		this.emailid = emailid;
		this.title = title;
		this.content = content;
		this.receusers = receusers;
		this.sendtime = sendtime;
		this.hasfile = hasfile;
		this.emailFiles = emailFiles;
		TUserEmails = tUserEmails;
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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Set getTUserEmails() {
		return this.TUserEmails;
	}

	public void setTUserEmails(Set TUserEmails) {
		this.TUserEmails = TUserEmails;
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

}