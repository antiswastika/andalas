package com.wd.andalas.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer.HBoxLayoutAlign;
import com.sencha.gxt.widget.core.client.container.Viewport;

public class EntryMain implements EntryPoint {

	@Override
	public void onModuleLoad() {
		/* FIRST TRY */
		//		RootPanel.get().add(lbl);

		/* SECOND TRY */
		//		TextButton textButton = new TextButton("Verify GXT Works");
		//		RootPanel.get().add(textButton);
		//		textButton.addSelectHandler(new SelectHandler() {
		//			@Override
		//			public void onSelect(SelectEvent event) {
		//				MessageBox msgbox = new MessageBox("GXT Works");
		//				msgbox.show();
		//			}
		//		});

		/* THIRD TRY */
		//		CssFloatLayoutContainer container = new CssFloatLayoutContainer();
		//		container.add(new TextButton("Test Button...."), new CssFloatData(1));

		/* START DEVELOP */
		String appTitle = "THOS-Register";

		ContentPanel north = new ContentPanel();
		north.setResize(false);
		north.setBorders(false);
		north.setBodyStyle("background:transparent; border:0");
		north.setHeaderVisible(false);
		BorderLayoutData northData = new BorderLayoutData();
		northData.setCollapsible(false);
		northData.setSize(60);
		northData.setMargins(new Margins(5, 5, 0, 5));

		HBoxLayoutContainer c = new HBoxLayoutContainer();
		Image appLogo = new Image();
		appLogo.setUrl("images/logo.png");
		appLogo.setHeight("50px");
		Label appLabel = new Label(appTitle);
		appLabel.setStyleName("app-header", true);
		c.setHBoxLayoutAlign(HBoxLayoutAlign.BOTTOM);
		c.add(appLogo, new BoxLayoutData(new Margins(5, 50, 0, 5)));
		c.add(appLabel);
		c.setWidth("500px");
		north.add(c);

		ContentPanel west = new ContentPanel();
		String judulWest = "My Menu";
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

		ContentPanel center = new ContentPanel();
		center.setResize(false);
		center.setBorders(true);
		center.setHeaderVisible(false);
		BorderLayoutData centerData = new BorderLayoutData();
		centerData.setMargins(new Margins(5, 5, 5, 4));

		ContentPanel south = new ContentPanel();
		south.setResize(false);
		south.setBorders(false);
		south.setBodyStyle("background:transparent; border:0");
		south.setHeaderVisible(false);
		BorderLayoutData southData = new BorderLayoutData();
		southData.setCollapsible(false);
		southData.setSize(30);
		southData.setMargins(new Margins(0, 5, 5, 5));

		BorderLayoutContainer mainContainer = new BorderLayoutContainer();
		mainContainer.setNorthWidget(north, northData);
		mainContainer.setCenterWidget(center, centerData);
		mainContainer.setWestWidget(west, westData);
		mainContainer.setSouthWidget(south, southData);

		Viewport viewPort = new Viewport();
		viewPort.setWidget(mainContainer);
		RootLayoutPanel.get().add(viewPort);
	}

}
