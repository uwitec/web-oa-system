package com.oa.action;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.oa.dao.impl.TPostFileDaoImp;
import com.oa.dao.inf.TPostFileDao;
import com.oa.dao.pojo.TPostFile;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PostFileAction extends ActionSupport{
  private int tPostFileId;
  private String savePath;

	public int gettPostFileId() {
		return tPostFileId;
	}

	public void settPostFileId(int tPostFileId) {
		this.tPostFileId = tPostFileId;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("------PostFileAction------------");
	 
		TPostFileDao tPostFileDao = new TPostFileDaoImp();
		TPostFile tPostFile = tPostFileDao.selectSingleTPostFile(tPostFileId);
		String realPath = ServletActionContext.getServletContext().getRealPath(
				savePath);
		String fileName = realPath + "/" + tPostFile.getNewname();
		File file = new File(fileName);
		if (file.exists()) {
			file.delete();

		}
		// É¾³ý¸½¼þ±í
		boolean res = tPostFileDao.deletePostFile(tPostFileId);		 
		String mes = "no";
		if (res) {
			mes = "ok";

		}
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(StrutsStatics.HTTP_RESPONSE);
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		out.println(mes);

		return NONE;
	}
	
}
