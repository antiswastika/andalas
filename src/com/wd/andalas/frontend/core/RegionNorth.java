package com.wd.andalas.frontend.core;

import com.google.gwt.user.client.ui.Image;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer.HBoxLayoutAlign;

public class RegionNorth {
	
	public void generateRegionNorth(BorderLayoutContainer mainContainer) {	
		ContentPanel north = new ContentPanel();
		north.setResize(false);
		north.setBorders(false);
		north.setBodyStyle("background:transparent; border:0");
		north.setHeaderVisible(false);
		
		BorderLayoutData northData = new BorderLayoutData();
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
		
		mainContainer.setNorthWidget(north, northData);
	}
	
}
