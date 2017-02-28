package com.wd.andalas.client.frontend.views.core.mvarstatic;

import java.util.Date;
import java.util.Iterator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.Padding;
import com.sencha.gxt.data.client.loader.RpcProxy;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.loader.DataProxy;
import com.sencha.gxt.data.shared.loader.ListLoadConfig;
import com.sencha.gxt.data.shared.loader.ListLoadResult;
import com.sencha.gxt.data.shared.loader.ListLoader;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
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
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.IntegerField;
import com.sencha.gxt.widget.core.client.form.TextArea;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;
import com.wd.andalas.client.backend.services.core.CoreMVarstaticService;
import com.wd.andalas.client.backend.services.core.CoreMVarstaticServiceAsync;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTO;
import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTOProperties;
import com.wd.andalas.global.GlobalToolbarList;

public class FormMVarStatic extends VBoxLayoutContainer implements IsWidget {

	/********** Inisiasi **********/
	private CoreMVarstaticDTOProperties properties = GWT.create(CoreMVarstaticDTOProperties.class);
	private CoreMVarstaticServiceAsync service = (CoreMVarstaticServiceAsync) GWT.create(CoreMVarstaticService.class);
	private ListLoader<ListLoadConfig, ListLoadResult<CoreMVarstaticDTO>> listLoader;
	private CoreMVarstaticDTO entity;

	private VerticalLayoutContainer vlcMain;
	private HorizontalLayoutContainer hlcMain;
	private VerticalLayoutContainer vlcCol1;
	private VerticalLayoutContainer vlcCol2;
	private Window parentWindow;

	private TextField txtInduk, txtNilai;
	private ComboBox<CoreMVarstaticDTO> cmbGrup;
	private TextArea txtDeskripsi;
	private IntegerField txtUrutan;
	private DateField dateAktif, dateKadaluarsa;
	final private String formTitle = "Form Variabel Statis";
	
	private ListMVarStatic classReferer = null; 
	
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

		//Buat Kolom 1
		//===========================================================
		vlcCol1 = new VerticalLayoutContainer();
		vlcCol1.setBorders(debugShowBorders);

		txtNilai = new TextField();
		txtNilai.setAllowBlank(true);
		cmbGrup = doCreateComboboxGrup();
		cmbGrup.setEmptyText("Pilih grup...");
		cmbGrup.setEditable(false);
		txtDeskripsi = new TextArea();
		txtDeskripsi.setAllowBlank(true);
		txtDeskripsi.setHeight(140);
		txtUrutan = new IntegerField();
		txtUrutan.setValue(0);
		dateAktif = new DateField();
		dateAktif.setAllowBlank(true);
		dateKadaluarsa = new DateField();
		dateKadaluarsa.setAllowBlank(true);

		vlcCol1.add(new FieldLabel(txtNilai, "Nilai Statis"), new VerticalLayoutData(1, -1));
		vlcCol1.add(new FieldLabel(txtUrutan, "Urutan"));
		vlcCol1.add(new FieldLabel(cmbGrup, "Grup"), new VerticalLayoutData(1, -1));
		vlcCol1.add(new FieldLabel(dateAktif, "Tanggal Mulai"));
		vlcCol1.add(new FieldLabel(dateKadaluarsa, "Tanggal Berakhir"));
		vlcCol1.add(new FieldLabel(txtDeskripsi, "Deskripsi"), new VerticalLayoutData(1, -1));
		Iterator<Widget> arrayOfChilds1 = vlcCol1.iterator();
		while (arrayOfChilds1.hasNext()) {
			Widget ch = arrayOfChilds1.next();
			if (ch instanceof FieldLabel) {
				((FieldLabel) ch).setLabelWidth(120);
				((FieldLabel) ch).setLabelSeparator("");
				((FieldLabel) ch).addStyleName("customFieldLabel");
			}
		}

		//Buat Kolom 2
		//===========================================================
		vlcCol2 = new VerticalLayoutContainer();
		vlcCol2.setBorders(debugShowBorders);

		txtInduk = new TextField();
		txtInduk.setAllowBlank(true);

		vlcCol2.add(new FieldLabel(null, "Nilai Induk"), new VerticalLayoutData(1, -1));
		vlcCol2.setEnabled(false);

		//Gabungkan
		//===========================================================
		hlcMain.add(vlcCol1, new HorizontalLayoutData(.6, -1, new Margins(10, 10, 10, 10)));
		hlcMain.add(vlcCol2, new HorizontalLayoutData(.4, -1, new Margins(10, 10, 10, 10)));

		//Apply Data
		//===========================================================
		doApplyData();

