package com.wd.andalas.server.backend.services.core;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.wd.andalas.client.backend.services.core.CoreMVarstaticService;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTO;

public class CoreMVarstaticServiceImpl extends RemoteServiceServlet implements CoreMVarstaticService {

	private static final long serialVersionUID = 1L;

	@Override
	public CoreMVarstaticDTO selectById(String id) {
		CoreMVarstaticDTO newObj = new CoreMVarstaticDTO();
		newObj.setVarstat_id("TESTIDNYA");
		newObj.setVarstat_name("TEST NAMA SAJA");
		return newObj;
	}

	/*********************************** CUSTOM METHODS ***********************************/

}
