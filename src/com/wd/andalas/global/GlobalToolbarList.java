package com.wd.andalas.global;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeHandler;
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

	public ToolBar createUpToolBar(final SelectHandler insertHandler, final SelectHandler deleteHandler, final SelectHandler refreshHandler, final SelectHandler printHandler, final SelectHandler exportHandler, final ChangeHandler clearSearchHandler, final SelectHandler searchHandler, final SelectHandler windowHandler) {
		final Resources imageResource = GWT.create(Resources.class);

		toolbarNya = new ToolBar();
		toolbarNya.setBorders(false);
		toolbarNya.setLayoutData(new VerticalLayoutData(1, -1));
		
		if (insertHandler != null) {
			TextButton btn11 = new TextButton("Tambah");
			btn11.setIcon(imageResource.btnAdd());
			btn11.setToolTip("Tambah");
			btn11.addSelectHandler(insertHandler);
			toolbarNya.add(btn11);
		}
		if (deleteHandler != null) {
			TextButton btn12 = new TextButton("Hapus");
			btn12.setIcon(imageResource.btnDelete());
			btn12.setToolTip("Hapus");
			btn12.setEnabled(false);
			btn12.addSelectHandler(deleteHandler);
			toolbarNya.add(btn12);
		}
		if (refreshHandler != null) {
			TextButton btn13 = new TextButton("Refresh");
			btn13.setIcon(imageResource.btnRefresh());
			btn13.setToolTip("Refresh");
			btn13.addSelectHandler(refreshHandler);
			toolbarNya.add(btn13);
		}
		if (printHandler != null) {
			TextButton btn14 = new TextButton("Cetak");
			btn14.setIcon(imageResource.btnPrinter());
			btn14.setToolTip("Cetak");
			btn14.addSelectHandler(printHandler);
			toolbarNya.add(btn14);
		}
		if (exportHandler != null) {
			TextButton btn15 = new TextButton("Ekspor");
			btn15.setIcon(imageResource.btnExport());
			btn15.setToolTip("Ekspor");
			btn15.addSelectHandler(exportHandler);
			toolbarNya.add(btn15);
		}
		
		toolbarNya.add(new FillToolItem());		
		
		if (clearSearchHandler != null) {
			CheckBox cbk1 = new CheckBox();
			cbk1.setWidth(15);
			cbk1.setToolTip("Clear Search Result");
			cbk1.addChangeHandler(clearSearchHandler);
			toolbarNya.add(cbk1);
		}
		if (searchHandler != null) {
			TextButton btn21 = new TextButton("Cari");
			btn21.setIcon(imageResource.btnSearch());
			btn21.setToolTip("Cari");
			btn21.addSelectHandler(searchHandler);
			toolbarNya.add(btn21);	
		}
		if (windowHandler != null) {
			TextButton btn22 = new TextButton("Window");
			btn22.setIcon(imageResource.btnWindow());
			btn22.setToolTip("Window");
			btn22.addSelectHandler(windowHandler);
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
			TextButton btn30 = new TextButton("");
			btn30.setIcon(imageResource.btnHelp());
			btn30.setToolTip("Informasi");
			btn30.addSelectHandler(infoHandler);
			toolbarNya.add(btn30);
		}
		if (resetHandler != null) {
			TextButton btn31 = new TextButton("Ulangi");
			btn31.setIcon(imageResource.btnRefresh());
			btn31.setToolTip("Ulangi");
			btn31.addSelectHandler(resetHandler);
			toolbarNya.add(btn31);
		}
		
		toolbarNya.add(new FillToolItem());
		
		if (customHandlerList != null && customHandlerTextList != null) {
			for (int i = 0; i < customHandlerList.size(); i++)
			{
				TextButton btn99 = new TextButton(customHandlerTextList.get(i));
				
				if (customHandlerIconResourceList != null) {
					btn99.setIcon(customHandlerIconResourceList.get(i));
				} else {
					btn99.setIcon(imageResource.btnInformation());
				}
				
				btn99.setToolTip(customHandlerTextList.get(i));
				btn99.addSelectHandler(customHandlerList.get(i));
				toolbarNya.add(btn99);
			}
		}
		
		if (saveHandler != null) {
			TextButton btn38 = new TextButton("Simpan");
			btn38.setIcon(imageResource.btnDiscBlue());
			btn38.setToolTip("Simpan");
			btn38.addSelectHandler(saveHandler);
			toolbarNya.add(btn38);
		}
		if (closeHandler != null) {
			TextButton btn39 = new TextButton("Tutup");
			btn39.setIcon(imageResource.btnExit());
			btn39.setToolTip("Tutup");
			btn39.addSelectHandler(closeHandler);
			toolbarNya.add(btn39);
		}
		
		return toolbarNya;
	}

}
