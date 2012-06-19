package com.oa.dao.inf;

import java.util.List;
import java.util.Set;

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
			final String questionnaireTitle, final int pageNo,
			final int pageSize);
	public List<Object[]> selectIdQuestionnaires(
			final String userid, final int pageNo,
			final int pageSize);
	
	public boolean publishQuestionnaire(int questionnaireId, List<TUser> users);
	
	public TUser getUser(String id);
	
	public int countQuestionnaire();
	public List<Integer> countQuestionTyoe(int naireid,String questiontype);

}
