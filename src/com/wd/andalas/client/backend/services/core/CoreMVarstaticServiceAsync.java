package com.wd.andalas.client.backend.services.core;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.data.shared.loader.ListLoadConfig;
import com.sencha.gxt.data.shared.loader.ListLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTO;

public interface CoreMVarstaticServiceAsync {

	/********** Main Methods **********/
	public void getById(String id, AsyncCallback<CoreMVarstaticDTO> callback);

	public void getAllPaged(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<CoreMVarstaticDTO>> callback);

	void getAllGrup(ListLoadConfig loadConfig, AsyncCallback<ListLoadResult<CoreMVarstaticDTO>> callback);

}
