package com.wd.andalas.client.frontend.core;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.wd.andalas.client.frontend.core.application.MenuLeft;

public class RegionWest implements IsWidget {

	final ContentPanel west = new ContentPanel();
	final BorderLayoutData westData = new BorderLayoutData();
	final String judulWest = "";

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
		westData.setSize(160);
		westData.setMinSize(140);
		westData.setMaxSize(300);
		westData.setCollapseMini(false);
		westData.setMargins(new Margins(0, 4, 0, 5));
		westData.setCollapseHeaderVisible(true);

		//MenuLeft menuLeft = (MenuLeft) outerObjects.get("menuLeft");
		//HashMap<String, Object> outerObjects2 = Singleton.getInstance().getAllObjects();
		//west.add((MenuLeft) outerObjects2.get("menuLeft"));

		MenuLeft menuLeft = new MenuLeft();
		west.add(menuLeft.getAccordionPanel());
		return west;
	}

	/*********************************** SETTER GETTER ***********************************/
	public ContentPanel getWest() {
		return west;
	}

	public BorderLayoutData getWestData() {
		return westData;
	}

}
