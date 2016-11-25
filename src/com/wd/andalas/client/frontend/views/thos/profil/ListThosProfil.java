package com.wd.andalas.client.frontend.views.thos.profil;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.ImageCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.Window;
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
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.grid.CheckBoxSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.RowNumberer;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;
import com.wd.andalas.client.backend.services.thos.ThosProfilService;
import com.wd.andalas.client.backend.services.thos.ThosProfilServiceAsync;
import com.wd.andalas.client.frontend.models.thos.ThosProfilDTO;
import com.wd.andalas.client.frontend.models.thos.ThosProfilDTOProperties;
import com.wd.andalas.global.GlobalToolbarList;

public class ListThosProfil implements IsWidget {

	/********** Inisiasi **********/
	private ContentPanel list;
	private BorderLayoutData listData = new BorderLayoutData();
	private String tabHeader = "XXXXX";
	private ThosProfilDTOProperties properties = GWT.create(ThosProfilDTOProperties.class);
	private ThosProfilServiceAsync service = (ThosProfilServiceAsync) GWT.create(ThosProfilService.class);
	private ColumnModel<ThosProfilDTO> cm;
	private VerticalLayoutContainer vlc;
	private ToolBar upToolbar;
	private Grid<ThosProfilDTO> grid;
	private PagingLoader<PagingLoadConfig, PagingLoadResult<ThosProfilDTO>> pagingLoader;
	private PagingToolBar pagingToolbar;
	private int pageLimit = 30;

	/********** Main Methods **********/
	@Override
	public Widget asWidget() {
		if (list == null) {
			list = new ContentPanel();
			list.setId("ListThosProfilID");
			list.setBodyStyle("background:transparent; border:0");
			list.setHeaderVisible(true);
			list.setHeading(tabHeader);
			list.setAllowTextSelection(false);
			listData.setMargins(new Margins(0, 0, 0, 0));
			list.setLayoutData(listData);

			vlc = doCreateVerticalLayoutContainer();
			upToolbar = doCreateUpToolbar();
			grid = doCreateGrid();
			pagingToolbar = doCreatePagingToolbar(pageLimit, pagingLoader);

			vlc.add(upToolbar);
			vlc.add(grid, new VerticalLayoutData(1, 1));
			vlc.add(pagingToolbar);

			list.add(vlc);
		}
		return list;
	}

	/********** Custom Methods **********/
	private VerticalLayoutContainer doCreateVerticalLayoutContainer() {
		vlc = new VerticalLayoutContainer();
		return vlc;
	}

	private ToolBar doCreateUpToolbar() {
		ToolBar upToolbar = new GlobalToolbarList().createUpToolBar(doInsert(), doDelete(), doRefresh(), doPrint(), doExport(), doSearch(), doWindow());
		return upToolbar;
	}

