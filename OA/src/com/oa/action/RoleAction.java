package com.oa.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.oa.common.UserInfo;
import com.oa.dao.inf.DataDao;
import com.oa.dao.pojo.TData;
import com.oa.dao.pojo.TRole;
import com.oa.service.inf.DataService;
import com.oa.service.inf.RoleService;

public class RoleAction extends BaseAction {
	private RoleService roleService;
	private DataService dataService;

	public DataService getDataService() {
		return dataService;
	}

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public String findRoles() {
		roleService.getRoles(userInfo);
		request.setAttribute("userInfo",userInfo);
		return SUCCESS;
	}

	public String getSingleRole() {
		//String rid = ServletActionContext.getRequest().getParameter("roleid");
		//System.out.println("rid="+rid);
		Integer roleid = userInfo.getRole().getRoleid();
		TRole role = roleService.getRole(userInfo.getRole().getRoleid());
		request.setAttribute(SINGLE_ROLE, role);
		return SUCCESS;
	}

	public String deleteRole() {
		roleService.deleteRole(userInfo.getRole());
		return SUCCESS;
	}

	public String addRole() {
		roleService.addRole(userInfo.getRole());
		return SUCCESS;
	}

	public String preAddRole() {
		List<TData> departmentList = dataService
				.getDatas(DataDao.TYPE_DEPARTMENT);
		List<TData> jobList = dataService.getDatas(DataDao.TYPE_JOB);
		List<TData> provinceList = dataService.getDatas(DataDao.TYPE_PROVINCE);
		request.getSession().setAttribute("departmentList", departmentList);
		request.getSession().setAttribute("jobList", jobList);
		request.getSession().setAttribute("provinceList", provinceList);
		return SUCCESS;
	}

	public String updateRole() {
		roleService.updateRole(userInfo.getRole());
		return SUCCESS;
	}

	public String preUpdateRole() {
		List<TData> departmentList = dataService
				.getDatas(DataDao.TYPE_DEPARTMENT);
		List<TData> jobList = dataService.getDatas(DataDao.TYPE_JOB);
		request.getSession().setAttribute("departmentList", departmentList);
		request.getSession().setAttribute("jobList", jobList);
		TRole role = roleService.getRole(userInfo.getRole().getRoleid());
		request.setAttribute(SINGLE_ROLE, role);
		return SUCCESS;
	}

	public String selfUpdate() {
		roleService.selfUpdate(userInfo.getRole());
		return SUCCESS;
	}

	public String preUpdate() {
		Integer roleid = ((TRole) request.getSession().getAttribute(USED_ROLE))
				.getRoleid();
//		String rolename = ((TRole) request.getSession().getAttribute(USED_ROLE))
//		.getRolename();
		TRole role = roleService.getRole(roleid);
		request.setAttribute(USED_ROLE, role);
		return SUCCESS;
	}
	
	public String isRoleNameExists() {
		String rolename = userInfo.getRole().getRolename();
		if (rolename == null || rolename.equals("")
				|| rolename.matches("/^[\u0391-\uFFE5]+[A-Za-z]$/") == false) {
			userInfo.setMessage("角色名为中文或英文");
			return "false";
		}
		boolean exists = roleService.isRoleNameExists(rolename);
		if (exists) {
			userInfo.setMessage("用户名存在");
			return "false";
		} else {
			userInfo.setMessage("用户名可以使用");
			return "true";
		}
	}
}
