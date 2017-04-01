package com.wd.andalas.client.frontend.views.core.mvarstatic;

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
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.IdentityValueProvider;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.client.loader.RpcProxy;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.Dialog.PredefinedButton;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent.DialogHideHandler;
import com.sencha.gxt.widget.core.client.event.HeaderClickEvent;
import com.sencha.gxt.widget.core.client.event.HeaderClickEvent.HeaderClickHandler;
import com.sencha.gxt.widget.core.client.event.HideEvent;
import com.sencha.gxt.widget.core.client.event.HideEvent.HideHandler;
import com.sencha.gxt.widget.core.client.event.RefreshEvent;
import com.sencha.gxt.widget.core.client.event.RowClickEvent;
import com.sencha.gxt.widget.core.client.event.RowClickEvent.RowClickHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.grid.CheckBoxSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.RowNumberer;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;
import com.wd.andalas.client.backend.services.core.CoreMVarstaticService;
import com.wd.andalas.client.backend.services.core.CoreMVarstaticServiceAsync;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTO;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTOProperties;
import com.wd.andalas.global.GlobalToolbarList;
import com.wd.andalas.global.views.FormExportData;

public class ListMVarStatic implements IsWidget {

	/********** Inisiasi **********/
	private ContentPanel list;
	private BorderLayoutData listData = new BorderLayoutData();
	private String tabHeader = "XXXXX";
	private CoreMVarstaticDTOProperties properties = GWT.create(CoreMVarstaticDTOProperties.class);
	private CoreMVarstaticServiceAsync service = (CoreMVarstaticServiceAsync) GWT.create(CoreMVarstaticService.class);
	private ColumnModel<CoreMVarstaticDTO> cm;
	private VerticalLayoutContainer vlc;
	private ToolBar upToolbar;
	private Grid<CoreMVarstaticDTO> grid;
	private PagingLoader<PagingLoadConfig, PagingLoadResult<CoreMVarstaticDTO>> pagingLoader;
	private PagingToolBar pagingToolbar;
	private int pageLimit = 30;

