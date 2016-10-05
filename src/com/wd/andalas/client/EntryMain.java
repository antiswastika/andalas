package com.wd.andalas.client;

import java.util.HashMap;

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
	private BorderLayoutContainer blc;
	private HashMap<String, Object> allObjects = new HashMap<String, Object>();

	private Widget generateWidget() {
		if (blc == null) {
			blc = new BorderLayoutContainer();
			RegionNorth regionNorth = new RegionNorth();
			RegionWest regionWest = new RegionWest();
			RegionCenter regionCenter = new RegionCenter();
			RegionSouth regionSouth = new RegionSouth();

			//regionNorth.generateRegionNorth();
			//allObjects.put("regionNorth", regionNorth);
			
			regionCenter.generateRegionCenter();
			allObjects.put("regionCenter", regionCenter);
			blc.setCenterWidget(regionCenter, regionCenter.getCenterData());
			
			//regionWest.generateRegionWest();
			//allObjects.put("regionWest", regionWest);
			
			//regionSouth.generateRegionSouth();
			//allObjects.put("regionSouth", regionSouth);
		}
		return blc;
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
		viewPort.setWidget(generateWidget());
		RootLayoutPanel.get().add(viewPort);

		//Logger logger = Logger.getLogger("DEBUG");
		//logger.log(Level.INFO, "X");
	}
	
	
	public HashMap<String, Object> getAllObjects() {
		return allObjects;
	}
	public void setAllObjects(HashMap<String, Object> allObjects) {
		this.allObjects = allObjects;
	}

}
