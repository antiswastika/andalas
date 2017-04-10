package com.wd.andalas.client.frontend.views.core.mvarstatic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.Padding;
import com.sencha.gxt.data.client.loader.RpcProxy;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;
import com.wd.andalas.client.backend.services.core.CoreMVarstaticService;
import com.wd.andalas.client.backend.services.core.CoreMVarstaticServiceAsync;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTO;
import com.wd.andalas.global.GlobalToolbarList;
import com.wd.andalas.global.views.AnyComboModel;
import com.wd.andalas.resources.Resources;

public class FormSearchData extends VBoxLayoutContainer implements IsWidget {

	private CoreMVarstaticServiceAsync service = (CoreMVarstaticServiceAsync) GWT.create(CoreMVarstaticService.class);
	private PagingLoader<PagingLoadConfig, PagingLoadResult<CoreMVarstaticDTO>> pagingLoader;
	
	private VerticalLayoutContainer vlcMain;
	private HorizontalLayoutContainer hlcMain;
	private VerticalLayoutContainer vlcCol1, vlcCol2,vlcCol3;
	private Window parentWindow;

	final private String formTitle = "Cari Data";
	
	private Object classReferer = null;
	private Grid<CoreMVarstaticDTO> gridReferer = null;
	private PagingToolBar pagingToolbarReferer = null;
	private int gridPageLimit = 0;
	private HashMap<String, String> fieldValues = null;
	
	/********** Main Methods **********/
	@Override
	public Widget asWidget() {
		vlcMain = new VerticalLayoutContainer();
		vlcMain.add(doCreateForm(), new VerticalLayoutData(1, 1, new Margins(5)));
		vlcMain.add(doCreateDownToolbar());
		
		return vlcMain;
	}

	/********** Custom Methods **********/
	private HorizontalLayoutContainer doCreateForm() {
		hlcMain = new HorizontalLayoutContainer();
		Boolean debugShowBorders = false;
		int banyakComboBox = 6;

		//Buat Kolom 1
		//===========================================================
		vlcCol1 = new VerticalLayoutContainer();
		vlcCol1.setBorders(debugShowBorders);
		vlcCol2 = new VerticalLayoutContainer();
		vlcCol2.setBorders(debugShowBorders);
		vlcCol3 = new VerticalLayoutContainer();
		vlcCol3.setBorders(debugShowBorders);
		
		List<String> comboValues = new ArrayList<String>();
	
		for (int i=0; i<banyakComboBox; i++) {
			ComboBox<AnyComboModel> cmbField;
			cmbField = doCreateComboboxField(comboValues);
			cmbField.setEmptyText("- - -");
			cmbField.setEditable(false);
			cmbField.setTriggerAction(TriggerAction.ALL);			
			vlcCol1.add(new FieldLabel(cmbField, "Field " + (i+1)), new VerticalLayoutData(1, -1));
			
			ComboBox<AnyComboModel> cmbField2;
			cmbField2 = doCreateComboboxCondition();
			cmbField2.setEmptyText("- - -");
			cmbField2.setEditable(false);
			cmbField2.setTriggerAction(TriggerAction.ALL);	
			vlcCol2.add(new FieldLabel(cmbField2, ""), new VerticalLayoutData(1, -1));
			
			TextField textField = new TextField();
			vlcCol3.add(new FieldLabel(textField, ""), new VerticalLayoutData(1, -1));
		}
		
		Iterator<Widget> arrayOfChilds1 = vlcCol1.iterator();
		while (arrayOfChilds1.hasNext()) {
			Widget ch = arrayOfChilds1.next();
			if (ch instanceof FieldLabel) {
				((FieldLabel) ch).setLabelWidth(60);
				((FieldLabel) ch).setLabelSeparator("");
				((FieldLabel) ch).addStyleName("customFieldLabel");
			}
		}
		
		Iterator<Widget> arrayOfChilds2 = vlcCol2.iterator();
		while (arrayOfChilds2.hasNext()) {
			Widget ch = arrayOfChilds2.next();
			if (ch instanceof FieldLabel) {
				((FieldLabel) ch).setLabelWidth(0);
				((FieldLabel) ch).setLabelSeparator("");
				((FieldLabel) ch).addStyleName("customFieldLabel");
			}
		}
		
		Iterator<Widget> arrayOfChilds3 = vlcCol3.iterator();
		while (arrayOfChilds3.hasNext()) {
			Widget ch = arrayOfChilds3.next();
			if (ch instanceof FieldLabel) {
				((FieldLabel) ch).setLabelWidth(0);
				((FieldLabel) ch).setLabelSeparator("");
				((FieldLabel) ch).addStyleName("customFieldLabel");
			}
		}

		//Terapkan
		//===========================================================
		hlcMain.add(vlcCol1, new HorizontalLayoutData(-1, -1, new Margins(10, 1, 10, 10)));
		hlcMain.add(vlcCol2, new HorizontalLayoutData(90, -1, new Margins(10, 1, 10, 1)));
		hlcMain.add(vlcCol3, new HorizontalLayoutData(1, -1, new Margins(10, 10, 10, 1)));

		return hlcMain;
	}

