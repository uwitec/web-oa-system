package com.oa.common;

import java.io.Serializable;
import java.util.List;

import com.oa.dao.pojo.TUser;

public class UserInfo implements Serializable {

	// ·ÖÒ³
	public static int PAGE_SIZE = 5;
	private int currPage;
	private int totalCount;
	private int totalPage;
	private String url;

	private List<TUser> userList;
	private String message;
	private String vcode;
	private String newPassword;
	private String repeatPassword;

	private TUser user = new TUser();

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<TUser> getUserList() {
		return userList;
	}

	public void setUserList(List<TUser> userList) {
		this.userList = userList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	public TUser getUser() {
		return user;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		setTotalPage(0 == totalCount ? 0
				: (0 == totalCount % PAGE_SIZE) ? totalCount / PAGE_SIZE
						: totalCount / PAGE_SIZE + 1);
		setCurrPage(totalCount == 0 ? 0 : currPage == 0 ? 1 : currPage);
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}
