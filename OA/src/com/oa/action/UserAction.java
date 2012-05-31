package com.oa.action;

import java.util.List;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

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
		request.getSession().setAttribute("departmentList", departmentList);
		request.getSession().setAttribute("jobList", jobList);
		request.getSession().setAttribute("provinceList", provinceList);
		List<TRole> roleList = roleService.getRoles(null);
		request.getSession().setAttribute("roleList", roleList);
		return SUCCESS;
	}

	public String addUser() {
		userService.addUser(userInfo.getUser());
		return SUCCESS;
	}

	public String isUserIdExists() {
		String userid = userInfo.getUser().getUserid();
		if (userid == null || userid.equals("")
				|| userid.matches("\\w{3,15}") == false) {
			userInfo.setMessage("用户名为字母数字下划线，长度为3~15");
			return "false";
		}
		boolean exists = userService.isUserIdExists(userid);
		if (exists) {
			userInfo.setMessage("用户名存在");
			return "false";
		} else {
			userInfo.setMessage("用户名可以使用");
			return "true";
		}
	}

	public void validateAdduser() {
		if (null == userInfo.getUser().getRoles()) {
			addFieldError("userInfo.user.roles", "角色不能为空");
		}
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@JSON(serialize = false)
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

	@JSON(serialize = false)
	public RoleService getRoleService() {
		return roleService;
	}

}