	/********** Main Methods **********/
	@Override
	public Widget asWidget() {
		if (list == null) {
			list = new ContentPanel();
			list.setId("ListMVarStaticID");
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
	private Grid<CoreMVarstaticDTO> doCreateGrid() {
		/* Step 1 : Buat Identity Model */
		IdentityValueProvider<CoreMVarstaticDTO> identity = new IdentityValueProvider<CoreMVarstaticDTO>();

		/* Step 2 : Buat Selection Model */
		final CheckBoxSelectionModel<CoreMVarstaticDTO> selectionModel = new CheckBoxSelectionModel<CoreMVarstaticDTO>(identity) {
			@Override
			protected void onRefresh(RefreshEvent event) {
				if (isSelectAllChecked()) {
					selectAll();
				} else {
					deselectAll();
				}
				super.onRefresh(event);
			}
		};

		/* Step 3 : Buat Definisi Semua Column */
		RowNumberer<CoreMVarstaticDTO> numbererColumn = new RowNumberer<CoreMVarstaticDTO>();
		numbererColumn.setHeader("No");
		numbererColumn.setWidth(40);
		ColumnConfig<CoreMVarstaticDTO, String> imageEditColumn = new ColumnConfig<CoreMVarstaticDTO, String>(properties.varstat_name(), 40, "");
		imageEditColumn.setResizable(false);
		ColumnConfig<CoreMVarstaticDTO, Date> created_at = new ColumnConfig<CoreMVarstaticDTO, Date>(properties.created_at(), 100, "Tgl Input");
		ColumnConfig<CoreMVarstaticDTO, String> created_by = new ColumnConfig<CoreMVarstaticDTO, String>(properties.created_by(), 150, "Input Oleh");
		ColumnConfig<CoreMVarstaticDTO, Date> updated_at = new ColumnConfig<CoreMVarstaticDTO, Date>(properties.updated_at(), 100, "Tgl Update");
		ColumnConfig<CoreMVarstaticDTO, String> updated_by = new ColumnConfig<CoreMVarstaticDTO, String>(properties.updated_by(), 150, "Update Oleh");
		ColumnConfig<CoreMVarstaticDTO, String> varstat_desc = new ColumnConfig<CoreMVarstaticDTO, String>(properties.varstat_desc(), 350, "Deskripsi");
		ColumnConfig<CoreMVarstaticDTO, String> varstat_name = new ColumnConfig<CoreMVarstaticDTO, String>(properties.varstat_name(), 250, "Nilai Statis");
		ColumnConfig<CoreMVarstaticDTO, Integer> varstat_seq = new ColumnConfig<CoreMVarstaticDTO, Integer>(properties.varstat_seq(), 80, "Urutan");
		ColumnConfig<CoreMVarstaticDTO, String> varstat_group = new ColumnConfig<CoreMVarstaticDTO, String>(properties.varstat_group(), 200, "Grup");
		ColumnConfig<CoreMVarstaticDTO, String> varstat_parentid = new ColumnConfig<CoreMVarstaticDTO, String>(properties.varstat_parentid(), 150, "Id Parent");
		ColumnConfig<CoreMVarstaticDTO, String> varstat_icon = new ColumnConfig<CoreMVarstaticDTO, String>(properties.varstat_icon(), 250, "Icon");
		ColumnConfig<CoreMVarstaticDTO, Byte> varstat_lock = new ColumnConfig<CoreMVarstaticDTO, Byte>(properties.varstat_lock(), 100, "Kunci");
		ColumnConfig<CoreMVarstaticDTO, Byte> varstat_deleteable = new ColumnConfig<CoreMVarstaticDTO, Byte>(properties.varstat_deleteable(), 100, "Bisa Dihapus");
		ColumnConfig<CoreMVarstaticDTO, Date> varstat_activedate = new ColumnConfig<CoreMVarstaticDTO, Date>(properties.varstat_activedate(), 120, "Tgl Mulai");
		ColumnConfig<CoreMVarstaticDTO, Date> varstat_expiredate = new ColumnConfig<CoreMVarstaticDTO, Date>(properties.varstat_expiredate(), 120, "Tgl Berakhir");

		/* Step 4 : Buat View Urutan Column */
		List<ColumnConfig<CoreMVarstaticDTO, ?>> columns = new ArrayList<ColumnConfig<CoreMVarstaticDTO, ?>>();
		columns.add(numbererColumn);
		columns.add(selectionModel.getColumn());
		columns.add(imageEditColumn);
		columns.add(varstat_name);
		columns.add(varstat_group);
		columns.add(varstat_seq);
		columns.add(varstat_parentid);
		columns.add(varstat_lock);
		columns.add(varstat_deleteable);
		columns.add(varstat_activedate);
		columns.add(varstat_expiredate);
		columns.add(varstat_desc);
		columns.add(varstat_icon);

		/* Step 5 : Buat Column Model */
		cm = new ColumnModel<CoreMVarstaticDTO>(columns);

		/* Step 6 : Buat Store */
		ListStore<CoreMVarstaticDTO> store = new ListStore<CoreMVarstaticDTO>(properties.varstat_id());

		/* Step 7 : Buat RpcProxy */
		RpcProxy<PagingLoadConfig, PagingLoadResult<CoreMVarstaticDTO>> dataProxy = new RpcProxy<PagingLoadConfig, PagingLoadResult<CoreMVarstaticDTO>>() {
			@Override
			public void load(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<CoreMVarstaticDTO>> callback) {
				service.getAllPaged(loadConfig, callback);
			}
		};

		/* Step 8 : Buat pagingLoader */
		pagingLoader = new PagingLoader<PagingLoadConfig, PagingLoadResult<CoreMVarstaticDTO>>(dataProxy);
		pagingLoader.setRemoteSort(true);
		pagingLoader.setLimit(pageLimit);
		pagingLoader.addLoadHandler(new LoadResultListStoreBinding<PagingLoadConfig, CoreMVarstaticDTO, PagingLoadResult<CoreMVarstaticDTO>>(store));
		pagingLoader.setReuseLoadConfig(true);

		/* Step 9 : Buat Format Semua Column */
		created_at.setCell(new DateCell(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));
		updated_at.setCell(new DateCell(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));
		varstat_activedate.setCell(new DateCell(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));
		varstat_expiredate.setCell(new DateCell(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));
		numbererColumn.setCell(new AbstractCell<CoreMVarstaticDTO>() {
			@Override
			public void render(Context context, CoreMVarstaticDTO value, SafeHtmlBuilder sb) {
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
					doCreateForm(grid.getSelectionModel().getSelectedItem().getVarstat_id(), grid.getSelectionModel().getSelectedItem());
				}
			}
		});
		imageEditColumn.setCellClassName("customTextCell");

		/* Step 10 : Buat Generate Grid */
		grid = new Grid<CoreMVarstaticDTO>(store, cm) {
			@Override
			protected void onAfterFirstAttach() {
				super.onAfterFirstAttach();
				Scheduler.get().scheduleDeferred(new ScheduledCommand() {
					@Override
					public void execute() {
						doRefreshGrid();
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
		
		grid.addRowClickHandler(onRowClick());
		grid.addHeaderClickHandler(onHeaderClick());
		
		return grid;
	}

	private PagingToolBar doCreatePagingToolbar(int pageLimit, PagingLoader<PagingLoadConfig, PagingLoadResult<CoreMVarstaticDTO>> pagingLoader) {
		pagingToolbar = new PagingToolBar(pageLimit);
		pagingToolbar.bind(pagingLoader);
		pagingToolbar.setBorders(false);
		return pagingToolbar;
	}

	private void doCreateForm(String idNya, CoreMVarstaticDTO entity) {
		Window newWindow = new Window();
		FormMVarStatic formTpl = new FormMVarStatic();
		String judulForm = formTpl.getFormTitle();
		formTpl.setClassReferer(this);
		formTpl.setParentWindow(newWindow);

		if (idNya != "" && entity != null) {
			formTpl.setEntity(entity);
			judulForm = judulForm + " (Ubah)";
		} else {
			formTpl.setEntity(new CoreMVarstaticDTO());
			judulForm = judulForm + " (Tambah)";
		}

		newWindow.setModal(true);
		newWindow.setSize("700", "430");
		newWindow.setResizable(false);
		newWindow.setClosable(false);
		newWindow.setAllowTextSelection(false);
		newWindow.setOnEsc(false);
		newWindow.setHeading(judulForm);
		
		newWindow.add(formTpl.asWidget());

		newWindow.show();
	}
	
	private void doStartDelete() {
		final List<CoreMVarstaticDTO> itemsToDelete = grid.getSelectionModel().getSelectedItems();
		service.deleteMany(itemsToDelete, new AsyncCallback<Boolean>() {
			@Override
			public void onSuccess(Boolean result) {
				for (CoreMVarstaticDTO item : itemsToDelete) {
					grid.getStore().remove(item);
				}
				doRefreshGrid();
			}
			@Override
			public void onFailure(Throwable caught) {
				//
			}
		});
	}
	
	private void doRefreshGrid() {
		pagingLoader.load(0, pageLimit);
	}
	
	private void doGetSetBtnDeleteActivities() {
		int selections = grid.getSelectionModel().getSelectedItems().size();
		TextButton btnDelete = (TextButton) upToolbar.getWidget(1);
		if (selections == 0) {
			btnDelete.setEnabled(false);
		} else {
			btnDelete.setEnabled(true);
		}
	}
	
	/********** Public Methods **********/	
	public void doPublicRefresh() {
		pagingToolbar.refresh();
	}

	/********** Event Handler dan Listener **********/
	private RowClickHandler onRowClick() {
		return new RowClickHandler() {
			@Override
			public void onRowClick(RowClickEvent event) {
				doGetSetBtnDeleteActivities();
			}
		};
	}
	
	private HeaderClickHandler onHeaderClick() {
		return new HeaderClickHandler() {
			@Override
			public void onHeaderClick(HeaderClickEvent event) {			
				doGetSetBtnDeleteActivities();
			}
		};
	}
	
	private SelectHandler doInsert() {
		return new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				doCreateForm("", null);
			}
		};
	}

	private SelectHandler doDelete() {
		return new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {	
				ConfirmMessageBox messageBox = new ConfirmMessageBox("Konfirmasi Hapus", "Apakah Anda sudah yakin akan menghapus data yang terpilih?");
				messageBox.setPredefinedButtons(PredefinedButton.YES, PredefinedButton.NO);
				messageBox.setIcon(MessageBox.ICONS.question());
				
			    messageBox.addDialogHideHandler(new DialogHideHandler() {
					@Override
					public void onDialogHide(DialogHideEvent event) {
						//Contoh
						//String message = Format.substitute("The '{0}' button was pressed", event.getHideButton());
					    //Info.display("MessageBox", message);
						
						switch (event.getHideButton()) {
							case YES:
								doStartDelete();
								break;
							case NO:
								break;
							default:
								break;
						}
					}
				});
			    messageBox.show();			
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
				//
			}
		};
	}

	private SelectHandler doExport() {
		return new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				Window newWindow = new Window();
				FormExportData formTpl = new FormExportData();
				String judulForm = formTpl.getFormTitle();
				formTpl.setClassReferer(this);
				formTpl.setParentWindow(newWindow);

				newWindow.setModal(true);
				newWindow.setSize("400", "160");
				newWindow.setResizable(false);
				newWindow.setClosable(false);
				newWindow.setAllowTextSelection(false);
				newWindow.setOnEsc(false);
				newWindow.setHeading(judulForm);
				
				newWindow.add(formTpl.asWidget());

				newWindow.show();
			}
		};
	}

	private SelectHandler doSearch() {
		return new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				//
			}
		};
	}

	private SelectHandler doWindow() {
		return new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				final Widget listWidget = list.getWidget(0);
				list.setHeaderVisible(false);
				upToolbar.getWidget(upToolbar.getWidgetCount()-1).setVisible(false);
				
				Window newWindow = new Window();
				newWindow.setMaximizable(true);
				newWindow.setHeading(list.getHeader().getHeading());
				newWindow.setModal(true);				
				newWindow.add(listWidget);				
				newWindow.addHideHandler(new HideHandler() {
					@Override
					public void onHide(HideEvent event) {
						list.setHeaderVisible(true);
						upToolbar.getWidget(upToolbar.getWidgetCount()-1).setVisible(true);
						list.add(listWidget);
						list.forceLayout();
					}					
				});
				newWindow.show();
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
