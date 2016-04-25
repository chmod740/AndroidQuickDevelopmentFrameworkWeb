package me.hupeng.android.service.DAO;

import java.util.List;

import me.hupeng.android.service.bean.Aqd;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Aqd
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see me.hupeng.android.service.bean.Aqd
 * @author MyEclipse Persistence Tools
 */
public class AqdDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(AqdDAO.class);

	public void save(Aqd transientInstance) {
		log.debug("saving Aqd instance");
		Transaction transaction = getSession().beginTransaction();
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		transaction.commit();
		getSession().flush();
		getSession().close();
	}

	public void delete(Aqd persistentInstance) {
		log.debug("deleting Aqd instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Aqd findById(java.lang.Integer id) {
		log.debug("getting Aqd instance with id: " + id);
		try {
			Aqd instance = (Aqd) getSession().get(
					"me.hupeng.android.service.bean.Aqd", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Aqd instance) {
		log.debug("finding Aqd instance by example");
		try {
			List results = getSession()
					.createCriteria("me.hupeng.android.service.bean.Aqd")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Aqd instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Aqd as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Aqd instances");
		try {
			String queryString = "from Aqd";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Aqd merge(Aqd detachedInstance) {
		log.debug("merging Aqd instance");
		try {
			Aqd result = (Aqd) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Aqd instance) {
		log.debug("attaching dirty Aqd instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Aqd instance) {
		log.debug("attaching clean Aqd instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}