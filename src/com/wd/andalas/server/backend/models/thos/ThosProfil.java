package com.wd.andalas.server.backend.models.thos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.wd.andalas.client.frontend.models.thos.ThosProfilDTO;

/**
 * The persistent class for the thos_profil database table.
 *
 */
@Entity
@Table(name="thos_profil")
@NamedQuery(name="ThosProfil.findAll", query="SELECT t FROM ThosProfil t")
public class ThosProfil implements Serializable {

	/********** Inisiasi **********/
	private static final long serialVersionUID = 1L;

	/********** Main Methods **********/
	public ThosProfil() { }

	// Just copy the fields from ThosProfilDTO (client side) to this server side class
	public ThosProfil(ThosProfilDTO obj) {
		this.profilId = obj.getProfil_id();
		this.createdAt = obj.getCreated_at();
		this.createdBy = obj.getCreated_by();
		this.updatedAt = obj.getUpdated_at();
		this.updatedBy = obj.getUpdated_by();
		this.profilDesc = obj.getProfil_desc();
		this.profilNip = obj.getProfil_nip();
		this.profilNama = obj.getProfil_nama();
		this.profilNamaPanggilan = obj.getProfil_nama_panggilan();
		this.profilTglLahir = obj.getProfil_tgl_lahir();
		this.profilTmpLahir = obj.getProfil_tmp_lahir();
		this.profilJenisKelamin = obj.getProfil_jenis_kelamin();
		this.profilAgama = obj.getProfil_agama();
		this.profilNoKtp = obj.getProfil_no_ktp();
		this.profilNoNpwp = obj.getProfil_no_npwp();
		this.profilNamaBank = obj.getProfil_nama_bank();
		this.profilNoRek = obj.getProfil_no_rek();
		this.profilStatusMenikah = obj.getProfil_status_menikah();
		this.profilAlamat = obj.getProfil_alamat();
		this.profilNoTelp = obj.getProfil_no_telp();
		this.profilJabatan = obj.getProfil_jabatan();
		this.profilFormasi = obj.getProfil_formasi();
		this.profilNamaKdarurat = obj.getProfil_nama_kdarurat();
		this.profilNoTelpKdarurat = obj.getProfil_no_telp_kdarurat();
		this.profilAlamatKdarurat = obj.getProfil_alamat_kdarurat();
		this.profilLock = obj.getProfil_lock();
		this.profilDeleteable = obj.getProfil_deleteable();
		this.profilActivedate = obj.getProfil_activedate();
		this.profilExpiredate = obj.getProfil_expiredate();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="profil_id", unique=true, nullable=false, length=23)
	private String profilId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at", nullable=false)
	private Date createdAt;

