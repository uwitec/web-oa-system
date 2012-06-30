package com.oa.dao.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
 
import java.util.ArrayList;
import java.util.Date;
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
import com.oa.dao.inf.EmailDao;
import com.oa.dao.inf.TPostDao;
import com.oa.dao.pojo.TData;
import com.oa.dao.pojo.TEmail;
import com.oa.dao.pojo.TPost;
import com.oa.dao.pojo.TPostFile;
import com.oa.dao.pojo.TUser;
import com.oa.dao.pojo.TUserEmail;
import com.oa.dao.pojo.TUserPost;
import com.oa.util.HibernateSessionFactory;
import com.oa.util.PostInfo;

public class TPostDaoImpl extends HibernateDaoSupport implements TPostDao{

 
//时间比较select * from t_post t where t.begindate>'8-5月-12' and t.enddate<'30-7月-2012'

	//保存TPost对象
	@Override
	public Integer savePost(final TPost tPost) {
		Integer postId = getHibernateTemplate().execute(
				new HibernateCallback<Integer>() {

					@Override
					public Integer doInHibernate(Session session)
							throws HibernateException, SQLException {
						org.hibernate.Transaction ts = session
								.beginTransaction();
						
						tPost.setContent(Hibernate.createClob(" "));
						session.save(tPost);
						session.flush();
						//锁定
						session.refresh(tPost, LockMode.UPGRADE);
						Clob clob = tPost.getContent();
						Writer writer = clob.setCharacterStream(0);
						try {
							writer.write(tPost.getStrContent());
							writer.flush();
						} catch (IOException e) {
							e.printStackTrace();
						} finally {
							try {
								writer.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						tPost.setStatus(0);
						tPost.setAddtime(new Date());
						Integer postId = (Integer) session.save(tPost);
						ts.commit();
						return postId;
					}
				});
		return postId;
	}
	@Override
	public void deletePost(final TPost tpost) {

		  getHibernateTemplate().delete(tpost);		
	}
	
	
	@Override
	public int upadtePost(final TPost tPost) {
		Integer postId = getHibernateTemplate().execute(
				new HibernateCallback<Integer>() {

					@Override
					public Integer doInHibernate(Session session)
							throws HibernateException, SQLException {
						org.hibernate.Transaction ts = session
								.beginTransaction();
						//sql
						//update T_Post t set t.title ='aa',t.content=empty_clob() where t.postid=1

						String hql = "update TPost t set t.title =:title,t.content=empty_clob()" +
								",t.begindate=:begindate,t.enddate=:enddate, " +
								"t.hasfile=:hasfile,t.updatetime=sysdate where t.postid=:postid";
						Query query = session.createQuery(hql);			

						query.setParameter("title", tPost.getTitle());
						query.setParameter("postid", tPost.getPostid());
						query.setParameter("begindate", tPost.getBegindate());
						query.setParameter("enddate", tPost.getEnddate());
						query.setParameter("hasfile", tPost.getHasfile());
						
						query.executeUpdate();
						session.refresh(tPost, LockMode.UPGRADE);
						Clob clob = tPost.getContent();
						Writer writer = clob.setCharacterStream(0);
						try {
							writer.write(tPost.getStrContent());
							writer.flush();
						} catch (IOException e) {
							e.printStackTrace();
						} finally {
							try {
								writer.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						session.update(tPost);				
						ts.commit();		
						return 0;
					}
				});
		return postId;
	}
	
	//设置通过
	@Override
	public void passPost(final TPost tPost) {
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "update TPost t set t.status = "
						+ TPostDao.STATUS_PASS
						+ " where t.postid=:postid";
				Query query = session.createQuery(hql);
				query.setParameter("postid",tPost.getPostid());
	 
				return query.executeUpdate();
			}
		});		
	}
	
	//通过Id获得公告
	public TPost selectSinglePost(final int postid) {
		return getHibernateTemplate().execute(new HibernateCallback<TPost>() {
			
			@Override
			public TPost doInHibernate(Session session)
					throws HibernateException, SQLException {
				TPost tPost = (TPost) session.load(TPost.class, postid);
				Clob content = tPost.getContent();
				tPost.setStrContent(content.getSubString(1L, (int) content
						.length()));				
				return tPost;
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TPost> findSelfAll(final UserInfo userInfo) {
		return getHibernateTemplate().executeFind(
				new HibernateCallback<List<TPost>>() {
					@Override
					public List<TPost> doInHibernate(Session session)
							throws HibernateException, SQLException {
						//select new TPost(tpost.postid, tpost.title, tpost.content,tpost.begindate,tpost.enddate,tpost.status,tpost.adduser, tpost.addtime) from TPost tpost where 1 = 1
								StringBuffer hql = new StringBuffer(
								"from TPost tpost where  1 = 1 and tpost.status=1");
						StringBuffer countHql = new StringBuffer(
								"select count(*) from TPost tpost where 1 = 1 and tpost.status=1 ");
						//根据标题查询和有效时间查询
						String title = userInfo.getTpost().getTitle();

						Date begin = userInfo.getTpost().getBegindate();
						Date end = userInfo.getTpost().getEnddate();
//						SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//						 String strBegin=df.format(begin);
						int currPage = userInfo.getCurrPage();
						currPage = currPage == 0 ? 1 : currPage;

						if (null != title && !"".equals(title)) {
							hql.append(" and tpost.title like '%" + title
									+ "%'");
							countHql.append(" and tpost.title like '%" + title
									+ "%'");
						}
						if (null != begin && !"".equals(begin)) {
							hql.append(" and tpost.begindate >" + begin);
							countHql.append(" and tpost.begindate >" + begin);
						}
						if (null != end && !"".equals(end)) {
							hql.append(" and tpost.enddate <" + end);
							countHql.append(" and tpost.enddate <" + end);
						}
							hql.append(" order by tpost.addtime desc");

						Query countQuery = session.createQuery(countHql
								.toString());
						userInfo.setTotalCount(((Long) countQuery
								.uniqueResult()).intValue());

						Query query = session.createQuery(hql.toString());
						query.setFirstResult((currPage - 1)
								* PostInfo.PAGE_SIZE);
						query.setMaxResults(PostInfo.PAGE_SIZE);
						
						
						List<TPost> postList = query.list();
						for (TPost post : postList) {
							Clob content = post.getContent();
							post.setStrContent(content.getSubString(1L, (int) content
									.length()));				
						}
						return postList;
			
					}
				});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TPost> findAll(final UserInfo userInfo) {
		return getHibernateTemplate().executeFind(
				new HibernateCallback<List<TPost>>() {
					@Override
					public List<TPost> doInHibernate(Session session)
							throws HibernateException, SQLException {
						//select new TPost(tpost.postid, tpost.title, tpost.content,tpost.begindate,tpost.enddate,tpost.status,tpost.adduser, tpost.addtime) from TPost tpost where 1 = 1
								StringBuffer hql = new StringBuffer(
								"from TPost tpost where 1 = 1");
						StringBuffer countHql = new StringBuffer(
								"select count(*) from TPost tpost where 1 = 1");
						//根据标题查询和有效时间查询
						String title = userInfo.getTpost().getTitle();
						Date begin = userInfo.getTpost().getBegindate();
						Date end = userInfo.getTpost().getEnddate();
						int currPage = userInfo.getCurrPage();
						currPage = currPage == 0 ? 1 : currPage;
						
 
						if (null != begin && !"".equals(begin)) {
							hql.append(" and tpost.begindate >" + begin);
							countHql.append(" and tpost.begindate >" + begin);
						}
						if (null != title && !"".equals(title)) {
							hql.append(" and tpost.title like '%" + title
									+ "%'");
							countHql.append(" and tpost.title like '%" + title
									+ "%'");
						}
						if (null != begin && !"".equals(begin)) {
							hql.append(" and tpost.begindate >" + begin);
							countHql.append(" and tpost.begindate >" + begin);
						}
						if (null != end && !"".equals(end)) {
							hql.append(" and tpost.enddate >" + begin);
							countHql.append(" and tpost.enddate >" + begin);
						}
							hql.append(" order by tpost.addtime desc");

						Query countQuery = session.createQuery(countHql
								.toString());
						userInfo.setTotalCount(((Long) countQuery
								.uniqueResult()).intValue());

						Query query = session.createQuery(hql.toString());
						query.setFirstResult((currPage - 1)
								* PostInfo.PAGE_SIZE);
						query.setMaxResults(PostInfo.PAGE_SIZE);
						
						
						List<TPost> postList = query.list();
						for (TPost post : postList) {
							Clob content = post.getContent();
							post.setStrContent(content.getSubString(1L, (int) content
									.length()));				
						}
						return postList;
			
					}
				});
	 
		 
	}
	
	
	
	
	@Override
	public void deletePostFile(TPostFile tPostFile) {
		getHibernateTemplate().delete(tPostFile);
	}
	@Override
	public void deltePost(final int postid) {
//		getHibernateTemplate().delete(postid);
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "delete from TPost t where t.postid=:postid";
				Query query = session.createQuery(hql);
				query.setParameter("postid",postid);
				return query.executeUpdate();
			}
		});		
	}

 

}
