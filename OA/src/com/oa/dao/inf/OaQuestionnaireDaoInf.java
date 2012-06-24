package com.oa.dao.inf;

import java.util.List;
import java.util.Set;

import com.oa.common.UserInfo;
import com.oa.dao.pojo.OaQuestion;
import com.oa.dao.pojo.OaQuestionnaire;
import com.oa.dao.pojo.TUser;



public interface OaQuestionnaireDaoInf {
	public boolean addQuestionnaire(OaQuestionnaire questionnaire,
			List<OaQuestion> questionsSet);

	public boolean updateQuestionnaire(OaQuestionnaire questionnaire,
			List<OaQuestion> questionsSet);

	public boolean delQuestionnaire(int questionnaireid,int questionId);

	public OaQuestionnaire selectQuestionnaire(int questionnaireid);

	public List<OaQuestionnaire> selectTitleQuestionnaires(
			final String questionnaireTitle, final UserInfo userInfo);
	public List<Object[]> selectIdQuestionnaires(
			final String userid, final UserInfo userInfo);
	
	public boolean publishQuestionnaire(int questionnaireId, List<TUser> users);
	

	public List<Integer> countQuestionTyoe(int naireid,String questiontype);

}
