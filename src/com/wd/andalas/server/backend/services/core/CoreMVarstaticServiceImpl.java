package com.wd.andalas.server.backend.services.core;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sencha.gxt.data.shared.loader.ListLoadConfig;
import com.sencha.gxt.data.shared.loader.ListLoadResult;
import com.sencha.gxt.data.shared.loader.ListLoadResultBean;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoadResultBean;
import com.wd.andalas.client.backend.services.core.CoreMVarstaticService;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTO;
import com.wd.andalas.server.backend.HibernateUtil;
import com.wd.andalas.server.backend.models.core.CoreMVarstatic;

public class CoreMVarstaticServiceImpl extends RemoteServiceServlet implements CoreMVarstaticService {

	/********** Inisiasi **********/
	private static final long serialVersionUID = 1L;

	/********** Main Methods **********/
	@SuppressWarnings("unchecked")
	@Override
	public CoreMVarstaticDTO getById(String id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String queryText = "FROM CoreMVarstatic WHERE varstat_id = :idnya";
		Query query = session.createQuery(queryText);
		query.setParameter("idnya", id);
		List<CoreMVarstatic> list = query.list();

		session.getTransaction().commit();
		session.close();

		CoreMVarstaticDTO result = new CoreMVarstaticDTO(list.get(0));
		return result;
	}

	@SuppressWarnings({ "unchecked" })
	private int getAllUnpaged() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String queryText = "FROM CoreMVarstatic";
		Query query = session.createQuery(queryText);
		List<CoreMVarstatic> result = query.list();

		session.getTransaction().commit();
		session.close();

		return result.size();
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public PagingLoadResult<CoreMVarstaticDTO> getAllPaged(PagingLoadConfig loadConfig) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String queryText = "FROM CoreMVarstatic";
		Query query = session.createQuery(queryText);

		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());

		List<CoreMVarstatic> result = query.list();

		List<CoreMVarstaticDTO> resultDTO = new ArrayList<CoreMVarstaticDTO>(result != null ? result.size() : 0);
		if (result != null) {
			for (CoreMVarstatic obj : result) {
				resultDTO.add(new CoreMVarstaticDTO(obj));
			}
		}

		session.getTransaction().commit();
		session.close();

		int allRecordSize = getAllUnpaged();

		return new PagingLoadResultBean<CoreMVarstaticDTO>(resultDTO, allRecordSize, loadConfig.getOffset());
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public ListLoadResult<CoreMVarstaticDTO> getAllGrup(ListLoadConfig loadConfig) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		//DENGAN METODE HQL
		//----------------------------------------------
		String queryText = "FROM CoreMVarstatic";
		Query query = session.createQuery(queryText);
		List<CoreMVarstatic> result = query.list();

		//DENGAN METODE CRITERIA
		//----------------------------------------------
		/*Criteria crit = session.createCriteria(CoreMVarstatic.class);
		crit.add(Restrictions.isNotNull("varstatGroup"));
		crit.setResultTransformer( DistinctRootEntityResultTransformer.INSTANCE );
		List<CoreMVarstatic> result = crit.list();*/

		//DENGAN METODE NATIVE QUERY
		//----------------------------------------------
		/*List<CoreMVarstatic> result = session.createSQLQuery("SELECT * FROM core_m_varstatic").addEntity(CoreMVarstatic.class).list();*/

		List<String> arrVarstatGroup = new ArrayList<String>();
		List<CoreMVarstaticDTO> resultDTO = new ArrayList<CoreMVarstaticDTO>(result != null ? result.size() : 0);
		if (result != null) {
			for (CoreMVarstatic obj : result) {
				if (arrVarstatGroup.contains(obj.getVarstatGroup()) == false) {
					resultDTO.add(new CoreMVarstaticDTO(obj));
					arrVarstatGroup.add(obj.getVarstatGroup());
				}
			}
		}

		session.getTransaction().commit();
		session.close();

		return new ListLoadResultBean<CoreMVarstaticDTO>(resultDTO);
	}
	
	@Override
	public Boolean insert(CoreMVarstaticDTO entity) {
		Boolean retVal = false;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		CoreMVarstatic objEntity = new CoreMVarstatic(entity);
		try {
			session.save(objEntity);
			session.getTransaction().commit();
			retVal = true;
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		
		session.close();
		return retVal;
	}
	
	@Override
	public Boolean update(CoreMVarstaticDTO entity) {
		Boolean retVal = false;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		CoreMVarstatic objEntity = new CoreMVarstatic(entity);
		try {
			session.update(objEntity);
			session.getTransaction().commit();
			retVal = true;
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		
		session.close();
		return retVal;
	}
	
	@Override
	public Boolean delete(CoreMVarstaticDTO entity) {
		Boolean retVal = false;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		CoreMVarstatic objEntity = new CoreMVarstatic(entity);
		try {
			session.delete(objEntity);
			session.getTransaction().commit();
			retVal = true;
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		
		session.close();
		return retVal;
	}

}
