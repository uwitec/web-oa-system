package com.oa.common;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.util.StrutsTypeConverter;

import com.oa.dao.pojo.TRole;

public class RoleTypeConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		Set<TRole> roles = new HashSet<TRole>();
		for (String s : values) {
			TRole role = new TRole();
			role.setRoleid(Integer.parseInt(s));
			roles.add(role);
		}
		return roles;
	}

	@Override
	public String convertToString(Map context, Object toClass) {
		return "";
	}

}
