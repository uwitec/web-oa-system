package com.oa.dao.impl;

import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.query.HQLQueryPlan;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

 


import com.oa.common.UserInfo;
import com.oa.dao.inf.TPostDao;
import com.oa.dao.pojo.TData;
import com.oa.dao.pojo.TPost;
import com.oa.dao.pojo.TUser;
import com.oa.util.HibernateSessionFactory;
import com.oa.util.PostInfo;

public class TPostDaoImpl extends HibernateDaoSupport implements TPostDao{

	@Override
	public int addPost(TPost tPost) {
//	 getHibernateTemplate().save(tPost);
		Session session=null; 
		Transaction transaction=null;		
		session= HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
		String hql = "insert into T_POST(TITLE,CONTENT,BEGINDATE,ENDDATE,STATUS," +
				"HASFILE,ADDUSER,ADDTIME,UPDATEUSER,UPDATETIME) values('"
				+ tPost.getTitle() + "',empty_clob(),sysdate,sysdate,0,0,'"
				+ tPost.gettUserByAdduser()+ "',sysdate,null,sysdate)";
//		String sqlSeq = "select  SEQ_T_POST.currval from dual";
		Query query =session.createQuery(hql);
	
		try {
//			String sqlClob = "select content from t_post where postid="
//				+ tPost.getPostid() + " for update";
//			query =session.createQuery(sqlClob);
			session.refresh(tPost, LockMode.UPGRADE);
			
			Clob clob = tPost.getContent();
			Writer writer = clob.setCharacterStream(0);
			writer.write("---clob--");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return tPost.getPostid();
	}

	@Override
	public boolean deletePost(int postId) {
		 getHibernateTemplate().delete(postId);
		return true;
	}

	@Override
	public List<TPost> selectPosts(String title) {
		Session session=null; 
		session=HibernateSessionFactory.getSession();
		List<TPost> tposts = new ArrayList<TPost>();
		String hql= "from t_post where  TITLE like '%" + title
				+ "%'";
		Query query =session.createQuery(hql);
	 
		tposts=query.list();
		
		for (TPost tPost : tposts) {
			String  out= "tPost.getContent():"+tPost.getContent()+
			"tPost.getTitle():"+tPost.getTitle()+
			"tPost.gettUserByAdduser():"+tPost.gettUserByAdduser()+
			"tPost.getAddtime():"+tPost.getAddtime();
		}
	return tposts;
		
	}

	@Override
	public TPost selectSinglePost(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int upadtePost(TPost tPost) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TPost> findAll(final PostInfo postInfo) {
		List<TPost> tpostList = getHibernateTemplate().executeFind(
				new HibernateCallback<List<TUser>>() {
					@Override
					public List<TUser> doInHibernate(Session session)
							throws HibernateException, SQLException {

						StringBuffer hql = new StringBuffer(
								"select new TUser(user.userid, user.realname, user.department, user.job, user.addtime) from TUser user where 1 = 1");
						StringBuffer countHql = new StringBuffer(
								"select count(*) from TUser user where 1 = 1");

						String title = postInfo.getTpost().getTitle();
						Boolean status = postInfo.getTpost().getStatus();
						TUser addUser= postInfo.getTpost().gettUserByAdduser();
						int currPage = postInfo.getCurrPage();
						currPage = currPage == 0 ? 1 : currPage;

						if (null != title && !"".equals(title)) {
							hql.append(" and tpost.title like '%" + title
									+ "%'");
							countHql.append(" and tpost.title like '%" + title
									+ "%'");
						}

						Query countQuery = session.createQuery(countHql
								.toString());
						postInfo.setTotalCount(((Long) countQuery
								.uniqueResult()).intValue());

						Query query = session.createQuery(hql.toString());
						query.setFirstResult((currPage - 1)
								* PostInfo.PAGE_SIZE);
						query.setMaxResults(PostInfo.PAGE_SIZE);
						return query.list();
					}
				});
		postInfo.setTpostList(tpostList);
		return tpostList;
	}

}
