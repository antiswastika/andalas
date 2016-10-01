package com.wd.andalas.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.wd.andalas.frontend.core.RegionCenter;
import com.wd.andalas.frontend.core.RegionNorth;
import com.wd.andalas.frontend.core.RegionSouth;
import com.wd.andalas.frontend.core.RegionWest;

public class EntryMain implements EntryPoint {
	private BorderLayoutContainer mainWidget;
	
	public Widget theWidget() {
		if (mainWidget == null) {
			mainWidget = new BorderLayoutContainer();		
			RegionNorth regionNorth = new RegionNorth();
			RegionWest regionWest = new RegionWest();
			RegionCenter regionCenter = new RegionCenter();
			RegionSouth regionSouth = new RegionSouth();
			
			regionNorth.generateRegionNorth(mainWidget);
			regionWest.generateRegionWest(mainWidget);
			regionCenter.generateRegionCenter(mainWidget);
			regionSouth.generateRegionSouth(mainWidget);
		}
		return mainWidget;
	}
	
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
		Viewport viewPort = new Viewport();
		viewPort.setWidget(this.theWidget());
		RootLayoutPanel.get().add(viewPort);
	}

}
