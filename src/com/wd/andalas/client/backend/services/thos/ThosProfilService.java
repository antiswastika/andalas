package com.wd.andalas.client.backend.services.thos;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.wd.andalas.client.frontend.models.thos.ThosProfilDTO;

@RemoteServiceRelativePath("thosprofil")
public interface ThosProfilService extends RemoteService {

	/********** Main Methods **********/
	public ThosProfilDTO getById(String id);

	public PagingLoadResult<ThosProfilDTO> getAllPaged(PagingLoadConfig loadConfig);

}
