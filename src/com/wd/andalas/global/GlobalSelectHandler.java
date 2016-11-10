package com.wd.andalas.global;

import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

public class GlobalSelectHandler implements SelectHandler {

	/********** Inisiasi **********/
	private String[] tabParams;
	private String widgetParams;

	/********** Main Methods **********/
	@Override
	public void onSelect(SelectEvent event) {
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

	public String getWidgetParams() {
		return widgetParams;
	}
	public void setWidgetParams(String widgetParams) {
		this.widgetParams = widgetParams;
	}

}
