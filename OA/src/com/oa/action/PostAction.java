package com.oa.action;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;


import com.oa.dao.impl.TPostDaoImpl;
import com.oa.dao.impl.TPostFileDaoImp;
import com.oa.dao.pojo.TPost;
import com.oa.dao.pojo.TPostFile;
import com.oa.util.Tools;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class PostAction extends ActionSupport{
	private TPost tPost;
	private List<File> upload;
	private List<String> uploadFileName;
	private String savePath;

	public TPost gettPost() {
		return tPost;
	}

	public void settPost(TPost tPost) {
		this.tPost = tPost;
	}

	public List<File> getUpload() {
		return upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	//��ӹ���
	public String addPost() {
		int postid= new TPostDaoImpl().addPost(tPost);
		System.out.println("postId=" + postid);
		if (upload != null) {
			for (int i = 0; i < upload.size(); i++) {

				// �����ļ���������µ��ļ���
				String newName = Tools.makeNewFileName(uploadFileName
						.get(i));
				 
				// ��÷���������ʵ·�� ����/webRoot/postfile
				String realPath = ServletActionContext.getServletContext()
						.getRealPath("/" + savePath);
				File newFile = new File(realPath + "/" + newName);
				Tools.copyFile(upload.get(i), newFile);
				// ���븽�� 
				TPostFile tPostFile = new TPostFile();
				tPostFile.setPfid(postid);
				tPostFile.setOldname(uploadFileName.get(i));
				tPostFile.setNewname(newName) ;	 
				boolean res = new TPostFileDaoImp().addPostFile(tPostFile);

			}
		}

		return SUCCESS;
	}
	
	
	//ɾ������
	public String  deletePost() {
		boolean flag= new TPostDaoImpl().deletePost(tPost.getPostid());
		System.out.println("flag="+flag);
		
 

		return "delete";
	}
	
	//�ӹ���ID��ѯ�������� 
	public String updateBefore() throws Exception {
		
		tPost=new TPostDaoImpl().selectSinglePost(tPost.getPostid());
	 
		List<TPostFile> tPostFiles = new TPostFileDaoImp().selectTPostFiles(tPost.getPostid());
		 
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(StrutsStatics.HTTP_REQUEST);
		request.setAttribute("tPostFile", tPostFiles);

		return "updatePost";
	}
	
	public void addActionError(String anErrorMessage) {
		//�����ϴ��ļ�̫������ 
		System.out.println("anErrorMessage=" + anErrorMessage);

		if (anErrorMessage
				.startsWith("the request was rejected because its size")) {
			Matcher matcher = Pattern.compile("\\d+").matcher(anErrorMessage);
			int realNum = 0;
			if (matcher.find()) {
				String s1 = matcher.group();
				realNum = Integer.parseInt(s1) / 1024 / 1024;
			}
			int oldNum = 0;
			if (matcher.find()) {
				String s2 = matcher.group();
				oldNum = Integer.parseInt(s2) / 1024 / 1024;
			}

			super.addActionError("ϵͳ�ܾ��������ϴ��ļ�:�ļ��Ĵ�СΪ(" + realNum
					+ ")M,����ϵͳ����Ĵ�С(" + oldNum + ")M");

		} else {
			super.addActionError(anErrorMessage);

		}
	}
	//���º��
	public String updatePost()throws Exception{
	 
		int postId = new TPostDaoImpl().upadtePost(tPost);
		if (upload != null) {
			for (int i = 0; i < upload.size(); i++) {

				String newFileName = Tools.makeNewFileName(uploadFileName
						.get(i));

				String realPath = ServletActionContext.getServletContext()
						.getRealPath("/" + savePath);
				File newFile = new File(realPath + "/" + newFileName);
				Tools.copyFile(upload.get(i), newFile);
				// ���븽����
				TPostFile tPostFile = new TPostFile();

				tPostFile.setOldname(uploadFileName.get(i));
				tPostFile.setNewname(newFileName);
				boolean res = new TPostFileDaoImp().addPostFile(tPostFile);

			}
		}
		System.out.println("���º�.....");
		return "updateSuccess";
		
		
	}
}