	private ToolBar doCreateDownToolbar() {
		List<SelectHandler> customHandlerList = new ArrayList<SelectHandler>();
		List<String> customHandlerTextList = new ArrayList<String>();
		List<ImageResource> customHandlerIconResourceList = new ArrayList<ImageResource>();
		Resources imageResource = GWT.create(Resources.class);
		
		customHandlerList.add(doSearch());
		customHandlerTextList.add("Proses");
		customHandlerIconResourceList.add(imageResource.btnSearch());
		
		ToolBar downToolbar = new GlobalToolbarList().createDownToolBar(null, null, doClose(), doInfo(), customHandlerList, customHandlerTextList, customHandlerIconResourceList);
		downToolbar.setBorders(true);
		downToolbar.setPadding(new Padding(2));
		return downToolbar;
	}
	
	private ComboBox<AnyComboModel> doCreateComboboxField(List<String> comboValues) {
		/* Step 1 : Buat Store */
		ListStore<AnyComboModel> store = new ListStore<AnyComboModel>(new ModelKeyProvider<AnyComboModel>() {
			public String getKey(AnyComboModel item) {
				return item.getKey().toString();
			}
		});

		/* Step 2 : Buat Data */
		for (Map.Entry<String, String> item : fieldValues.entrySet()) {
			store.add(new AnyComboModel(item.getKey(), item.getValue()));
		}
		
		/* Step 3 : Buat labelProvider */
		LabelProvider<AnyComboModel> labelProvider = new LabelProvider<AnyComboModel>() {
			@Override
			public String getLabel(AnyComboModel item) {
				if (item.getValue() == null) {
					return "";
				}
				return item.getValue();
			}
		};

		/* Step 4 : Buat combobox */
		ComboBox<AnyComboModel> cmb = new ComboBox<AnyComboModel>(store, labelProvider);
		cmb.setWidth(formTitle);

		return cmb;
	}
	
	private ComboBox<AnyComboModel> doCreateComboboxCondition() {
		/* Step 1 : Buat Store */
		ListStore<AnyComboModel> store = new ListStore<AnyComboModel>(new ModelKeyProvider<AnyComboModel>() {
			public String getKey(AnyComboModel item) {
				return item.getKey().toString();
			}
		});

		/* Step 2 : Buat Data */
		store.add(new AnyComboModel("0", "="));
		store.add(new AnyComboModel("1", "<>"));
		store.add(new AnyComboModel("2", "LIKE"));
		
		/* Step 3 : Buat labelProvider */
		LabelProvider<AnyComboModel> labelProvider = new LabelProvider<AnyComboModel>() {
			@Override
			public String getLabel(AnyComboModel item) {
				if (item.getValue() == null) {
					return "";
				}
				return item.getValue();
			}
		};

		/* Step 4 : Buat combobox */
		ComboBox<AnyComboModel> cmb = new ComboBox<AnyComboModel>(store, labelProvider);
		cmb.setWidth(formTitle);

		return cmb;
	}
	
