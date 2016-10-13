package com.wd.andalas.client.frontend.views.core;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;

public class RegionWest implements IsWidget {

	private ContentPanel west;
	private BorderLayoutData westData = new BorderLayoutData();
	private String judulWest = "";

	/*********************************** MAIN CODE ***********************************/
	@Override
	public Widget asWidget() {
		if (west == null) {
			west = new ContentPanel();
			west.setId("regionWestID");
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
			west.setLayoutData(westData);
			west.add(menuLeft.getAccordionPanel());
		}
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