	@Column(name="created_by", nullable=false, length=255)
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="profil_activedate")
	private Date profilActivedate;

	@Column(name="profil_agama", nullable=false, length=255)
	private String profilAgama;

	@Column(name="profil_alamat", nullable=false, length=255)
	private String profilAlamat;

	@Column(name="profil_alamat_kdarurat", nullable=false, length=255)
	private String profilAlamatKdarurat;

	@Column(name="profil_deleteable", nullable=false)
	private byte profilDeleteable;

	@Column(name="profil_desc", length=255)
	private String profilDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="profil_expiredate")
	private Date profilExpiredate;

	@Column(name="profil_formasi", nullable=false, length=255)
	private String profilFormasi;

	@Column(name="profil_jabatan", nullable=false, length=255)
	private String profilJabatan;

	@Column(name="profil_jenis_kelamin", nullable=false)
	private byte profilJenisKelamin;

	@Column(name="profil_lock", nullable=false)
	private byte profilLock;

	@Column(name="profil_nama", nullable=false, length=100)
	private String profilNama;

	@Column(name="profil_nama_kdarurat", nullable=false, length=50)
	private String profilNamaKdarurat;

	@Column(name="profil_nama_panggilan", length=100)
	private String profilNamaPanggilan;

	@Column(name="profil_nip", nullable=false, length=10)
	private String profilNip;

	@Column(name="profil_no_ktp", nullable=false, length=16)
	private String profilNoKtp;

	@Column(name="profil_no_npwp", nullable=false, length=255)
	private String profilNoNpwp;

	@Column(name="profil_nama_bank", nullable=false, length=100)
	private String profilNamaBank;

	@Column(name="profil_no_rek", nullable=false, length=255)
	private String profilNoRek;

	@Column(name="profil_no_telp", nullable=false, length=50)
	private String profilNoTelp;

	@Column(name="profil_no_telp_kdarurat", nullable=false, length=50)
	private String profilNoTelpKdarurat;

	@Column(name="profil_status_menikah", nullable=false)
	private byte profilStatusMenikah;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="profil_tgl_lahir", nullable=false)
	private Date profilTglLahir;

	@Column(name="profil_tmp_lahir", nullable=false, length=255)
	private String profilTmpLahir;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="updated_by", length=255)
	private String updatedBy;

	//bi-directional many-to-one association to ThosKeluarga
	@OneToMany(mappedBy="thosProfil")
	private List<ThosKeluarga> thosKeluargas;

	/********** Setter Getter **********/
	public String getProfilId() {
		return this.profilId;
	}
	public void setProfilId(String profilId) {
		this.profilId = profilId;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getProfilActivedate() {
		return this.profilActivedate;
	}
	public void setProfilActivedate(Date profilActivedate) {
		this.profilActivedate = profilActivedate;
	}

	public String getProfilAgama() {
		return this.profilAgama;
	}
	public void setProfilAgama(String profilAgama) {
		this.profilAgama = profilAgama;
	}

	public String getProfilAlamat() {
		return this.profilAlamat;
	}
	public void setProfilAlamat(String profilAlamat) {
		this.profilAlamat = profilAlamat;
	}

	public String getProfilAlamatKdarurat() {
		return this.profilAlamatKdarurat;
	}
	public void setProfilAlamatKdarurat(String profilAlamatKdarurat) {
		this.profilAlamatKdarurat = profilAlamatKdarurat;
	}

	public byte getProfilDeleteable() {
		return this.profilDeleteable;
	}
	public void setProfilDeleteable(byte profilDeleteable) {
		this.profilDeleteable = profilDeleteable;
	}

	public String getProfilDesc() {
		return this.profilDesc;
	}
	public void setProfilDesc(String profilDesc) {
		this.profilDesc = profilDesc;
	}

	public Date getProfilExpiredate() {
		return this.profilExpiredate;
	}
	public void setProfilExpiredate(Date profilExpiredate) {
		this.profilExpiredate = profilExpiredate;
	}

	public String getProfilFormasi() {
		return this.profilFormasi;
	}
	public void setProfilFormasi(String profilFormasi) {
		this.profilFormasi = profilFormasi;
	}

	public String getProfilJabatan() {
		return this.profilJabatan;
	}
	public void setProfilJabatan(String profilJabatan) {
		this.profilJabatan = profilJabatan;
	}

	public byte getProfilJenisKelamin() {
		return this.profilJenisKelamin;
	}
	public void setProfilJenisKelamin(byte profilJenisKelamin) {
		this.profilJenisKelamin = profilJenisKelamin;
	}

	public byte getProfilLock() {
		return this.profilLock;
	}
	public void setProfilLock(byte profilLock) {
		this.profilLock = profilLock;
	}

	public String getProfilNama() {
		return this.profilNama;
	}
	public void setProfilNama(String profilNama) {
		this.profilNama = profilNama;
	}

	public String getProfilNamaKdarurat() {
		return this.profilNamaKdarurat;
	}
	public void setProfilNamaKdarurat(String profilNamaKdarurat) {
		this.profilNamaKdarurat = profilNamaKdarurat;
	}

	public String getProfilNamaPanggilan() {
		return this.profilNamaPanggilan;
	}
	public void setProfilNamaPanggilan(String profilNamaPanggilan) {
		this.profilNamaPanggilan = profilNamaPanggilan;
	}

	public String getProfilNip() {
		return this.profilNip;
	}
	public void setProfilNip(String profilNip) {
		this.profilNip = profilNip;
	}

	public String getProfilNoKtp() {
		return this.profilNoKtp;
	}
	public void setProfilNoKtp(String profilNoKtp) {
		this.profilNoKtp = profilNoKtp;
	}

	public String getProfilNoNpwp() {
		return this.profilNoNpwp;
	}
	public void setProfilNoNpwp(String profilNoNpwp) {
		this.profilNoNpwp = profilNoNpwp;
	}

	public String getProfilNamaBank() {
		return this.profilNamaBank;
	}
	public void setProfilNamaBank(String profilNamaBank) {
		this.profilNamaBank = profilNamaBank;
	}

	public String getProfilNoRek() {
		return this.profilNoRek;
	}
	public void setProfilNoRek(String profilNoRek) {
		this.profilNoRek = profilNoRek;
	}

	public String getProfilNoTelp() {
		return this.profilNoTelp;
	}
	public void setProfilNoTelp(String profilNoTelp) {
		this.profilNoTelp = profilNoTelp;
	}

	public String getProfilNoTelpKdarurat() {
		return this.profilNoTelpKdarurat;
	}
	public void setProfilNoTelpKdarurat(String profilNoTelpKdarurat) {
		this.profilNoTelpKdarurat = profilNoTelpKdarurat;
	}

	public byte getProfilStatusMenikah() {
		return this.profilStatusMenikah;
	}
	public void setProfilStatusMenikah(byte profilStatusMenikah) {
		this.profilStatusMenikah = profilStatusMenikah;
	}

	public Date getProfilTglLahir() {
		return this.profilTglLahir;
	}
	public void setProfilTglLahir(Date profilTglLahir) {
		this.profilTglLahir = profilTglLahir;
	}

	public String getProfilTmpLahir() {
		return this.profilTmpLahir;
	}
	public void setProfilTmpLahir(String profilTmpLahir) {
		this.profilTmpLahir = profilTmpLahir;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public List<ThosKeluarga> getThosKeluargas() {
		return this.thosKeluargas;
	}
	public void setThosKeluargas(List<ThosKeluarga> thosKeluargas) {
		this.thosKeluargas = thosKeluargas;
	}

	public ThosKeluarga addThosKeluarga(ThosKeluarga thosKeluarga) {
		getThosKeluargas().add(thosKeluarga);
		thosKeluarga.setThosProfil(this);

		return thosKeluarga;
	}
	public ThosKeluarga removeThosKeluarga(ThosKeluarga thosKeluarga) {
		getThosKeluargas().remove(thosKeluarga);
		thosKeluarga.setThosProfil(null);

		return thosKeluarga;
	}

}