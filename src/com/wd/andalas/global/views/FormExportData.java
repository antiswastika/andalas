package com.wd.andalas.global.views;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.Padding;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
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
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;
import com.wd.andalas.global.GlobalToolbarList;
import com.wd.andalas.resources.Resources;

public class FormExportData extends VBoxLayoutContainer implements IsWidget {

	/********** Inisiasi **********/
	private VerticalLayoutContainer vlcMain;
	private HorizontalLayoutContainer hlcMain;
	private VerticalLayoutContainer vlcCol1;
	private Window parentWindow;

	private ComboBox<AnyCombo> cmbFormat;
	final private String formTitle = "Ekspor Data";
	
	private Object classReferer = null; 
	
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

		cmbFormat = doCreateComboboxFormat();
		cmbFormat.setEmptyText("Pilih format...");
		cmbFormat.setEditable(false);
		cmbFormat.setTriggerAction(TriggerAction.ALL);

		vlcCol1.add(new FieldLabel(cmbFormat, "Format Data"), new VerticalLayoutData(1, -1));

		Iterator<Widget> arrayOfChilds1 = vlcCol1.iterator();
		while (arrayOfChilds1.hasNext()) {
			Widget ch = arrayOfChilds1.next();
			if (ch instanceof FieldLabel) {
				((FieldLabel) ch).setLabelWidth(90);
				((FieldLabel) ch).setLabelSeparator("");
				((FieldLabel) ch).addStyleName("customFieldLabel");
			}
		}

		//Terapkan
		//===========================================================
		hlcMain.add(vlcCol1, new HorizontalLayoutData(1, -1, new Margins(10, 10, 10, 10)));

		return hlcMain;
	}

	private ToolBar doCreateDownToolbar() {
		List<SelectHandler> customHandlerList = new ArrayList<SelectHandler>();
		List<String> customHandlerTextList = new ArrayList<String>();
		List<ImageResource> customHandlerIconResourceList = new ArrayList<ImageResource>();
		Resources imageResource = GWT.create(Resources.class);
		
		customHandlerList.add(doExport());
		customHandlerTextList.add("Proses");
		customHandlerIconResourceList.add(imageResource.btnExport());
		
		ToolBar downToolbar = new GlobalToolbarList().createDownToolBar(null, null, doClose(), doInfo(), customHandlerList, customHandlerTextList, customHandlerIconResourceList);
		downToolbar.setBorders(true);
		downToolbar.setPadding(new Padding(2));
		return downToolbar;
	}

	private ComboBox<AnyCombo> doCreateComboboxFormat() {
		/* Step 1 : Buat Store */
		ListStore<AnyCombo> store = new ListStore<AnyCombo>(new ModelKeyProvider<AnyCombo>() {
			public String getKey(AnyCombo item) {
				return item.getKey().toString();
			}
		});

		/* Step 2 : Buat Data */
		store.add(new AnyCombo("0", "Portable Document Format (*.pdf)"));
		store.add(new AnyCombo("1", "Ms Excel Document (*.xls)"));
		store.add(new AnyCombo("2", "Ms Word Document (*.doc)"));
		store.add(new AnyCombo("3", "Comma-Separated Values (*.csv)"));
		store.add(new AnyCombo("4", "DataBase File (*.dbf)"));
		store.add(new AnyCombo("5", "JavaScript Object Notation (*.json)"));
		store.add(new AnyCombo("6", "eXtensible Markup Language (*.xml)"));
		store.add(new AnyCombo("7", "Hypertext Markup Language (*.html)"));	

		/* Step 3 : Buat labelProvider */
		LabelProvider<AnyCombo> labelProvider = new LabelProvider<AnyCombo>() {
			@Override
			public String getLabel(AnyCombo item) {
				if (item.getValue() == null) {
					return "";
				}
				return item.getValue();
			}
		};

		/* Step 5 : Buat combobox */
		ComboBox<AnyCombo> cmb = new ComboBox<AnyCombo>(store, labelProvider);
		cmb.setWidth(formTitle);

		return cmb;
	}

	/********** Event Handler dan Listener **********/
	private SelectHandler doExport() {
		return new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {					
				MessageBox msgbox = new MessageBox("EXPORT");
				msgbox.show();
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

	public Object getClassReferer() {
		return classReferer;
	}
	public void setClassReferer(Object classReferer) {
		this.classReferer = classReferer;
	}

}
