package com.oa.action;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;


import com.oa.common.UserInfo;
import com.oa.dao.impl.TPostDaoImpl;
import com.oa.dao.impl.TPostFileDaoImp;
import com.oa.dao.inf.DataDao;
import com.oa.dao.inf.EmailDao;
import com.oa.dao.pojo.TData;
import com.oa.dao.pojo.TPost;
import com.oa.dao.pojo.TPostFile;
import com.oa.dao.pojo.TUser;
import com.oa.dao.pojo.TUserPost;
import com.oa.dao.pojo.TUserRole;
import com.oa.service.inf.DataService;
import com.oa.service.inf.PostServiceInf;
import com.oa.util.Tools;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;



public class PostAction extends BaseAction{	 
	private TPost tPost;
	private TUserPost tUserPost;
	private TUserRole tUserRole;
	private PostServiceInf postServiceInf;
	
	private String fileName;
	private String oldName;
	private List<File> upload;
	private List<String> uploadFileName;
	private List<String> uploadContentType;
	private List<TPost>  selectedPosts;
	private String savePath;
	private UserInfo userInfo = new UserInfo();

	
	
	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getOldName() {
		return oldName;
	}


	public void setOldName(String oldName) {
		try {
			this.oldName = new String(oldName.getBytes("GBK"), "iso-8859-1");
		} catch (UnsupportedEncodingException e) {			 
			e.printStackTrace();
		}
	}


	public TUserRole gettUserRole() {
		return tUserRole;
	}


	public void settUserRole(TUserRole tUserRole) {
		this.tUserRole = tUserRole;
	}


	public PostServiceInf getPostServiceInf() {
		return postServiceInf;
	}


	public void setPostServiceInf(PostServiceInf postServiceInf) {
		this.postServiceInf = postServiceInf;
	}


	public UserInfo getUserInfo() {
		return userInfo;
	}


	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}




	public TPost gettPost() {
		return tPost;
	}


	public void settPost(TPost tPost) {
		this.tPost = tPost;
	}


	public TUserPost gettUserPost() {
		return tUserPost;
	}


	public void settUserPost(TUserPost tUserPost) {
		this.tUserPost = tUserPost;
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


	public List<String> getUploadContentType() {
		return uploadContentType;
	}


	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}


	public List<TPost> getSelectedPosts() {
		return selectedPosts;
	}


	public void setSelectedPosts(List<TPost> selectedPosts) {
		this.selectedPosts = selectedPosts;
	}


	public String getSavePath() {
		return savePath;
	}


	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}


	//��ӹ���
	public String addPost() {	
		TUser tUser = (TUser) request.getSession().getAttribute(LOGIN_USER);
		 System.out.println("tUserPost="+tUserPost);
		tUserPost.getId().settUser(tUser);
		tUserPost.getId().gettPost().settUserByAdduser(tUser);
		tUserPost.getId().gettPost().setHasfile(false);
//		if (tUserPost.getId().gettPost().getStatus() == 0) {
//			postServiceInf.savePost(tUserPost, upload, uploadFileName, uploadContentType, savePath);
//		}
		postServiceInf.savePost(tPost, upload, uploadFileName, uploadContentType, savePath);
		return "post_add";
	}
	
	
	//ɾ������
	public String  deletePost() {
//		boolean flag= new TPostDaoImpl().deletePost(tPost);
//		System.out.println("flag="+flag);
		
		postServiceInf.deletePost(tPost);

		return "delete";
	}
	public String getPosts(){
		System.out.println("---------------");
		userInfo.setUser((TUser) request.getSession().getAttribute(LOGIN_USER));
		List<TPost> posts = postServiceInf.findAll(userInfo);
		 request.setAttribute("posts", posts);
		 request.setAttribute(USER_INFO, userInfo);
	//	if(tUserRole.getId().getTRole().getRolename()=="ϵͳ����Ա")
		return "postlist";
//		else
//			return "self_getposts";
	}
		
	public String updatePost()throws Exception{
	 
		TUser tUser = (TUser) request.getSession().getAttribute(LOGIN_USER);
		tPost.settUserByUpdateuser(tUser);
		tPost.setUpdatetime(new Date());
//		if(tUserRole.getId().getTRole().getRolename()=="ϵͳ����Ա"){
//			
//		}
		
		if (tUserPost.getId().gettPost().getStatus() == 0) {
			postServiceInf.updatePost(tPost, upload, uploadFileName, uploadContentType, savePath);			
		}
		return  "edit";
	}
	public String viewPost(){
		TPost tpost=postServiceInf.selectSinglePost(tPost.getPostid());
		request.setAttribute("tPost", tpost);
		return "view";
		
	}
	public String downLoad() {
		return "download";
	}

	public InputStream getInputStream() {
 
		return ServletActionContext.getServletContext().getResourceAsStream(
				"upload/post/" + fileName);

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
 
}
