package com.wd.andalas.client.backend.services.core;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTO;

@RemoteServiceRelativePath("coremvarstatic")
public interface CoreMVarstaticService extends RemoteService {

	/********** Main Methods **********/
	public CoreMVarstaticDTO getById(String id);

	public PagingLoadResult<CoreMVarstaticDTO> getAllPaged(PagingLoadConfig loadConfig);

}
