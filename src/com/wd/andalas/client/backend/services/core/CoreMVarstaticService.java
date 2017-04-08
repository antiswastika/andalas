package com.wd.andalas.client.backend.services.core;

import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sencha.gxt.data.shared.loader.ListLoadConfig;
import com.sencha.gxt.data.shared.loader.ListLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTO;

@RemoteServiceRelativePath("./coremvarstatic")
public interface CoreMVarstaticService extends RemoteService {

	/********** Main Methods **********/
	public CoreMVarstaticDTO getById(String id);

	public PagingLoadResult<CoreMVarstaticDTO> getAllPaged(PagingLoadConfig loadConfig);

	public ListLoadResult<CoreMVarstaticDTO> getAllGrup(ListLoadConfig loadConfig);

	public Boolean insert(CoreMVarstaticDTO obj);
	
	public Boolean update(CoreMVarstaticDTO obj);
	
	public Boolean delete(CoreMVarstaticDTO obj);

	public Boolean deleteMany(List<CoreMVarstaticDTO> objs);

	public PagingLoadResult<CoreMVarstaticDTO> getSearchPaged(Map<String, String> mapCriteria, PagingLoadConfig loadConfig);

}
