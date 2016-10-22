package com.wd.andalas.client.frontend.views.core;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.Padding;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.ExpandMode;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer.VBoxLayoutAlign;
import com.wd.andalas.global.GlobalClickHandler;

public class CustomMenuLeft {
	
	/********** Inisiasi **********/
	final AccordionLayoutContainer accordionPanel = new AccordionLayoutContainer();

	/********** Main Methods **********/
	public CustomMenuLeft() {
		// Membuat ImageList Menu A
		VBoxLayoutContainer vlc_A = new VBoxLayoutContainer();
		vlc_A.setVBoxLayoutAlign(VBoxLayoutAlign.CENTER);
		vlc_A.setPadding(new Padding(10));
		String[] tabParamsA1 = { "Pegawai THOS" };
		doCreateImageList(vlc_A, "images/icon/32x32/daftar_pegawai_thos.png", tabParamsA1, "");
		String[] tabParamsA2 = { "Cari Pegawai THOS" };
		doCreateImageList(vlc_A, "images/icon/32x32/cari_pegawai.png", tabParamsA2, "");
		ContentPanel cp_A = new ContentPanel();
		cp_A.setHeading("Daftar");
		cp_A.add(vlc_A);

		// Membuat ImageList Menu B
		VBoxLayoutContainer vlc_B = new VBoxLayoutContainer();
		vlc_B.setVBoxLayoutAlign(VBoxLayoutAlign.CENTER);
		vlc_B.setPadding(new Padding(10));
		String[] tabParamsB1 = { "Variabel Statis", "Daftar Variabel Statis" };
		doCreateImageList(vlc_B, "images/icon/32x32/daftar_varstatis.png", tabParamsB1, "ListMVarStaticID");
		String[] tabParamsB2 = { "Daftar User" };
		doCreateImageList(vlc_B, "images/icon/32x32/daftar_user.png", tabParamsB2, "");
		String[] tabParamsB3 = { "Ubah Password" };
		doCreateImageList(vlc_B, "images/icon/32x32/ganti_password.png", tabParamsB3, "");
		String[] tabParamsB4 = { "Logout" };
		doCreateImageList(vlc_B, "images/icon/32x32/logout.png", tabParamsB4, "");
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

	/********** Custom Methods **********/
	private void doCreateImageList(VBoxLayoutContainer vlc, String pathIcon, String[] tabParams, String widgetParams) {
		GlobalClickHandler customHandler = new GlobalClickHandler();
		customHandler.setTabParams(tabParams);
		customHandler.setWidgetParams(widgetParams);

		/*Menampilkan Icon*/
		Image imgNya = new Image();
		imgNya.setUrl(pathIcon);
		imgNya.setHeight("32px");
		imgNya.setWidth("32px");
		imgNya.setAltText(tabParams[0]);
		imgNya.addClickHandler(customHandler);
		imgNya.getElement().getStyle().setCursor(Style.Cursor.POINTER);
		vlc.add(imgNya, new BoxLayoutData(new Margins(10, 0, 0, 0)));

		/*Buat Teks Label*/
		Label lblNya = new Label(tabParams[0]);
		lblNya.addClickHandler(customHandler);
		lblNya.getElement().getStyle().setCursor(Style.Cursor.POINTER);
		vlc.add(lblNya, new BoxLayoutData(new Margins(0, 0, 10, 0)));
	}

	/*********************************** SETTER GETTER ***********************************/
	public AccordionLayoutContainer getAccordionPanel() {
		return accordionPanel;
	}

}