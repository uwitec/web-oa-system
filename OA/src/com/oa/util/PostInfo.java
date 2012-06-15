package com.oa.util;

import java.io.Serializable;
import java.util.List;

import com.oa.dao.pojo.TPost;
import com.oa.dao.pojo.TUser;

public class PostInfo implements Serializable {

	// ·ÖÒ³
	public static int PAGE_SIZE = 5;
	private int currPage;
	private int totalCount;
	private int totalPage;
	private String url;

	private List<TPost> tpostList;
	private String message;
	private String vcode;


	private TPost tpost = new TPost();

	

	public static int getPAGE_SIZE() {
		return PAGE_SIZE;
	}

	public static void setPAGE_SIZE(int pAGESIZE) {
		PAGE_SIZE = pAGESIZE;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<TPost> getTpostList() {
		return tpostList;
	}

	public void setTpostList(List<TPost> tpostList) {
		this.tpostList = tpostList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public TPost getTpost() {
		return tpost;
	}

	public void setTpost(TPost tpost) {
		this.tpost = tpost;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		setTotalPage(0 == totalCount ? 0
				: (0 == totalCount % PAGE_SIZE) ? totalCount / PAGE_SIZE
						: totalCount / PAGE_SIZE + 1);
		setCurrPage(totalCount == 0 ? 0 : currPage == 0 ? 1 : currPage);
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}
