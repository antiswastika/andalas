package com.wd.andalas.client.frontend.views.core.mvarstatic;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

public class ListMVarStatic implements IsWidget {

	private ContentPanel list;
	private BorderLayoutData listData = new BorderLayoutData();
	private String tabHeader = "";

	/*********************************** MAIN CODE ***********************************/
	@Override
	public Widget asWidget() {
		if (list == null) {
			list = new ContentPanel();
			list.setId("regionSouthID");
			list.setBodyStyle("background:transparent; border:0");
			list.setHeaderVisible(true);
			list.setHeading(tabHeader);
			listData.setMargins(new Margins(0, 0, 0, 0));

			list.setLayoutData(listData);
			list.add(new VerticalLayoutContainer());
		}
		return list;
	}

	/*********************************** SETTER GETTER ***********************************/
	public ContentPanel getList() {
		return list;
	}

	public BorderLayoutData getListData() {
		return listData;
	}

	public String getTabHeader() {
		return tabHeader;
	}
	public void setTabHeader(String tabHeader) {
		this.tabHeader = tabHeader;
	}

}
