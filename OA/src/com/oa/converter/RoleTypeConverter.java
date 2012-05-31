package com.oa.converter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.util.StrutsTypeConverter;

import com.oa.dao.pojo.TRole;
import com.opensymphony.xwork2.conversion.TypeConversionException;

public class RoleTypeConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		Set<TRole> roles = new HashSet<TRole>();
		if (null == values || values.length == 0 && values[0].equals("")) {
			throw new TypeConversionException("角色不能为空");
		}
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
