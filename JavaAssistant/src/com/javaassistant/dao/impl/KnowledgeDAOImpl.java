package com.javaassistant.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.javaassistant.dao.KnowledgeDAO;
import com.javaassistant.model.Knowledge;

public class KnowledgeDAOImpl implements KnowledgeDAO {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean save(Knowledge knowledge) {
		// TODO Auto-generated method stub
		try {
			this.hibernateTemplate.save(knowledge);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean update(Knowledge knowledge) {
		// TODO Auto-generated method stub
		try {
			this.hibernateTemplate.update(knowledge);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public List<Knowledge> loadAllKnowledge() {
		// TODO Auto-generated method stub
		String sql = "select * from Knowledge";

		try {
			List<Knowledge> list = (List<Knowledge>) this.hibernateTemplate
					.find(sql, null);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Knowledge loadKnowledgeById(int id) {
		// TODO Auto-generated method stub
		Knowledge knowledge = this.hibernateTemplate.get(Knowledge.class, id);
		return knowledge;
	}

	public List<Knowledge> loadKnowledgeByType(int type) {
		// TODO Auto-generated method stub
		List<Knowledge> list = null;
		String sql = "select * from Knowledge where type=?";
		try {
			list = (List<Knowledge>) this.hibernateTemplate.find(sql,
					new Object[] { type });
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Knowledge> loadKnowledgeByPage(final int startId,
			final int pageSize) {
		// TODO Auto-generated method stub
		List<Knowledge> list = (List<Knowledge>) this.hibernateTemplate
				.execute(new HibernateCallback<Object>() {

					public Object doInHibernate(Session session)
							throws HibernateException {
						// TODO Auto-generated method stub
						Query query = session.createQuery("from Knowledge");
						query.setFirstResult(startId);
						query.setFetchSize(pageSize);
						return query.list();
					}
				});

		return list;
	}

	public long getKnowledgeCount() {
		// TODO Auto-generated method stub
		final String sql = "select count(*) from Knowledge";
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

	public long getKnowledgeCountByType(int type) {
		// TODO Auto-generated method stub
		final String sql = "select count(*) from Knowledge where type=" + type;
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
