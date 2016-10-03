package com.wd.andalas.frontend.core;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

public class RegionCenter {

	ContentPanel center;

	public void generateRegionCenter(BorderLayoutContainer mainContainer) {
		center = new ContentPanel();
		center.setId("regionCenter");
		center.setResize(false);
		center.setBorders(false);
		center.setHeaderVisible(true);
		center.setHeading("Test Center");

		BorderLayoutData centerData = new BorderLayoutData();
		centerData.setMargins(new Margins(5, 5, 5, 4));
		
		mainContainer.setCenterWidget(center, centerData);
		doCreateTab();
	}
	
	public void doCreateTab() {
		//TextButton buttonAlert = new TextButton("Show Message");
		//center.add(buttonAlert);
		
		Logger logger = Logger.getLogger("DEBUG");
		logger.log(Level.INFO, "Creating tabs............");
	}
	
}
