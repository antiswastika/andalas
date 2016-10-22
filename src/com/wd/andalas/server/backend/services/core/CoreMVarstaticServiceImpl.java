package com.wd.andalas.server.backend.services.core;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.wd.andalas.client.backend.services.core.CoreMVarstaticService;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTO;
import com.wd.andalas.server.backend.models.core.CoreMVarstatic;

public class CoreMVarstaticServiceImpl extends RemoteServiceServlet implements CoreMVarstaticService {
	
	/********** Inisiasi **********/
	private static final long serialVersionUID = 1L;
	
	/********** Main Methods **********/
	@Override
	public CoreMVarstaticDTO getById(String id) {
		CoreMVarstatic jObj = new CoreMVarstatic();
		jObj.setVarstatId("001");
		jObj.setVarstatName("Testing nama");

		CoreMVarstaticDTO xObj = new CoreMVarstaticDTO(jObj);
		return xObj;
	}

}
