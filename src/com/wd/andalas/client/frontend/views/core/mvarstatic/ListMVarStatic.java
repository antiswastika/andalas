package com.wd.andalas.client.frontend.views.core.mvarstatic;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;

public class ListMVarStatic implements IsWidget {

	private ContentPanel list;
	private BorderLayoutData listData = new BorderLayoutData();

	/*********************************** MAIN CODE ***********************************/
	@Override
	public Widget asWidget() {
		if (list == null) {
			list = new ContentPanel();
			list.setId("regionSouthID");
			list.setBodyStyle("background:transparent; border:0");
			list.setHeaderVisible(false);
			listData.setMargins(new Margins(0, 5, 5, 5));

			list.setLayoutData(listData);
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

}
