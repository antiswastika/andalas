package com.wd.andalas.frontend.core;

import java.util.HashMap;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer.VBoxLayoutAlign;

public class MenuRightImageList implements IsWidget {

	VBoxLayoutContainer imageMenuPanel = new VBoxLayoutContainer();
	private HashMap<String, Object> outerObjects = new HashMap<String, Object>();

	/*********************************** MAIN CODE ***********************************/
	@Override
	public Widget asWidget() {
		Image appLogo = new Image();
		appLogo.setUrl("images/logo.png");
		appLogo.setHeight("50px");

		imageMenuPanel.setVBoxLayoutAlign(VBoxLayoutAlign.CENTER);
		imageMenuPanel.add(appLogo, new BoxLayoutData(new Margins(5, 0, 0, 20)));
		imageMenuPanel.setWidth("500px");

		imageMenuPanel.add(imageMenuPanel);

		return imageMenuPanel;
	}

	/*********************************** CUSTOM METHODS ***********************************/
	public void generateImageList(String menuApa) {
		switch (menuApa) {
		case "1":

			break;

		default:
			break;
		}
	}

	/*********************************** SETTER GETTER ***********************************/
	public VBoxLayoutContainer getImageMenuPanel() {
		return imageMenuPanel;
	}

	public HashMap<String, Object> getOuterObjects() {
		return outerObjects;
	}

	public void setOuterObjects(HashMap<String, Object> outerObjects) {
		this.outerObjects = outerObjects;
	}

}
