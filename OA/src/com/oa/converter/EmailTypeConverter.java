package com.oa.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.oa.dao.pojo.TEmail;

public class EmailTypeConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		List<TEmail> emails = new ArrayList<TEmail>();
		for (String s : values) {
			TEmail email = new TEmail();
			email.setEmailid(Integer.valueOf(s));
			emails.add(email);
		}
		return emails;
	}

	@Override
	public String convertToString(Map context, Object o) {
		return null;
	}

}
