package com.oa.action;

import java.io.File;
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
	private DataService dataService;
	private TPost tPost;
	private TUserPost tUserPost;
	private TUserRole tUserRole;
	private PostServiceInf postServiceInf;
	private List<File> upload;
	private List<String> uploadFileName;
	private List<String> uploadContentType;
	private List<TPost>  selectedPosts;
	private String savePath;
	private UserInfo userInfo = new UserInfo();

	
	
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


	public DataService getDataService() {
		return dataService;
	}


	public void setDataService(DataService dataService) {
		this.dataService = dataService;
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
	public String preAdd() {
		List<TData> departmentUsers = dataService.getDatasWithUsers(dataService
				.getDatas(DataDao.TYPE_DEPARTMENT));
		request.getSession().setAttribute("departmentUsers", departmentUsers);
		return SUCCESS;
	}

	//添加公告
	public String addpost() {	
		TUser tUser = (TUser) request.getSession().getAttribute(LOGIN_USER);
		tUserPost.getId().settUser(tUser);
		tUserPost.getId().gettPost().settUserByAdduser(tUser);
		tUserPost.getId().gettPost().setHasfile(false);
//		if (tUserPost.getId().gettPost().getStatus() == 0) {
//			postServiceInf.savePost(tUserPost, upload, uploadFileName, uploadContentType, savePath);
//		}
		postServiceInf.savePost(tPost, upload, uploadFileName, uploadContentType, savePath);
		return "addpost";
	}
	
	
	//删除公告
	public String  deletepost() {
//		boolean flag= new TPostDaoImpl().deletePost(tPost);
//		System.out.println("flag="+flag);
		
		postServiceInf.deletePost(tUserPost);

		return "deletepost";
	}
	public String getposts(){
		postServiceInf.findAll(tPost, userInfo);
		if(tUserRole.getId().getTRole().getRolename()=="系统管理员")
		return "getposts";
		else
			return "self_getposts";
	}
	
	//从公告ID查询单个公告 
	public String updatebefore() throws Exception {
		
		tPost=new TPostDaoImpl().selectSinglePost(tPost.getPostid());
	 
		List<TPostFile> tPostFiles = new TPostFileDaoImp().selectTPostFiles(tPost.getPostid());
		 
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(StrutsStatics.HTTP_REQUEST);
		request.setAttribute("tPostFile", tPostFiles);

		return "updatebefore";
	}
	
	public void addActionError(String anErrorMessage) {
		//处理上传文件太大问题 
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

			super.addActionError("系统拒绝了您的上传文件:文件的大小为(" + realNum
					+ ")M,超过系统允许的大小(" + oldNum + ")M");

		} else {
			super.addActionError(anErrorMessage);

		}
	}
	//更新后的
	public String updatepost()throws Exception{
	 
		TUser tUser = (TUser) request.getSession().getAttribute(LOGIN_USER);
		tPost.settUserByUpdateuser(tUser);
		tPost.setUpdatetime(new Date());
//		if (tUserPost.getId().gettPost().getStatus() == 0) {
//			postServiceInf.savePost(tUserPost, upload, uploadFileName, uploadContentType, savePath);
//		}
		postServiceInf.updatePost(tPost, upload, uploadFileName, uploadContentType, savePath);
		return "updatepost";
		
		
	}


 
}
