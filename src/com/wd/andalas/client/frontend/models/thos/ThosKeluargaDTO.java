package com.wd.andalas.client.frontend.models.thos;

import java.io.Serializable;
import java.util.Date;

import com.wd.andalas.server.backend.models.thos.ThosKeluarga;
import com.wd.andalas.server.backend.models.thos.ThosProfil;

public class ThosKeluargaDTO implements Serializable {

	/********** Inisiasi **********/
	private static final long serialVersionUID = 1L;
	private String keluarga_id;
	private Date created_at;
	private String created_by;
	private Date updated_at;
	private String updated_by;
	private String keluarga_desc;
	private ThosProfil thos_profil;
	private String keluarga_nama;
	private Date keluarga_tgl_lahir;
	private String keluarga_tmp_lahir;
	private Byte keluarga_jenis_kelamin;
	private String keluarga_hubungan;
	private Integer keluarga_urutan;
	private String keluarga_agama;
	private Byte keluarga_status_menikah;
	private Date keluarga_tgl_menikah;
	private Byte keluarga_status_tanggungan;
	private String keluarga_alamat;
	private String keluarga_no_telp;
	private Byte keluarga_lock;
	private Byte keluarga_deleteable;
	private Date keluarga_activedate;
	private Date keluarga_expiredate;

	/********** Main Methods **********/
	public ThosKeluargaDTO() { }

	public ThosKeluargaDTO(ThosKeluarga obj) {
		super();
		this.keluarga_id = obj.getKeluargaId();
		this.created_at = obj.getCreatedAt();
		this.created_by = obj.getCreatedBy();
		this.updated_at = obj.getUpdatedAt();
		this.updated_by = obj.getUpdatedBy();
		this.keluarga_desc = obj.getKeluargaDesc();
		this.thos_profil = obj.getThosProfil();
		this.keluarga_nama = obj.getKeluargaNama();
		this.keluarga_tgl_lahir = obj.getKeluargaTglLahir();
		this.keluarga_tmp_lahir = obj.getKeluargaTmpLahir();
		this.keluarga_jenis_kelamin = obj.getKeluargaJenisKelamin();
		this.keluarga_hubungan = obj.getKeluargaHubungan();
		this.keluarga_urutan = obj.getKeluargaUrutan();
		this.keluarga_agama = obj.getKeluargaAgama();
		this.keluarga_status_menikah = obj.getKeluargaStatusMenikah();
		this.keluarga_tgl_menikah = obj.getKeluargaTglMenikah();
		this.keluarga_status_tanggungan = obj.getKeluargaStatusTanggungan();
		this.keluarga_alamat = obj.getKeluargaAlamat();
		this.keluarga_no_telp = obj.getKeluargaNoTelp();
		this.keluarga_lock = obj.getKeluargaLock();
		this.keluarga_deleteable = obj.getKeluargaDeleteable();
		this.keluarga_activedate = obj.getKeluargaActivedate();
		this.keluarga_expiredate = obj.getKeluargaExpiredate();
	}

	/********** Setter Getter **********/
	public String getKeluarga_id() {
		return keluarga_id;
	}
	public void setKeluarga_id(String keluarga_id) {
		this.keluarga_id = keluarga_id;
	}

	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public String getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	public String getKeluarga_desc() {
		return keluarga_desc;
	}
	public void setKeluarga_desc(String keluarga_desc) {
		this.keluarga_desc = keluarga_desc;
	}

	public ThosProfil getThosProfil() {
		return thos_profil;
	}
	public void setThosProfil(ThosProfil thos_profil) {
		this.thos_profil = thos_profil;
	}

	public String getKeluarga_nama() {
		return keluarga_nama;
	}
	public void setKeluarga_nama(String keluarga_nama) {
		this.keluarga_nama = keluarga_nama;
	}

	public Date getKeluarga_tgl_lahir() {
		return keluarga_tgl_lahir;
	}
	public void setKeluarga_tgl_lahir(Date keluarga_tgl_lahir) {
		this.keluarga_tgl_lahir = keluarga_tgl_lahir;
	}

	public String getKeluarga_tmp_lahir() {
		return keluarga_tmp_lahir;
	}
	public void setKeluarga_tmp_lahir(String keluarga_tmp_lahir) {
		this.keluarga_tmp_lahir = keluarga_tmp_lahir;
	}

	public Byte getKeluarga_jenis_kelamin() {
		return keluarga_jenis_kelamin;
	}
	public void setKeluarga_jenis_kelamin(Byte keluarga_jenis_kelamin) {
		this.keluarga_jenis_kelamin = keluarga_jenis_kelamin;
	}

	public String getKeluarga_hubungan() {
		return keluarga_hubungan;
	}
	public void setKeluarga_hubungan(String keluarga_hubungan) {
		this.keluarga_hubungan = keluarga_hubungan;
	}

	public Integer getKeluarga_urutan() {
		return keluarga_urutan;
	}
	public void setKeluarga_urutan(Integer keluarga_urutan) {
		this.keluarga_urutan = keluarga_urutan;
	}

	public String getKeluarga_agama() {
		return keluarga_agama;
	}
	public void setKeluarga_agama(String keluarga_agama) {
		this.keluarga_agama = keluarga_agama;
	}

	public Byte getKeluarga_status_menikah() {
		return keluarga_status_menikah;
	}
	public void setKeluarga_status_menikah(Byte keluarga_status_menikah) {
		this.keluarga_status_menikah = keluarga_status_menikah;
	}

	public Date getKeluarga_tgl_menikah() {
		return keluarga_tgl_menikah;
	}
	public void setKeluarga_tgl_menikah(Date keluarga_tgl_menikah) {
		this.keluarga_tgl_menikah = keluarga_tgl_menikah;
	}

	public Byte getKeluarga_status_tanggungan() {
		return keluarga_status_tanggungan;
	}
	public void setKeluarga_status_tanggungan(Byte keluarga_status_tanggungan) {
		this.keluarga_status_tanggungan = keluarga_status_tanggungan;
	}

	public String getKeluarga_alamat() {
		return keluarga_alamat;
	}
	public void setKeluarga_alamat(String keluarga_alamat) {
		this.keluarga_alamat = keluarga_alamat;
	}

	public String getKeluarga_no_telp() {
		return keluarga_no_telp;
	}
	public void setKeluarga_no_telp(String keluarga_no_telp) {
		this.keluarga_no_telp = keluarga_no_telp;
	}

	public Byte getKeluarga_lock() {
		return keluarga_lock;
	}
	public void setKeluarga_lock(Byte keluarga_lock) {
		this.keluarga_lock = keluarga_lock;
	}

	public Byte getKeluarga_deleteable() {
		return keluarga_deleteable;
	}
	public void setKeluarga_deleteable(Byte keluarga_deleteable) {
		this.keluarga_deleteable = keluarga_deleteable;
	}

	public Date getKeluarga_activedate() {
		return keluarga_activedate;
	}
	public void setKeluarga_activedate(Date keluarga_activedate) {
		this.keluarga_activedate = keluarga_activedate;
	}

	public Date getKeluarga_expiredate() {
		return keluarga_expiredate;
	}
	public void setKeluarga_expiredate(Date keluarga_expiredate) {
		this.keluarga_expiredate = keluarga_expiredate;
	}

}
