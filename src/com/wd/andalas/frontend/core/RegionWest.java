package com.wd.andalas.frontend.core;

import java.util.HashMap;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.Padding;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.ExpandMode;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer.VBoxLayoutAlign;
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
		west.setHeaderVisible(false);
		west.setAnimationDuration(300);
		west.setBorders(false);
		west.setResize(true);
		westData.setCollapsible(false);
		westData.setSplit(true);
		westData.setSize(150);
		westData.setMinSize(100);
		westData.setMaxSize(300);
		westData.setCollapseMini(false);
		westData.setMargins(new Margins(0, 4, 0, 5));
		westData.setCollapseHeaderVisible(true);

		// Membuat ImageList Menu A
		VBoxLayoutContainer imp_A = new VBoxLayoutContainer();
		imp_A.setVBoxLayoutAlign(VBoxLayoutAlign.CENTER);
		imp_A.setPadding(new Padding(10));
		Image menu_A1 = new Image();
		menu_A1.setUrl("images/icon/48x48/daftar_pegawai.png");
		menu_A1.setHeight("50px");
		imp_A.add(menu_A1);
		Label lbl_A1 = new Label("Daftar Pegawai");
		imp_A.add(lbl_A1);
		ContentPanel cp_A = new ContentPanel();
		cp_A.setHeading("Daftar");
		cp_A.add(imp_A);

		// Membuat ImageList Menu A
		TextButton buttonAlert2 = new TextButton("Show Message");
		ContentPanel cp_B = new ContentPanel();
		cp_B.setHeading("Pengaturan");
		cp_B.add(buttonAlert2);

		TextButton buttonAlert3 = new TextButton("Show Message");
		buttonAlert3.addSelectHandler(btnAlert_clickHandler());
		ContentPanel cp_C = new ContentPanel();
		cp_C.setHeading("Test");
		cp_C.add(buttonAlert3);

		/*Buat Accordion*/
		AccordionLayoutContainer accdn = new AccordionLayoutContainer();
		accdn.setExpandMode(ExpandMode.SINGLE_FILL);
		accdn.add(cp_A);
		accdn.setActiveWidget(cp_A);
		accdn.add(cp_B);
		accdn.add(cp_C);
		west.add(accdn);

		return west;
	}

	/*********************************** HANDLERS & LISTENERS ***********************************/
	private SelectHandler btnAlert_clickHandler() {
		return new SelectHandler() {
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

				RegionTabPanel tabPanel = (RegionTabPanel) outerObjects.get("regionTabPanel");
				tabPanel.doCreateTab(tabPanel.getTabPanel(), 1);
			}
		};
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
