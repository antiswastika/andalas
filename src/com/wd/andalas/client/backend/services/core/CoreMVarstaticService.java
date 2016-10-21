package com.wd.andalas.client.backend.services.core;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTO;

@RemoteServiceRelativePath("coremvarstatic")
public interface CoreMVarstaticService extends RemoteService {

	public CoreMVarstaticDTO getById(String id);

}
