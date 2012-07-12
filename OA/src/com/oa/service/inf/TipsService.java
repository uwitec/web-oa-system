package com.oa.service.inf;

import java.util.List;

import com.oa.dao.pojo.TTips;
import com.oa.dao.pojo.TUser;

public interface TipsService {
	
	void updateTips(TTips tips);

	List<Integer> countEmailAndPost(TUser user);
}
