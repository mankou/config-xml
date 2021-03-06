package mang.tools.config.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import mang.tools.config.dao.BaseDAO;


@SuppressWarnings({ "rawtypes", "unchecked" })
public class BaseDAOImpl<T> extends HibernateDaoSupport implements BaseDAO<T> {
	private Class clazz;

	public void setSessionFactory0(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public BaseDAOImpl() {
		// ParameterizedType type =
		// (ParameterizedType)this.getClass().getGenericSuperclass();
		// clazz = (Class) type.getActualTypeArguments()[0];
	}

//	/**
//	 * 获取当前工作的Session
//	 */
//	protected Session getSession() {
//		return this.getSessionFactory().getCurrentSession();
//	}

	public T saveOrUpdate(T entity) {
		this.getSessionFactory().getCurrentSession().saveOrUpdate(entity);
//		this.getSession().saveOrUpdate(entity);
		return entity;
	}

	@Override
	public List<T> saverOrUpdateList(List<T> lis) {
		for (T t : lis) {
			this.saveOrUpdate(t);
		}
		return lis;
	}

	public T save(T entity) {
//		this.getSessionFactory().getCurrentSession().save(entity);
		this.getSession().save(entity);
//		this.getHibernateTemplate().save(entity);
		return entity;
	}

	@Override
	public List<T> saveOrUpdateBatch(final List<T> lis) {

		if (lis == null || lis.size() == 0) {
			return lis;
		}
		this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				for (int i = 0; i < lis.size(); i++) {
					T t = lis.get(i);
					session.save(t);
					if (i % 100 == 0) {
						session.flush();
						session.clear();
					}
				}
				return null;
			}
		});

		return lis;
	}

	@Override
	public T delete(T entity) {
//		this.getSessionFactory().getCurrentSession().delete(entity);
		this.getSession().delete(entity);
		return entity;
	}

	public T getById(Serializable id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

	public List<T> getAllData(String hql, Object... objects) {
		return (List<T>) this.getHibernateTemplate().find(hql, objects);

	}

	/*
	 * 分页查询 (non-Javadoc)
	 * 
	 * @see com.bdqn.Flower.dao.BaseDao#getDataByPage(java.lang.String, int,
	 * int, java.lang.Object[])
	 */
	public List<T> queryDataByPage(final String hql, final int offset, final int length, final Object... objects) {

		// List<T> list = this.getHibernateTemplate().executeFind(new
		// HibernateCallback() {
		// public Object doInHibernate(Session session) throws
		// HibernateException,
		// SQLException {
		// Query query = session.createQuery(hql);
		// if(objects!=null){
		// for (int i = 0; i < objects.length; i++) {
		// query.setParameter(i, objects[i]);
		// }
		// }
		// query.setFirstResult(offset);
		// query.setMaxResults(length);
		// List<T> list = query.list();
		// return list;
		// }
		// });
		// return list;
		return null;
	}

	public Object queryDataByObject(final String hql, final Object... objects) {
		// Object object = this.hibernateTemplate.execute(new
		// HibernateCallback() {
		//
		// public Object doInHibernate(Session session) throws
		// HibernateException,
		// SQLException {
		// Query query = session.createQuery(hql);
		// for (int i = 0; i < objects.length; i++) {
		// query.setParameter(0, objects[i]);
		// }
		// Object obj= query.uniqueResult();
		// return obj;
		// }
		// });
		// return object;
		return null;
	}

	@Override
	public T findById(Serializable id) {
		return (T) this.getSession().get(this.clazz, id);
	}

	@Override
	public List<T> findByHQL(String hql, Object... params) {
		Query query = this.getSession().createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params);
		}
		return query.list();
	}

}
