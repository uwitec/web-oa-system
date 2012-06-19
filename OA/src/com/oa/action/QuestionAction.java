package com.oa.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import com.oa.common.UserInfo;
import com.oa.dao.inf.OaQuestionDaoInf;
import com.oa.dao.pojo.OaOptions;
import com.oa.dao.pojo.OaQuestion;
import com.opensymphony.xwork2.ActionSupport;

public class QuestionAction extends BaseAction {
	private OaQuestionDaoInf questionDaoId;
	private OaQuestion question;
	private List<OaOptions> optionsset;
	private int questionid;
	private int questionnaireid;
	private List<OaQuestion> questions;
	private List<String> option;
	private UserInfo userInfo = new UserInfo();

	// 增加题目
	public String addQuestion() throws Exception {
		
		optionsset = new ArrayList<OaOptions>();
		if (option != null) {
			if (!question.getQuestionType().equals("3")) {
				for (int i = 0; i < option.size(); i++) {
					OaOptions options = new OaOptions(option.get(i));
					optionsset.add(options);
				}
			}
		}
		question.setQuestionDeltype("0");
		questionDaoId.addQuestion(question, optionsset);
		if (questionnaireid == 0) {
			return "addQuestion";
		} else {
			return "addNaireQuestion";
		}

	}

	// 检测增加题目的正确性
	public void validateAddQuestion() {
		// TODO Auto-generated method stub

		if (question == null) {
			this.addFieldError("questionName", "问题不能为空");
			return;
		}
		if (question.getQuestionName().trim() == null
				|| question.getQuestionName().trim().length() <= 0) {
			this.addFieldError("questionName", "题目不能为空");
			return;
		}
		if (question.getQuestionName().trim().length() < 6) {
			this.addFieldError("questionName", "题目的长度不能小于6");
			return;
		}

		if (!question.getQuestionType().equals("3")) {

			if (option == null || option.size() <= 0) {
				this.addFieldError("questionName", "题目必须有选项");
				return;
			}
			for (int i = 0; i < option.size(); i++) {
				if (option.get(i).trim() == null
						|| option.get(i).trim().length() <= 0) {
					this.addFieldError("questionName", "选项不能为空");
					return;
				}
			}
		}
	}

	// 删除题目
	public String delQuestion() throws Exception {
		questionDaoId.delQuestion(questionid);

		return "delQuestion";
	}

	// 查询问题的选项
	public String selectQuestion() throws Exception {
		question = questionDaoId.selectIdQuestion(questionid);
		optionsset = questionDaoId.selectOaOptions(questionid);

		return "selectQuestion";
	}

	// 查询所有的问题
	public String selectQuestions() throws Exception {
		request.setAttribute("userInfo",userInfo);
		if (question != null) {
			String qname = question.getQuestionName().trim();
			questions = questionDaoId.selectTitleQuestion(qname, question.getQuestionType(), userInfo, 0);

		} else {
			questions = questionDaoId.selectTitleQuestion(null, "0", userInfo, 0);
		}

		return "selectQuestions";
	}

	// 在问卷中添加题目，所查询的问题
	public String editQuestionnaireQueations() throws Exception {
		
		if (question != null) {
			String qname = question.getQuestionName().trim();
			questions = questionDaoId.selectTitleQuestion(qname, question.getQuestionType(), userInfo,
					questionnaireid);

		} else {
			questions = questionDaoId.selectTitleQuestion(null, "0", userInfo,
					questionnaireid);
		}

		return "editQuestionnaireQueations";
	}

	public String addQuestionnaireQueations() throws Exception {

		questions = questionDaoId.selectTitleQuestion(null, "0", userInfo, 0);

		return "addQuestionnaireQueations";
	}

	public int getQuestionnaireid() {
		return questionnaireid;
	}

	public void setQuestionnaireid(int questionnaireid) {
		this.questionnaireid = questionnaireid;
	}

	public List<String> getOption() {
		return option;
	}

	public void setOption(List<String> option) {
		this.option = option;
	}

	public List<OaQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<OaQuestion> questions) {
		this.questions = questions;
	}

	public List<OaOptions> getOptionsset() {
		return optionsset;
	}

	public void setOptionsset(List<OaOptions> optionsset) {
		this.optionsset = optionsset;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public OaQuestionDaoInf getQuestionDaoId() {
		return questionDaoId;
	}

	public void setQuestionDaoId(OaQuestionDaoInf questionDaoId) {
		this.questionDaoId = questionDaoId;
	}

	public OaQuestion getQuestion() {
		return question;
	}

	public void setQuestion(OaQuestion question) {
		this.question = question;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
