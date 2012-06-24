package com.oa.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;



import com.oa.common.UserInfo;
import com.oa.dao.inf.OaQuestionDaoInf;
import com.oa.dao.inf.OaQuestionnaireDaoInf;
import com.oa.dao.pojo.OaQuestion;
import com.oa.dao.pojo.OaQuestionnaire;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QuestionnaireAction extends BaseAction {
	private OaQuestionnaire questionnaire;
	private OaQuestionnaireDaoInf questionnarieId;
	private OaQuestionDaoInf questionDaoId;
	private List<OaQuestionnaire> questionnaires;
	private int questionnaireid;
	private int quesid;
	private List<Object[]> questionlist;
	private String qname;
	private List<OaQuestion> questionsSet;
	private List<Integer> questionid;
	private List<Integer> userids;
	private UserInfo userInfo = new UserInfo();
	// 查询所有问卷
	public String selectAllQuestionnaire() throws Exception {
		request.setAttribute("userInfo", userInfo);
		if (qname == null) {
			questionnaires = questionnarieId.selectTitleQuestionnaires(null, userInfo);
		} else {
			qname = qname.trim();
			questionnaires = questionnarieId.selectTitleQuestionnaires(qname,userInfo);
		}

		return "selectAllQuestionnaire";

	}

	// 删除问卷
	public String delQuestionnaire() throws Exception {

		if (quesid == 0) {
			boolean bool = questionnarieId.delQuestionnaire(questionnaireid, 0);
			if (bool) {
				return "delQuestionnaire";
			}
		} else {
			boolean bool = questionnarieId.delQuestionnaire(questionnaireid,
					quesid);
			if (bool) {
				return "delQuestion";
			}
		}

		return ERROR;

	}

	// 查询单个问卷
	public String selectQuestionnaire() throws Exception {

		questionnaire = questionnarieId.selectQuestionnaire(questionnaireid);
		return "selectQuestionnaire";

	}

	// 查询单个问卷题库
	public String selectNaireQuestion() throws Exception {

		questionnaire = questionnarieId.selectQuestionnaire(questionnaireid);
		questionlist = questionDaoId.selectQuestionnaireOptions(
				questionnaireid, userInfo);
		return "selectNaireQuestion";

	}

	// 修改问卷
	public String updateQuestionnaire() throws Exception {
		questionsSet = new ArrayList<OaQuestion>();

		if (questionid != null) {
			for (int i = 0; i < questionid.size(); i++) {

				OaQuestion question = questionDaoId.selectIdQuestion(questionid
						.get(i));
				questionsSet.add(question);
			}
			
			questionnaire = questionnarieId
					.selectQuestionnaire(questionnaireid);
			boolean bool = questionnarieId.updateQuestionnaire(questionnaire,
					questionsSet);
			if (bool) {
				return "updateNaireQuestion";
			}
		} else {
			questionnaire.setPublish("0");
			boolean bool = questionnarieId.updateQuestionnaire(questionnaire,
					null);
			if (bool) {
				return "updateQuestionnaire";
			}
		}

		return ERROR;
	}
	
	public void validateUpdateQuestionnaire() {
		// TODO Auto-generated method stub
		if(questionnaire!=null){
			Date startdate = questionnaire.getStartdate();
			Date stopdate = questionnaire.getStopdate();
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dates = null;
			try {
				dates = dateFormat.parse(dateFormat.format(date));
				System.out.println(dates);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (startdate.before(dates) && !startdate.equals(dates)) {
				this.addFieldError("sdates", "开始日期不能在今天之前");
				return;
			}
			if (startdate.after(stopdate)) {
				this.addFieldError("sdates", "结束日期不能在开始日期之后");
				return;
			}
		}
		

	}

	// 增加问卷的检测

	public void validateAddQuestionnaire() {
		// TODO Auto-generated method stub
		Date startdate = questionnaire.getStartdate();
		Date stopdate = questionnaire.getStopdate();
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dates = null;
		try {
			dates = dateFormat.parse(dateFormat.format(date));
			System.out.println(dates);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (startdate.before(dates) && !startdate.equals(dates)) {
			this.addFieldError("sdates", "开始日期不能在今天之前");
			return;
		}
		if (startdate.after(stopdate)) {
			this.addFieldError("sdates", "结束日期不能在开始日期之后");
			return;
		}

	}


	// 添加问卷
	public String addQuestionnaire() throws Exception {
		questionsSet = new ArrayList<OaQuestion>();
		if (questionid != null) {
			for (int i = 0; i < questionid.size(); i++) {

				OaQuestion question = questionDaoId.selectIdQuestion(questionid
						.get(i));
				questionsSet.add(question);
			}
		}
		questionnaire.setCreatetime(new Date());
		questionnaire.setPublish("0");
		boolean bool = questionnarieId.addQuestionnaire(questionnaire,
				questionsSet);
		if (bool) {
			return "addQuestionnaire";
		}
		return ERROR;
	}
	public String getQname() {
		return qname;
	}

	//发布问卷
	public String publishQuestionnaire(){
		questionnaire = questionnarieId.selectQuestionnaire(questionnaireid);
		
		
		
		return "publishQuestionnaire";
	}
	//问答问卷
	public String answerQuestionnaire(){
		questionlist = questionDaoId.answerQuestionnaire(questionnaireid);
		
		return "answerQuestionnaire";
	}
	
	
	
	public void setQname(String qname) {
		this.qname = qname;
	}

	public int getQuesid() {
		return quesid;
	}

	public void setQuesid(int quesid) {
		this.quesid = quesid;
	}

	

	public List<Integer> getQuestionid() {
		return questionid;
	}

	public void setQuestionid(List<Integer> questionid) {
		this.questionid = questionid;
	}

	public List<OaQuestion> getQuestionsSet() {
		return questionsSet;
	}

	public void setQuestionsSet(List<OaQuestion> questionsSet) {
		this.questionsSet = questionsSet;
	}

	public OaQuestionDaoInf getQuestionDaoId() {
		return questionDaoId;
	}

	public void setQuestionDaoId(OaQuestionDaoInf questionDaoId) {
		this.questionDaoId = questionDaoId;
	}

	

	public List<Object[]> getQuestionlist() {
		return questionlist;
	}

	public void setQuestionlist(List<Object[]> questionlist) {
		this.questionlist = questionlist;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public OaQuestionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(OaQuestionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public OaQuestionnaireDaoInf getQuestionnarieId() {
		return questionnarieId;
	}

	public void setQuestionnarieId(OaQuestionnaireDaoInf questionnarieId) {
		this.questionnarieId = questionnarieId;
	}

	public List<OaQuestionnaire> getQuestionnaires() {
		return questionnaires;
	}

	public void setQuestionnaires(List<OaQuestionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}

	

	public int getQuestionnaireid() {
		return questionnaireid;
	}

	public void setQuestionnaireid(int questionnaireid) {
		this.questionnaireid = questionnaireid;
	}
}
