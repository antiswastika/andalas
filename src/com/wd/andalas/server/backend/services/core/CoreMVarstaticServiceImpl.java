package com.wd.andalas.server.backend.services.core;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.wd.andalas.client.backend.services.core.CoreMVarstaticService;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTO;
import com.wd.andalas.server.backend.HibernateUtil;
import com.wd.andalas.server.backend.models.core.CoreMVarstatic;

public class CoreMVarstaticServiceImpl extends RemoteServiceServlet implements CoreMVarstaticService {

	private static final long serialVersionUID = 1L;

	@Override
	public CoreMVarstaticDTO selectById(String id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		CoreMVarstaticDTO newObj = new CoreMVarstaticDTO();
		newObj.setVarstat_id("TESTIDNYA");
		newObj.setVarstat_name("TEST NAMA SAJA");
		
//		Query query = session.createQuery("from core_m_varstatic");
//		List<CoreMVarstatic> recList = query.list();
//		for(CoreMVarstatic rec : recList)
//		{
//			if (rec.getVarstatId().equalsIgnoreCase("VAR20150115095820547590")) {
//				newObj = new CoreMVarstaticDTO(rec);
//			}
//		}

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

		return newObj;
	}

	/***********************************
	 * CUSTOM METHODS
	 ***********************************/

}
