package com.oa.action;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;



import com.oa.dao.inf.OaQuestionDaoInf;
import com.oa.dao.inf.OaQuestionnaireDaoInf;
import com.oa.dao.inf.OaUserAnswersDaoInf;
import com.oa.dao.pojo.OaOptions;
import com.oa.dao.pojo.OaQuestion;
import com.oa.dao.pojo.OaQuestionnaire;
import com.oa.dao.pojo.OaUserAnswers;
import com.oa.dao.pojo.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserQuestionnaireAction extends BaseAction implements
		ServletRequestAware {

	private HttpServletRequest request;
	private OaUserAnswersDaoInf userAnswerDaoId;
	private OaQuestionnaireDaoInf questionnarieId;
	private OaQuestionDaoInf questionDaoId;
	private int questionnaireid;
	private OaUserAnswers userAnswers;
	private String qname;
	private List<Object[]> questionnaires;
	private long sumcount;
	private OaQuestionnaire questionnaire;

	// 用户答卷
	public String addUserAnswer() throws Exception {
		// TODO Auto-generated method stub

		Enumeration all = request.getParameterNames();
		List<Integer> questid1 = questionnarieId.countQuestionTyoe(
				questionnaireid, "1");
		List<Integer> questid2 = questionnarieId.countQuestionTyoe(
				questionnaireid, "2");
		List<Integer> questid3 = questionnarieId.countQuestionTyoe(
				questionnaireid, "3");
		TUser user = (TUser) ActionContext.getContext().getSession().get(LOGIN_USER);
//		String username = (String) ActionContext.getContext().getSession().get("username");
//		TUser user = questionnarieId.getUser("1");
		OaQuestionnaire questionnaire = questionnarieId
		.selectQuestionnaire(questionnaireid);
		while (all.hasMoreElements()) {
			
			String name = (String) all.nextElement();
			
			if (name.equals("questionnaireid")) {
				continue;
			}
			Integer questionid = Integer.parseInt(name);
			userAnswers = new OaUserAnswers();
			if (questid1.contains(questionid)) {
				String answer = request.getParameter(name);

				int optionid = Integer.parseInt(answer);
				OaOptions options = questionDaoId.selectOption(optionid);
				OaQuestion question = questionDaoId
						.selectIdQuestion(questionid);
				
				
				userAnswers.setOaOptions(options);
				userAnswers.setOaQuestion(question);
				userAnswers.setOaQuestionnaire(questionnaire);
//				userAnswers.setUserId(userId);
				userAnswerDaoId.addUserAnswer(userAnswers);
			} else if (questid2.contains(questionid)) {
				String[] answer = request.getParameterValues(name);
				for (int i = 0; i < answer.length; i++) {
					int optionid = Integer.parseInt(answer[i]);
					OaOptions options = questionDaoId.selectOption(optionid);
					OaQuestion question = questionDaoId
							.selectIdQuestion(questionid);
					
					userAnswers.setOaOptions(options);
					userAnswers.setOaQuestion(question);
					userAnswers.setOaQuestionnaire(questionnaire);
//					userAnswers.setUser(user);
					userAnswerDaoId.addUserAnswer(userAnswers);
				}

			} else if (questid3.contains(questionid)) {
				OaQuestion question = questionDaoId
						.selectIdQuestion(questionid);
				
				
				userAnswers.setOaQuestion(question);
				userAnswers.setOaQuestionnaire(questionnaire);
//				userAnswers.setUser(user);
				String answer = request.getParameter(name);
				userAnswers.setQuestionanswer(answer);
				userAnswerDaoId.addUserAnswer(userAnswers);
			}

		}
//		userAnswerDaoId.userAnswerQuestionnaire(questionnaire, user);
		return "addUserAnswer";
	}

	// 用户可以问答的所有的问卷
	public String userQuestionnaire() {
		Map session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		questionnaires = questionnarieId.selectIdQuestionnaires("0", 0, 40);
		questionnaire = questionnarieId.selectQuestionnaire(questionnaireid);
		return "userQuestionnaire";
	}
	//总结问卷
	public String sumQuestionnaire(){
		
		sumcount = userAnswerDaoId.selectUserAnswer(questionnaireid, 0, 0);
		questionnaire = questionnarieId.selectQuestionnaire(questionnaireid);
		questionnaires = userAnswerDaoId.userQuestionnaireResult(questionnaireid);
		
		return "sumQuestionnaire";
	}
	public String selectUserQuestionnaire() {
		String username = (String) ActionContext.getContext().getSession().get(
				"username");
		
		questionnaires = userAnswerDaoId.selectUserQuestionnaire("0",
				questionnaireid);

		return "selectUserQuestionnaire";
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	public OaUserAnswersDaoInf getUserAnswerDaoId() {
		return userAnswerDaoId;
	}

	public void setUserAnswerDaoId(OaUserAnswersDaoInf userAnswerDaoId) {
		this.userAnswerDaoId = userAnswerDaoId;
	}

	public OaQuestionnaireDaoInf getQuestionnarieId() {
		return questionnarieId;
	}

	public void setQuestionnarieId(OaQuestionnaireDaoInf questionnarieId) {
		this.questionnarieId = questionnarieId;
	}

	public OaQuestionDaoInf getQuestionDaoId() {
		return questionDaoId;
	}

	public void setQuestionDaoId(OaQuestionDaoInf questionDaoId) {
		this.questionDaoId = questionDaoId;
	}

	public int getQuestionnaireid() {
		return questionnaireid;
	}

	public void setQuestionnaireid(int questionnaireid) {
		this.questionnaireid = questionnaireid;
	}

	public OaUserAnswers getUserAnswers() {
		return userAnswers;
	}

	public void setUserAnswers(OaUserAnswers userAnswers) {
		this.userAnswers = userAnswers;
	}

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public List<Object[]> getQuestionnaires() {
		return questionnaires;
	}

	public void setQuestionnaires(List<Object[]> questionnaires) {
		this.questionnaires = questionnaires;
	}

	public long getSumcount() {
		return sumcount;
	}

	public void setSumcount(long sumcount) {
		this.sumcount = sumcount;
	}

	public OaQuestionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(OaQuestionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

}
