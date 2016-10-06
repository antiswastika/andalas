package com.wd.andalas.frontend.core;

import java.util.HashMap;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;

public class RegionSouth implements IsWidget {

	final ContentPanel south = new ContentPanel();
	final BorderLayoutData southData = new BorderLayoutData();
	private HashMap<String, Object> outerObjects = new HashMap<String, Object>();

	/*********************************** MAIN CODE ***********************************/
	@Override
	public Widget asWidget() {
		south.setResize(false);
		south.setBorders(false);
		south.setBodyStyle("background:transparent; border:0");
		south.setHeaderVisible(false);
		southData.setCollapsible(false);
		southData.setSize(30);
		southData.setMargins(new Margins(0, 5, 5, 5));

		return south;
	}

	/*********************************** SETTER GETTER ***********************************/
	public ContentPanel getSouth() {
		return south;
	}

	public BorderLayoutData getSouthData() {
		return southData;
	}

	public HashMap<String, Object> getOuterObjects() {
		return outerObjects;
	}

	public void setOuterObjects(HashMap<String, Object> outerObjects) {
		this.outerObjects = outerObjects;
	}

}
