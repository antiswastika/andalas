package com.wd.andalas.client.frontend.views.thos.profil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.IdentityValueProvider;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.client.loader.RpcProxy;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.loader.DataProxy;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.RefreshEvent;
import com.sencha.gxt.widget.core.client.grid.CheckBoxSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.RowNumberer;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;
import com.wd.andalas.client.backend.services.core.CoreMVarstaticService;
import com.wd.andalas.client.backend.services.core.CoreMVarstaticServiceAsync;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTO;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTOProperties;

public class ListThosProfil implements IsWidget {

	/********** Inisiasi **********/
	private ContentPanel list;
	private BorderLayoutData listData = new BorderLayoutData();
	private String tabHeader = "XXXXX";
	private CoreMVarstaticDTOProperties properties = GWT.create(CoreMVarstaticDTOProperties.class);
	private CoreMVarstaticServiceAsync service = (CoreMVarstaticServiceAsync) GWT.create(CoreMVarstaticService.class);
	ColumnModel<CoreMVarstaticDTO> cm;
	private VerticalLayoutContainer vlc;
	private Grid<CoreMVarstaticDTO> grid;
	private PagingToolBar toolbar;

	/********** Main Methods **********/
	@Override
	public Widget asWidget() {
		if (list == null) {
			list = new ContentPanel();
			list.setId("ListThosProfilID");
			list.setBodyStyle("background:transparent; border:0");
			list.setHeaderVisible(true);
			list.setHeading(tabHeader);
			listData.setMargins(new Margins(0, 0, 0, 0));
			list.setLayoutData(listData);

			vlc = doCreateVerticalLayoutContainer();

			doCreateGrid();

			list.add(vlc);
		}
		return list;
	}

	/********** Custom Methods **********/
	private VerticalLayoutContainer doCreateVerticalLayoutContainer() {
		vlc = new VerticalLayoutContainer();
		return vlc;
	}

