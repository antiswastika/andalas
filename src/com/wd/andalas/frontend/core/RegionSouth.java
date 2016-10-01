package com.wd.andalas.frontend.core;

import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;

public class RegionSouth {
	
	public void generateRegionSouth(BorderLayoutContainer mainContainer) {
		ContentPanel south = new ContentPanel();
		south.setResize(false);
		south.setBorders(false);
		south.setBodyStyle("background:transparent; border:0");
		south.setHeaderVisible(false);
		
		BorderLayoutData southData = new BorderLayoutData();
		southData.setCollapsible(false);
		southData.setSize(30);
		southData.setMargins(new Margins(0, 5, 5, 5));
		
		mainContainer.setSouthWidget(south, southData);		
	}
	
}
