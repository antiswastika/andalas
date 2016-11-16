package com.wd.andalas.client.frontend.views.core.mvarstatic;

import java.util.HashMap;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Window;
import com.wd.andalas.global.Singleton;

public class FormMVarStatic extends Window implements IsWidget {
	
	/********** Inisiasi **********/
	private Window thisWindow;
	private HashMap<String, Object> allObjects = new HashMap<String, Object>();

	@Override
	public Widget asWidget() {
		if (thisWindow == null) {
			thisWindow = new Window();
			thisWindow.setId("FormMVarStaticID");
			thisWindow.setModal(true);
			thisWindow.setBlinkModal(true);
			thisWindow.setOnEsc(true);
			
			allObjects.put("formMVarStaticID", thisWindow);
			Singleton.getInstance().setAllObjects(allObjects);
		} else {
			thisWindow = (Window) Singleton.getInstance().getAllObjects().get("formMVarStaticID");
		}
		return thisWindow;
	}	

}