	private void doSearching() {
		//MessageBox msgbox = new MessageBox("SEARCH");
		//msgbox.show();
		
		/* Step 6 : Buat Store */
		ListStore<CoreMVarstaticDTO> store = gridReferer.getStore();

		/* Step 7 : Buat RpcProxy */
		RpcProxy<PagingLoadConfig, PagingLoadResult<CoreMVarstaticDTO>> dataProxy = new RpcProxy<PagingLoadConfig, PagingLoadResult<CoreMVarstaticDTO>>() {
			@Override
			public void load(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<CoreMVarstaticDTO>> callback) {
				Map<String, String> mapCriteria = new HashMap<String, String>();
				mapCriteria.put("Keynya", "Valnya");
				
				service.getSearchPaged(mapCriteria, loadConfig, callback);
			}
		};
		
		/* Step 8 : Buat pagingLoader */
		pagingLoader = new PagingLoader<PagingLoadConfig, PagingLoadResult<CoreMVarstaticDTO>>(dataProxy);
		pagingLoader.setRemoteSort(true);
		pagingLoader.setLimit(gridPageLimit);
		pagingLoader.addLoadHandler(new LoadResultListStoreBinding<PagingLoadConfig, CoreMVarstaticDTO, PagingLoadResult<CoreMVarstaticDTO>>(store));
		pagingLoader.setReuseLoadConfig(true);
		
		gridReferer.setLoadMask(true);
		gridReferer.setLoader(pagingLoader);
		
		pagingToolbarReferer.bind(pagingLoader);
		
		pagingLoader.load();
	}
	
	/********** Event Handler dan Listener **********/
	private SelectHandler doSearch() {
		return new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {			
				//doSearching();
				
				List<Map<String, String>> listMapParams = new ArrayList<Map<String, String>>();
				
				Iterator<Widget> arrayOfChilds1 = vlcCol1.iterator();
				while (arrayOfChilds1.hasNext()) {
					Widget ch = arrayOfChilds1.next();
					if (ch instanceof FieldLabel) {
						((FieldLabel) ch).setLabelWidth(120);
						((FieldLabel) ch).setLabelSeparator("");
						((FieldLabel) ch).addStyleName("customFieldLabel");
					}
				}
			}
		};
	}

	private SelectHandler doClose() {
		return new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				parentWindow.setVisible(false);
			}
		};
	}

	private SelectHandler doInfo() {
		return new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				MessageBox msgbox = new MessageBox("INFO");
				msgbox.show();
			}
		};
	}

	/********** Setter Getter **********/
	public String getFormTitle() {
		return formTitle;
	}

	public Window getParentWindow() {
		return parentWindow;
	}
	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	public HashMap<String, String> getFieldValues() {
		return fieldValues;
	}
	public void setFieldValues(final HashMap<String, String> fieldValues) {
		this.fieldValues = fieldValues;
	}
	
	public Object getClassReferer() {
		return classReferer;
	}
	public void setClassReferer(Object classReferer) {
		this.classReferer = classReferer;
	}

	public Grid<CoreMVarstaticDTO> getGridReferer() {
		return gridReferer;
	}
	public void setGridReferer(Grid<CoreMVarstaticDTO> gridReferer) {
		this.gridReferer = gridReferer;
	}

	public PagingToolBar getPagingToolbarReferer() {
		return pagingToolbarReferer;
	}
	public void setPagingToolbarReferer(PagingToolBar pagingToolbarReferer) {
		this.pagingToolbarReferer = pagingToolbarReferer;
	}

	public int getGridPageLimit() {
		return gridPageLimit;
	}
	public void setGridPageLimit(int gridPageLimit) {
		this.gridPageLimit = gridPageLimit;
	}

}