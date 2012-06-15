package com.oa.service.impl;

import java.util.List;

import com.oa.dao.inf.TPostDao;
import com.oa.dao.inf.TPostFileDao;
import com.oa.dao.pojo.TPost;
import com.oa.service.inf.PostServiceInf;

public class PostServiceImpl implements PostServiceInf {
	private TPostDao tpotDao;
	private TPostFileDao tpotFileDao;

	@Override
	public TPost addTPost(TPost tPost) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TPost> getPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectPost(int postid) {
		// TODO Auto-generated method stub

	}

	public void setTpotFileDao(TPostFileDao tpotFileDao) {
		this.tpotFileDao = tpotFileDao;
	}

	public TPostFileDao getTpotFileDao() {
		return tpotFileDao;
	}

	public void setTpotDao(TPostDao tpotDao) {
		this.tpotDao = tpotDao;
	}

	public TPostDao getTpotDao() {
		return tpotDao;
	}

}
