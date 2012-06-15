package com.oa.dao.pojo;

/**
 * TPostFile entity. @author MyEclipse Persistence Tools
 */

public class TPostFile implements java.io.Serializable {

	// Fields

	private Integer pfid;
	private TPost tPost;
	private String oldname;
	private String newname;
	private Boolean del;

	// Constructors

	/** default constructor */
	public TPostFile() {
	}

	/** full constructor */
	public TPostFile(TPost tPost, String oldname, String newname, Boolean del) {
		this.tPost = tPost;
		this.oldname = oldname;
		this.newname = newname;
		this.del = del;
	}

	// Property accessors

	public Integer getPfid() {
		return this.pfid;
	}

	public void setPfid(Integer pfid) {
		this.pfid = pfid;
	}

	public TPost gettPost() {
		return tPost;
	}

	public void settPost(TPost tPost) {
		this.tPost = tPost;
	}

 

	public String getOldname() {
		return this.oldname;
	}

	public void setOldname(String oldname) {
		this.oldname = oldname;
	}

	public String getNewname() {
		return this.newname;
	}

	public void setNewname(String newname) {
		this.newname = newname;
	}

	public Boolean getDel() {
		return this.del;
	}

	public void setDel(Boolean del) {
		this.del = del;
	}

}