package com.oa.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.oa.dao.inf.OaUserAnswersDaoInf;
import com.oa.dao.pojo.CenNaireUser;
import com.oa.dao.pojo.CenNaireUserId;
import com.oa.dao.pojo.OaOptions;
import com.oa.dao.pojo.OaQuestion;
import com.oa.dao.pojo.OaQuestionnaire;
import com.oa.dao.pojo.OaUserAnswers;
import com.oa.dao.pojo.TUser;



public class OaUserAnswerDaoImple extends HibernateDaoSupport implements
		OaUserAnswersDaoInf {
//回答问卷
	@Override
	public boolean addUserAnswer(OaUserAnswers userAnswers) {
		// TODO Auto-generated method stub
		try {
			getHibernateTemplate().save(userAnswers);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

		return true;
	}
//查询问答这个问卷的有多少人
	@Override
	public long selectUserAnswer(int naireid, int questionid, int optionid) {
		// TODO Auto-generated method stub
		String hql = "select count(distinct oa.user.userid ) from OaUserAnswers oa where oa.oaQuestionnaire.qid = "
				+ naireid;
		if (questionid != 0) {
			hql = hql + " and oa.oaQuestion.questionId = " + questionid;
		}
		if (questionid != 0) {
			hql = hql + " and oa.oaOptions.optionId = " + optionid;
		}
		List<Long> count = getHibernateTemplate().find(hql);

		return count.get(0);
	}
//用户查询自己的已回答的问卷
	@Override
	public List<Object[]> selectUserQuestionnaire(final String username,
			final int naireid) {
		// TODO Auto-generated method stub
		List<Object[]> questionnaire = null;
		questionnaire = getHibernateTemplate().executeFind(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						List<Object[]> questionnaire = new ArrayList<Object[]>();
						String hql = "select cen.oaQuestion, cen.oaOptions.optionId,cen.questionanswer from OaUserAnswers cen where cen.user.userid = '"
								+ username
								+ "' and cen.oaQuestionnaire.qid="
								+ naireid;
						List<Object[]> list = session.createQuery(hql).list();
						
						for (Object[] ob : list) {
							OaQuestion question = (OaQuestion) ob[0];
							String hqloption = "from OaOptions ops where ops.oaQuestion.questionId = "
									+ question.getQuestionId();
							List<OaOptions> options = session.createQuery(
									hqloption).list();
							Map<Integer, String> map = new HashMap<Integer, String>();
							for (OaOptions op : options) {
								map.put(op.getOptionId(), op.getPotionName());
							}
							
							Object[] ob1 = new Object[4];
							ob1[0] = ob[0];
							ob1[1] = ob[1];
							ob1[2] = ob[2];

							ob1[3] = map;
							questionnaire.add(ob1);
						}
						 for (Object[] ob : questionnaire) {
						 OaQuestion question = (OaQuestion) ob[0];
						 int i = (Integer) ob[1];
						 
									
						 }

						return questionnaire;
					}
				});
		return questionnaire;
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		OaUserAnswersDaoInf daoInf = (OaUserAnswersDaoInf) applicationContext
				.getBean("userAnswerDaoId");

		daoInf.userQuestionnaireResult(142);
	}
//用户问答问卷
	@Override
	public boolean userAnswerQuestionnaire(OaQuestionnaire questionnaire,
			TUser user) {
		// TODO Auto-generated method stub
		try {
			CenNaireUserId id = new CenNaireUserId(user, questionnaire);
			CenNaireUser cenNaireUser = getHibernateTemplate().load(
					CenNaireUser.class, id);
			cenNaireUser.setNaireAnswer("1");
			getHibernateTemplate().update(cenNaireUser);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

		return true;
	}
	//总结问卷
	@Override
	public List<Object[]> userQuestionnaireResult(final int questionnaireid) {
		// TODO Auto-generated method stub
		List<Object[]> questionnaires = new ArrayList<Object[]>();
		final long allcount = selectUserAnswer(questionnaireid, 0, 0);
		System.out.println("allcont = "+allcount);
		questionnaires = getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = "select cen.id.oaQuestion from CenNaireQuestion cen where cen.id.oaQuestionnaire.qid = "+questionnaireid;
				List<OaQuestion> questions = session.createQuery(hql).list();
				List<Object[]> questionnaires = new ArrayList<Object[]>();
				for (OaQuestion question : questions) {
					String hql1 = "select op from OaOptions op where op.oaQuestion.questionId = "+question.getQuestionId();
					List<OaOptions> ops = session.createQuery(hql1).list();
					List<Object[]> list = new ArrayList<Object[]>();
					Object[] obs = null;
					for (OaOptions op : ops) {
						obs = new Object[2];
						long count = selectUserAnswer(questionnaireid, question.getQuestionId(), op.getOptionId());
						System.out.println("fi = "+count);
						float fi = (float) (count*1.0/allcount);
						obs[0] = op;
						obs[1] = fi;
						list.add(obs);
					}
					Object[] e = new Object[2];
					e[0] = question;
					e[1] = list;
					questionnaires.add(e);
					
				}
				for (Object[] ob : questionnaires) {
					List<Object[]> oo = (List<Object[]>) ob[1];
					for (Object[] obo : oo) {
						float i = (Float) obo[1];
						System.out.println(i);
					}
				}
				return questionnaires;
			}
		});
		
		
		return questionnaires;
	}

}
