package com.wd.andalas.client;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer.HBoxLayoutAlign;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.wd.andalas.client.frontend.views.core.CustomMenuLeft;
import com.wd.andalas.global.GlobalFunctions;
import com.wd.andalas.global.Singleton;

public class ModMain implements EntryPoint {

	/********** Inisiasi **********/
	private Viewport viewPort = new Viewport();
	private HashMap<String, Object> allObjects = new HashMap<String, Object>();
	private BorderLayoutContainer blc;

	/********** Main Methods **********/
	@Override
	public void onModuleLoad() {
		Singleton.getInstance().setSingletonId("ABCD1234");

		Widget mainWidget = startUp();
		viewPort.setWidget(mainWidget);
		RootLayoutPanel.get().add(viewPort);

		Logger logger = Logger.getLogger("DEBUG");
		logger.log(Level.INFO, "Application Started.....");

		allObjects.put("viewPort", viewPort);
		allObjects.put("mainWidget", mainWidget);
		Singleton.getInstance().setAllObjects(allObjects);
	}

	public BorderLayoutContainer startUp() {
		if (blc == null) {
			blc = new BorderLayoutContainer();

			blc.setNorthWidget(doCreateNorth());
			blc.setWestWidget(doCreateWest());
			blc.setSouthWidget(doCreateSouth());
			blc.setCenterWidget(doCreateCenter());
		}
		return blc;
	}

	/********** Custom Methods **********/
	private ContentPanel doCreateNorth() {
		ContentPanel north;
		BorderLayoutData northData = new BorderLayoutData();

		north = new ContentPanel();
		north.setId("regionNorthID");
		north.setResize(false);
		north.setBorders(false);
		north.setBodyStyle("background:transparent; border:0");
		north.setHeaderVisible(false);
		northData.setCollapsible(false);
		northData.setSize(60);
		northData.setMargins(new Margins(5, 5, 0, 5));
		north.setLayoutData(northData);

		HBoxLayoutContainer hContainer = new HBoxLayoutContainer();
		Image appLogo = new Image();
		appLogo.setUrl("images/logo.png");
		appLogo.setHeight("40px");
		hContainer.setHBoxLayoutAlign(HBoxLayoutAlign.BOTTOM);
		hContainer.add(appLogo, new BoxLayoutData(new Margins(5, 0, 0, 20)));
		hContainer.setWidth("500px");
		north.add(hContainer);

		return north;
	}

	private ContentPanel doCreateWest() {
		ContentPanel west;
		BorderLayoutData westData = new BorderLayoutData();
		String judulWest = "";

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
		west.setLayoutData(westData);

		CustomMenuLeft menuLeft = new CustomMenuLeft();
		west.add(menuLeft.getAccordionPanel());

		return west;
	}

	private ContentPanel doCreateSouth() {
		ContentPanel south;
		BorderLayoutData southData = new BorderLayoutData();

		south = new ContentPanel();
		south.setId("regionSouthID");
		south.setResize(false);
		south.setBorders(false);
		south.setBodyStyle("background:transparent; border:0");
		south.setHeaderVisible(false);
		southData.setCollapsible(false);
		southData.setSize(30);
		southData.setMargins(new Margins(0, 5, 5, 5));
		south.setLayoutData(southData);

		return south;
	}

	private TabPanel doCreateCenter() {
		TabPanel tabPanel;
		BorderLayoutData tabPanelData = new BorderLayoutData();

		tabPanel = new TabPanel();
		tabPanel.setId("regionCenterID");
		tabPanel.setBorders(false);
		tabPanelData.setMargins(new Margins(0, 5, 0, 4));
		tabPanel.setLayoutData(tabPanelData);

		GlobalFunctions globalF = new GlobalFunctions();
		globalF.doCreateTab(tabPanel, null, null);

		return tabPanel;
	}

	/********** Setter Getter **********/
	public HashMap<String, Object> getAllObjects() {
		return allObjects;
	}
	public void setAllObjects(HashMap<String, Object> allObjects) {
		this.allObjects = allObjects;
	}

}
