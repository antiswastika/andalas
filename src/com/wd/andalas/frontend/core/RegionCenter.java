package com.wd.andalas.frontend.core;

import java.util.HashMap;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;

public class RegionCenter implements IsWidget {

	final ContentPanel center = new ContentPanel();
	final BorderLayoutData centerData = new BorderLayoutData();
	private HashMap<String, Object> outerObjects = new HashMap<String, Object>();
	private TabPanel tabPanel;

	/*********************************** MAIN CODE ***********************************/
	@Override
	public Widget asWidget() {
		center.setId("regionCenter");
		center.setResize(false);
		center.setBorders(false);
		center.setHeaderVisible(false);
		centerData.setMargins(new Margins(5, 5, 5, 4));

		tabPanel = new TabPanel();
		center.add( doCreateTab(tabPanel, null) );

		return center;
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
	public ContentPanel getCenter() {
		return center;
	}

	public BorderLayoutData getCenterData() {
		return centerData;
	}

	public HashMap<String, Object> getOuterObjects() {
		return outerObjects;
	}

	public void setOuterObjects(HashMap<String, Object> outerObjects) {
		this.outerObjects = outerObjects;
	}

	public TabPanel getTabPanel() {
		return tabPanel;
	}

}
