package com.oa.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.oa.dao.inf.TPostFileDao;
import com.oa.dao.pojo.TPostFile;
import com.oa.util.HibernateSessionFactory;

public class TPostFileDaoImp extends HibernateDaoSupport implements TPostFileDao {

	@Override
	public boolean addPostFile(TPostFile tPostFile) {

		
		getHibernateTemplate().save(tPostFile);
		
		return true;
	}

	@Override
	public boolean deletePostFile(final int id) {
		getHibernateTemplate().execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session)
					throws HibernateException, SQLException {
				//奇怪的错误
//				String hql = "delete from TPostFile t where t.postid=:postid";
//				Query query =session.createQuery(hql);
//				query.setInteger("postid", id);
				
				String hql = "delete from TPostFile where postid="+id;
				Query query =session.createQuery(hql);
				  query.executeUpdate();
				return false;
			}
		});
		return false;

	}

	@Override
	public TPostFile selectSingleTPostFile(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().load(TPostFile.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TPostFile> selectTPostFiles(final int postId) {
		return getHibernateTemplate().executeFind(
				new HibernateCallback<List<TPostFile>>() {
					@Override
					public List<TPostFile> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<TPostFile> tPostFiles =new  ArrayList<TPostFile>();
						String hql = "from TPostFile tpf where tpf.postid=:postid";
						Query query = session.createQuery(hql);
						query.setParameter("postid", postId);
						tPostFiles = query.list();
						return tPostFiles;
					}
				});	
	 
	}
	//找出所有的公告附件
	@Override
	public List findAll(){
		return getHibernateTemplate().loadAll(TPostFile.class);
	}

}