		return hlcMain;
	}

	private ToolBar doCreateDownToolbar() {
		ToolBar downToolbar = new GlobalToolbarList().createDownToolBar(doSave(), doReset(), doClose(), doInfo(), null);
		downToolbar.setBorders(true);
		downToolbar.setPadding(new Padding(2));
		return downToolbar;
	}

	private ComboBox<CoreMVarstaticDTO> doCreateComboboxGrup() {
		/* Step 1 : Buat Store */
		ListStore<CoreMVarstaticDTO> store = new ListStore<CoreMVarstaticDTO>(properties.varstat_id());

		/* Step 2 : Buat RpcProxy */
		DataProxy<ListLoadConfig, ListLoadResult<CoreMVarstaticDTO>> dataProxy = new RpcProxy<ListLoadConfig, ListLoadResult<CoreMVarstaticDTO>>() {
			@Override
			public void load(ListLoadConfig loadConfig, final AsyncCallback<ListLoadResult<CoreMVarstaticDTO>> callback) {
				service.getAllGrup(loadConfig, callback);
			}
		};

		/* Step 3 : Buat listLoader */
		listLoader = new ListLoader<ListLoadConfig, ListLoadResult<CoreMVarstaticDTO>>(dataProxy);
		listLoader.addLoadHandler(new LoadResultListStoreBinding<ListLoadConfig, CoreMVarstaticDTO, ListLoadResult<CoreMVarstaticDTO>>(store));
		listLoader.load();

		/* Step 4 : Buat labelProvider */
		LabelProvider<CoreMVarstaticDTO> labelProvider = new LabelProvider<CoreMVarstaticDTO>() {
			@Override
			public String getLabel(CoreMVarstaticDTO item) {
				if (item.getVarstat_group() == null) {
					return "";
				}
				return item.getVarstat_group();
			}
		};

		/* Step 5 : Buat combobox */
		ComboBox<CoreMVarstaticDTO> cmb = new ComboBox<CoreMVarstaticDTO>(store, labelProvider);
		cmb.setLoader(listLoader);

		return cmb;
	}

	private void doApplyData() {
		if (entity != null) {
			txtNilai.setText(entity.getVarstat_name().trim());
			cmbGrup.setText(entity.getVarstat_group());
			txtDeskripsi.setText(entity.getVarstat_desc().trim());
			txtUrutan.setValue(entity.getVarstat_seq());
			dateAktif.setValue(entity.getVarstat_activedate());
			dateKadaluarsa.setValue(entity.getVarstat_expiredate());
		} else {
			//Default Value
			entity = new CoreMVarstaticDTO();
			entity.setVarstat_deleteable((byte) 1);
			entity.setVarstat_lock((byte) 1);
			entity.setVarstat_parentid(null);
			txtUrutan.setValue(1);
		}
	}
	
	private void doGetEntity() {
		if (entity != null) {
			entity.setCreated_at(new Date());
			entity.setCreated_by("SYSTEM");
			entity.setUpdated_at(new Date());
			entity.setUpdated_by("SYSTEM");
			entity.setVarstat_desc(txtDeskripsi.getText().trim());
			entity.setVarstat_name(txtNilai.getText().trim());
			entity.setVarstat_seq(txtUrutan.getValue());
			entity.setVarstat_group(cmbGrup.getText().trim());
			entity.setVarstat_icon(null);
			entity.setVarstat_activedate(dateAktif.getValue());
			entity.setVarstat_expiredate(dateKadaluarsa.getValue());
		} else {
			doApplyData();
		}
	}

	/********** Event Handler dan Listener **********/
	private SelectHandler doSave() {
		return new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {	
				doGetEntity();
				service.insert(entity, new AsyncCallback<Boolean>() {
					@Override
					public void onSuccess(Boolean result) {
						parentWindow.setVisible(false);
						classReferer.doPublicRefresh();
					}
					@Override
					public void onFailure(Throwable caught) {
						MessageBox msgbox = new MessageBox("GAGAL", caught.getMessage());
						msgbox.show();
					}
				});
			}
		};
	}

	private SelectHandler doReset() {
		return new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				doApplyData();
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
	public CoreMVarstaticDTO getEntity() {
		return entity;
	}
	public void setEntity(CoreMVarstaticDTO entity) {
		this.entity = entity;
	}

	public String getFormTitle() {
		return formTitle;
	}

	public Window getParentWindow() {
		return parentWindow;
	}
	public void setParentWindow(Window parentWindow) {
		this.parentWindow = parentWindow;
	}

	public ListMVarStatic getClassReferer() {
		return classReferer;
	}
	public void setClassReferer(ListMVarStatic classReferer) {
		this.classReferer = classReferer;
	}

}
