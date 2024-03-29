package com.oa.service.impl;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.oa.common.FileUtil;
import com.oa.common.UserInfo;
import com.oa.dao.inf.EmailDao;
import com.oa.dao.inf.TPostDao;
import com.oa.dao.inf.TPostFileDao;
import com.oa.dao.pojo.TEmail;
import com.oa.dao.pojo.TEmailFile;
import com.oa.dao.pojo.TPost;
import com.oa.dao.pojo.TPostFile;
import com.oa.dao.pojo.TUser;
import com.oa.dao.pojo.TUserEmail;
import com.oa.dao.pojo.TUserEmailId;
import com.oa.dao.pojo.TUserPost;
import com.oa.dao.pojo.TUserPostId;
import com.oa.service.inf.PostServiceInf;
import com.oa.util.PostInfo;

public class PostServiceImpl implements PostServiceInf {
	private TPostDao tPostDao;
	private TPostFileDao postFileDao;

	public TPostFileDao getPostFileDao() {
		return postFileDao;
	}

	public void setPostFileDao(TPostFileDao postFileDao) {
		this.postFileDao = postFileDao;
	}

	public TPostDao gettPostDao() {
		return tPostDao;
	}

	public void settPostDao(TPostDao tPostDao) {
		this.tPostDao = tPostDao;
	}


	@Override
	public void savePost(TUserPost tUserPost, List<File> upload,
			List<String> uploadFileName, List<String> uploadContentType,
			String savePath) {
		TPost tPost = tUserPost.getId().gettPost();

		Set<TPostFile> tPostFiles = new HashSet<TPostFile>();
		if (null != upload) {
			tPost.setHasfile(true);
			for (int i = 0; i < upload.size(); ++i) {
				String newFileName = FileUtil.makeNewFileName(uploadFileName
						.get(i));
				String newFilePath = savePath + File.separator + newFileName;
				File newFile = new File(newFilePath);
				FileUtil.copyFile(upload.get(i), newFile);
				TPostFile tPostFile = new TPostFile();

				tPostFile.setNewname(newFileName);
				tPostFile.setOldname(uploadFileName.get(i));
				tPostFile.settPost(tPost);
				tPostFiles.add(tPostFile);
			}
		} else {
			tPost.setHasfile(false);
		}
		tPost.setTpostfiles(tPostFiles);

		Integer postid = tPostDao.savePost(tPost);

		tPost.setPostid(postid);

		TUser addUser = tUserPost.getId().gettPost().getAddUser();
		tPost.setAddUser(addUser);
 

	}


	// 直接删除公告对象
	@Override
	public void deletePost(TPost tPost) {
		tPostDao.deletePost(tPost);

	}

	@Override
	public List<TPost> findAll(UserInfo userInfo) {
		 
		return tPostDao.findAll(userInfo);
	}
	
	@Override
	public List<TPost> findSelfAll(UserInfo userInfo) {
		return tPostDao.findSelfAll(userInfo);
	}

	@Override
	public void savePost(TPost tPost, List<File> upload,
			List<String> uploadFileName, List<String> uploadContentType,
			String savePath) {
		//传到此处savePath应该为tomcat下的绝对路径
		Set<TPostFile> tPostFiles = new HashSet<TPostFile>();
		if (null != upload) {
			tPost.setHasfile(true);
			tPostDao.savePost(tPost);
			
			for (int i = 0; i < upload.size(); ++i) {
				String newFileName = FileUtil.makeNewFileName(uploadFileName
						.get(i));
				String newFilePath = savePath + File.separator + newFileName;
				File newFile = new File(newFilePath);
				FileUtil.copyFile(upload.get(i), newFile);
 				TPostFile tPostFile = new TPostFile();

				tPostFile.setNewname(newFileName);				 
				tPostFile.setOldname(uploadFileName.get(i));
				tPostFile.settPost(tPost);
				
				
				postFileDao.addPostFile(tPostFile);
				tPostFiles.add(tPostFile);
			}
		} else {
			tPost.setHasfile(false);
		}
		tPost.setTpostfiles(tPostFiles);
 
		tPostDao.upadtePost(tPost);
		
		

	}

	@Override
	public void updatePost(TPost tPost, List<File> upload,
			List<String> uploadFileName, List<String> uploadContentType,
			String savePath) {
		Set<TPostFile> tPostFiles = new HashSet<TPostFile>();	 
		if (null != upload ) {
			tPost.setHasfile(true);
			for (int i = 0; i < upload.size(); ++i) {
				String newFileName = FileUtil.makeNewFileName(uploadFileName
						.get(i));
				String newFilePath = savePath + "//"+ newFileName;
				File newFile = new File(newFilePath);
				FileUtil.copyFile(upload.get(i), newFile);
				TPostFile tPostFile = new TPostFile();

				tPostFile.setNewname(newFileName);
				tPostFile.setOldname(uploadFileName.get(i));
				tPostFile.settPost(tPost);
				postFileDao.addPostFile(tPostFile);
				tPostFiles.add(tPostFile);
			}
		} 
		
		tPost.setTpostfiles(tPostFiles);

		tPostDao.upadtePost(tPost);
	}

	@Override
	public TPost selectSinglePost(int postid) {

		return tPostDao.selectSinglePost(postid);
	}

	@Override
	public void deletePost(int postid) {
		tPostDao.deltePost(postid);
		
	}

	@Override
	public void passPost(TPost tPost) {
		tPostDao.passPost(tPost);
		
	}

	@Override
	public List<TPostFile> findAll(int postid) {
		 
		return postFileDao.selectTPostFiles(postid);
	}

	@Override
	public void deletePostFile(TPostFile postFile) {
		postFileDao.deletePostFile(postFile.getPfid());
		FileUtil.deleteFile(postFile.getNewname());
		
	}



}
