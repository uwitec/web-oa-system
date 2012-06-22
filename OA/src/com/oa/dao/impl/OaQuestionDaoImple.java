package com.oa.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.oa.common.UserInfo;
import com.oa.dao.inf.OaQuestionDaoInf;
import com.oa.dao.pojo.OaOptions;
import com.oa.dao.pojo.OaQuestion;
import com.oa.dao.pojo.OaQuestionnaire;

public class OaQuestionDaoImple extends HibernateDaoSupport implements
		OaQuestionDaoInf {
	// 增加问题
	@Override
	public boolean addQuestion(OaQuestion oaQuestion, List<OaOptions> optionsset) {
		// TODO Auto-generated method stub
		try {
			Set<OaOptions> options = oaQuestion.getOaOptionses();
			if (optionsset != null && optionsset.size() > 0) {
				for (OaOptions oaOptions : optionsset) {
					oaOptions.setOaQuestion(oaQuestion);
					options.add(oaOptions);
				}
			}
			getHibernateTemplate().save(oaQuestion);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 删除问题
	@Override
	public boolean delQuestion(int questionid) {
		// TODO Auto-generated method stub

		try {
			OaQuestion question = getHibernateTemplate().load(OaQuestion.class,
					questionid);
			question.setQuestionDeltype("1");
			getHibernateTemplate().update(question);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

		return true;
	}

	// 查询单独问题
	@Override
	public OaQuestion selectIdQuestion(int questionid) {
		// TODO Auto-generated method stub
		OaQuestion question = null;
		try {
			question = getHibernateTemplate().get(OaQuestion.class, questionid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return question;
	}

	// 查询问卷所有问题
	@Override
	public List<OaQuestion> selectQuestionnaire(final int qid,
			final UserInfo userInfo) {
		// TODO Auto-generated method stub

		List<OaQuestion> questions = getHibernateTemplate().executeFind(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						String hql = " select questions from OaQuestion questions , CenNaireQuestion cen where  cen.id.oaQuestion.questionId = questions.questionId and cen.id.oaQuestionnaire.qid = "
								+ qid;
						int currpage = userInfo.getCurrPage();
						int pageSize = userInfo.PAGE_SIZE;

						Query query = session.createQuery(hql);
						query.setFirstResult((currpage - 1) * pageSize);
						query.setMaxResults(pageSize);
						List<OaQuestion> list = query.list();

						return list;
					}
				});

		return questions;

	}

	// 查询所有问题
	@SuppressWarnings("unchecked")
	@Override
	public List<OaQuestion> selectTitleQuestion(final String questionTitle,
			final String questionType, final UserInfo userInfo,
			final int naireid) {

		// TODO Auto-generated method stub
		List<OaQuestion> questions = getHibernateTemplate().executeFind(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						String hql = " from OaQuestion where questionDeltype='0' ";
						String halcount = "select count(*) from OaQuestion where questionDeltype='0'";
						if (questionTitle != null && questionTitle.length() > 0) {
							hql = hql + " and questionName like '%"
									+ questionTitle + "%'";
							halcount = halcount + " and questionName like '%"
									+ questionTitle + "%'";
						}
						if (!questionType.equals("0")) {
							hql = hql + " and questionType = '" + questionType
									+ "'";
							halcount = halcount + " and questionType = '"
									+ questionType + "'";
						}
						if (naireid != 0) {
							hql = hql
									+ " and questionId not in (select cen.id.oaQuestion.questionId from CenNaireQuestion cen where cen.id.oaQuestionnaire.qid = "
									+ naireid + ")";
							halcount = halcount
									+ " and questionId not in (select cen.id.oaQuestion.questionId from CenNaireQuestion cen where cen.id.oaQuestionnaire.qid = "
									+ naireid + ")";
						}
						hql = hql
								+ " order by questionType ASC,questionId DESC";
						Query query = session.createQuery(hql);
						int currPage = userInfo.getCurrPage();
						int pageSize = userInfo.PAGE_SIZE;
						currPage = currPage == 0 ? 1 : currPage;
						query.setFirstResult((currPage - 1) * pageSize);
						query.setMaxResults(pageSize);
						Query countQuery = session.createQuery(halcount);
						userInfo.setTotalCount(((Long) countQuery
								.uniqueResult()).intValue());
						List<OaQuestionnaire> list = query.list();

						return list;
					}
				});
		return questions;
	}

	// 查看单个问题
	@Override
	public List<OaOptions> selectOaOptions(final int questionid) {
		// TODO Auto-generated method stub
		List<OaOptions> options = getHibernateTemplate().executeFind(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						String hql = "from OaOptions ops where ops.oaQuestion.questionId = "
								+ questionid;
						Query query = session.createQuery(hql);
						List<OaOptions> options = query.list();
						return options;
					}
				});

		return options;
	}

	// 问卷的所有问题,预览问卷的信息
	@Override
	public List<Object[]> selectQuestionnaireOptions(final int qid,
			final UserInfo userInfo) {
		// TODO Auto-generated method stub

		List<Object[]> lists = getHibernateTemplate().executeFind(
				new HibernateCallback<List<Object[]>>() {

					@Override
					public List<Object[]> doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						String hql = "select cen.id.oaQuestion from CenNaireQuestion cen where cen.id.oaQuestionnaire.qid="
								+ qid +" order by cen.id.oaQuestion.questionType ASC,cen.id.oaQuestion.questionId DESC ";
						String hqlcount = "select count(*) from CenNaireQuestion cen where cen.id.oaQuestionnaire.qid="
								+ qid;
						
						Query countQuery = session.createQuery(hqlcount);
						userInfo.setTotalCount(((Long) countQuery
								.uniqueResult()).intValue());
						int currpage = userInfo.getCurrPage();
						int pageSize = userInfo.PAGE_SIZE;
						Query query = session.createQuery(hql);
						query.setFirstResult((currpage - 1) * pageSize);
						query.setMaxResults(pageSize);
						
						List<OaQuestion> questions = query.list();
						
						List<Object[]> list = new ArrayList<Object[]>();
						
						for (OaQuestion question : questions) {
							Object[] obs = new Object[2];
							String hqloption = "from OaOptions ops where ops.oaQuestion.questionId = "
									+ question.getQuestionId();
							List<OaOptions> options = session.createQuery(
									hqloption).list();
							Map<Integer, String> map = new HashMap<Integer, String>();
							for (OaOptions op : options) {
								map.put(op.getOptionId(), op.getPotionName());
							}
							obs[0] = question;
							obs[1] = map;
							list.add(obs);

						}

						return list;
					}
				});

		return lists;

	}



	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// OaQuestionnaireDaoInf daoImple = (OaQuestionnaireDaoInf)
		// applicationContext
		// .getBean("narieid");
		OaQuestionDaoInf daoInf = (OaQuestionDaoInf) applicationContext
				.getBean("questionDaoId");
		// daoInf.selectQuestionnaireOptions(128, 0, 3);
		// OaQuestion oaQuestion = new OaQuestion("问题");
		// Set<OaOptions> optionsset = new HashSet<OaOptions>();
		// OaOptions options1 = new OaOptions("选项1");
		// OaOptions options2 = new OaOptions("选项2");
		// OaOptions options3 = new OaOptions("选项3");
		// // options1.setOaQuestion(oaQuestion);
		// optionsset.add(options1);
		// optionsset.add(options2);
		// optionsset.add(options3);
		// // daoInf.addQuestion(oaQuestion, optionsset);
		// // daoInf.delQuestion(43);
		// // daoInf.selectTitleQuestion("题目", 0, 10);
		// // daoInf.selectOaOptions(44);
		// daoInf.selectQuestionnaireOptions(22, 0, 10);

	}

	// 查询单个的选项
	@Override
	public OaOptions selectOption(int optionid) {
		// TODO Auto-generated method stub
		OaOptions options = getHibernateTemplate().load(OaOptions.class,
				optionid);
		return options;
	}
