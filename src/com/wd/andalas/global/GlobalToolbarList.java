package com.wd.andalas.global;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
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
		
		if (insertHandler != null) {
			TextButton btn11 = new TextButton("Tambah", insertHandler);
			btn11.setIcon(imageResource.btnAdd());
			btn11.setToolTip("Tambah");
			toolbarNya.add(btn11);
		}
		if (deleteHandler != null) {
			TextButton btn12 = new TextButton("Hapus", deleteHandler);
			btn12.setIcon(imageResource.btnDelete());
			btn12.setToolTip("Hapus");
			btn12.setEnabled(false);
			toolbarNya.add(btn12);
		}
		if (refreshHandler != null) {
			TextButton btn13 = new TextButton("Refresh", refreshHandler);
			btn13.setIcon(imageResource.btnRefresh());
			btn13.setToolTip("Refresh");
			toolbarNya.add(btn13);
		}
		if (printHandler != null) {
			TextButton btn14 = new TextButton("Cetak", printHandler);
			btn14.setIcon(imageResource.btnPrinter());
			btn14.setToolTip("Cetak");
			toolbarNya.add(btn14);
		}
		if (exportHandler != null) {
			TextButton btn15 = new TextButton("Ekspor", exportHandler);
			btn15.setIcon(imageResource.btnExport());
			btn15.setToolTip("Ekspor");
			toolbarNya.add(btn15);
		}
		
		toolbarNya.add(new FillToolItem());

		CheckBox cbk1 = new CheckBox();
		cbk1.setWidth(15);
		toolbarNya.add(cbk1);
		
		if (searchHandler != null) {
			TextButton btn21 = new TextButton("Cari", searchHandler);
			btn21.setIcon(imageResource.btnSearch());
			btn21.setToolTip("Cari");
			toolbarNya.add(btn21);	
		}
		if (windowHandler != null) {
			TextButton btn22 = new TextButton("Window", windowHandler);
			btn22.setIcon(imageResource.btnWindow());
			btn22.setToolTip("Window");
			toolbarNya.add(btn22);
		}

		return toolbarNya;
	}

	public ToolBar createDownToolBar(final SelectHandler saveHandler, final SelectHandler resetHandler, final SelectHandler closeHandler, final SelectHandler infoHandler, final List<SelectHandler> customHandlerList, final List<String> customHandlerTextList,  final List<ImageResource> customHandlerIconResourceList) {
		final Resources imageResource = GWT.create(Resources.class);

		toolbarNya = new ToolBar();
		toolbarNya.setBorders(false);
		toolbarNya.setLayoutData(new VerticalLayoutData(1, -1));
		
		if (infoHandler != null) {
			TextButton btn30 = new TextButton("", infoHandler);
			btn30.setIcon(imageResource.btnHelp());
			btn30.setToolTip("Informasi");
			toolbarNya.add(btn30);
		}
		if (resetHandler != null) {
			TextButton btn31 = new TextButton("Ulangi", resetHandler);
			btn31.setIcon(imageResource.btnRefresh());
			btn31.setToolTip("Ulangi");
			toolbarNya.add(btn31);
		}
		
		toolbarNya.add(new FillToolItem());
		
		if (customHandlerList != null && customHandlerTextList != null) {
			for (int i = 0; i < customHandlerList.size(); i++)
			{
				TextButton btn99 = new TextButton(customHandlerTextList.get(i), customHandlerList.get(i));
				
				if (customHandlerIconResourceList != null) {
					btn99.setIcon(customHandlerIconResourceList.get(i));
				} else {
					btn99.setIcon(imageResource.btnInformation());
				}
				
				btn99.setToolTip(customHandlerTextList.get(i));
				toolbarNya.add(btn99);
			}
		}
		
		if (saveHandler != null) {
			TextButton btn38 = new TextButton("Simpan", saveHandler);
			btn38.setIcon(imageResource.btnDiscBlue());
			btn38.setToolTip("Simpan");
			toolbarNya.add(btn38);
		}
		if (closeHandler != null) {
			TextButton btn39 = new TextButton("Tutup", closeHandler);
			btn39.setIcon(imageResource.btnExit());
			btn39.setToolTip("Tutup");
			toolbarNya.add(btn39);
		}
		
		return toolbarNya;
	}

}
