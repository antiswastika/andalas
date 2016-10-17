package com.wd.andalas.client.frontend.views.core.mvarstatic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.IdentityValueProvider;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.RefreshEvent;
import com.sencha.gxt.widget.core.client.grid.CheckBoxSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTO;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTOProperties;

public class ListMVarStatic implements IsWidget {

	private ContentPanel list;
	private BorderLayoutData listData = new BorderLayoutData();
	private String tabHeader = "";
	private CoreMVarstaticDTOProperties properties = GWT.create(CoreMVarstaticDTOProperties.class);
	private VerticalLayoutContainer vlc;
	private PagingToolBar toolbar;

	/***********************************
	 * MAIN CODE
	 ***********************************/
	@Override
	public Widget asWidget() {
		if (list == null) {
			list = new ContentPanel();
			list.setId("ListMVarStaticID");
			list.setBodyStyle("background:transparent; border:0");
			list.setHeaderVisible(true);
			list.setHeading(tabHeader);
			listData.setMargins(new Margins(0, 0, 0, 0));

			list.setLayoutData(listData);
			doCreateVerticalLayoutContainer();
			list.add(vlc);
		}
		return list;
	}

	/***********************************
	 * CUSTOM METHODS
	 ***********************************/
	private VerticalLayoutContainer doCreateVerticalLayoutContainer() {
		vlc = new VerticalLayoutContainer();
		Grid<CoreMVarstaticDTO> grid = doCreateGrid();
		PagingToolBar toolbar = doCreatePagingToolBar();
		vlc.add(grid, new VerticalLayoutData(1, 1));
		vlc.add(toolbar, new VerticalLayoutData(1, -1));
		return vlc;
	}

	private PagingToolBar doCreatePagingToolBar() {
		toolbar = new PagingToolBar(50);
		toolbar.setBorders(false);
		return toolbar;
	}

	@SuppressWarnings("unused")
	private Grid<CoreMVarstaticDTO> doCreateGrid() {
		/* Step 1 : Buat Indentity Model */
		IdentityValueProvider<CoreMVarstaticDTO> identity = new IdentityValueProvider<CoreMVarstaticDTO>();

		/* Step 2 : Buat Selection Model */
		final CheckBoxSelectionModel<CoreMVarstaticDTO> selectionModel = new CheckBoxSelectionModel<CoreMVarstaticDTO>(identity) {
			@Override
			protected void onRefresh(RefreshEvent event) {
				if (isSelectAllChecked()) {
					selectAll();
				}
				super.onRefresh(event);
			}
		};

		/* Step 3 : Buat Definisi Semua Column */
		ColumnConfig<CoreMVarstaticDTO, Date> created_at = new ColumnConfig<CoreMVarstaticDTO, Date>(properties.created_at(), 100, "Tgl Input");
		ColumnConfig<CoreMVarstaticDTO, String> created_by = new ColumnConfig<CoreMVarstaticDTO, String>(properties.created_by(), 150, "Input Oleh");
		ColumnConfig<CoreMVarstaticDTO, Date> updated_at = new ColumnConfig<CoreMVarstaticDTO, Date>(properties.updated_at(), 100, "Tgl Update");
		ColumnConfig<CoreMVarstaticDTO, String> updated_by = new ColumnConfig<CoreMVarstaticDTO, String>(properties.updated_by(), 150, "Update Oleh");
		ColumnConfig<CoreMVarstaticDTO, String> varstat_desc = new ColumnConfig<CoreMVarstaticDTO, String>(properties.varstat_desc(), 350, "Deskripsi");
		ColumnConfig<CoreMVarstaticDTO, String> varstat_name = new ColumnConfig<CoreMVarstaticDTO, String>(properties.varstat_name(), 250, "Nilai Statis");
		ColumnConfig<CoreMVarstaticDTO, Integer> varstat_seq = new ColumnConfig<CoreMVarstaticDTO, Integer>(properties.varstat_seq(), 80, "Urutan");
		ColumnConfig<CoreMVarstaticDTO, String> varstat_group = new ColumnConfig<CoreMVarstaticDTO, String>(properties.varstat_group(), 200, "Grup");
		//ColumnConfig<CoreMVarstaticDTO, String> varstat_parentid = new ColumnConfig<CoreMVarstaticDTO, String>(properties.varstat_parentid(), 150, "Id Parent");
		//ColumnConfig<CoreMVarstaticDTO, String> varstat_parentname = new ColumnConfig<CoreMVarstaticDTO, String>(properties.varstat_parentid(), 150, "Nama Parent");
		ColumnConfig<CoreMVarstaticDTO, String> varstat_icon = new ColumnConfig<CoreMVarstaticDTO, String>(properties.varstat_icon(), 250, "Icon");
		ColumnConfig<CoreMVarstaticDTO, Integer> varstat_lock = new ColumnConfig<CoreMVarstaticDTO, Integer>(properties.varstat_lock(), 100, "ReadOnly");
		ColumnConfig<CoreMVarstaticDTO, Integer> varstat_deleteable = new ColumnConfig<CoreMVarstaticDTO, Integer>(properties.varstat_deleteable(), 100, "Deleteable");
		ColumnConfig<CoreMVarstaticDTO, Date> varstat_activedate = new ColumnConfig<CoreMVarstaticDTO, Date>(properties.varstat_activedate(), 120, "Tgl Mulai");
		ColumnConfig<CoreMVarstaticDTO, Date> varstat_expiredate = new ColumnConfig<CoreMVarstaticDTO, Date>(properties.varstat_expiredate(), 120, "Tgl Berakhir");
		created_at.setCell(new DateCell(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));
		updated_at.setCell(new DateCell(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));
		varstat_activedate.setCell(new DateCell(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));
		varstat_expiredate.setCell(new DateCell(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));

		/* Step 5 : Buat View Column */
		List<ColumnConfig<CoreMVarstaticDTO, ?>> columns = new ArrayList<ColumnConfig<CoreMVarstaticDTO, ?>>();
		columns.add(selectionModel.getColumn());
		columns.add(varstat_name);
		columns.add(varstat_group);
		columns.add(varstat_seq);
		//columns.add(varstat_parentid);
		//columns.add(varstat_parentname);
		columns.add(varstat_lock);
		columns.add(varstat_deleteable);
		columns.add(varstat_activedate);
		columns.add(varstat_expiredate);
		columns.add(varstat_desc);
		columns.add(varstat_icon);

		/* Step 6 : Buat Column Model */
		ColumnModel<CoreMVarstaticDTO> cm = new ColumnModel<CoreMVarstaticDTO>(columns);

		/* Step 7 : Buat Store */
		ListStore<CoreMVarstaticDTO> store = new ListStore<CoreMVarstaticDTO>(properties.varstat_id());
		//store.addAll(TestData.getStocks());

		/* Step 8 : Buat Grid */
		Grid<CoreMVarstaticDTO> grid = new Grid<CoreMVarstaticDTO>(store, cm);
		grid.setSelectionModel(selectionModel);
		grid.setColumnReordering(true);
		grid.setAllowTextSelection(true);
		grid.setLoadMask(true);
		grid.setBorders(false);
		grid.setColumnReordering(true);
		grid.getView().setStripeRows(true);
		grid.getView().setColumnLines(true);

		return grid;
	}

	/***********************************
	 * SETTER GETTER
	 ***********************************/
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
