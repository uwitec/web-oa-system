package com.oa.action;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.oa.common.UserInfo;
import com.oa.dao.inf.DataDao;
import com.oa.dao.inf.EmailDao;
import com.oa.dao.pojo.TData;
import com.oa.dao.pojo.TEmail;
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

	private List<TEmail> selectedEmails;

	private UserInfo userInfo = new UserInfo();

	public String preAddEmail() {
		List<TData> departmentUsers = dataService.getDatasWithUsers(dataService
				.getDatas(DataDao.TYPE_DEPARTMENT));
		request.getSession().setAttribute("departmentUsers", departmentUsers);
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	public String getEmails() {
		userInfo.setUser((TUser) request.getSession().getAttribute(LOGIN_USER));
		List<TUserEmail> userEmails = emailService.getEmails(userEmail,
				userInfo);
		request.setAttribute(USER_EMAILS, userEmails);
		request.setAttribute(USER_INFO, getUserInfo());
		if (userEmail.getType() == EmailDao.TYPE_SEND) {// ∑¢º˛œ‰
			return "outbox";
		} else if (userEmail.getType() == EmailDao.TYPE_RECE) { //  ’º˛œ‰
			return "inbox";
		} else if (userEmail.getType() == EmailDao.TYPE_DUST) { // ¿¨ª¯œ‰
			return "dust";
		} else if (userEmail.getType() == EmailDao.TYPE_DRAFT) { // ≤›∏Âœ‰
			return "draft";
		}

		return SUCCESS;
	}

	/**
	 * ∑¢ÀÕ ªÚ ±£¥Ê≤›∏Â
	 * */
	public String saveEmail() {
		TUser sendUser = (TUser) request.getSession().getAttribute(LOGIN_USER);
		userEmail.getId().setUser(sendUser);
		userEmail.getId().getEmail().setSenduser(sendUser);
		userEmail.getId().getEmail().setHasfile(false);
		if (userEmail.getType() == EmailDao.TYPE_SEND) {
			emailService.saveEmail(userEmail, upload, uploadFileName,
					uploadContentType, getSavePath());
		}
		return SUCCESS;
	}

	public String deleteEmail() {
		emailService.deleteEmail(userEmail);
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
}