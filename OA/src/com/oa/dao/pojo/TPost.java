package com.oa.dao.pojo;

import java.sql.Clob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TPost entity. @author MyEclipse Persistence Tools
 */

public class TPost implements java.io.Serializable {

	// Fields

	private Integer postid;
	private TUser tUserByUpdateuser;
	private TUser tUserByAdduser;
	private String title;
	private Clob content;
	private Date begindate;
	private Date enddate;
	private Boolean status;
	private Boolean hasfile;
	private Date addtime;
	private Date updatetime;
	private Set tUserPosts = new HashSet(0);
	private Set<TPostFile> tPostFiles = new HashSet<TPostFile>(0);

	// Constructors

	/** default constructor */
	public TPost() {
	}

	/** full constructor */
	public TPost(TUser TUserByUpdateuser, TUser TUserByAdduser, String title,
			Clob content, Date begindate, Date enddate, Boolean status,
			Boolean hasfile, Date addtime, Date updatetime, Set tUserPosts,
			Set TPostFiles) {
		this.tUserByUpdateuser = tUserByUpdateuser;
		this.tUserByAdduser = tUserByAdduser;
		this.title = title;
		this.content = content;
		this.begindate = begindate;
		this.enddate = enddate;
		this.status = status;
		this.hasfile = hasfile;
		this.addtime = addtime;
		this.updatetime = updatetime;
		this.tUserPosts = tUserPosts;
		this.tPostFiles = tPostFiles;
	}

	// Property accessors

	public Integer getPostid() {
		return this.postid;
	}

	public void setPostid(Integer postid) {
		this.postid = postid;
	}



	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public Clob getContent() {
		return content;
	}

	public void setContent(Clob content) {
		this.content = content;
	}

	public Date getBegindate() {
		return this.begindate;
	}

	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Boolean getHasfile() {
		return this.hasfile;
	}

	public void setHasfile(Boolean hasfile) {
		this.hasfile = hasfile;
	}

	public Date getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public TUser gettUserByUpdateuser() {
		return tUserByUpdateuser;
	}

	public void settUserByUpdateuser(TUser tUserByUpdateuser) {
		this.tUserByUpdateuser = tUserByUpdateuser;
	}

	public TUser gettUserByAdduser() {
		return tUserByAdduser;
	}

	public void settUserByAdduser(TUser tUserByAdduser) {
		this.tUserByAdduser = tUserByAdduser;
	}

	public Set gettUserPosts() {
		return tUserPosts;
	}

	public void settUserPosts(Set tUserPosts) {
		this.tUserPosts = tUserPosts;
	}

	public Set<TPostFile> gettPostFiles() {
		return tPostFiles;
	}

	public void settPostFiles(Set<TPostFile> tPostFiles) {
		this.tPostFiles = tPostFiles;
	}



}