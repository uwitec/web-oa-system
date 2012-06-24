package com.oa.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.oa.common.UserInfo;
import com.oa.dao.inf.OaQuestionDaoInf;
import com.oa.dao.inf.OaQuestionnaireDaoInf;
import com.oa.dao.pojo.OaQuestion;
import com.oa.dao.pojo.OaQuestionnaire;
import com.oa.dao.pojo.TUser;



public class OaQuestionnaireDaoImple extends HibernateDaoSupport implements
		OaQuestionnaireDaoInf {
	// 增加问卷
	@Override
	public boolean addQuestionnaire(OaQuestionnaire questionnaire,
			List<OaQuestion> questionsSet) {
		// TODO Auto-generated method stub
		try {
			Set<OaQuestion> questionnaireset = questionnaire.getQuestions();
			if (questionsSet != null && questionsSet.size() > 0) {
				for (OaQuestion oaQuestion : questionsSet) {
					questionnaireset.add(oaQuestion);
				}
			}

			getHibernateTemplate().save(questionnaire);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;

	}

	// 删除问卷或者删除问卷里面的题目
	@Override
	public boolean delQuestionnaire(final int questionnaireid,
			final int questionId) {

		// TODO Auto-generated method stub
		if (questionId == 0) {
			try {
				OaQuestionnaire questionnaire = getHibernateTemplate().load(
						OaQuestionnaire.class, questionnaireid);
				getHibernateTemplate().delete(questionnaire);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		} else {
			getHibernateTemplate().execute(new HibernateCallback() {

				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					String hql = "delete CenNaireQuestion cen where cen.id.oaQuestion.questionId = "
							+ questionId
							+ " and cen.id.oaQuestionnaire.qid = "
							+ questionnaireid;
					Query query = session.createQuery(hql);
					query.executeUpdate();

					return null;
				}
			});
		}

		return true;
	}

	// 查询单个问卷
	@Override
	public OaQuestionnaire selectQuestionnaire(int questionnaireid) {
		// TODO Auto-generated method stub
		OaQuestionnaire questionnaire = null;
		try {
			questionnaire = getHibernateTemplate().get(OaQuestionnaire.class,
					questionnaireid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return questionnaire;
	}

	// 查询所有的问卷
	@Override
	public List<OaQuestionnaire> selectTitleQuestionnaires(
			final String questionnaireTitle, final UserInfo userInfo) {
		// TODO Auto-generated method stub
		List<OaQuestionnaire> questionnaires = getHibernateTemplate()
				.executeFind(new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						String hql = " from OaQuestionnaire where 1 = 1";
						String hqlcount = "select count(*) from OaQuestionnaire where 1 = 1";
						
						if (questionnaireTitle != null
								&& questionnaireTitle.length() > 0) {
							hql = hql + " and qname like '%"
									+ questionnaireTitle + "%'";
							hqlcount = hqlcount + " and qname like '%"
							+ questionnaireTitle + "%'";
						}
						hql = hql + " order by createtime DESC";
						Query querycount = session.createQuery(hqlcount);
						userInfo.setTotalCount(((Long) querycount
								.uniqueResult()).intValue());
						
						
						
						Query query = session.createQuery(hql);
						int currPage = userInfo.getCurrPage();
						int pageSize = userInfo.PAGE_SIZE;
						currPage = currPage == 0 ? 1 : currPage;
						query.setFirstResult((currPage - 1) * pageSize);
						query.setMaxResults(pageSize);
						List<OaQuestionnaire> list = query.list();

						return list;
					}
				});

		return questionnaires;
	}

	// 修改问卷
	@Override
	public boolean updateQuestionnaire(OaQuestionnaire questionnaire,
			List<OaQuestion> questionsSet) {
		// TODO Auto-generated method stub
		try {
			Set<OaQuestion> questionnaireset = questionnaire.getQuestions();
			if (questionsSet != null && questionsSet.size() > 0) {
				for (OaQuestion oaQuestion : questionsSet) {
					questionnaireset.add(oaQuestion);
				}
			}

			getHibernateTemplate().update(questionnaire);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;

	}

	// 查询用户所有的问卷
	@Override
	public List<Object[]> selectIdQuestionnaires(final String userid,
			final UserInfo userInfo) {
		// TODO Auto-generated method stub
		List<Object[]> questionnaires = null;
		
			questionnaires = getHibernateTemplate().executeFind(
					new HibernateCallback() {

						@Override
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							// TODO Auto-generated method stub
							String hql = "select naire,cen  from CenNaireUser cen,OaQuestionnaire naire where cen.id.oaQuestionnaire.qid = naire.qid and cen.id.user.userid = "
									+ userid
									+ " order by cen.naireAnswer ASC";
							String hqlcount = "select count(*)  from CenNaireUser cen where  cen.id.user.userid = "
								+ userid;
							
							Query queryCount = session.createQuery(hqlcount);
							userInfo.setTotalCount(((Long) queryCount
									.uniqueResult()).intValue());
							
							Query query = session.createQuery(hql);
							int currPage = userInfo.getCurrPage();
							int pageSize = userInfo.PAGE_SIZE;
							currPage = currPage == 0 ? 1 : currPage;
							query.setFirstResult((currPage - 1) * pageSize);
							query.setMaxResults(pageSize);
							List<Object[]> questionnaires = query.list();
							
							return questionnaires;
						}
					});

		
		

		return questionnaires;
	}

	// 发布问卷
	@Override
	public boolean publishQuestionnaire(final int questionnaireId,
			final List<TUser> users) {
		// TODO Auto-generated method stub
		getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				OaQuestionnaire questionnaire = (OaQuestionnaire) session.load(
						OaQuestionnaire.class, questionnaireId);
				Set<TUser> setUsers = questionnaire.getUsers();
				if (users != null && users.size() > 0) {
					for (TUser user : users) {
						setUsers.add(user);
					}
				}
				questionnaire.setPublish("1");
				getHibernateTemplate().update(questionnaire);
				return null;
			}
		});

		return true;
	}



	@Override
	public List<Integer> countQuestionTyoe(int naireid, String questiontype) {
		// TODO Auto-generated method stub
		String hql = "select cen.id.oaQuestion.questionId from CenNaireQuestion cen where cen.id.oaQuestion.questionType = '"
				+ questiontype
				+ "' and cen.id.oaQuestionnaire.qid = "
				+ naireid;
		List<Integer> count = getHibernateTemplate().find(hql);

		return count;
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		OaQuestionnaireDaoInf daoImple = (OaQuestionnaireDaoInf) applicationContext
				.getBean("questionnarieId");
		OaQuestionDaoInf daoInf = (OaQuestionDaoInf) applicationContext
				.getBean("questionDaoId");
//		daoImple.getUser("1");
		// OaQuestionnaire questionnaire = new OaQuestionnaire("sdf", new
		// Date(),
		// new Date(), "1", "1");
		// List<OaQuestion> questionsSet = daoInf.selectTitleQuestion("1", 1,
		// 2);
		// daoImple.addQuestionnaire(questionnaire, questionsSet);
		// daoImple.selectTitleQuestionnaires(null,1,5);
		// OaQuestionnaire questionnaire = daoImple.selectQuestionnaire(1);
		// daoImple.updateQuestionnaire(questionnaire, questionsSet);
		// daoImple.delQuestionnaire(41,23);
		// daoImple.selectIdQuestionnaires(1, 0, 2);
		// List<TUser> users = new ArrayList<TUser>();
		// TUser user = daoImple.getUser(1);
		// users.add(user);
		// daoImple.publishQuestionnaire(23, users);

	}


}
