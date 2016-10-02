package com.wd.andalas.frontend.core;

import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;

public class RegionCenter {

	ContentPanel center = new ContentPanel();

	public void generateRegionCenter(BorderLayoutContainer mainContainer) {
		center.setId("regionCenter");
		center.setResize(false);
		center.setBorders(false);
		center.setHeaderVisible(true);
		center.setHeading("Test Center");
		center.setTitle("Test Lagi Center");

		BorderLayoutData centerData = new BorderLayoutData();
		centerData.setMargins(new Margins(5, 5, 5, 4));

		mainContainer.setCenterWidget(center, centerData);
	}

}
