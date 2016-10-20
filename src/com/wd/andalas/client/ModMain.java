package com.wd.andalas.client;

import java.util.HashMap;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.wd.andalas.client.backend.services.core.CoreMVarstaticService;
import com.wd.andalas.client.backend.services.core.CoreMVarstaticServiceAsync;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTO;
import com.wd.andalas.client.frontend.views.core.RegionNorth;
import com.wd.andalas.client.frontend.views.core.RegionSouth;
import com.wd.andalas.client.frontend.views.core.RegionTabPanel;
import com.wd.andalas.client.frontend.views.core.RegionWest;
import com.wd.andalas.global.Singleton;

public class ModMain implements EntryPoint {
	private Viewport viewPort = new Viewport();
	private HashMap<String, Object> allObjects = new HashMap<String, Object>();
	private BorderLayoutContainer blc;

	private CoreMVarstaticServiceAsync testService = GWT.create(CoreMVarstaticService.class);

	/***********************************
	 * MAIN CODE
	 ***********************************/
	@Override
	public void onModuleLoad() {
		/* FIRST TRY */
		// RootPanel.get().add(lbl);

		/* SECOND TRY */
		// TextButton textButton = new TextButton("Verify GXT Works");
		// RootPanel.get().add(textButton);
		// textButton.addSelectHandler(new SelectHandler() {
		// @Override
		// public void onSelect(SelectEvent event) {
		// MessageBox msgbox = new MessageBox("GXT Works");
		// msgbox.show();
		// }
		// });

		/* THIRD TRY */
		// CssFloatLayoutContainer container = new CssFloatLayoutContainer();
		// container.add(new TextButton("Test Button...."), new
		// CssFloatData(1));

		/* START DEVELOP */
		Singleton.getInstance().setSingletonId("ABCD1234");

		viewPort.setWidget(startUp());
		allObjects.put("viewPort", viewPort);
		RootLayoutPanel.get().add(viewPort);
		// Logger logger = Logger.getLogger("DEBUG");
		// logger.log(Level.INFO, "X");

		testService.selectById("XXXXXX", new CoreMVarstaticDTOCallBack());
	}

	public BorderLayoutContainer startUp() {
		if (blc == null) {
			blc = new BorderLayoutContainer();

			RegionNorth regionNorth = new RegionNorth();
			RegionWest regionWest = new RegionWest();
			RegionSouth regionSouth = new RegionSouth();
			RegionTabPanel regionTabPanel = new RegionTabPanel();

			allObjects.put("borderLayoutContainer", blc);
			allObjects.put("regionNorth", regionNorth);
			allObjects.put("regionWest", regionWest);
			allObjects.put("regionSouth", regionSouth);
			allObjects.put("regionTabPanel", regionTabPanel);

			// Masukin semua kedalam Singleton
			Singleton.getInstance().setAllObjects(allObjects);

			// TODO: Masih Dobel Instantiate... Belom solve..!!! :((
			blc.setNorthWidget(regionNorth);
			blc.setWestWidget(regionWest);
			blc.setSouthWidget(regionSouth);
			blc.setCenterWidget(regionTabPanel);

			regionTabPanel.doCreateTab(regionTabPanel.getTabPanel(), null, null);
		}
		return blc;
	}

	private class CoreMVarstaticDTOCallBack implements AsyncCallback<CoreMVarstaticDTO> {
		@Override
		public void onFailure(Throwable caught) {
			/* server side error occured */
			Window.alert("Unable to obtain server response: " + caught.getMessage());
		}
		@Override
		public void onSuccess(CoreMVarstaticDTO result) {
			/* server returned result, show user the message */
			Window.alert(result.getVarstat_id());
		}
	}

	/***********************************
	 * SETTER GETTER
	 ***********************************/
	public HashMap<String, Object> getAllObjects() {
		return allObjects;
	}

	public void setAllObjects(HashMap<String, Object> allObjects) {
		this.allObjects = allObjects;
	}

}
