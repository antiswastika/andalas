package com.wd.andalas.global;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;

public class GlobalClickHandler implements ClickHandler {
	
	/********** Inisiasi **********/
	private String[] tabParams;
	private String widgetParams;
	
	/********** Main Methods **********/
	@Override
	public void onClick(ClickEvent event) {
		BorderLayoutContainer blc = (BorderLayoutContainer) Singleton.getInstance().getAllObjects().get("mainWidget");
		TabPanel tabPanel = (TabPanel) blc.getCenterWidget(); 
		
		GlobalFunctions globalF = new GlobalFunctions();
		globalF.doCreateTab(tabPanel, tabParams, widgetParams);
	}
	
	/********** Setter Getter **********/
	public String[] getTabParams() {
		return tabParams;
	}
	public void setTabParams(String[] tabParams) {
		this.tabParams = tabParams;
	}

	public String getWdigetParams() {
		return widgetParams;
	}
	public void setWidgetParams(String widgetParams) {
		this.widgetParams = widgetParams;
	}

}
