package com.wd.andalas.client.backend.services.core;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTO;

public interface CoreMVarstaticServiceAsync {

	/********** Main Methods **********/
	public void getById(String id, AsyncCallback<CoreMVarstaticDTO> callback);

	public void getAll(PagingLoadConfig loadConfig, AsyncCallback<List<CoreMVarstaticDTO>> callback);

}
