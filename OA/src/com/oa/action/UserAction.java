package com.oa.action;

import java.io.File;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.oa.common.UserInfo;
import com.oa.dao.inf.DataDao;
import com.oa.dao.pojo.TData;
import com.oa.dao.pojo.TRole;
import com.oa.dao.pojo.TUser;
import com.oa.service.inf.DataService;
import com.oa.service.inf.RoleService;
import com.oa.service.inf.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends BaseAction implements ModelDriven<UserInfo> {
	private UserService userService;
	private RoleService roleService;
	private DataService dataService;

	private UserInfo userInfo = new UserInfo();

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
		request.getSession().invalidate();
		return LOGIN;
	}

	public String findUsers() {
		userService.findUsers(userInfo);
		List<TData> departmentList = dataService
				.getDatas(DataDao.TYPE_DEPARTMENT);
		TData data = new TData();
		data.setDataid(0);
		data.setDataname("全部");
		departmentList.add(data);
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
		List<TData> departmentList = dataService
				.getDatas(DataDao.TYPE_DEPARTMENT);
		List<TData> jobList = dataService.getDatas(DataDao.TYPE_JOB);
		List<TData> provinceList = dataService.getDatas(DataDao.TYPE_PROVINCE);
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

	public String preUpdate() {
		String userid = ((TUser) request.getSession().getAttribute(LOGIN_USER))
				.getUserid();
		TUser user = userService.getUser(userid);
		request.setAttribute(SINGLE_USER, user);
		return SUCCESS;
	}

	public String selfUpdate() {
		userService.selfUpdate(userInfo.getUser());
		return SUCCESS;
	}

	public String updateUser() {
		userService.updateUser(userInfo.getUser());
		return SUCCESS;
	}

	public String preUpdateUser() {
		List<TData> departmentList = dataService
				.getDatas(DataDao.TYPE_DEPARTMENT);
		List<TData> jobList = dataService.getDatas(DataDao.TYPE_JOB);
		request.getSession().setAttribute("departmentList", departmentList);
		request.getSession().setAttribute("jobList", jobList);
		List<TRole> roleList = roleService.getRoles(null);
		request.getSession().setAttribute("roleList", roleList);
		TUser user = userService.getUser(userInfo.getUser().getUserid());
		request.setAttribute(SINGLE_USER, user);
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

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	public DataService getDataService() {
		return dataService;
	}

	@Override
	public UserInfo getModel() {
		// TODO Auto-generated method stub
		return userInfo;
	}

}
