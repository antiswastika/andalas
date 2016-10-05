package com.wd.andalas.frontend.core;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;

public class RegionCenter implements IsWidget {

	final ContentPanel center = new ContentPanel();
	final BorderLayoutData centerData = new BorderLayoutData();

	public Widget generateRegionCenter() {
		center.setId("regionCenter");
		center.setResize(false);
		center.setBorders(false);
		center.setHeaderVisible(true);
		center.setHeading("Test Center");

		centerData.setMargins(new Margins(5, 5, 5, 4));
		return center;
	}

	public void doCreateTab() {
		Window.alert("Creating Tab.........");
	}
	
	public ContentPanel getCenter() {
		return center;
	}

	public BorderLayoutData getCenterData() {
		return centerData;
	}

	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return null;
	}

}