	@SuppressWarnings("unused")
	private void doCreateGrid() {
		/* Step 1 : Buat Identity Model */
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
		RowNumberer<CoreMVarstaticDTO> numbererColumn = new RowNumberer<CoreMVarstaticDTO>();
		ColumnConfig<CoreMVarstaticDTO, Date> created_at = new ColumnConfig<CoreMVarstaticDTO, Date>(properties.created_at(), 100, "Tgl Input");
		ColumnConfig<CoreMVarstaticDTO, String> created_by = new ColumnConfig<CoreMVarstaticDTO, String>(properties.created_by(), 150, "Input Oleh");
		ColumnConfig<CoreMVarstaticDTO, Date> updated_at = new ColumnConfig<CoreMVarstaticDTO, Date>(properties.updated_at(), 100, "Tgl Update");
		ColumnConfig<CoreMVarstaticDTO, String> updated_by = new ColumnConfig<CoreMVarstaticDTO, String>(properties.updated_by(), 150, "Update Oleh");
		ColumnConfig<CoreMVarstaticDTO, String> varstat_desc = new ColumnConfig<CoreMVarstaticDTO, String>(properties.varstat_desc(), 350, "Deskripsi");
		ColumnConfig<CoreMVarstaticDTO, String> varstat_name = new ColumnConfig<CoreMVarstaticDTO, String>(properties.varstat_name(), 250, "Nilai Statis");
		ColumnConfig<CoreMVarstaticDTO, Integer> varstat_seq = new ColumnConfig<CoreMVarstaticDTO, Integer>(properties.varstat_seq(), 80, "Urutan");
		ColumnConfig<CoreMVarstaticDTO, String> varstat_group = new ColumnConfig<CoreMVarstaticDTO, String>(properties.varstat_group(), 200, "Grup");
		ColumnConfig<CoreMVarstaticDTO, String> varstat_parentid = new ColumnConfig<CoreMVarstaticDTO, String>(properties.varstat_parentid(), 150, "Id Parent");
		ColumnConfig<CoreMVarstaticDTO, String> varstat_parentname = new ColumnConfig<CoreMVarstaticDTO, String>(properties.varstat_parentid(), 150, "Nama Parent");
		ColumnConfig<CoreMVarstaticDTO, String> varstat_icon = new ColumnConfig<CoreMVarstaticDTO, String>(properties.varstat_icon(), 250, "Icon");
		ColumnConfig<CoreMVarstaticDTO, Byte> varstat_lock = new ColumnConfig<CoreMVarstaticDTO, Byte>(properties.varstat_lock(), 100, "ReadOnly");
		ColumnConfig<CoreMVarstaticDTO, Byte> varstat_deleteable = new ColumnConfig<CoreMVarstaticDTO, Byte>(properties.varstat_deleteable(), 100, "Deleteable");
		ColumnConfig<CoreMVarstaticDTO, Date> varstat_activedate = new ColumnConfig<CoreMVarstaticDTO, Date>(properties.varstat_activedate(), 120, "Tgl Mulai");
		ColumnConfig<CoreMVarstaticDTO, Date> varstat_expiredate = new ColumnConfig<CoreMVarstaticDTO, Date>(properties.varstat_expiredate(), 120, "Tgl Berakhir");

		/* Step 4 : Buat Format Semua Column */
		created_at.setCell(new DateCell(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));
		updated_at.setCell(new DateCell(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));
		varstat_activedate.setCell(new DateCell(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));
		varstat_expiredate.setCell(new DateCell(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));

		/* Step 5 : Buat View Urutan Column */
		List<ColumnConfig<CoreMVarstaticDTO, ?>> columns = new ArrayList<ColumnConfig<CoreMVarstaticDTO, ?>>();
		columns.add(selectionModel.getColumn());
		columns.add(numbererColumn);
		columns.add(varstat_name);
		columns.add(varstat_group);
		columns.add(varstat_seq);
		columns.add(varstat_parentid);
		columns.add(varstat_parentname);
		columns.add(varstat_lock);
		columns.add(varstat_deleteable);
		columns.add(varstat_activedate);
		columns.add(varstat_expiredate);
		columns.add(varstat_desc);
		columns.add(varstat_icon);

		/* Step 6 : Buat Column Model */
		cm = new ColumnModel<CoreMVarstaticDTO>(columns);

		/* Step 7 : Buat Store */
		ListStore<CoreMVarstaticDTO> store = new ListStore<CoreMVarstaticDTO>(properties.varstat_id());

		/* Step 8 : Buat RpcProxy */
		DataProxy<PagingLoadConfig, PagingLoadResult<CoreMVarstaticDTO>> dataProxy = new RpcProxy<PagingLoadConfig, PagingLoadResult<CoreMVarstaticDTO>>() {
			@Override
			public void load(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<CoreMVarstaticDTO>> callback) {
				service.getAllPaged(loadConfig, callback);
			}
		};

		/* Step 9 : Buat pagingLoader */
		final PagingLoader<PagingLoadConfig, PagingLoadResult<CoreMVarstaticDTO>> pagingLoader = new PagingLoader<PagingLoadConfig, PagingLoadResult<CoreMVarstaticDTO>>(dataProxy);
		pagingLoader.setRemoteSort(true);
		pagingLoader.addLoadHandler(new LoadResultListStoreBinding<PagingLoadConfig, CoreMVarstaticDTO, PagingLoadResult<CoreMVarstaticDTO>>(store));
		
		/* Step 10 : Buat Definisi PagingToolbar */
		toolbar = new PagingToolBar(10);
		toolbar.bind(pagingLoader);
		toolbar.setBorders(false);

		/* Step 11 : Buat Generate Grid */
		grid = new Grid<CoreMVarstaticDTO>(store, cm) {
			@Override
			protected void onAfterFirstAttach() {
				super.onAfterFirstAttach();
				Scheduler.get().scheduleDeferred(new ScheduledCommand() {
					@Override
					public void execute() {
						pagingLoader.load();
					}
				});
			}
		};

		/* Step 12 : Buat set Parameter Grid */
		grid.setSelectionModel(selectionModel);
		grid.setColumnReordering(true);
		grid.setAllowTextSelection(true);
		grid.setLoadMask(true);
		grid.setBorders(false);
		grid.setColumnReordering(true);
		grid.getView().setStripeRows(true);
		grid.getView().setColumnLines(true);
		grid.setLoader(pagingLoader);

		/* Step 13 : Gabungkan VLC, GRID, dan PAGINGTOOLBAR */
		vlc.add(grid, new VerticalLayoutData(1, 1));
		vlc.add(toolbar);
	}

	/********** Setter Getter **********/
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
