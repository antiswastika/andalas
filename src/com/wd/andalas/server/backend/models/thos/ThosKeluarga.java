package com.wd.andalas.server.backend.models.thos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.wd.andalas.client.frontend.models.thos.ThosKeluargaDTO;

/**
 * The persistent class for the thos_keluarga database table.
 *
 */
@Entity
@Table(name="thos_keluarga")
@NamedQuery(name="ThosKeluarga.findAll", query="SELECT t FROM ThosKeluarga t")
public class ThosKeluarga implements Serializable {

	/********** Inisiasi **********/
	private static final long serialVersionUID = 1L;

	/********** Main Methods **********/
	public ThosKeluarga() { }

	// Just copy the fields from ThosProfilDTO (client side) to this server side class
	public ThosKeluarga(ThosKeluargaDTO obj) {
		this.keluargaId = obj.getKeluarga_id();
		this.createdAt = obj.getCreated_at();
		this.createdBy = obj.getCreated_by();
		this.updatedAt = obj.getUpdated_at();
		this.updatedBy = obj.getUpdated_by();
		this.keluargaDesc = obj.getKeluarga_desc();
		this.thosProfil = obj.getThosProfil();
		this.keluargaNama = obj.getKeluarga_nama();
		this.keluargaTglLahir = obj.getKeluarga_tgl_lahir();
		this.keluargaTmpLahir = obj.getKeluarga_tmp_lahir();
		this.keluargaJenisKelamin = obj.getKeluarga_jenis_kelamin();
		this.keluargaHubungan = obj.getKeluarga_hubungan();
		this.keluargaUrutan = obj.getKeluarga_urutan();
		this.keluargaAgama = obj.getKeluarga_agama();
		this.keluargaStatusMenikah = obj.getKeluarga_status_menikah();
		this.keluargaTglMenikah = obj.getKeluarga_tgl_menikah();
		this.keluargaStatusTanggungan = obj.getKeluarga_status_tanggungan();
		this.keluargaAlamat = obj.getKeluarga_alamat();
		this.keluargaNoTelp = obj.getKeluarga_no_telp();
		this.keluargaLock = obj.getKeluarga_lock();
		this.keluargaDeleteable = obj.getKeluarga_deleteable();
		this.keluargaActivedate = obj.getKeluarga_activedate();
		this.keluargaExpiredate = obj.getKeluarga_expiredate();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="keluarga_id", unique=true, nullable=false, length=23)
	private String keluargaId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at", nullable=false)
	private Date createdAt;

