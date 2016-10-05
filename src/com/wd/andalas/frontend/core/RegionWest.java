package com.wd.andalas.frontend.core;

import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

public class RegionWest {

	ContentPanel west;

	public Widget generateRegionWest(BorderLayoutContainer mainContainer) {
		String judulWest = "My Menu";

		west = new ContentPanel();
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
				/*Viewport vp = (Viewport) RootLayoutPanel.get().getWidget(0);
				BorderLayoutContainer borderContainer = (BorderLayoutContainer) vp.getWidget(0);*/

				/*Iterator<Widget> arrayOfWidgets = borderContainer.iterator();
				while (arrayOfWidgets.hasNext()){
					Widget ch = arrayOfWidgets.next();
					//Window.alert(ch.getElement().getId());
					if (ch.getElement().getId().equalsIgnoreCase("regionCenter")) {
						//Window.alert(ch.getElement().getId());
					}
				}*/
			}
		});
		west.add(buttonAlert);

		mainContainer.setWestWidget(west, westData);

		return west;
	}

}
