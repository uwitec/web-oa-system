package com.oa.action;

import java.util.List;

import com.oa.common.UserInfo;
import com.oa.dao.inf.DataDao;
import com.oa.dao.pojo.TData;
import com.oa.dao.pojo.TMenu;
import com.oa.dao.pojo.TUser;
import com.oa.service.inf.UserService;
import com.opensymphony.xwork2.ActionContext;

public class UserAction extends BaseAction {
	private UserService userService;

	public String login() {
		String sessionVcode = (String) ActionContext.getContext().getSession()
				.get(VCODE);
		String vcode = userInfo.getVcode();
		if (vcode.equalsIgnoreCase(sessionVcode) == false) {
			addActionMessage("验证码错误!");
			return LOGIN;
		}
		TUser loginUser = userService.login(userInfo.getUser());
		if (null != loginUser) {
			saveCookie(USER_ID, loginUser.getUserid());
			request.getSession().setAttribute(LOGIN_USER, loginUser);
			return SUCCESS;
		} else {
			addActionMessage("用户名或密码错误!");
			return LOGIN;
		}
	}

	public String findUsers() {
		userService.findUsers(userInfo);
		List<TData> departmentList = userService
				.getDatas(DataDao.TYPE_DEPARTMENT);
		request.setAttribute("userInfo", userInfo);
		request.setAttribute("departmentList", departmentList);
		return SUCCESS;
	}

	public String getSingleUser() {
		TUser user = userService.getUser(userInfo.getUser().getUserid());
		request.setAttribute(SINGLE_USER, user);
		return SUCCESS;
	}

	public String deleteUser() {
		userService.deleteUser(userInfo.getUser());
		return SUCCESS;
	}

	public String preAddUser() {
		return SUCCESS;
	}

	public String addUser() {
		return SUCCESS;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}
}
