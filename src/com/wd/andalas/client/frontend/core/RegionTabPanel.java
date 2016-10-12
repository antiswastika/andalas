package com.wd.andalas.client.frontend.core;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;

public class RegionTabPanel implements IsWidget {

	final TabPanel tabPanel = new TabPanel();
	final BorderLayoutData tabPanelData = new BorderLayoutData();

	/*********************************** MAIN CODE ***********************************/
	@Override
	public Widget asWidget() {
		tabPanel.setId("regionTabPanel");
		tabPanel.setBorders(false);
		tabPanelData.setMargins(new Margins(0, 5, 0, 4));

		return tabPanel;
	}

	/*********************************** CUSTOM METHODS ***********************************/
	public TabPanel doCreateTab(TabPanel tabPanel, Integer tabParams) {
		if (tabParams == null) {
			tabPanel.clear();
			tabPanel.setTabScroll(true);
			tabPanel.setAnimScroll(true);
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

	public BorderLayoutData getTabPanelData() {
		return tabPanelData;
	}

}
