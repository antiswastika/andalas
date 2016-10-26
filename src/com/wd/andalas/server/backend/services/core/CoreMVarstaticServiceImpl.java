package com.wd.andalas.server.backend.services.core;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
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
	@Override
	public List<CoreMVarstaticDTO> getAll() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String queryText = "FROM CoreMVarstatic";
		Query query = session.createQuery(queryText);
		List<CoreMVarstatic> result = query.list();

		List<CoreMVarstaticDTO> resultDTO = new ArrayList<CoreMVarstaticDTO>(result != null ? result.size() : 0);
		if (result != null) {
			for (CoreMVarstatic obj : result) {
				resultDTO.add(new CoreMVarstaticDTO(obj));
			}
		}

		session.getTransaction().commit();
		session.close();

		return resultDTO;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public PagingLoadResult<CoreMVarstaticDTO> getAllPaged(PagingLoadConfig loadConfig) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String queryText = "FROM CoreMVarstatic";
		Query query = session.createQuery(queryText);
		List<CoreMVarstatic> result = query.list();

		List<CoreMVarstaticDTO> resultDTO = new ArrayList<CoreMVarstaticDTO>(result != null ? result.size() : 0);
		if (result != null) {
			for (CoreMVarstatic obj : result) {
				resultDTO.add(new CoreMVarstaticDTO(obj));
			}
		}

		session.getTransaction().commit();
		session.close();

		PagingLoadResult<CoreMVarstaticDTO> resultFinal = new PagingLoadResult<CoreMVarstaticDTO>() {
			private static final long serialVersionUID = 1L;
			@Override
			public List<CoreMVarstaticDTO> getData() {
				return resultDTO;
			}
			@Override
			public void setTotalLength(int totalLength) {
				// TODO Auto-generated method stub
			}
			@Override
			public void setOffset(int offset) {
				// TODO Auto-generated method stub
			}
			@Override
			public int getTotalLength() {
				// TODO Auto-generated method stub
				return resultDTO.size();
			}
			@Override
			public int getOffset() {
				// TODO Auto-generated method stub
				return 5;
			}
		};

		return resultFinal;
	}

}
