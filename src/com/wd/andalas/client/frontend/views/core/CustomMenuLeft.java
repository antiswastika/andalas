package com.wd.andalas.client.frontend.views.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gwt.core.client.GWT;
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
import com.wd.andalas.global.locale.AndalasConstants;

public class CustomMenuLeft {

	/********** Inisiasi **********/
	final AccordionLayoutContainer accordionPanel = new AccordionLayoutContainer();
	final AndalasConstants andalasText = GWT.create(AndalasConstants.class);

	/********** Main Methods **********/
	public CustomMenuLeft() {
		// Membuat ImageList Menu A
		// Harus dibuat dinamis berdasarkan database sehingga:
		// 1. Localization bisa terbentuk.
		// 2. Menu based database bisa terbentuk.
		VBoxLayoutContainer vlc_A = new VBoxLayoutContainer();
		vlc_A.setVBoxLayoutAlign(VBoxLayoutAlign.CENTER);
		vlc_A.setPadding(new Padding(10));
		String[] tabParamsA1 = { "Pegawai", "Daftar Pegawai" };
		doCreateImageList(vlc_A, "images/icon/32x32/daftar_pegawai_thos.png", tabParamsA1, "ListThosProfilID");
		String[] tabParamsA2 = { "Cari Pegawai", "Pencarian Pegawai" };
		doCreateImageList(vlc_A, "images/icon/32x32/cari_pegawai.png", tabParamsA2, "");
		String[] tabParamsA3 = { "Alih Vendor", "Proses Alih Vendor" };
		doCreateImageList(vlc_A, "images/icon/32x32/alih_vendor.png", tabParamsA3, "");
		ContentPanel cp_A = new ContentPanel();
		cp_A.setHeading("Umum");
		cp_A.add(vlc_A);
		
		
		// Membuat ImageList Menu B
		// Harus dibuat dinamis berdasarkan database sehingga:
		// 1. Localization bisa terbentuk.
		// 2. Menu based database bisa terbentuk.
		/*VBoxLayoutContainer vlc_B = new VBoxLayoutContainer();
		vlc_B.setVBoxLayoutAlign(VBoxLayoutAlign.CENTER);
		vlc_B.setPadding(new Padding(10));
		String[] tabParamsB1 = { "Pegawai", "Daftar Pegawai" };
		doCreateImageList(vlc_B, "images/icon/32x32/daftar_pegawai_thos.png", tabParamsB1, "ListThosProfilID");
		String[] tabParamsB2 = { "Cari Pegawai", "Pencarian Pegawai" };
		doCreateImageList(vlc_B, "images/icon/32x32/cari_pegawai.png", tabParamsB2, "");
		String[] tabParamsB3 = { "Alih Vendor", "Proses Alih Vendor" };
		doCreateImageList(vlc_B, "images/icon/32x32/alih_vendor.png", tabParamsB3, "");*/
		ContentPanel cp_B = new ContentPanel();
		cp_B.setHeading("Menu Saya");
		/*cp_B.add(vlc_B);*/
		
		
		// Membuat ImageList Menu B
		// Harus dibuat statis sehingga:
		// 1. Menjadi bagian dari application-platform.
		// 2. Localization terpusat.
		List<String> listSubtitle = new ArrayList<String>(Arrays.asList(andalasText.labelMenuMap().get("label.menu00.subtitle").split(andalasText.labelApplicationMap().get("label.application.delimiter"))));
		List<String> listSubtitleBar = new ArrayList<String>(Arrays.asList(andalasText.labelMenuMap().get("label.menu00.subtitle.bar").split(andalasText.labelApplicationMap().get("label.application.delimiter"))));		
		VBoxLayoutContainer vlc_C = new VBoxLayoutContainer();
		vlc_C.setVBoxLayoutAlign(VBoxLayoutAlign.CENTER);
		vlc_C.setPadding(new Padding(10));
		String[] tabParamsC1 = { listSubtitle.get(0), listSubtitleBar.get(0) };
		doCreateImageList(vlc_C, "images/icon/32x32/daftar_varstatis.png", tabParamsC1, "ListMVarStaticID");
		String[] tabParamsC2 = { listSubtitle.get(1), listSubtitleBar.get(1) };
		doCreateImageList(vlc_C, "images/icon/32x32/daftar_user.png", tabParamsC2, "");
		String[] tabParamsC3 = { listSubtitle.get(3), listSubtitleBar.get(3) };
		doCreateImageList(vlc_C, "images/icon/32x32/logout.png", tabParamsC3, "");
		ContentPanel cp_C = new ContentPanel();
		cp_C.setHeading(andalasText.labelMenuMap().get("label.menu00.title"));
		cp_C.add(vlc_C);
		

		/*Buat Accordion*/
		accordionPanel.setId("accdn");
		accordionPanel.setExpandMode(ExpandMode.SINGLE_FILL);
		accordionPanel.addStyleName("label-imgList");
		accordionPanel.add(cp_A);
		accordionPanel.add(cp_B);
		accordionPanel.add(cp_C);

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
