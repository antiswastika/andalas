package com.wd.andalas.frontend.core;

import java.util.HashMap;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer.HBoxLayoutAlign;

public class RegionNorth implements IsWidget {

	final ContentPanel north = new ContentPanel();
	final BorderLayoutData northData = new BorderLayoutData();
	private HashMap<String, Object> outerObjects = new HashMap<String, Object>();

	/*********************************** MAIN CODE ***********************************/
	@Override
	public Widget asWidget() {
		north.setResize(false);
		north.setBorders(false);
		north.setBodyStyle("background:transparent; border:0");
		north.setHeaderVisible(false);
		northData.setCollapsible(false);
		northData.setSize(60);
		northData.setMargins(new Margins(5, 5, 0, 5));

		HBoxLayoutContainer hContainer = new HBoxLayoutContainer();
		Image appLogo = new Image();
		appLogo.setUrl("images/logo.png");
		appLogo.setHeight("50px");
		hContainer.setHBoxLayoutAlign(HBoxLayoutAlign.BOTTOM);
		hContainer.add(appLogo, new BoxLayoutData(new Margins(5, 0, 0, 20)));
		hContainer.setWidth("500px");
		north.add(hContainer);

		return north;
	}

	/*********************************** SETTER GETTER ***********************************/
	public ContentPanel getNorth() {
		return north;
	}

	public BorderLayoutData getNorthData() {
		return northData;
	}

	public HashMap<String, Object> getOuterObjects() {
		return outerObjects;
	}

	public void setOuterObjects(HashMap<String, Object> outerObjects) {
		this.outerObjects = outerObjects;
	}

}
