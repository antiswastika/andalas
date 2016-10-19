package com.wd.andalas.client.frontend.views.core;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.Padding;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.ExpandMode;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer.VBoxLayoutAlign;
import com.wd.andalas.client.frontend.views.core.mvarstatic.ListMVarStatic;
import com.wd.andalas.global.GlobalClickHandler;

public class MenuLeft {

	final AccordionLayoutContainer accordionPanel = new AccordionLayoutContainer();

	/*********************************** MAIN CODE ***********************************/
	public MenuLeft() {
		// Membuat ImageList Menu A
		VBoxLayoutContainer vlc_A = new VBoxLayoutContainer();
		vlc_A.setVBoxLayoutAlign(VBoxLayoutAlign.CENTER);
		vlc_A.setPadding(new Padding(10));
		doCreateImageList(vlc_A, "images/icon/32x32/daftar_pegawai_thos.png", "Pegawai THOS", new Label().asWidget());
		doCreateImageList(vlc_A, "images/icon/32x32/cari_pegawai.png", "Cari Pegawai THOS", new Label().asWidget());
		ContentPanel cp_A = new ContentPanel();
		cp_A.setHeading("Daftar");
		cp_A.add(vlc_A);

		// Membuat ImageList Menu B
		VBoxLayoutContainer vlc_B = new VBoxLayoutContainer();
		vlc_B.setVBoxLayoutAlign(VBoxLayoutAlign.CENTER);
		vlc_B.setPadding(new Padding(10));
		ListMVarStatic listMVarStatic = new ListMVarStatic();
		listMVarStatic.setTabHeader("Daftar Variabel Statis");
		doCreateImageList(vlc_B, "images/icon/32x32/daftar_varstatis.png", "Variabel Statis", listMVarStatic.asWidget());
		doCreateImageList(vlc_B, "images/icon/32x32/daftar_user.png", "Daftar User", new Label().asWidget());
		doCreateImageList(vlc_B, "images/icon/32x32/ganti_password.png", "Ubah Password", new Label().asWidget());
		doCreateImageList(vlc_B, "images/icon/32x32/logout.png", "Logout", new Label().asWidget());
		ContentPanel cp_B = new ContentPanel();
		cp_B.setHeading("Pengaturan");
		cp_B.add(vlc_B);

		/*Buat Accordion*/
		accordionPanel.setId("accdn");
		accordionPanel.setExpandMode(ExpandMode.SINGLE_FILL);
		accordionPanel.addStyleName("label-imgList");
		accordionPanel.add(cp_A);
		accordionPanel.add(cp_B);

		accordionPanel.setActiveWidget(cp_A);
	}

	/*********************************** CUSTOM METHODS ***********************************/
	private void doCreateImageList(VBoxLayoutContainer vlcNya, String pathIconNya, String teksLabelNya, Widget widgetNya) {
		String[] tabParams = { teksLabelNya };
		Widget objParams = widgetNya;
		GlobalClickHandler myClickHandler = new GlobalClickHandler();
		myClickHandler.setTabParams(tabParams);
		myClickHandler.setObjParams(objParams);

		/*Buat Menampilkan Icon*/
		Image imgNya = new Image();
		imgNya.setUrl(pathIconNya);
		imgNya.setHeight("32px");
		imgNya.setWidth("32px");
		imgNya.setAltText(teksLabelNya);
		imgNya.addClickHandler(myClickHandler);
		imgNya.getElement().getStyle().setCursor(Style.Cursor.POINTER);
		vlcNya.add(imgNya, new BoxLayoutData(new Margins(10, 0, 0, 0)));

		/*Buat Teks Label*/
		Label lblNya = new Label(teksLabelNya);
		lblNya.addClickHandler(myClickHandler);
		lblNya.getElement().getStyle().setCursor(Style.Cursor.POINTER);
		vlcNya.add(lblNya, new BoxLayoutData(new Margins(0, 0, 10, 0)));
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

	/*********************************** SETTER GETTER ***********************************/
	public AccordionLayoutContainer getAccordionPanel() {
		return accordionPanel;
	}

}
