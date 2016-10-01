package com.wd.andalas.frontend.core;

import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;

public class RegionWest {
	
	public void generateRegionWest(BorderLayoutContainer mainContainer) {
		String judulWest = "My Menu";
		
		ContentPanel west = new ContentPanel();
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
		
		mainContainer.setWestWidget(west, westData);		
	}
	
}