	@Column(name="created_by", nullable=false, length=255)
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="keluarga_activedate")
	private Date keluargaActivedate;

	@Column(name="keluarga_agama", length=255)
	private String keluargaAgama;

	@Column(name="keluarga_alamat", length=255)
	private String keluargaAlamat;

	@Column(name="keluarga_deleteable", nullable=false)
	private byte keluargaDeleteable;

	@Column(name="keluarga_desc", length=255)
	private String keluargaDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="keluarga_expiredate")
	private Date keluargaExpiredate;

	@Column(name="keluarga_hubungan", nullable=false, length=100)
	private String keluargaHubungan;

	@Column(name="keluarga_jenis_kelamin", nullable=false)
	private byte keluargaJenisKelamin;

	@Column(name="keluarga_lock", nullable=false)
	private byte keluargaLock;

	@Column(name="keluarga_nama", nullable=false, length=100)
	private String keluargaNama;

	@Column(name="keluarga_no_telp", length=50)
	private String keluargaNoTelp;

	@Column(name="keluarga_status_menikah", nullable=false)
	private byte keluargaStatusMenikah;

	@Column(name="keluarga_status_tanggungan", nullable=false)
	private byte keluargaStatusTanggungan;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="keluarga_tgl_lahir")
	private Date keluargaTglLahir;

	@Temporal(TemporalType.DATE)
	@Column(name="keluarga_tgl_menikah")
	private Date keluargaTglMenikah;

	@Column(name="keluarga_tmp_lahir", length=255)
	private String keluargaTmpLahir;

	@Column(name="keluarga_urutan", nullable=false)
	private int keluargaUrutan;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="updated_by", length=255)
	private String updatedBy;

	//bi-directional many-to-one association to ThosProfil
	@ManyToOne
	@JoinColumn(name="profil_id", nullable=false)
	private ThosProfil thosProfil;



	/********** Setter Getter **********/
	public String getKeluargaId() {
		return this.keluargaId;
	}
	public void setKeluargaId(String keluargaId) {
		this.keluargaId = keluargaId;
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

	public Date getKeluargaActivedate() {
		return this.keluargaActivedate;
	}
	public void setKeluargaActivedate(Date keluargaActivedate) {
		this.keluargaActivedate = keluargaActivedate;
	}

	public String getKeluargaAgama() {
		return this.keluargaAgama;
	}
	public void setKeluargaAgama(String keluargaAgama) {
		this.keluargaAgama = keluargaAgama;
	}

	public String getKeluargaAlamat() {
		return this.keluargaAlamat;
	}
	public void setKeluargaAlamat(String keluargaAlamat) {
		this.keluargaAlamat = keluargaAlamat;
	}

	public byte getKeluargaDeleteable() {
		return this.keluargaDeleteable;
	}
	public void setKeluargaDeleteable(byte keluargaDeleteable) {
		this.keluargaDeleteable = keluargaDeleteable;
	}

	public String getKeluargaDesc() {
		return this.keluargaDesc;
	}
	public void setKeluargaDesc(String keluargaDesc) {
		this.keluargaDesc = keluargaDesc;
	}

	public Date getKeluargaExpiredate() {
		return this.keluargaExpiredate;
	}
	public void setKeluargaExpiredate(Date keluargaExpiredate) {
		this.keluargaExpiredate = keluargaExpiredate;
	}

	public String getKeluargaHubungan() {
		return this.keluargaHubungan;
	}
	public void setKeluargaHubungan(String keluargaHubungan) {
		this.keluargaHubungan = keluargaHubungan;
	}

	public byte getKeluargaJenisKelamin() {
		return this.keluargaJenisKelamin;
	}
	public void setKeluargaJenisKelamin(byte keluargaJenisKelamin) {
		this.keluargaJenisKelamin = keluargaJenisKelamin;
	}

	public byte getKeluargaLock() {
		return this.keluargaLock;
	}
	public void setKeluargaLock(byte keluargaLock) {
		this.keluargaLock = keluargaLock;
	}

	public String getKeluargaNama() {
		return this.keluargaNama;
	}
	public void setKeluargaNama(String keluargaNama) {
		this.keluargaNama = keluargaNama;
	}

	public String getKeluargaNoTelp() {
		return this.keluargaNoTelp;
	}
	public void setKeluargaNoTelp(String keluargaNoTelp) {
		this.keluargaNoTelp = keluargaNoTelp;
	}

	public byte getKeluargaStatusMenikah() {
		return this.keluargaStatusMenikah;
	}
	public void setKeluargaStatusMenikah(byte keluargaStatusMenikah) {
		this.keluargaStatusMenikah = keluargaStatusMenikah;
	}

	public byte getKeluargaStatusTanggungan() {
		return this.keluargaStatusTanggungan;
	}
	public void setKeluargaStatusTanggungan(byte keluargaStatusTanggungan) {
		this.keluargaStatusTanggungan = keluargaStatusTanggungan;
	}

	public Date getKeluargaTglLahir() {
		return this.keluargaTglLahir;
	}
	public void setKeluargaTglLahir(Date keluargaTglLahir) {
		this.keluargaTglLahir = keluargaTglLahir;
	}

	public Date getKeluargaTglMenikah() {
		return this.keluargaTglMenikah;
	}
	public void setKeluargaTglMenikah(Date keluargaTglMenikah) {
		this.keluargaTglMenikah = keluargaTglMenikah;
	}

	public String getKeluargaTmpLahir() {
		return this.keluargaTmpLahir;
	}
	public void setKeluargaTmpLahir(String keluargaTmpLahir) {
		this.keluargaTmpLahir = keluargaTmpLahir;
	}

	public int getKeluargaUrutan() {
		return this.keluargaUrutan;
	}
	public void setKeluargaUrutan(int keluargaUrutan) {
		this.keluargaUrutan = keluargaUrutan;
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

	public ThosProfil getThosProfil() {
		return this.thosProfil;
	}
	public void setThosProfil(ThosProfil thosProfil) {
		this.thosProfil = thosProfil;
	}

}