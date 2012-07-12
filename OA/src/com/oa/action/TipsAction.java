package com.oa.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.oa.common.UserInfo;
import com.oa.dao.pojo.TUser;
import com.oa.service.inf.TipsService;
import com.opensymphony.xwork2.ModelDriven;

public class TipsAction extends BaseAction implements ModelDriven<UserInfo> {
	private UserInfo userInfo = new UserInfo();

	private TipsService tipsService;

	public String updateTips() {
		return SUCCESS;
	}

	public String countEmailAndPost() {
		TUser user = (TUser) request.getSession().getAttribute(LOGIN_USER);
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		userInfo.setNumbers(numbers);
		System.out.println(numbers.size());
		return SUCCESS;
	}

	@Override
	public UserInfo getModel() {
		return getUserInfo();
	}

	public void setTipsService(TipsService tipsService) {
		this.tipsService = tipsService;
	}

	@JSON(serialize = false)
	public TipsService getTipsService() {
		return tipsService;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

}
