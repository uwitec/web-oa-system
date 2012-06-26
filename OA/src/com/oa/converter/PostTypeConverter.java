package com.oa.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.oa.dao.pojo.TPost;

public class PostTypeConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		List<TPost> tPosts = new ArrayList<TPost>();
		for (String s : values) {
			TPost tPost = new TPost();
			tPost.setPostid(Integer.valueOf(s));
			tPosts.add(tPost);
 
		}
		return tPosts;
	}

	@Override
	public String convertToString(Map context, Object o) {
		return null;
	}

}
