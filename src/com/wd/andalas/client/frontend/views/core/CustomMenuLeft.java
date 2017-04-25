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
import com.wd.andalas.client.locale.thos.profil.ThosProfilConstants;
import com.wd.andalas.global.GlobalClickHandler;
import com.wd.andalas.global.locale.AndalasConstants;

public class CustomMenuLeft {

	/********** Inisiasi **********/
	final AccordionLayoutContainer accordionPanel = new AccordionLayoutContainer();
	final AndalasConstants andalasText = GWT.create(AndalasConstants.class);
	final ThosProfilConstants thosprofilText = GWT.create(ThosProfilConstants.class);

	/********** Main Methods **********/
	public CustomMenuLeft() {
		// Membuat ImageList Menu A
		// Harus dibuat dinamis berdasarkan database sehingga:
		// 1. Localization bisa terbentuk.
		// 2. Menu based database bisa terbentuk.
		VBoxLayoutContainer vlc_A = new VBoxLayoutContainer();
		vlc_A.setVBoxLayoutAlign(VBoxLayoutAlign.CENTER);
		vlc_A.setPadding(new Padding(10));
		String[] tabParamsA1 = { thosprofilText.labelUiMap().get("label.ui.01"), thosprofilText.labelUiMap().get("label.ui.02") };
		doCreateImageList(vlc_A, "images/icon/32x32/daftar_pegawai_thos.png", tabParamsA1, "ListThosProfilID");
		String[] tabParamsA2 = { thosprofilText.labelUiMap().get("label.ui.03"), thosprofilText.labelUiMap().get("label.ui.04") };
		doCreateImageList(vlc_A, "images/icon/32x32/cari_pegawai.png", tabParamsA2, "");
		String[] tabParamsA3 = { thosprofilText.labelUiMap().get("label.ui.05"), thosprofilText.labelUiMap().get("label.ui.06") };
		doCreateImageList(vlc_A, "images/icon/32x32/alih_vendor.png", tabParamsA3, "");
		ContentPanel cp_A = new ContentPanel();
		cp_A.setHeading(andalasText.labelMenuMap().get("label.menu01.title"));
		cp_A.add(vlc_A);
		
		
		// Membuat ImageList Menu B
		// Harus dibuat dinamis berdasarkan database sehingga:
		// 1. Localization bisa terbentuk.
		// 2. Menu based database bisa terbentuk.
		List<String> listSubtitleB = new ArrayList<String>(Arrays.asList(andalasText.labelMenuMap().get("label.menu00.subtitle").split(andalasText.labelApplicationMap().get("label.application.delimiter"))));
		List<String> listSubtitleBarB = new ArrayList<String>(Arrays.asList(andalasText.labelMenuMap().get("label.menu00.subtitle.bar").split(andalasText.labelApplicationMap().get("label.application.delimiter"))));
		VBoxLayoutContainer vlc_B = new VBoxLayoutContainer();
		vlc_B.setVBoxLayoutAlign(VBoxLayoutAlign.CENTER);
		vlc_B.setPadding(new Padding(10));
		String[] tabParamsB999 = { listSubtitleB.get(3), listSubtitleBarB.get(3) };
		doCreateImageList(vlc_B, "images/icon/32x32/logout.png", tabParamsB999, "");
		ContentPanel cp_B = new ContentPanel();
		cp_B.setHeading(andalasText.labelMenuMap().get("label.menu02.title"));
		cp_B.add(vlc_B);
		
		
		// Membuat ImageList Menu B
		// Harus dibuat statis sehingga:
		// 1. Menjadi bagian dari application-platform.
		// 2. Localization terpusat.
		List<String> listSubtitleC = new ArrayList<String>(Arrays.asList(andalasText.labelMenuMap().get("label.menu00.subtitle").split(andalasText.labelApplicationMap().get("label.application.delimiter"))));
		List<String> listSubtitleBarC = new ArrayList<String>(Arrays.asList(andalasText.labelMenuMap().get("label.menu00.subtitle.bar").split(andalasText.labelApplicationMap().get("label.application.delimiter"))));		
		VBoxLayoutContainer vlc_C = new VBoxLayoutContainer();
		vlc_C.setVBoxLayoutAlign(VBoxLayoutAlign.CENTER);
		vlc_C.setPadding(new Padding(10));
		String[] tabParamsC1 = { listSubtitleC.get(0), listSubtitleBarC.get(0) };
		doCreateImageList(vlc_C, "images/icon/32x32/daftar_varstatis.png", tabParamsC1, "ListMVarStaticID");
		String[] tabParamsC2 = { listSubtitleC.get(1), listSubtitleBarC.get(1) };
		doCreateImageList(vlc_C, "images/icon/32x32/daftar_user.png", tabParamsC2, "");
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
