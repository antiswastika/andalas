package com.wd.andalas.client.frontend.views.core;

import java.util.Iterator;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;

public class RegionTabPanel implements IsWidget {

	private TabPanel tabPanel;
	private BorderLayoutData tabPanelData = new BorderLayoutData();

	/*********************************** MAIN CODE ***********************************/
	@Override
	public Widget asWidget() {
		if (tabPanel == null) {
			tabPanel = new TabPanel();
			tabPanel.setId("regionTabPanelID");
			tabPanel.setBorders(false);
			tabPanelData.setMargins(new Margins(0, 5, 0, 4));

			tabPanel.setLayoutData(tabPanelData);
		}
		return tabPanel;
	}

	/*********************************** CUSTOM METHODS ***********************************/
	public TabPanel doCreateTab(TabPanel tabPanel, String[] tabParams, Widget objParams) {
		if (tabParams == null) {
			tabPanel.clear();
			tabPanel.setTabScroll(true);
			tabPanel.setAnimScroll(true);
			tabPanel.add(new Label(), new TabItemConfig("Home", false));
		} else {
			int i = tabPanel.getWidgetCount() + 1;
			Iterator<Widget> arrayOfTabPanels = tabPanel.iterator();
			boolean ada = false;

			while (arrayOfTabPanels.hasNext()){
				Widget wgt = arrayOfTabPanels.next();
				if (wgt.getElement().getId().equalsIgnoreCase(objParams.getElement().getId())) {
					ada = true;
					tabPanel.setActiveWidget(wgt);
					break;
				} else {
					ada = false;
				}
			}

			if (ada == false) {
				tabPanel.add(objParams, new TabItemConfig(tabParams[0], true));
				tabPanel.setActiveWidget(tabPanel.getWidget(i - 1));
			}
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
