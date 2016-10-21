package com.wd.andalas.client.backend.services.core;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTO;

public class CoreMVarstaticServiceCallback implements AsyncCallback<List<CoreMVarstaticDTO>> {

	private String errMsg = "";
	private Boolean isErr = false;
	private List<CoreMVarstaticDTO> allRec = null;

	@Override
	public void onFailure(Throwable caught) {
		/* server side error occured */
		//Window.alert("Unable to obtain server response: " + caught.getMessage());
		this.isErr = true;
		this.errMsg = "Unable to obtain server response";
	}

	@Override
	public void onSuccess(List<CoreMVarstaticDTO> result) {
		/* server returned result, show user the message */
		//Window.alert(result.get(1).getVarstat_id());
		this.errMsg = "";
		this.allRec = result;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public Boolean getIsErr() {
		return isErr;
	}

	public List<CoreMVarstaticDTO> getAllRec() {
		return allRec;
	}

}
