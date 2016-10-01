package com.wd.andalas.frontend.core;

import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;

public class RegionCenter {
	
	public void generateRegionCenter(BorderLayoutContainer mainContainer) {
		ContentPanel center = new ContentPanel();
		center.setResize(false);
		center.setBorders(false);
		center.setHeaderVisible(false);
		
		BorderLayoutData centerData = new BorderLayoutData();
		centerData.setMargins(new Margins(5, 5, 5, 4));
		
		mainContainer.setCenterWidget(center, centerData);		
	}
	
}
