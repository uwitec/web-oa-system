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
	private TUser updateUser;
	private TUser addUser;
	private String title;
	private Clob content;
	private String strContent;
	private Date begindate;
	private Date enddate;
	private Integer status;
	private Boolean hasfile;
	private Date addtime;
	private Date updatetime;
	private Set<TUserPost> tUserPosts = new HashSet<TUserPost> (0);
	private Set<TPostFile> tpostfiles = new HashSet<TPostFile>(0);

	// Constructors

	/** default constructor */
	public TPost() {
	}

	/** full constructor */
	public TPost(TUser updateUser, TUser addUser, String title,
			Clob content, Date begindate, Date enddate, Integer status,
			Boolean hasfile, Date addtime, Date updatetime, Set tUserPosts,
			Set TPostFiles) {
		this.updateUser = updateUser;
		this.addUser = addUser;
		this.title = title;
		this.content = content;
		this.begindate = begindate;
		this.enddate = enddate;
		this.status = status;
		this.hasfile = hasfile;
		this.addtime = addtime;
		this.updatetime = updatetime;
		this.tUserPosts = tUserPosts;
		this.tpostfiles = tpostfiles;
	}

	// Property accessors

	public Integer getPostid() {
		return this.postid;
	}

	public String getStrContent() {
		return strContent;
	}

	public void setStrContent(String strContent) {
		this.strContent = strContent;
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



	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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



	public Set<TUserPost> gettUserPosts() {
		return tUserPosts;
	}

	public void settUserPosts(Set<TUserPost> tUserPosts) {
		this.tUserPosts = tUserPosts;
	}



	public Set<TPostFile> getTpostfiles() {
		return tpostfiles;
	}

	public void setTpostfiles(Set<TPostFile> tpostfiles) {
		this.tpostfiles = tpostfiles;
	}

	public void setUpdateUser(TUser updateUser) {
		this.updateUser = updateUser;
	}

	public TUser getUpdateUser() {
		return updateUser;
	}

	public void setAddUser(TUser addUser) {
		this.addUser = addUser;
	}

	public TUser getAddUser() {
		return addUser;
	}



}