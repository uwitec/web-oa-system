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
						Integer postId = (Integer) session.save(tPost);
						ts.commit();
						return postId;
					}
				});
		return postId;
	}
//	@Override
//	public void deletePost(final TPost tpost) {
//
//		  getHibernateTemplate().delete(tpost);		
//	}
	
	
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
//						session.update(tPost);
//						session.flush();
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
	
	@Override
	public List<TPost> findAll(final UserInfo userInfo) {
		return getHibernateTemplate().executeFind(
				new HibernateCallback<List<TUser>>() {
					@Override
					public List<TUser> doInHibernate(Session session)
							throws HibernateException, SQLException {
						//select new TPost(tpost.postid, tpost.title, tpost.content,tpost.begindate,tpost.enddate,tpost.status,tpost.adduser, tpost.addtime) from TPost tpost where 1 = 1
								StringBuffer hql = new StringBuffer(
								"from TPost tpost where 1 = 1");
						StringBuffer countHql = new StringBuffer(
								"select count(*) from TPost tpost where 1 = 1");
						//根据标题查询和有效时间查询
						String title = userInfo.getTpost().getTitle();
//						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");						
//						String begin = sdf.format(userInfo.getTpost().getBegindate());
//						String end = sdf.format(userInfo.getTpost().getEnddate());
						Date begin = userInfo.getTpost().getBegindate();
						Date end = userInfo.getTpost().getEnddate();
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
						return query.list();
			
					}
				});
	 
		 
	}
	//级联表列出用户所有公告
	@Override
	public List<TUserPost> getPosts(final TUserPost tUserPost, final UserInfo userInfo) {
		return getHibernateTemplate().executeFind(
				new HibernateCallback<List<TPost>>() {
					@Override
					public List<TPost> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = null;
						String hql = "from TUserPost t where t.id.user.userid = :userid";
						int currPage = userInfo.getCurrPage();
						currPage = currPage == 0 ? 1 : currPage;
						int postStatus = tUserPost.getId().gettPost().getStatus();
						query=session.createQuery(hql);
						query.setParameter("userid", userInfo.getUser()
								.getUserid());

																	
						List<TUserPost>  tposts = query.list();
						for (TUserPost t : tposts) {
							System.out.println(t.getId().gettPost().getTitle());
						}
						userInfo.setTotalCount(tposts.size());
						query.setFirstResult((currPage - 1)
								* UserInfo.PAGE_SIZE);
						query.setMaxResults(currPage * UserInfo.PAGE_SIZE);

						return query.list();
					}
				});
	}
	
	
	
	//通过级联删除
	@Override
	public void deletePost(final TUserPost tpost) {
		getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "delete from TUserPost t where t.id.tUser.userid = :userid and t.id.tPost.postid = :postid";
				Query query = session.createQuery(hql);
				
				query.setParameter("userid",  tpost.getId().gettUser().getUserid());
				query.setParameter("postid", tpost.getId().gettPost().getPostid());

				return query.executeUpdate();
			}
		});
		
	}




	
	//级联表的记录增加
	@Override
	public void saveUserPost(TUserPost tUserPost) {
		getHibernateTemplate().save(tUserPost);
		
	}
	//通过级选择
	@Override
	public TPost selectSinglePost(final TUserPost tUserPost) {
		return getHibernateTemplate().execute(new HibernateCallback<TPost>() {
			
			@Override
			public TPost doInHibernate(Session session)
					throws HibernateException, SQLException {
				TPost tPost = (TPost) session.load(TPost.class, tUserPost
						.getId().gettPost().getPostid());
				Clob content = tPost.getContent();
				tPost.setStrContent(content.getSubString(1L, (int) content
						.length()));
 
				return tPost;
			}
		});
	}

//删除公告文件
	@Override
	public void deletePostFile(TPostFile tPostFile) {
		getHibernateTemplate().delete(tPostFile);
	}


	@Override
	public void deletePost(TPost tPost) {
		getHibernateTemplate().delete(tPost);
		 
	}
	

	

}
