package com.wd.andalas.client.frontend.views.core.mvarstatic;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;

public class FormMVarStatic implements IsWidget {

	private ContentPanel form;
	private BorderLayoutData formData = new BorderLayoutData();

	/*********************************** MAIN CODE ***********************************/
	@Override
	public Widget asWidget() {
		if (form == null) {
			form = new ContentPanel();
			form.setId("regionSouthID");
			form.setBodyStyle("background:transparent; border:0");
			form.setHeaderVisible(false);
			formData.setMargins(new Margins(0, 5, 5, 5));

			form.setLayoutData(formData);
		}
		return form;
	}

	/*********************************** SETTER GETTER ***********************************/
	public ContentPanel getForm() {
		return form;
	}

	public BorderLayoutData getFormData() {
		return formData;
	}

}
