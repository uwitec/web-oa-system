package com.oa.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.oa.common.UserInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware, ModelDriven<UserInfo> {
	protected HttpServletRequest request;
	protected HttpServletResponse response;

	public static String LOGIN_USER = "user";
	public static String USER_ID = "userid";
	public static String VCODE = "vcode";
	public static String USER_INFO = "userInfo";
	public static String SINGLE_USER = "singleuser";
	public static String USER_EMAILS = "userEmails";

	protected UserInfo userInfo = new UserInfo();

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	protected void saveCookie(String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(60 * 60 * 24 * 7);// 7Ìì
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	@Override
	public UserInfo getModel() {
		return userInfo;
	}
}
