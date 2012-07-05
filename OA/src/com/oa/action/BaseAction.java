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
		ServletResponseAware {
	protected HttpServletRequest request;
	protected HttpServletResponse response;

	public static String LOGIN_USER = "user";
	public static String USER_ID = "userid";
	public static String VCODE = "vcode";
	public static String USER_INFO = "userInfo";
	public static String SINGLE_USER = "singleuser";
	public static String USED_ROLE = "role";
	public static String ROLE_ID = "roleid";
	public static String SINGLE_ROLE = "singlerole";
	public static String USER_EMAILS = "userEmails";
	public static String SINGLE_MENU = "singlemenu";
	public static String P_MENU = "pmenu";
	public static String EMAIL = "email";
	public static String SELECTED_ROLES= "selectedRoles";

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
}
