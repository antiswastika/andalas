package com.wd.andalas.client.frontend.views.core.mvarstatic;

import java.util.HashMap;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;
import com.wd.andalas.global.GlobalToolbarForm;
import com.wd.andalas.global.Singleton;

public class FormMVarStatic extends ContentPanel implements IsWidget {
	
	/********** Inisiasi **********/
	private ContentPanel cp;
	private HashMap<String, Object> allObjects = new HashMap<String, Object>();
	private VerticalLayoutContainer vlc;
	private ToolBar downToolbar;

	@Override
	public Widget asWidget() {
		if (cp == null) {
			cp = new ContentPanel();
			cp.setId("FormMVarStaticID");
			cp.setHeaderVisible(false);
			cp.setHeading("");
			
			//vlc = doCreateVerticalLayoutContainer();
			downToolbar = doCreateDownToolbar();
			
			//vlc.add(downToolbar);
			cp.add(downToolbar);
			
			allObjects.put("formMVarStaticID", cp);
			Singleton.getInstance().setAllObjects(allObjects);
		} else {
			cp = (ContentPanel) Singleton.getInstance().getAllObjects().get("formMVarStaticID");
		}
		return cp;
	}
	
	/********** Custom Methods **********/
	private VerticalLayoutContainer doCreateVerticalLayoutContainer() {
		vlc = new VerticalLayoutContainer();
		return vlc;
	}
	
	private ToolBar doCreateDownToolbar() {
		ToolBar downToolbar = new GlobalToolbarForm().createToolBar( null, null, null, null, null, null, null );
		return downToolbar;
	}

}
