package com.wd.andalas.client.frontend.models.thos;

import java.io.Serializable;
import java.util.Date;

import com.wd.andalas.server.backend.models.thos.ThosProfil;

public class ThosProfilDTO implements Serializable {

	/********** Inisiasi **********/
	private static final long serialVersionUID = 1L;
	private String profil_id;
	private Date created_at;
	private String created_by;
	private Date updated_at;
	private String updated_by;
	private String profil_desc;
	private String profil_nip;
	private String profil_nama;
	private String profil_nama_panggilan;
	private Date profil_tgl_lahir;
	private String profil_tmp_lahir;
	private Byte profil_jenis_kelamin;
	private String profil_agama;
	private String profil_no_ktp;
	private String profil_no_npwp;
	private String profil_nama_bank;
	private String profil_no_rek;
	private Byte profil_status_menikah;
	private String profil_alamat;
	private String profil_no_telp;
	private String profil_jabatan;
	private String profil_formasi;
	private String profil_nama_kdarurat;
	private String profil_no_telp_kdarurat;
	private String profil_alamat_kdarurat;
	private Byte profil_lock;
	private Byte profil_deleteable;
	private Date profil_activedate;
	private Date profil_expiredate;

	/********** Main Methods **********/
	public ThosProfilDTO() { }

	public ThosProfilDTO(ThosProfil obj) {
		super();
		this.profil_id = obj.getProfilId();
		this.created_at = obj.getCreatedAt();
		this.created_by = obj.getCreatedBy();
		this.updated_at = obj.getUpdatedAt();
		this.updated_by = obj.getUpdatedBy();
		this.profil_desc = obj.getProfilDesc();
		this.profil_nip = obj.getProfilNip();
		this.profil_nama = obj.getProfilNama();
		this.profil_nama_panggilan = obj.getProfilNamaPanggilan();
		this.profil_tgl_lahir = obj.getProfilTglLahir();
		this.profil_tmp_lahir = obj.getProfilTmpLahir();
		this.profil_jenis_kelamin = obj.getProfilJenisKelamin();
		this.profil_agama = obj.getProfilAgama();
		this.profil_no_ktp = obj.getProfilNoKtp();
		this.profil_no_npwp = obj.getProfilNoNpwp();
		this.profil_nama_bank = obj.getProfilNamaBank();
		this.profil_no_rek = obj.getProfilNoRek();
		this.profil_status_menikah = obj.getProfilStatusMenikah();
		this.profil_alamat = obj.getProfilAlamat();
		this.profil_no_telp = obj.getProfilNoTelp();
		this.profil_jabatan = obj.getProfilJabatan();
		this.profil_formasi = obj.getProfilFormasi();
		this.profil_nama_kdarurat = obj.getProfilNamaKdarurat();
		this.profil_no_telp_kdarurat = obj.getProfilNoTelpKdarurat();
		this.profil_alamat_kdarurat = obj.getProfilAlamatKdarurat();
		this.profil_lock = obj.getProfilLock();
		this.profil_deleteable = obj.getProfilDeleteable();
		this.profil_activedate = obj.getProfilActivedate();
		this.profil_expiredate = obj.getProfilExpiredate();
	}

