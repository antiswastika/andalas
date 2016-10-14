package com.wd.andalas.client.frontend.views.core.mvarstatic;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTO;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticProperties;

public class ListMVarStatic implements IsWidget {

	private ContentPanel list;
	private BorderLayoutData listData = new BorderLayoutData();
	private String tabHeader = "";
	private VerticalLayoutContainer vlc;

	/*********************************** MAIN CODE ***********************************/
	@Override
	public Widget asWidget() {
		if (list == null) {
			list = new ContentPanel();
			list.setId("regionSouthID");
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

	/*********************************** CUSTOM METHODS ***********************************/
	private VerticalLayoutContainer doCreateVerticalLayoutContainer() {
		vlc = new VerticalLayoutContainer();
		Grid<CoreMVarstaticDTO> grid = doCreateGrid();
		vlc.add(grid, new VerticalLayoutData(1, 1));

		return vlc;
	}

	private Grid<CoreMVarstaticDTO> doCreateGrid() {

		CoreMVarstaticProperties properties = GWT.create(CoreMVarstaticProperties.class);

		ListStore<CoreMVarstaticDTO> store = new ListStore<CoreMVarstaticDTO>(new ModelKeyProvider<CoreMVarstaticDTO>() {
			@Override
			public String getKey(CoreMVarstaticDTO item) {
				return "" + item.getVarstat_id();
			}
		});

		/*Defined Columns*/
		ColumnConfig<CoreMVarstaticDTO, String> forumColumn = new ColumnConfig<CoreMVarstaticDTO, String>(properties.forum(), 130, "Forum");
		ColumnConfig<CoreMVarstaticDTO, String> usernameColumn = new ColumnConfig<CoreMVarstaticDTO, String>(properties.username(), 100, "Username");
		ColumnConfig<CoreMVarstaticDTO, String> subjectColumn = new ColumnConfig<CoreMVarstaticDTO, String>(properties.subject(), 150, "Subject");
		ColumnConfig<CoreMVarstaticDTO> dateColumn = new ColumnConfig<CoreMVarstaticDTO, Date>(properties.date(), 100, "Date");
		dateColumn.setCell(new DateCell(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));

		List<ColumnConfig<CoreMVarstaticDTO, ?>> columns = new ArrayList<ColumnConfig<CoreMVarstaticDTO, ?>>();
		// The selection model provides the first column config
		columns.add(selectionModel.getColumn());
		columns.add(forumColumn);
		columns.add(usernameColumn);
		columns.add(subjectColumn);
		columns.add(dateColumn);

		ColumnModel<CoreMVarstaticDTO> cm = new ColumnModel<CoreMVarstaticDTO>(columns);

		Grid<CoreMVarstaticDTO> grid = new Grid<CoreMVarstaticDTO>(store, cm) {
			@Override
			protected void onAfterFirstAttach() {
				super.onAfterFirstAttach();
				Scheduler.get().scheduleDeferred(new ScheduledCommand() {
					@Override
					public void execute() {
						loader.load();
					}
				});
			}
		};
		grid.setSelectionModel(selectionModel);
		grid.getView().setAutoExpandColumn(subjectColumn);
		grid.setLoadMask(true);
		grid.setLoader(loader);
		grid.setColumnReordering(true);

		return grid;
	}



	/*********************************** SETTER GETTER ***********************************/
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