//用户回答问卷
	@Override
	public List<Object[]> answerQuestionnaire(final int qid) {
		// TODO Auto-generated method stub
		List<Object[]> lists = getHibernateTemplate().executeFind(
				new HibernateCallback<List<Object[]>>() {

					@Override
					public List<Object[]> doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						String hql = "select cen.id.oaQuestion from CenNaireQuestion cen where cen.id.oaQuestionnaire.qid="
								+ qid +" order by cen.id.oaQuestion.questionType ASC,cen.id.oaQuestion.questionId DESC ";
						
						
						Query query = session.createQuery(hql);
						
						
						List<OaQuestion> questions = query.list();
						
						List<Object[]> list = new ArrayList<Object[]>();
						
						for (OaQuestion question : questions) {
							Object[] obs = new Object[2];
							String hqloption = "from OaOptions ops where ops.oaQuestion.questionId = "
									+ question.getQuestionId();
							List<OaOptions> options = session.createQuery(
									hqloption).list();
							Map<Integer, String> map = new HashMap<Integer, String>();
							for (OaOptions op : options) {
								map.put(op.getOptionId(), op.getPotionName());
							}
							obs[0] = question;
							obs[1] = map;
							list.add(obs);

						}

						return list;
					}
				});

		return lists;
	}

}
