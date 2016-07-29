package com.javaassistant.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.javaassistant.dao.QuestionDAO;
import com.javaassistant.model.Question;

public class QuestionDAOImpl implements QuestionDAO {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean save(Question question) {
		// TODO Auto-generated method stub
		try {
			this.hibernateTemplate.save(question);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

		return true;
	}

	public boolean update(Question question) {
		// TODO Auto-generated method stub
		try {
			this.hibernateTemplate.update(question);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	public List<Question> loadAllQuestion() {
		// TODO Auto-generated method stub
		String sql = "select * from Question";
		try {
			List<Question> list = (List<Question>) this.hibernateTemplate.find(
					sql, null);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Question loadQuestionById(int id) {
		// TODO Auto-generated method stub
		// 使用load若不存在，则会抛出异常
		Question question = this.hibernateTemplate.get(Question.class, id);
		return question;
	}

	public List<Question> loadQuestionByType(int type) {
		// TODO Auto-generated method stub
		String sql = "select * from Question where type=?";
		try {
			List<Question> list = (List<Question>) this.hibernateTemplate.find(
					sql, new Object[] { type });
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<Question> loadQuestionByRandomAndType(int type, int count) {
		// TODO Auto-generated method stub
		String sql = "select * from (select * from Question where type=? order by sys_guid()) where rownum <= ?";
		try {

			List<Question> list = (List<Question>) this.hibernateTemplate.find(
					sql, new Object[] { type, count });
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public long getQuestionCount() {
		// TODO Auto-generated method stub
		final String sql = "select count(*) from Question";
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

	public long getQuestionCountByType(int type) {
		// TODO Auto-generated method stub
		final String sql = "select count(*) from Question where type=" + type;
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

	public List<Question> loadQuestionByTypeAndPage(int type,
			final int startId, final int pageSize) {
		// TODO Auto-generated method stub
		final String sql = "select * from Question where type=" + type;

		List<Question> list = (List<Question>) this.hibernateTemplate
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

	public List<Question> loadQuestionByPage(final int startId, final int pageSize) {
		// TODO Auto-generated method stub
		final String sql = "select * from Question";

		List<Question> list = (List<Question>) this.hibernateTemplate
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
}
