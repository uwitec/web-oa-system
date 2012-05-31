package com.oa.action;

import java.util.List;
import java.util.Set;

import com.oa.common.UserInfo;
import com.oa.dao.inf.DataDao;
import com.oa.dao.pojo.TData;
import com.oa.dao.pojo.TMenu;
import com.oa.dao.pojo.TRole;
import com.oa.dao.pojo.TUser;
import com.oa.service.inf.RoleService;
import com.oa.service.inf.UserService;
import com.opensymphony.xwork2.ActionContext;

public class UserAction extends BaseAction {
	private UserService userService;
	private RoleService roleService;

	private Set<TRole> roles;

	public String login() {
		String sessionVcode = (String) ActionContext.getContext().getSession()
				.get(VCODE);
		String vcode = userInfo.getVcode();
		if (vcode.equalsIgnoreCase(sessionVcode) == false) {
			addActionError("验证码错误!");
			return LOGIN;
		}
		TUser loginUser = userService.login(userInfo.getUser());
		if (null != loginUser) {
			saveCookie(USER_ID, loginUser.getUserid());
			request.getSession().setAttribute(LOGIN_USER, loginUser);
			return SUCCESS;
		} else {
			addActionError("用户名或密码错误!");
			return LOGIN;
		}

	}

	public String logout() {
		clearActionErrors();
		request.getSession().removeAttribute(LOGIN_USER);
		return LOGIN;
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
		List<TData> departmentList = userService
				.getDatas(DataDao.TYPE_DEPARTMENT);
		List<TData> jobList = userService.getDatas(DataDao.TYPE_JOB);
		List<TData> provinceList = userService.getDatas(DataDao.TYPE_PROVINCE);
		request.setAttribute("departmentList", departmentList);
		request.setAttribute("jobList", jobList);
		request.setAttribute("provinceList", provinceList);

		List<TRole> roleList = roleService.getRoles(null);
		request.setAttribute("roleList", roleList);
		return SUCCESS;
	}

	public String addUser() {
		userInfo.getUser().setRoles(roles);
		userService.addUser(userInfo.getUser());
		return SUCCESS;
	}

	public String isUserIdExists() {
		boolean exists = userService.isUserIdExists(userInfo.getUser()
				.getUserid());
		if (exists) {
			userInfo.setMessage("<span>用户名存在</span>");
			return "false";
		} else {
			userInfo.setMessage("<span>用户名可以使用</span>");
			return "true";
		}
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

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoles(Set<TRole> roles) {
		this.roles = roles;
	}

	public Set<TRole> getRoles() {
		return roles;
	}

}
