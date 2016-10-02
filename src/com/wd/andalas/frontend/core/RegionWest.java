package com.wd.andalas.frontend.core;

import com.google.gwt.dom.client.Element;
import com.sencha.gxt.core.client.dom.DomQuery;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.box.AlertMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

public class RegionWest {

	public void generateRegionWest(BorderLayoutContainer mainContainer) {
		String judulWest = "My Menu";

		final ContentPanel west = new ContentPanel();
		west.setHeading(judulWest);
		west.setTitle(judulWest);
		west.setAnimationDuration(500);
		west.setBorders(true);
		west.setResize(true);

		BorderLayoutData westData = new BorderLayoutData();
		westData.setCollapsible(true);
		westData.setSplit(true);
		westData.setSize(200);
		westData.setMinSize(150);
		westData.setMaxSize(500);
		westData.setCollapseMini(true);
		westData.setMargins(new Margins(5, 4, 5, 5));
		westData.setCollapseHeaderVisible(true);

		TextButton buttonAlert = new TextButton("Show Message");
		buttonAlert.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				Element regionCenter = DomQuery.select("#regionCenter").getItem(0);

				// String textNya =
				// Integer.toString(regionCenter.getChildCount());
				String textNya = regionCenter.getChild(0).getNodeName();

				AlertMessageBox messageBox = new AlertMessageBox("Test Message", textNya);

				messageBox.show();
			}
		});
		west.add(buttonAlert);

		mainContainer.setWestWidget(west, westData);
	}

}
