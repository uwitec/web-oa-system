package com.oa.dao.impl;

import java.io.IOException;
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
import com.oa.dao.pojo.TEmail;
import com.oa.dao.pojo.TPost;
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
	@Override
	public void deletePost(final TPost tpost) {
//		 getHibernateTemplate().execute(new HibernateCallback<TPost>() {
//			
//			@Override
//			public void doInHibernate(Session session)
//					throws HibernateException, SQLException {
//				session.delete(tpost);			 
//			}
//		});return true;
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
						String hql = "update TPost set t.title ='"
							+ tPost.getTitle()
							+ "',POSTCONTENT=empty_clob() where t.postid="
							+ tPost.getPostid();
						Query query = session.createQuery(hql);
						query.setParameter("title", tPost.getTitle());
						query.setParameter("postid", tPost.getPostid());
						
						//tPost.setContent(Hibernate.createClob(" "));
						session.save(tPost);
						session.flush();// insert postFIle 级联
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
	public List<TPost> findAll(final PostInfo postInfo) {
		List<TPost> tpostList = getHibernateTemplate().executeFind(
				new HibernateCallback<List<TUser>>() {
					@Override
					public List<TUser> doInHibernate(Session session)
							throws HibernateException, SQLException {

						StringBuffer hql = new StringBuffer(
								"select new TPost(tpost.postid, tpost.title, tpost.content,tpost.begindate,tpost.enddate,tpost.status,tpost.adduser, tpost.addtime) from TPost tpost where 1 = 1");
						StringBuffer countHql = new StringBuffer(
								"select count(*) from TPost tpost where 1 = 1");

						String title = postInfo.getTpost().getTitle();
						Integer status = postInfo.getTpost().getStatus();
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
	//级联表列出用户所有公告
	@Override
	public List<TUserPost> selectPosts(final TUserPost tUserPost, final UserInfo userInfo) {
		return getHibernateTemplate().executeFind(
				new HibernateCallback<List<TPost>>() {
					@Override
					public List<TPost> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = null;
						String hql = "from TUserPost t where t.id.user.userid = :userid";
						int currPage = userInfo.getCurrPage();
						currPage = currPage == 0 ? 1 : currPage;

					 
						

																	
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
	@Override
	public List<TPost> selectPosts(final TPost tPost, final UserInfo userInfo) {
		return getHibernateTemplate().executeFind(
				new HibernateCallback<List<TPost>>() {
					@Override
					public List<TPost> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = null;
						String hql = "from TUserPost t where t.id.user.userid = :userid";
						int currPage = userInfo.getCurrPage();
						currPage = currPage == 0 ? 1 : currPage;
														
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
				String hql = "delete from TUserPost t where t.id.user.userid = :userid and t.id.post.postid = :postid";
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
	

	

}
