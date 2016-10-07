package com.wd.andalas.frontend.core;

import java.util.HashMap;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;

public class RegionTabPanel implements IsWidget {

	final TabPanel tabPanel = new TabPanel();
	private HashMap<String, Object> outerObjects = new HashMap<String, Object>();

	/*********************************** MAIN CODE ***********************************/
	@Override
	public Widget asWidget() {
		this.doCreateTab(tabPanel, null);
		return tabPanel;
	}
	
	/*********************************** CUSTOM METHODS ***********************************/
	public TabPanel doCreateTab(TabPanel tabPanel, Integer tabParams) {
		if (tabParams == null) {
			tabPanel.setTabScroll(true);
			tabPanel.setAnimScroll(true);
			tabPanel.clear();
			tabPanel.add(new Label(""), new TabItemConfig("Home", false));
		} else {
			int i = tabPanel.getWidgetCount() + 1;
			tabPanel.add(new Label(""), new TabItemConfig("Tab_" + i, true));
			tabPanel.setActiveWidget(tabPanel.getWidget(i-1));
		}

		return tabPanel;
	}

	/*********************************** SETTER GETTER ***********************************/
	public TabPanel getTabPanel() {
		return tabPanel;
	}

	public HashMap<String, Object> getOuterObjects() {
		return outerObjects;
	}

	public void setOuterObjects(HashMap<String, Object> outerObjects) {
		this.outerObjects = outerObjects;
	}

}
