package com.wd.andalas.client.frontend.views.core.mvarstatic;

import java.util.Iterator;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.IntegerField;
import com.sencha.gxt.widget.core.client.form.TextArea;
import com.sencha.gxt.widget.core.client.form.TextField;

public class FormMVarStatic extends VBoxLayoutContainer implements IsWidget {

	/********** Inisiasi **********/
	private VBoxLayoutContainer vlcMain;
	private HorizontalLayoutContainer hlcMain;

	private VerticalLayoutContainer vlcCol1;
	private VerticalLayoutContainer vlcCol2;

	private TextField txtInduk, txtNilai, txtGrup;
	private TextArea txtDeskripsi;
	private IntegerField txtUrutan;
	private CheckBox ckKonstan, ckHapus;
	private DateField dateAktif, dateKadaluarsa;

	@Override
	public Widget asWidget() {
		vlcMain = new VBoxLayoutContainer(VBoxLayoutAlign.STRETCH);
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
		txtDeskripsi.setHeight(80);
		txtUrutan = new IntegerField();
		txtUrutan.setValue(0);
		dateAktif = new DateField();
		dateKadaluarsa = new DateField();
		ckKonstan = new CheckBox();
		ckKonstan.setBoxLabel("Konstan");
		ckHapus = new CheckBox();
		ckHapus.setBoxLabel("Bisa Dihapus");

		HorizontalPanel hp1 = new HorizontalPanel();
		hp1.add(ckKonstan);
		hp1.add(ckHapus);
		hp1.setLayoutData(new VerticalLayoutData(1, -1, new Margins(5, 0,0,0)));

		vlcCol1.add(new FieldLabel(txtNilai, "Nilai Statis"), new VerticalLayoutData(1, -1));
		vlcCol1.add(new FieldLabel(txtUrutan, "Urutan"));
		vlcCol1.add(new FieldLabel(txtGrup, "Grup"), new VerticalLayoutData(1, -1));
		vlcCol1.add(new FieldLabel(dateAktif, "Tanggal Mulai"));
		vlcCol1.add(new FieldLabel(dateKadaluarsa, "Tanggal Berakhir"));
		vlcCol1.add(new FieldLabel(txtDeskripsi, "Deskripsi"), new VerticalLayoutData(1, -1));
		vlcCol1.add(new FieldLabel(hp1, "Lainnya"), new VerticalLayoutData(1, -1, new Margins(3, 0,0,0)));
		Iterator<Widget> arrayOfChilds1 = vlcCol1.iterator();
		while (arrayOfChilds1.hasNext()) {
			Widget ch = arrayOfChilds1.next();
			if (ch instanceof FieldLabel) {
				((FieldLabel) ch).setLabelWidth(150);
			}
		}

		//Buat Kolom 2
		//===========================================================
		vlcCol2 = new VerticalLayoutContainer();
		vlcCol2.setBorders(debugShowBorders);

		txtInduk = new TextField();
		txtInduk.setAllowBlank(true);

		vlcCol2.add(new FieldLabel(txtInduk, "Relasi Nilai Induk"), new VerticalLayoutData(1, -1));

		//Gabungkan
		//===========================================================
		hlcMain.add(vlcCol1, new HorizontalLayoutData(.5, -1, new Margins(10, 10, 10, 10)));
		hlcMain.add(vlcCol2, new HorizontalLayoutData(.5, -1, new Margins(10, 10, 10, 10)));

		vlcMain.add(hlcMain);
		return vlcMain;
	}

	/********** Custom Methods **********/
	private void doCreateForm(String idNya) {
		MessageBox msgbox = new MessageBox(idNya);
		msgbox.show();
	}

	/********** Event Handler dan Listener **********/
	@SuppressWarnings("unused")
	private SelectHandler doSave() {
		return new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				doCreateForm("SAVE");
			}
		};
	}

}
