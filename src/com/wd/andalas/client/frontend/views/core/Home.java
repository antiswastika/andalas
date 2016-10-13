package com.wd.andalas.client.frontend.views.core;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.AbstractHtmlLayoutContainer.HtmlData;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;

public class Home implements IsWidget {

	private ContentPanel home;
	private BorderLayoutData homeData = new BorderLayoutData();

	/*********************************** MAIN CODE ***********************************/
	@Override
	public Widget asWidget() {
		if (home == null) {
			home = new ContentPanel();
			home.setId("homeID");
			home.setHeaderVisible(false);

			TextButton button1 = new TextButton("Button Left Column");
			TextButton button2 = new TextButton("Button Right Column");

			HtmlLayoutContainerTemplate templates = GWT.create(HtmlLayoutContainerTemplate.class);
			HtmlLayoutContainer htmlLayoutContainer = new HtmlLayoutContainer(templates.getTemplate());
			htmlLayoutContainer.add(button1, new HtmlData(".cell1"));
			htmlLayoutContainer.add(button2, new HtmlData(".cell2"));

			home.add(htmlLayoutContainer, new MarginData(20));
		}
		return home;
	}

	public interface HtmlLayoutContainerTemplate extends XTemplates {
		@XTemplate("<table width=\"500px\" height=\"100%\"><tbody><tr><td height=\"100%\" class=\"cell1\" /><td>Some other cell</td><td class=\"cell2\" /></tr></tbody></table>")
		SafeHtml getTemplate();
	}

	/*********************************** SETTER GETTER ***********************************/
	public ContentPanel getHome() {
		return home;
	}

	public BorderLayoutData getHomeData() {
		return homeData;
	}

}
