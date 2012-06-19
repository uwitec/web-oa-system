package com.oa.dao.inf;

import java.util.List;

import com.oa.dao.pojo.OaQuestionnaire;
import com.oa.dao.pojo.OaUserAnswers;
import com.oa.dao.pojo.TUser;

public interface OaUserAnswersDaoInf {
	public boolean addUserAnswer(OaUserAnswers userAnswers);
	public List<Object[]> selectUserQuestionnaire(String username,int naireid);
	
	public long selectUserAnswer(int naireid,int questionid,int optionid);
	
	public boolean userAnswerQuestionnaire(OaQuestionnaire questionnaire,TUser userid);
	
	public List<Object[]> userQuestionnaireResult(int questionnaireid);

}
