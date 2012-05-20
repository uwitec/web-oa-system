package com.oa.dao.pojo;

/**
 * TTips entity. @author MyEclipse Persistence Tools
 */

public class TTips implements java.io.Serializable {

	// Fields

	private String userid;
	private Boolean showtips;
	private Boolean showemail;
	private Boolean showpost;
	private Integer interval;
	private TUser user;
	// Constructors

	/** default constructor */
	public TTips() {
	}

	/** minimal constructor */
	public TTips(TUser user) {
		this.setUser(user);
	}

	/** full constructor */
	public TTips(TUser user, Boolean showtips, Boolean showemail,
			Boolean showpost, Integer interval) {
		this.setUser(user);
		this.showtips = showtips;
		this.showemail = showemail;
		this.showpost = showpost;
		this.interval = interval;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}


	public Boolean getShowtips() {
		return this.showtips;
	}

	public void setShowtips(Boolean showtips) {
		this.showtips = showtips;
	}

	public Boolean getShowemail() {
		return this.showemail;
	}

	public void setShowemail(Boolean showemail) {
		this.showemail = showemail;
	}

	public Boolean getShowpost() {
		return this.showpost;
	}

	public void setShowpost(Boolean showpost) {
		this.showpost = showpost;
	}

	public Integer getInterval() {
		return this.interval;
	}

	public void setInterval(Integer interval) {
		this.interval = interval;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	public TUser getUser() {
		return user;
	}

}