	@SuppressWarnings("unused")
	private Grid<ThosProfilDTO> doCreateGrid() {
		/* Step 1 : Buat Identity Model */
		IdentityValueProvider<ThosProfilDTO> identity = new IdentityValueProvider<ThosProfilDTO>();

		/* Step 2 : Buat Selection Model */
		final CheckBoxSelectionModel<ThosProfilDTO> selectionModel = new CheckBoxSelectionModel<ThosProfilDTO>(identity) {
			@Override
			protected void onRefresh(RefreshEvent event) {
				if (isSelectAllChecked()) {
					selectAll();
				}
				super.onRefresh(event);
			}
		};

		/* Step 3 : Buat Definisi Semua Column */
		RowNumberer<ThosProfilDTO> numbererColumn = new RowNumberer<ThosProfilDTO>();
		numbererColumn.setHeader("No");
		numbererColumn.setWidth(40);
		ColumnConfig<ThosProfilDTO, String> imageEditColumn = new ColumnConfig<ThosProfilDTO, String>(properties.profil_nama(), 40, "");
		imageEditColumn.setResizable(false);
		ColumnConfig<ThosProfilDTO, Date> created_at = new ColumnConfig<ThosProfilDTO, Date>(properties.created_at(), 100, "Tgl Input");
		ColumnConfig<ThosProfilDTO, String> created_by = new ColumnConfig<ThosProfilDTO, String>(properties.created_by(), 150, "Input Oleh");
		ColumnConfig<ThosProfilDTO, Date> updated_at = new ColumnConfig<ThosProfilDTO, Date>(properties.updated_at(), 100, "Tgl Update");
		ColumnConfig<ThosProfilDTO, String> updated_by = new ColumnConfig<ThosProfilDTO, String>(properties.updated_by(), 150, "Update Oleh");
		ColumnConfig<ThosProfilDTO, String> profil_desc = new ColumnConfig<ThosProfilDTO, String>(properties.profil_desc(), 350, "Deskripsi");
		ColumnConfig<ThosProfilDTO, String> profil_nip = new ColumnConfig<ThosProfilDTO, String>(properties.profil_nip(), 80, "NIP");
		ColumnConfig<ThosProfilDTO, String> profil_nama = new ColumnConfig<ThosProfilDTO, String>(properties.profil_nama(), 150, "Nama");
		ColumnConfig<ThosProfilDTO, String> profil_nama_panggilan = new ColumnConfig<ThosProfilDTO, String>(properties.profil_nama_panggilan(), 150, "Panggilan");
		ColumnConfig<ThosProfilDTO, Date> profil_tgl_lahir = new ColumnConfig<ThosProfilDTO, Date>(properties.profil_tgl_lahir(), 100, "Tgl Lahir");
		ColumnConfig<ThosProfilDTO, String> profil_tmp_lahir = new ColumnConfig<ThosProfilDTO, String>(properties.profil_tmp_lahir(), 150, "Tempat Lahir");
		ColumnConfig<ThosProfilDTO, Byte> profil_jenis_kelamin = new ColumnConfig<ThosProfilDTO, Byte>(properties.profil_jenis_kelamin(), 80, "Jenis");
		ColumnConfig<ThosProfilDTO, String> profil_agama = new ColumnConfig<ThosProfilDTO, String>(properties.profil_agama(), 80, "Agama");
		ColumnConfig<ThosProfilDTO, String> profil_no_ktp = new ColumnConfig<ThosProfilDTO, String>(properties.profil_no_ktp(), 100, "No.KTP");
		ColumnConfig<ThosProfilDTO, String> profil_no_npwp = new ColumnConfig<ThosProfilDTO, String>(properties.profil_no_npwp(), 100, "No.NPWP");
		ColumnConfig<ThosProfilDTO, String> profil_nama_bank = new ColumnConfig<ThosProfilDTO, String>(properties.profil_nama_bank(), 100, "Nama Bank");
		ColumnConfig<ThosProfilDTO, String> profil_no_rek = new ColumnConfig<ThosProfilDTO, String>(properties.profil_no_rek(), 100, "No.Rekening");
		ColumnConfig<ThosProfilDTO, Byte> profil_status_menikah = new ColumnConfig<ThosProfilDTO, Byte>(properties.profil_status_menikah(), 80, "Menikah");
		ColumnConfig<ThosProfilDTO, String> profil_alamat = new ColumnConfig<ThosProfilDTO, String>(properties.profil_alamat(), 250, "Alamat");
		ColumnConfig<ThosProfilDTO, String> profil_no_telp = new ColumnConfig<ThosProfilDTO, String>(properties.profil_no_telp(), 100, "No.Telepon");
		ColumnConfig<ThosProfilDTO, String> profil_jabatan = new ColumnConfig<ThosProfilDTO, String>(properties.profil_jabatan(), 250, "Jabatan");
		ColumnConfig<ThosProfilDTO, String> profil_formasi = new ColumnConfig<ThosProfilDTO, String>(properties.profil_formasi(), 250, "Formasi");
		ColumnConfig<ThosProfilDTO, String> profil_nama_kdarurat = new ColumnConfig<ThosProfilDTO, String>(properties.profil_nama_kdarurat(), 150, "Nama Kontak Darurat");
		ColumnConfig<ThosProfilDTO, String> profil_no_telp_kdarurat = new ColumnConfig<ThosProfilDTO, String>(properties.profil_no_telp_kdarurat(), 100, "No.Telepon Kontak Darurat");
		ColumnConfig<ThosProfilDTO, String> profil_alamat_kdarurat = new ColumnConfig<ThosProfilDTO, String>(properties.profil_alamat_kdarurat(), 250, "Alamat Kontak Darurat");
		ColumnConfig<ThosProfilDTO, Byte> profil_lock = new ColumnConfig<ThosProfilDTO, Byte>(properties.profil_lock(), 100, "ReadOnly");
		ColumnConfig<ThosProfilDTO, Byte> profil_deleteable = new ColumnConfig<ThosProfilDTO, Byte>(properties.profil_deleteable(), 100, "Deleteable");
		ColumnConfig<ThosProfilDTO, Date> profil_activedate = new ColumnConfig<ThosProfilDTO, Date>(properties.profil_activedate(), 120, "Tgl Mulai");
		ColumnConfig<ThosProfilDTO, Date> profil_expiredate = new ColumnConfig<ThosProfilDTO, Date>(properties.profil_expiredate(), 120, "Tgl Berakhir");

		/* Step 4 : Buat View Urutan Column */
		List<ColumnConfig<ThosProfilDTO, ?>> columns = new ArrayList<ColumnConfig<ThosProfilDTO, ?>>();
		columns.add(numbererColumn);
		columns.add(selectionModel.getColumn());
		columns.add(imageEditColumn);
		columns.add(profil_nip);
		columns.add(profil_nama);
		columns.add(profil_tgl_lahir);
		columns.add(profil_jenis_kelamin);
		columns.add(profil_agama);
		columns.add(profil_no_ktp);
		columns.add(profil_status_menikah);
		columns.add(profil_alamat);
		columns.add(profil_jabatan);
		columns.add(profil_nama_kdarurat);
		columns.add(profil_alamat_kdarurat);
		columns.add(profil_lock);
		columns.add(profil_deleteable);
		columns.add(profil_activedate);
		columns.add(profil_expiredate);
		columns.add(profil_desc);

		/* Step 5 : Buat Column Model */
		cm = new ColumnModel<ThosProfilDTO>(columns);

		/* Step 6 : Buat Store */
		ListStore<ThosProfilDTO> store = new ListStore<ThosProfilDTO>(properties.profil_id());

		/* Step 7 : Buat RpcProxy */
		DataProxy<PagingLoadConfig, PagingLoadResult<ThosProfilDTO>> dataProxy = new RpcProxy<PagingLoadConfig, PagingLoadResult<ThosProfilDTO>>() {
			@Override
			public void load(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<ThosProfilDTO>> callback) {
				service.getAllPaged(loadConfig, callback);
			}
		};

		/* Step 8 : Buat pagingLoader */
		pagingLoader = new PagingLoader<PagingLoadConfig, PagingLoadResult<ThosProfilDTO>>(dataProxy);
		pagingLoader.setRemoteSort(true);
		pagingLoader.setLimit(pageLimit);
		pagingLoader.addLoadHandler(new LoadResultListStoreBinding<PagingLoadConfig, ThosProfilDTO, PagingLoadResult<ThosProfilDTO>>(store));

		/* Step 9 : Buat Format Semua Column */
		created_at.setCell(new DateCell(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));
		updated_at.setCell(new DateCell(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));
		profil_activedate.setCell(new DateCell(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));
		profil_expiredate.setCell(new DateCell(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));
		numbererColumn.setCell(new AbstractCell<ThosProfilDTO>() {
			@Override
			public void render(Context context, ThosProfilDTO value, SafeHtmlBuilder sb) {
				Integer urutan = pagingLoader.getOffset() + context.getIndex() + 1;
				sb.appendHtmlConstant(Integer.toString(urutan));
			}
		});
		numbererColumn.setCellClassName("customTextCell");
		imageEditColumn.setCell(new ImageCell() {
			@Override
			public void render(Context context, String value, SafeHtmlBuilder sb) {
				sb.appendHtmlConstant("<img src='images\\icon\\16x16\\edit.png' style='cursor: pointer'/> ");
			}
			@Override
			public Set<String> getConsumedEvents() {
				Set<String> events = new HashSet<String>();
				events.add("click");
				return events;
			}
			@Override
			public void onBrowserEvent(Context context, Element parent, String value, NativeEvent event, ValueUpdater<String> valueUpdater) {
				super.onBrowserEvent(context, parent, value, event, valueUpdater);
				if (parent.getFirstChildElement().isOrHasChild(Element.as(event.getEventTarget()))) {
					doCreateForm(grid.getSelectionModel().getSelectedItem().getProfil_id());
				}
			}
		});
		imageEditColumn.setCellClassName("customTextCell");

		/* Step 10 : Buat Generate Grid */
		grid = new Grid<ThosProfilDTO>(store, cm) {
			@Override
			protected void onAfterFirstAttach() {
				super.onAfterFirstAttach();
				Scheduler.get().scheduleDeferred(new ScheduledCommand() {
					@Override
					public void execute() {
						// Begitu di-attach langsung tampilkan page pertama.
						pagingLoader.load(0, pageLimit);
					}
				});
			}
		};

		/* Step 11 : Buat set Parameter Grid */
		numbererColumn.initPlugin(grid);
		grid.setSelectionModel(selectionModel);
		grid.setColumnReordering(true);
		grid.setAllowTextSelection(true);
		grid.setLoadMask(true);
		grid.setBorders(false);
		grid.setColumnReordering(true);
		grid.getView().setStripeRows(true);
		grid.getView().setColumnLines(true);
		grid.setLoader(pagingLoader);

		return grid;
	}

	private PagingToolBar doCreatePagingToolbar(int pageLimit, PagingLoader<PagingLoadConfig, PagingLoadResult<ThosProfilDTO>> pagingLoader) {
		pagingToolbar = new PagingToolBar(pageLimit);
		pagingToolbar.bind(pagingLoader);
		pagingToolbar.setBorders(false);
		return pagingToolbar;
	}

	private void doCreateForm(String idNya) {
		Window.alert(idNya);
	}

	/********** Event Handler dan Listener **********/
	private SelectHandler doInsert() {
		return new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				doCreateForm("INSERT");
			}
		};
	}

	private SelectHandler doDelete() {
		return new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				doCreateForm("DELETE");
			}
		};
	}

	private SelectHandler doRefresh() {
		return new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				pagingToolbar.refresh();
			}
		};
	}

	private SelectHandler doPrint() {
		return new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				doCreateForm("PRINT");
			}
		};
	}

	private SelectHandler doExport() {
		return new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				doCreateForm("EXPORT");
			}
		};
	}

	private SelectHandler doSearch() {
		return new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				doCreateForm("SEARCH");
			}
		};
	}

	private SelectHandler doWindow() {
		return new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				doCreateForm("WINDOW");
			}
		};
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
