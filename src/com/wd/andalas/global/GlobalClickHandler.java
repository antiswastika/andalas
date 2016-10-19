package com.wd.andalas.global;

import java.util.HashMap;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Widget;
import com.wd.andalas.client.frontend.views.core.RegionTabPanel;

public class GlobalClickHandler implements ClickHandler {
	private String[] tabParams;
	private Widget objParams;
	private HashMap<String, Object> allObjects = null;
	
	/*********************************** MAIN CODE ***********************************/
	@Override
	public void onClick(ClickEvent event) {
		RegionTabPanel tabPanel = (RegionTabPanel) Singleton.getInstance().getAllObjects().get("regionTabPanel");
		tabPanel.doCreateTab(tabPanel.getTabPanel(), tabParams, objParams);
		allObjects.put(objParams.getElement().getId(), objParams);
		Singleton.getInstance().setAllObjects(allObjects);
	}
	
	/*********************************** SETTER GETTER ***********************************/
	public String[] getTabParams() {
		return tabParams;
	}
	public void setTabParams(String[] tabParams) {
		this.tabParams = tabParams;
	}

	public Widget getObjParams() {
		return objParams;
	}
	public void setObjParams(Widget objParams) {
		this.objParams = objParams;
	}

}
