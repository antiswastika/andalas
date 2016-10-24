package com.wd.andalas.client.frontend.models.thos;

import java.util.Date;

import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.wd.andalas.server.backend.models.thos.ThosProfil;

public interface ThosKeluargaDTOProperties extends PropertyAccess<ThosKeluargaDTO> {

	/********** Main Methods **********/
	@Path("keluarga_id")
	ModelKeyProvider<ThosKeluargaDTO> keluarga_id();
	ValueProvider<ThosKeluargaDTO, Date> created_at();
	ValueProvider<ThosKeluargaDTO, String> created_by();
	ValueProvider<ThosKeluargaDTO, Date> updated_at();
	ValueProvider<ThosKeluargaDTO, String> updated_by();
	ValueProvider<ThosKeluargaDTO, String> keluarga_desc();
	ValueProvider<ThosKeluargaDTO, ThosProfil> thos_profil();
	ValueProvider<ThosKeluargaDTO, String> keluarga_nama();
	ValueProvider<ThosKeluargaDTO, Date> keluarga_tgl_lahir();
	ValueProvider<ThosKeluargaDTO, String> keluarga_tmp_lahir();
	ValueProvider<ThosKeluargaDTO, Byte> keluarga_jenis_kelamin();
	ValueProvider<ThosKeluargaDTO, String> keluarga_hubungan();
	ValueProvider<ThosKeluargaDTO, Integer> keluarga_urutan();
	ValueProvider<ThosKeluargaDTO, String> keluarga_agama();
	ValueProvider<ThosKeluargaDTO, Byte> keluarga_status_menikah();
	ValueProvider<ThosKeluargaDTO, Date> keluarga_tgl_menikah();
	ValueProvider<ThosKeluargaDTO, Byte> keluarga_status_tanggungan();
	ValueProvider<ThosKeluargaDTO, String> keluarga_alamat();
	ValueProvider<ThosKeluargaDTO, String> keluarga_no_telp();
	ValueProvider<ThosKeluargaDTO, Byte> keluarga_lock();
	ValueProvider<ThosKeluargaDTO, Byte> keluarga_deleteable();
	ValueProvider<ThosKeluargaDTO, Date> keluarga_activedate();
	ValueProvider<ThosKeluargaDTO, Date> keluarga_expiredate();

}
