package com.wd.andalas.global;

import java.util.Iterator;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.wd.andalas.client.frontend.views.core.mvarstatic.ListMVarStatic;
import com.wd.andalas.client.frontend.views.thos.profil.ListThosProfil;

public class GlobalFunctions {

	/********** Main Methods **********/
	public GlobalFunctions() { }

	/********** Custom Methods **********/
	public TabPanel doCreateTab(TabPanel tabPanel, String[] tabParams, String widgetParams) {
		if (tabParams == null) {
			tabPanel.clear();
			tabPanel.setTabScroll(true);
			tabPanel.setAnimScroll(true);
			tabPanel.add(new Label(), new TabItemConfig("Home", false));
		} else {
			int i = tabPanel.getWidgetCount() + 1;
			Iterator<Widget> arrayOfTabPanels = tabPanel.iterator();
			boolean ada = false;

			//Instansiasi Dynamic Class To Object
			//------------------------------------
			/*Class<?> objClass;
			Widget theWidget;
			try {
				objClass = Class.forName(widgetParams);
				theWidget = (Widget) objClass.newInstance();
			} catch (Exception e) {
				theWidget = new Label();
				e.printStackTrace();
				Logger logger = Logger.getLogger("ERROR");
				logger.log(Level.WARNING, e.toString());
			}*/
			//------------------------------------

			while (arrayOfTabPanels.hasNext()){
				Widget wgt = arrayOfTabPanels.next();
				if (wgt.getElement().getId().equalsIgnoreCase(widgetParams)) {
					ada = true;
					tabPanel.setActiveWidget(wgt);
					break;
				} else {
					ada = false;
				}
			}

			Widget theWidget;
			if (ada == false) {
				switch (widgetParams) {
				case "ListMVarStaticID":
					ListMVarStatic widgetListMVarStatic = new ListMVarStatic();
					widgetListMVarStatic.setTabHeader(tabParams[1]);
					theWidget = widgetListMVarStatic.asWidget();
					break;
				case "ListThosProfilID":
					ListThosProfil widgetListThosProfil = new ListThosProfil();
					widgetListThosProfil.setTabHeader(tabParams[1]);
					theWidget = widgetListThosProfil.asWidget();
					break;
				default:
					theWidget = new Label().asWidget();
					break;
				}
				tabPanel.add(theWidget, new TabItemConfig(tabParams[0], true));
				tabPanel.setActiveWidget(tabPanel.getWidget(i - 1));
			}
		}

		return tabPanel;
	}

}
