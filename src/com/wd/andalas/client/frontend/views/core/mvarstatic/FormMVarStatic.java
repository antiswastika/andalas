package com.wd.andalas.client.frontend.views.core.mvarstatic;

import java.util.Iterator;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.Padding;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.IntegerField;
import com.sencha.gxt.widget.core.client.form.TextArea;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.toolbar.FillToolItem;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;
import com.wd.andalas.global.GlobalToolbarList;

public class FormMVarStatic extends VBoxLayoutContainer implements IsWidget {

	/********** Inisiasi **********/
	private VBoxLayoutContainer vlcMain;
	private HorizontalLayoutContainer hlcMain;

	private VerticalLayoutContainer vlcCol1;
	private VerticalLayoutContainer vlcCol2;

	private TextField txtInduk, txtNilai, txtGrup;
	private TextArea txtDeskripsi;
	private IntegerField txtUrutan;
	private DateField dateAktif, dateKadaluarsa;
	final private String formTitle = "Form - Insert Variabel Statis";

	@Override
	public Widget asWidget() {
		vlcMain = new VBoxLayoutContainer(VBoxLayoutAlign.STRETCH);
		vlcMain.add(doCreateForm());
		vlcMain.add(new FillToolItem());
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
		txtGrup = new TextField();
		txtGrup.setAllowBlank(true);
		txtDeskripsi = new TextArea();
		txtDeskripsi.setAllowBlank(true);
		txtDeskripsi.setHeight(120);
		txtUrutan = new IntegerField();
		txtUrutan.setValue(0);
		dateAktif = new DateField();
		dateKadaluarsa = new DateField();
		
		vlcCol1.add(new FieldLabel(txtNilai, "Nilai Statis"), new VerticalLayoutData(1, -1));
		vlcCol1.add(new FieldLabel(txtUrutan, "Urutan"));
		vlcCol1.add(new FieldLabel(txtGrup, "Grup"), new VerticalLayoutData(1, -1));
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
		
		return hlcMain;
	}
	
	private ToolBar doCreateDownToolbar() {
		ToolBar downToolbar = new GlobalToolbarList().createDownToolBar(doSave(), doSave(), doSave(), null);
		downToolbar.setBorders(true);
		downToolbar.setPadding(new Padding(2));
		downToolbar.setShadow(true);
		return downToolbar;
	}

	/********** Event Handler dan Listener **********/
	private SelectHandler doSave() {
		return new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				MessageBox msgbox = new MessageBox("SAVE");
				msgbox.show();
			}
		};
	}
	
	/********** Setter Getter **********/
	public String getFormTitle() {
		return formTitle;
	}

}
