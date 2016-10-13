package com.wd.andalas.client;

import java.util.HashMap;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.wd.andalas.client.frontend.core.RegionNorth;
import com.wd.andalas.client.frontend.core.RegionSouth;
import com.wd.andalas.client.frontend.core.RegionTabPanel;
import com.wd.andalas.client.frontend.core.RegionWest;
import com.wd.andalas.core.Singleton;

public class EntryMain implements EntryPoint {
	final Viewport viewPort = new Viewport();
	private HashMap<String, Object> allObjects = new HashMap<String, Object>();
	private BorderLayoutContainer blc;

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
		Singleton.getInstance().setSingletonId("ABCD1234");

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
			RegionSouth regionSouth = new RegionSouth();
			RegionTabPanel regionTabPanel = new RegionTabPanel();

			allObjects.put("regionNorth", regionNorth);
			allObjects.put("regionWest", regionWest);
			allObjects.put("regionSouth", regionSouth);
			allObjects.put("regionTabPanel", regionTabPanel);

			blc.setNorthWidget(regionNorth, regionNorth.getNorthData());
			blc.setWestWidget(regionWest, regionWest.getWestData());
			blc.setSouthWidget(regionSouth, regionSouth.getSouthData());
			blc.setCenterWidget(regionTabPanel, regionTabPanel.getTabPanelData());

			// Masukin semua kedalam Singleton
			Singleton.getInstance().setAllObjects(allObjects);

			regionTabPanel.doCreateTab(regionTabPanel.getTabPanel(), null, null);
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
