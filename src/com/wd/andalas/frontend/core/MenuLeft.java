package com.wd.andalas.frontend.core;

import java.util.HashMap;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Padding;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.ExpandMode;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer.VBoxLayoutAlign;

public class MenuLeft implements IsWidget {

	final AccordionLayoutContainer accordionPanel = new AccordionLayoutContainer();
	private HashMap<String, Object> outerObjects = new HashMap<String, Object>();

	/*********************************** MAIN CODE ***********************************/
	@Override
	public Widget asWidget() {
		// Membuat ImageList Menu A
		VBoxLayoutContainer vlc_A = new VBoxLayoutContainer();
		vlc_A.setVBoxLayoutAlign(VBoxLayoutAlign.CENTER);
		vlc_A.setPadding(new Padding(10));				
		ContentPanel cp_A = new ContentPanel();
		cp_A.setHeading("Daftar");
		cp_A.add(generateImageList(vlc_A, "images/icon/48x48/daftar_pegawai.png", "Pegawai THOS", "viewTHOS"));
		
		// Membuat ImageList Menu B
		TextButton buttonAlert2 = new TextButton("Show Message");
		ContentPanel cp_B = new ContentPanel();
		cp_B.setHeading("Pengaturan");
		cp_B.add(buttonAlert2);

		TextButton buttonAlert3 = new TextButton("Show Message");
		ContentPanel cp_C = new ContentPanel();
		cp_C.setHeading("Test");
		cp_C.add(buttonAlert3);
		
		/*Buat Accordion*/		
		accordionPanel.setExpandMode(ExpandMode.SINGLE_FILL);
		accordionPanel.addStyleName("label-imgList");
		accordionPanel.add(cp_A);
		accordionPanel.add(cp_B);
		accordionPanel.add(cp_C);
		
		accordionPanel.setActiveWidget(cp_A);
		return accordionPanel;
	}

	/*********************************** CUSTOM METHODS ***********************************/
	private VBoxLayoutContainer generateImageList(VBoxLayoutContainer vlcNya, String pathIconNya, String teksLabelNya, String actionNya) {
		/*Buat Menampilkan Icon*/
		Image imgNya = new Image();
		imgNya.setUrl(pathIconNya);
		imgNya.addClickHandler(menu_A1_clickHandler());
		imgNya.getElement().getStyle().setCursor(Style.Cursor.POINTER);
		
		/*Buat Teks Label*/
		Label lblNya = new Label(teksLabelNya);
		lblNya.getElement().getStyle().setCursor(Style.Cursor.POINTER);
		
		/*Gabungkan Image dan TeksLabel ke dalam vlc*/
		vlcNya.add(imgNya);
		vlcNya.add(lblNya);
		
		return vlcNya;
	}
	
	/*********************************** HANDLERS & LISTENERS ***********************************/
//	private SelectHandler btnAlert_clickHandler() {
//		return new SelectHandler() {
//			@Override
//			public void onSelect(SelectEvent event) {
//				/*Viewport vp = (Viewport) RootLayoutPanel.get().getWidget(0);
//				BorderLayoutContainer borderContainer = (BorderLayoutContainer) vp.getWidget(0);
//				Iterator<Widget> arrayOfWidgets = borderContainer.iterator();
//				while (arrayOfWidgets.hasNext()){
//					Widget ch = arrayOfWidgets.next();
//					//Window.alert(ch.getElement().getId());
//					if (ch.getElement().getId().equalsIgnoreCase("regionCenter")) {
//						//Window.alert(ch.getElement().getId());
//					}
//				}*/
//
//				RegionTabPanel tabPanel = (RegionTabPanel) outerObjects.get("regionTabPanel");
//				tabPanel.doCreateTab(tabPanel.getTabPanel(), 1);
//			}
//		};
//	}

	private ClickHandler menu_A1_clickHandler() {
		return new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//RegionTabPanel tabPanel = (RegionTabPanel) outerObjects.get("regionTabPanel");
				//tabPanel.doCreateTab(tabPanel.getTabPanel(), 1);
				Window.alert(Integer.toString(outerObjects.size()));
			}
		};
	}

	/*********************************** SETTER GETTER ***********************************/
	public AccordionLayoutContainer getAccordionPanel() {
		return accordionPanel;
	}

	public HashMap<String, Object> getOuterObjects() {
		return outerObjects;
	}

	public void setOuterObjects(HashMap<String, Object> outerObjects) {
		this.outerObjects = outerObjects;
	}

}
