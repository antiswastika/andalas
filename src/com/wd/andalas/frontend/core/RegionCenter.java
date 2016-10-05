package com.wd.andalas.frontend.core;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;

public class RegionCenter {

	ContentPanel center;

	public Widget generateRegionCenter(BorderLayoutContainer mainContainer) {
		center = new ContentPanel();
		center.setId("regionCenter");
		center.setResize(false);
		center.setBorders(false);
		center.setHeaderVisible(true);
		center.setHeading("Test Center");

		BorderLayoutData centerData = new BorderLayoutData();
		centerData.setMargins(new Margins(5, 5, 5, 4));

		mainContainer.setCenterWidget(center, centerData);

		return center;
	}

	public void doCreateTab() {
		Window.alert("Creating Tab.........");
	}

}
