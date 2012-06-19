package com.oa.dao.inf;

import java.util.List;
import java.util.Set;

import com.oa.common.UserInfo;
import com.oa.dao.pojo.OaOptions;
import com.oa.dao.pojo.OaQuestion;



public interface OaQuestionDaoInf {
	public boolean addQuestion(OaQuestion oaQuestion,List<OaOptions> optionsset);
	
	public boolean delQuestion(int questionid);
	
	public List<OaQuestion> selectTitleQuestion(final String questionTitle,final String questionType,UserInfo userInfo,final int naireid);
	
	public List<OaQuestion> selectQuestionnaire(final int pid,UserInfo userInfo);
	
	public OaQuestion selectIdQuestion(int questionid);
	
	public List<OaOptions> selectOaOptions(int questionid);
	
	public List<Object[]> selectQuestionnaireOptions(final int qid,
			UserInfo userInfo) ;
	public OaOptions selectOption(int optionid);
}
