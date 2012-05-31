package com.oa.dao.pojo;

/**
 * TEmailFile entity. @author MyEclipse Persistence Tools
 */

public class TEmailFile implements java.io.Serializable {

	// Fields

	private Integer efid;
	private TEmail email;
	private String oldname;
	private String newname;
	private Boolean del;

	// Constructors

	/** default constructor */
	public TEmailFile() {
	}

	/** full constructor */
	public TEmailFile(TEmail email, String oldname, String newname, Boolean del) {
		this.email = email;
		this.oldname = oldname;
		this.newname = newname;
		this.del = del;
	}

	// Property accessors

	public Integer getEfid() {
		return this.efid;
	}

	public void setEfid(Integer efid) {
		this.efid = efid;
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

	public void setEmail(TEmail email) {
		this.email = email;
	}

	public TEmail getEmail() {
		return email;
	}

}