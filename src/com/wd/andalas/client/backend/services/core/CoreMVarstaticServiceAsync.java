package com.wd.andalas.client.backend.services.core;

import java.util.List;

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

	public void getAllGrup(ListLoadConfig loadConfig, AsyncCallback<ListLoadResult<CoreMVarstaticDTO>> callback);

	public void insert(CoreMVarstaticDTO obj, AsyncCallback<Boolean> callback);
	
	public void update(CoreMVarstaticDTO obj, AsyncCallback<Boolean> callback);
	
	public void delete(CoreMVarstaticDTO obj, AsyncCallback<Boolean> callback);

	public void deleteMany(List<CoreMVarstaticDTO> objs, AsyncCallback<Boolean> callback);

}
