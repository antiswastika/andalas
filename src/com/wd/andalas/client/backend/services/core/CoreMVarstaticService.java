package com.wd.andalas.client.backend.services.core;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTO;
import com.wd.andalas.server.backend.models.core.CoreMVarstatic;

@RemoteServiceRelativePath("coremvarstatic")
public interface CoreMVarstaticService extends RemoteService {
	
	/********** Main Methods **********/
	public CoreMVarstaticDTO getById(String id);
	
	public List<CoreMVarstatic> getAll();

}
