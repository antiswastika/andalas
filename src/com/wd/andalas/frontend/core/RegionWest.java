package com.wd.andalas.frontend.core;

import java.util.HashMap;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;

public class RegionWest implements IsWidget {

	final ContentPanel west = new ContentPanel();
	final BorderLayoutData westData = new BorderLayoutData();
	final String judulWest = "";
	private HashMap<String, Object> outerObjects = new HashMap<String, Object>();

	/*********************************** MAIN CODE ***********************************/
	@Override
	public Widget asWidget() {
		west.setHeading(judulWest);
		west.setTitle(judulWest);
		west.setHeaderVisible(false);
		west.setAnimationDuration(300);
		west.setBorders(false);
		west.setResize(true);
		westData.setCollapsible(false);
		westData.setSplit(true);
		westData.setSize(150);
		westData.setMinSize(100);
		westData.setMaxSize(300);
		westData.setCollapseMini(false);
		westData.setMargins(new Margins(0, 4, 0, 5));
		westData.setCollapseHeaderVisible(true);
		
		MenuLeft menuLeft = new MenuLeft();
		menuLeft.setOuterObjects(outerObjects);
		west.add(menuLeft);
		
		return west;
	}

	/*********************************** SETTER GETTER ***********************************/
	public ContentPanel getWest() {
		return west;
	}

	public BorderLayoutData getWestData() {
		return westData;
	}

	public HashMap<String, Object> getOuterObjects() {
		return outerObjects;
	}

	public void setOuterObjects(HashMap<String, Object> outerObjects) {
		this.outerObjects = outerObjects;
	}

}
