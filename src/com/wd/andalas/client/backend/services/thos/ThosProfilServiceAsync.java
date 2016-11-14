package com.wd.andalas.client.backend.services.thos;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.wd.andalas.client.frontend.models.thos.ThosProfilDTO;

public interface ThosProfilServiceAsync {

	/********** Main Methods **********/
	public void getById(String id, AsyncCallback<ThosProfilDTO> callback);

	public void getAllPaged(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<ThosProfilDTO>> callback);

}
