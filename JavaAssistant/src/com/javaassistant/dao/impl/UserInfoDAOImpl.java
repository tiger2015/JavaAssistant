package com.javaassistant.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.javaassistant.dao.UserInfoDAO;
import com.javaassistant.model.UserInfo;

public class UserInfoDAOImpl implements UserInfoDAO {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean save(UserInfo userInfo) {
		// TODO Auto-generated method stub
		try {
			this.hibernateTemplate.save(userInfo);

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

		return true;
	}

	public boolean update(UserInfo userInfo) {
		// TODO Auto-generated method stub
		try {
			this.hibernateTemplate.update(userInfo);

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

		return true;
	}

	public List<UserInfo> loadAllUserInfo() {
		// TODO Auto-generated method stub
		String sql = "select * from UserInfo";
		List<UserInfo> list = (List<UserInfo>) this.hibernateTemplate.find(sql,
				null);
		return list;
	}

	public UserInfo loadUserInfoById(int id) {
		// TODO Auto-generated method stub
		UserInfo userInfo = this.hibernateTemplate.get(UserInfo.class, id);
		return userInfo;
	}

	public UserInfo loadUserByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from UserInfo where name=?";
		List<UserInfo> list = (List<UserInfo>) this.hibernateTemplate.find(sql,
				new Object[] { name });
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public List<UserInfo> loadUserInfoByPage(final int startId,
			final int pageSize) {
		// TODO Auto-generated method stub
		final String sql = "select * from UserInfo";
		List<UserInfo> list = (List<UserInfo>) this.hibernateTemplate
				.execute(new HibernateCallback<Object>() {

					public Object doInHibernate(Session session)
							throws HibernateException {
						// TODO Auto-generated method stub
						Query query = session.createQuery(sql);
						query.setFirstResult(startId);
						query.setFetchSize(pageSize);
						return query.list();
					}
				});

		return list;
	}

	public long getUserInfoCount() {
		// TODO Auto-generated method stub
		final String sql = "select count(*) from UserInfo";
		long count = (Long) this.hibernateTemplate
				.execute(new HibernateCallback<Object>() {

					public Object doInHibernate(Session session)
							throws HibernateException {
						// TODO Auto-generated method stub
						Query query = session.createQuery(sql);
						return query.uniqueResult();
					}
				});

		return count;
	}

}
