package com.wd.andalas.frontend.core;

import java.util.HashMap;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;

public class RegionCenter implements IsWidget {

	final ContentPanel center = new ContentPanel();
	final BorderLayoutData centerData = new BorderLayoutData();
	private HashMap<String, Object> outerObjects = new HashMap<String, Object>();

	/*********************************** MAIN CODE ***********************************/
	@Override
	public Widget asWidget() {
		center.setId("regionCenter");
		center.setResize(false);
		center.setBorders(false);
		center.setHeaderVisible(false);
		centerData.setMargins(new Margins(5, 5, 5, 4));

		return center;
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

}
