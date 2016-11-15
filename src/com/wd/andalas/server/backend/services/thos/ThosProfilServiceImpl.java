package com.wd.andalas.server.backend.services.thos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoadResultBean;
import com.wd.andalas.client.backend.services.thos.ThosProfilService;
import com.wd.andalas.client.frontend.models.thos.ThosProfilDTO;
import com.wd.andalas.server.backend.HibernateUtil;
import com.wd.andalas.server.backend.models.thos.ThosProfil;

public class ThosProfilServiceImpl extends RemoteServiceServlet implements ThosProfilService {

	/********** Inisiasi **********/
	private static final long serialVersionUID = 1L;

	/********** Main Methods **********/
	@SuppressWarnings("unchecked")
	@Override
	public ThosProfilDTO getById(String id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String queryText = "FROM ThosProfil WHERE profil_id = :idnya";
		Query query = session.createQuery(queryText);
		query.setParameter("idnya", id);
		List<ThosProfil> list = query.list();

		session.getTransaction().commit();
		session.close();

		ThosProfilDTO result = new ThosProfilDTO(list.get(0));
		return result;
	}

	@SuppressWarnings({ "unchecked" })
	private int getAllUnpaged() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String queryText = "FROM ThosProfil";
		Query query = session.createQuery(queryText);
		List<ThosProfil> result = query.list();

		session.getTransaction().commit();
		session.close();

		return result.size();
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public PagingLoadResult<ThosProfilDTO> getAllPaged(PagingLoadConfig loadConfig) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String queryText = "FROM ThosProfil";
		Query query = session.createQuery(queryText);

		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());

		List<ThosProfil> result = query.list();

		List<ThosProfilDTO> resultDTO = new ArrayList<ThosProfilDTO>(result != null ? result.size() : 0);
		if (result != null) {
			for (ThosProfil obj : result) {
				resultDTO.add(new ThosProfilDTO(obj));
			}
		}

		session.getTransaction().commit();
		session.close();

		int allRecordSize = getAllUnpaged();

		return new PagingLoadResultBean<ThosProfilDTO>(resultDTO, allRecordSize, loadConfig.getOffset());
	}

}