	/********** Setter Getter **********/
	public String getProfil_id() {
		return profil_id;
	}
	public void setProfil_id(String profil_id) {
		this.profil_id = profil_id;
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

	public String getProfil_desc() {
		return profil_desc;
	}
	public void setProfil_desc(String profil_desc) {
		this.profil_desc = profil_desc;
	}

	public String getProfil_nip() {
		return profil_nip;
	}
	public void setProfil_nip(String profil_nip) {
		this.profil_nip = profil_nip;
	}

	public String getProfil_nama() {
		return profil_nama;
	}
	public void setProfil_nama(String profil_nama) {
		this.profil_nama = profil_nama;
	}

	public String getProfil_nama_panggilan() {
		return profil_nama_panggilan;
	}
	public void setProfil_nama_panggilan(String profil_nama_panggilan) {
		this.profil_nama_panggilan = profil_nama_panggilan;
	}

	public Date getProfil_tgl_lahir() {
		return profil_tgl_lahir;
	}
	public void setProfil_tgl_lahir(Date profil_tgl_lahir) {
		this.profil_tgl_lahir = profil_tgl_lahir;
	}

	public String getProfil_tmp_lahir() {
		return profil_tmp_lahir;
	}
	public void setProfil_tmp_lahir(String profil_tmp_lahir) {
		this.profil_tmp_lahir = profil_tmp_lahir;
	}

	public Byte getProfil_jenis_kelamin() {
		return profil_jenis_kelamin;
	}
	public void setProfil_jenis_kelamin(Byte profil_jenis_kelamin) {
		this.profil_jenis_kelamin = profil_jenis_kelamin;
	}

	public String getProfil_agama() {
		return profil_agama;
	}
	public void setProfil_agama(String profil_agama) {
		this.profil_agama = profil_agama;
	}

	public String getProfil_no_ktp() {
		return profil_no_ktp;
	}
	public void setProfil_no_ktp(String profil_no_ktp) {
		this.profil_no_ktp = profil_no_ktp;
	}

	public String getProfil_no_npwp() {
		return profil_no_npwp;
	}
	public void setProfil_no_npwp(String profil_no_npwp) {
		this.profil_no_npwp = profil_no_npwp;
	}

	public String getProfil_nama_bank() {
		return profil_nama_bank;
	}
	public void setProfil_nama_bank(String profil_nama_bank) {
		this.profil_nama_bank = profil_nama_bank;
	}

	public String getProfil_no_rek() {
		return profil_no_rek;
	}
	public void setProfil_no_rek(String profil_no_rek) {
		this.profil_no_rek = profil_no_rek;
	}

	public Byte getProfil_status_menikah() {
		return profil_status_menikah;
	}
	public void setProfil_status_menikah(Byte profil_status_menikah) {
		this.profil_status_menikah = profil_status_menikah;
	}

	public String getProfil_alamat() {
		return profil_alamat;
	}
	public void setProfil_alamat(String profil_alamat) {
		this.profil_alamat = profil_alamat;
	}

	public String getProfil_no_telp() {
		return profil_no_telp;
	}
	public void setProfil_no_telp(String profil_no_telp) {
		this.profil_no_telp = profil_no_telp;
	}

	public String getProfil_jabatan() {
		return profil_jabatan;
	}
	public void setProfil_jabatan(String profil_jabatan) {
		this.profil_jabatan = profil_jabatan;
	}

	public String getProfil_formasi() {
		return profil_formasi;
	}
	public void setProfil_formasi(String profil_formasi) {
		this.profil_formasi = profil_formasi;
	}

	public String getProfil_nama_kdarurat() {
		return profil_nama_kdarurat;
	}
	public void setProfil_nama_kdarurat(String profil_nama_kdarurat) {
		this.profil_nama_kdarurat = profil_nama_kdarurat;
	}

	public String getProfil_no_telp_kdarurat() {
		return profil_no_telp_kdarurat;
	}
	public void setProfil_no_telp_kdarurat(String profil_no_telp_kdarurat) {
		this.profil_no_telp_kdarurat = profil_no_telp_kdarurat;
	}

	public String getProfil_alamat_kdarurat() {
		return profil_alamat_kdarurat;
	}
	public void setProfil_alamat_kdarurat(String profil_alamat_kdarurat) {
		this.profil_alamat_kdarurat = profil_alamat_kdarurat;
	}

	public Byte getProfil_lock() {
		return profil_lock;
	}
	public void setProfil_lock(Byte profil_lock) {
		this.profil_lock = profil_lock;
	}

	public Byte getProfil_deleteable() {
		return profil_deleteable;
	}
	public void setProfil_deleteable(Byte profil_deleteable) {
		this.profil_deleteable = profil_deleteable;
	}

	public Date getProfil_activedate() {
		return profil_activedate;
	}
	public void setProfil_activedate(Date profil_activedate) {
		this.profil_activedate = profil_activedate;
	}

	public Date getProfil_expiredate() {
		return profil_expiredate;
	}
	public void setProfil_expiredate(Date profil_expiredate) {
		this.profil_expiredate = profil_expiredate;
	}

}
