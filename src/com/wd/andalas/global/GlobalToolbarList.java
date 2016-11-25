package com.wd.andalas.global;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.toolbar.FillToolItem;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;
import com.wd.andalas.resources.Resources;

public class GlobalToolbarList extends ToolBar {
	
	private ToolBar toolbarNya;
	
	public GlobalToolbarList() {
		return;
	}
	
	public ToolBar createUpToolBar(final SelectHandler insertHandler, final SelectHandler deleteHandler, final SelectHandler refreshHandler, final SelectHandler printHandler, final SelectHandler exportHandler, final SelectHandler searchHandler, final SelectHandler windowHandler) {
		final Resources imageResource = GWT.create(Resources.class);
		
		toolbarNya = new ToolBar();
		toolbarNya.setBorders(false);
		toolbarNya.setLayoutData(new VerticalLayoutData(1, -1));

		TextButton btn11 = new TextButton("Insert", insertHandler);
		btn11.setIcon(imageResource.btnAdd());
		toolbarNya.add(btn11);
		TextButton btn12 = new TextButton("Delete", deleteHandler);
		btn12.setIcon(imageResource.btnDelete());
		toolbarNya.add(btn12);
		TextButton btn13 = new TextButton("Refresh", refreshHandler);
		btn13.setIcon(imageResource.btnRefresh());
		toolbarNya.add(btn13);
		TextButton btn14 = new TextButton("Print", printHandler);
		btn14.setIcon(imageResource.btnPrinter());
		toolbarNya.add(btn14);
		TextButton btn15 = new TextButton("Export", exportHandler);
		btn15.setIcon(imageResource.btnExport());
		toolbarNya.add(btn15);

		toolbarNya.add(new FillToolItem());

		CheckBox cbk1 = new CheckBox();
		cbk1.setWidth(15);
		toolbarNya.add(cbk1);
		TextButton btn21 = new TextButton("Search", searchHandler);
		btn21.setIcon(imageResource.btnSearch());
		toolbarNya.add(btn21);
		TextButton btn22 = new TextButton("Window", windowHandler);
		btn22.setIcon(imageResource.btnWindow());
		toolbarNya.add(btn22);
		
		return toolbarNya;
	}
	
	public ToolBar createDownToolBar(final SelectHandler saveHandler, final SelectHandler resetHandler, final SelectHandler closeHandler, final SelectHandler customHandler) {
		final Resources imageResource = GWT.create(Resources.class);
		
		toolbarNya = new ToolBar();
		toolbarNya.setBorders(false);
		toolbarNya.setLayoutData(new VerticalLayoutData(1, -1));
		
		TextButton btn30 = new TextButton("Reset", resetHandler);
		btn30.setIcon(imageResource.btnRefresh());
		toolbarNya.add(btn30);
		
		toolbarNya.add(new FillToolItem());

		TextButton btn31 = new TextButton("Simpan", saveHandler);
		btn31.setIcon(imageResource.btnDiscBlue());
		toolbarNya.add(btn31);
		TextButton btn32 = new TextButton("Tutup", closeHandler);
		btn32.setIcon(imageResource.btnWindow());
		toolbarNya.add(btn32);
		
		return toolbarNya;
	}
	
}
