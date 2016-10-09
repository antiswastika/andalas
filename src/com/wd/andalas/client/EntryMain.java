package com.wd.andalas.client;

import java.util.HashMap;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.wd.andalas.frontend.core.RegionCenter;
import com.wd.andalas.frontend.core.RegionNorth;
import com.wd.andalas.frontend.core.RegionSouth;
import com.wd.andalas.frontend.core.RegionTabPanel;
import com.wd.andalas.frontend.core.RegionWest;

public class EntryMain implements EntryPoint {
	final Viewport viewPort = new Viewport();
	private BorderLayoutContainer blc;
	private HashMap<String, Object> allObjects = new HashMap<String, Object>();

	/*********************************** MAIN CODE ***********************************/
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
		viewPort.setWidget(startUp());
		allObjects.put("viewPort", viewPort);

		RootLayoutPanel.get().add(viewPort);
		//Logger logger = Logger.getLogger("DEBUG");
		//logger.log(Level.INFO, "X");
	}

	public Widget startUp() {
		if (blc == null) {
			blc = new BorderLayoutContainer();
			RegionNorth regionNorth = new RegionNorth();
			RegionWest regionWest = new RegionWest();
			RegionCenter regionCenter = new RegionCenter();
			RegionSouth regionSouth = new RegionSouth();
			RegionTabPanel regionTabPanel = new RegionTabPanel();

			allObjects.put("regionNorth", regionNorth);
			blc.setNorthWidget(regionNorth, regionNorth.getNorthData());

			allObjects.put("regionCenter", regionCenter);
			blc.setCenterWidget(regionCenter, regionCenter.getCenterData());

			allObjects.put("regionWest", regionWest);
			blc.setWestWidget(regionWest, regionWest.getWestData());

			allObjects.put("regionSouth", regionSouth);
			blc.setSouthWidget(regionSouth, regionSouth.getSouthData());
			
			allObjects.put("regionTabPanel", regionTabPanel);
			
			HorizontalLayoutContainer container = new HorizontalLayoutContainer();
			HorizontalLayoutData horizontalLayoutData = new HorizontalLayoutData(1, 1, new Margins(0));
			container.add(regionTabPanel, horizontalLayoutData);
			container.forceLayout();
			
			regionTabPanel.doCreateTab(regionTabPanel.getTabPanel(), null);
			regionCenter.getCenter().add(container);
			
			//HBoxLayoutContainer container = new HBoxLayoutContainer();
			//container.add(regionTabPanel.getTabPanel());
			//regionTabPanel.doCreateTab(regionTabPanel.getTabPanel(), null);
			//regionCenter.getCenter().add(container);
					

			regionNorth.setOuterObjects(allObjects);
			regionCenter.setOuterObjects(allObjects);
			regionWest.setOuterObjects(allObjects);
			regionSouth.setOuterObjects(allObjects);
			regionTabPanel.setOuterObjects(allObjects);
		}
		return blc;
	}

	/*********************************** SETTER GETTER ***********************************/
	public HashMap<String, Object> getAllObjects() {
		return allObjects;
	}
	public void setAllObjects(HashMap<String, Object> allObjects) {
		this.allObjects = allObjects;
	}

}
