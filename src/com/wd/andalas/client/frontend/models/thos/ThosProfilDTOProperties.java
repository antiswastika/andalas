package com.wd.andalas.client.frontend.models.thos;

import java.util.Date;

import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface ThosProfilDTOProperties extends PropertyAccess<ThosProfilDTO> {

	/********** Main Methods **********/
	@Path("profil_id")
	ModelKeyProvider<ThosProfilDTO> profil_id();
	ValueProvider<ThosProfilDTO, Date> created_at();
	ValueProvider<ThosProfilDTO, String> created_by();
	ValueProvider<ThosProfilDTO, Date> updated_at();
	ValueProvider<ThosProfilDTO, String> updated_by();
	ValueProvider<ThosProfilDTO, String> profil_desc();
	ValueProvider<ThosProfilDTO, String> profil_nip();
	ValueProvider<ThosProfilDTO, String> profil_nama();
	ValueProvider<ThosProfilDTO, String> profil_nama_panggilan();
	ValueProvider<ThosProfilDTO, Date> profil_tgl_lahir();
	ValueProvider<ThosProfilDTO, String> profil_tmp_lahir();
	ValueProvider<ThosProfilDTO, Byte> profil_jenis_kelamin();
	ValueProvider<ThosProfilDTO, String> profil_agama();
	ValueProvider<ThosProfilDTO, String> profil_no_ktp();
	ValueProvider<ThosProfilDTO, String> profil_no_npwp();
	ValueProvider<ThosProfilDTO, String> profil_nama_bank();
	ValueProvider<ThosProfilDTO, String> profil_no_rek();
	ValueProvider<ThosProfilDTO, Byte> profil_status_menikah();
	ValueProvider<ThosProfilDTO, String> profil_alamat();
	ValueProvider<ThosProfilDTO, String> profil_no_telp();
	ValueProvider<ThosProfilDTO, String> profil_jabatan();
	ValueProvider<ThosProfilDTO, String> profil_formasi();
	ValueProvider<ThosProfilDTO, String> profil_nama_kdarurat();
	ValueProvider<ThosProfilDTO, String> profil_no_telp_kdarurat();
	ValueProvider<ThosProfilDTO, String> profil_alamat_kdarurat();
	ValueProvider<ThosProfilDTO, Byte> profil_lock();
	ValueProvider<ThosProfilDTO, Byte> profil_deleteable();
	ValueProvider<ThosProfilDTO, Date> profil_activedate();
	ValueProvider<ThosProfilDTO, Date> profil_expiredate();

}
