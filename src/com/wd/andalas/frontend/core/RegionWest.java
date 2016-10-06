package com.wd.andalas.frontend.core;

import java.util.HashMap;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

public class RegionWest implements IsWidget {

	final ContentPanel west = new ContentPanel();
	final BorderLayoutData westData = new BorderLayoutData();
	final String judulWest = "My Menu";
	private HashMap<String, Object> outerObjects = new HashMap<String, Object>();

	/*********************************** MAIN CODE ***********************************/
	@Override
	public Widget asWidget() {
		west.setHeading(judulWest);
		west.setTitle(judulWest);
		west.setAnimationDuration(500);
		west.setBorders(true);
		west.setResize(true);
		westData.setCollapsible(true);
		westData.setSplit(true);
		westData.setSize(200);
		westData.setMinSize(150);
		westData.setMaxSize(500);
		westData.setCollapseMini(true);
		westData.setMargins(new Margins(5, 4, 5, 5));
		westData.setCollapseHeaderVisible(true);

		TextButton buttonAlert = new TextButton("Show Message");
		buttonAlert.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				/*Viewport vp = (Viewport) RootLayoutPanel.get().getWidget(0);
				BorderLayoutContainer borderContainer = (BorderLayoutContainer) vp.getWidget(0);
				Iterator<Widget> arrayOfWidgets = borderContainer.iterator();
				while (arrayOfWidgets.hasNext()){
					Widget ch = arrayOfWidgets.next();
					//Window.alert(ch.getElement().getId());
					if (ch.getElement().getId().equalsIgnoreCase("regionCenter")) {
						//Window.alert(ch.getElement().getId());
					}
				}*/

				RegionCenter rc = (RegionCenter) outerObjects.get("regionCenter");
				rc.doCreateTab(rc.getTabPanel(), 1);
			}
		});
		west.add(buttonAlert);

		return west;
	}

	/*********************************** SETTER GETTER ***********************************/
	public ContentPanel getWest() {
		return west;
	}

	public BorderLayoutData getWestData() {
		return westData;
	}

	public HashMap<String, Object> getOuterObjects() {
		return outerObjects;
	}

	public void setOuterObjects(HashMap<String, Object> outerObjects) {
		this.outerObjects = outerObjects;
	}

}
