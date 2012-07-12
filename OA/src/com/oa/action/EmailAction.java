package com.oa.action;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.oa.common.UserInfo;
import com.oa.dao.inf.DataDao;
import com.oa.dao.inf.EmailDao;
import com.oa.dao.pojo.TData;
import com.oa.dao.pojo.TEmail;
import com.oa.dao.pojo.TEmailFile;
import com.oa.dao.pojo.TUser;
import com.oa.dao.pojo.TUserEmail;
import com.oa.service.inf.DataService;
import com.oa.service.inf.EmailService;
import com.opensymphony.xwork2.ModelDriven;

public class EmailAction extends BaseAction implements ModelDriven<UserInfo> {
	
	private DataService dataService;
	private EmailService emailService;

	private TUserEmail userEmail;

	private List<File> upload;
	private List<String> uploadFileName;
	private List<String> uploadContentType;

	private String savePath;

	private String fileName;
	private String oldName;

	private TEmailFile emailFile;

	private List<TEmail> selectedEmails;

	private UserInfo userInfo = new UserInfo();

	public String preAddEmail() {
		List<TData> departmentUsers = dataService.getDatasWithUsers(dataService
				.getDatas(DataDao.TYPE_DEPARTMENT));
		request.getSession().setAttribute("departmentUsers", departmentUsers);
		return SUCCESS;
	}

	public String getEmails() {
		userInfo.setUser((TUser) request.getSession().getAttribute(LOGIN_USER));
		List<TUserEmail> userEmails = emailService.getEmails(userEmail,
				userInfo);
		request.setAttribute(USER_EMAILS, userEmails);
		request.setAttribute(USER_INFO, getUserInfo());

		if (userEmail.getType() == EmailDao.TYPE_SEND) {// ·¢¼þÏä
			return "outbox";
		} else if (userEmail.getType() == EmailDao.TYPE_RECE) { // ÊÕ¼þÏä
			return "inbox";
		} else if (userEmail.getType() == EmailDao.TYPE_DUST) { // À¬»øÏä
			return "dust";
		} else { // ²Ý¸åÏä
			return "draft";
		}
	}

	public String viewEmail() {
		List<TData> departmentUsers = dataService.getDatasWithUsers(dataService
				.getDatas(DataDao.TYPE_DEPARTMENT));
		request.getSession().setAttribute("departmentUsers", departmentUsers);
		userEmail.getId().setUser(
				(TUser) request.getSession().getAttribute(LOGIN_USER));
		TEmail email = emailService.getSingleEmail(userEmail);
		request.setAttribute(EMAIL, email);
		if (userEmail.getType() == EmailDao.TYPE_DRAFT) {// ²Ý¸åÏä ±à¼­½çÃæ
			return "edit";
		} else {
			return "view";
		}
	}

	/**
	 * ·¢ËÍ ±£´æ²Ý¸å ¸üÐÂ²Ý¸å ²Ý¸å·¢ËÍ
	 * */
	public String saveEmail() {
		TUser sendUser = (TUser) request.getSession().getAttribute(LOGIN_USER);
		userEmail.getId().setUser(sendUser);
		userEmail.getId().getEmail().setSenduser(sendUser);
		userEmail.getId().getEmail().setHasfile(false);
		if (userEmail.getType() == EmailDao.TYPE_SEND) { // ·¢ËÍ
			emailService.saveEmail(userEmail, upload, uploadFileName,
					uploadContentType, getSavePath());
		} else if (userEmail.getType() == EmailDao.TYPE_DRAFT) { // ±£´æ²Ý¸å
			emailService.saveEmailToDraft(userEmail, upload, uploadFileName,
					uploadContentType, getSavePath());
		} else if (userEmail.getType() == EmailDao.TYPE_DRAFT_SEND) {// ²Ý¸å·¢ËÍ 5
			emailService.draftSend(userEmail, upload, uploadFileName,
					uploadContentType, getSavePath());
			userEmail.setType(EmailDao.TYPE_SEND);
		} else if (userEmail.getType() == EmailDao.TYPE_DRAFT_UPDATE) {// ²Ý¸å¸üÐÂ 6
			emailService.updateDraft(userEmail, upload, uploadFileName,
					uploadContentType, getSavePath());
			userEmail.setType(EmailDao.TYPE_DRAFT);
		}
		return SUCCESS;
	}

	public String downLoad() {
		return "download";
	}

	public InputStream getInputStream() {
		// ServletActionContext.getResponse().setHeader("Content-Disposition",
		// "attachment; filename=" + oldName);
		return ServletActionContext.getServletContext().getResourceAsStream(
				"upload/email/" + fileName);

	}

	// ajaxÉ¾³ý²Ý¸å¸½¼þ
	public String deleteEmailFile() {
		emailFile.setNewname(getSavePath() + File.separator
				+ emailFile.getNewname());
		emailService.deleteEmailFile(emailFile);
		userInfo.setMessage("success");
		return SUCCESS;
	}

	public String deleteEmail() {
		emailService.deleteEmail(userEmail);
		return SUCCESS;
	}

	public String deleteToDust() {
		emailService.deleteToDust(userEmail);
		return SUCCESS;
	}

	public String dustToInbox() {
		emailService.dustToInbox(userEmail);
		return SUCCESS;
	}

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	public DataService getDataService() {
		return dataService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public EmailService getEmailService() {
		return emailService;
	}

	public void setUserEmail(TUserEmail userEmail) {
		this.userEmail = userEmail;
	}

	public TUserEmail getUserEmail() {
		return userEmail;
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

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	@Override
	public UserInfo getModel() {
		// TODO Auto-generated method stub
		return userInfo;
	}

	public void setSelectedEmails(List<TEmail> selectedEmails) {
		this.selectedEmails = selectedEmails;
	}

	public List<TEmail> getSelectedEmails() {
		return selectedEmails;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setOldName(String oldName) {
		try {
			this.oldName = new String(oldName.getBytes("GBK"), "iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getOldName() {
		return oldName;
	}

	public void setEmailFile(TEmailFile emailFile) {
		this.emailFile = emailFile;
	}

	public TEmailFile getEmailFile() {
		return emailFile;
	}
}