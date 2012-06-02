package com.oa.converter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.util.StrutsTypeConverter;

import com.oa.dao.pojo.TRole;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.conversion.TypeConversionException;

public class RoleTypeConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		Set<TRole> roles = new HashSet<TRole>();
		if (null == values || values.length == 0 && values[0].equals("")) {
			Map<String, Object> conversionErrors = (Map<String, Object>) context
					.get(ActionContext.CONVERSION_ERRORS);

			if (conversionErrors == null) {
				conversionErrors = new HashMap<String, Object>();
				context.put(ActionContext.CONVERSION_ERRORS, conversionErrors);
			}
			conversionErrors.put("userInfo.user.roles", "角色不能为空");
			return null;
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
