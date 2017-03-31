package com.wd.andalas.server.backend.models.core;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.wd.andalas.client.frontend.models.core.CoreMVarstaticDTO;

/**
 * The persistent class for the core_m_varstatic database table.
 *
 */
@Entity
@Table(name = "core_m_varstatic")
@NamedQuery(name = "CoreMVarstatic.findAll", query = "SELECT c FROM CoreMVarstatic c")
public class CoreMVarstatic implements Serializable {

	/********** Inisiasi **********/
	private static final long serialVersionUID = 1L;

	/********** Main Methods **********/
	public CoreMVarstatic() { }

	// Just copy the fields from CoreMVarstaticDTO (client side) to this server side class
	public CoreMVarstatic(CoreMVarstaticDTO obj) {
		this.varstatId = obj.getVarstat_id();
		this.createdAt = obj.getCreated_at();
		this.createdBy = obj.getCreated_by();
		this.updatedAt = obj.getUpdated_at();
		this.updatedBy = obj.getUpdated_by();
		this.varstatActivedate = obj.getVarstat_activedate();
		this.varstatDeleteable = obj.getVarstat_deleteable();
		this.varstatDesc = obj.getVarstat_desc();
		this.varstatExpiredate = obj.getVarstat_expiredate();
		this.varstatGroup = obj.getVarstat_group();
		this.varstatIcon = obj.getVarstat_icon();
		this.varstatLock = obj.getVarstat_lock();
		this.varstatName = obj.getVarstat_name();
		this.varstatParentid = obj.getVarstat_parentid();
		this.varstatSeq = obj.getVarstat_seq();
	}

	@Id
	@GenericGenerator(name="custom_id_generator", strategy="com.wd.andalas.server.backend.models.core.CoreMVarstaticIdGenerator")
	@GeneratedValue(generator="custom_id_generator")
	@Column(name="varstat_id", unique=true, nullable=false, length=23)
	private String varstatId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at", nullable=false)
	private Date createdAt;

	@Column(name="created_by", nullable=false, length=255)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="updated_by", length=255)
	private String updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="varstat_activedate")
	private Date varstatActivedate;

	@Column(name="varstat_deleteable", nullable=false)
	private byte varstatDeleteable;

	@Column(name="varstat_desc", length=255)
	private String varstatDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="varstat_expiredate")
	private Date varstatExpiredate;

	@Column(name="varstat_group", nullable=false, length=255)
	private String varstatGroup;

	@Column(name="varstat_icon", length=255)
	private String varstatIcon;

	@Column(name="varstat_lock", nullable=false)
	private byte varstatLock;

	@Column(name="varstat_name", nullable=false, length=255)
	private String varstatName;

	@Column(name="varstat_parentid", length=23)
	private String varstatParentid;

	@Column(name="varstat_seq", nullable=false)
	private int varstatSeq;

	/********** Setter Getter **********/
	public String getVarstatId() {
		return this.varstatId;
	}
	public void setVarstatId(String varstatId) {
		this.varstatId = varstatId;
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

	public Date getVarstatActivedate() {
		return this.varstatActivedate;
	}
	public void setVarstatActivedate(Date varstatActivedate) {
		this.varstatActivedate = varstatActivedate;
	}

	public byte getVarstatDeleteable() {
		return this.varstatDeleteable;
	}
	public void setVarstatDeleteable(byte varstatDeleteable) {
		this.varstatDeleteable = varstatDeleteable;
	}

	public String getVarstatDesc() {
		return this.varstatDesc;
	}
	public void setVarstatDesc(String varstatDesc) {
		this.varstatDesc = varstatDesc;
	}

	public Date getVarstatExpiredate() {
		return this.varstatExpiredate;
	}
	public void setVarstatExpiredate(Date varstatExpiredate) {
		this.varstatExpiredate = varstatExpiredate;
	}

	public String getVarstatGroup() {
		return this.varstatGroup;
	}
	public void setVarstatGroup(String varstatGroup) {
		this.varstatGroup = varstatGroup;
	}

	public String getVarstatIcon() {
		return this.varstatIcon;
	}
	public void setVarstatIcon(String varstatIcon) {
		this.varstatIcon = varstatIcon;
	}

	public byte getVarstatLock() {
		return this.varstatLock;
	}
	public void setVarstatLock(byte varstatLock) {
		this.varstatLock = varstatLock;
	}

	public String getVarstatName() {
		return this.varstatName;
	}
	public void setVarstatName(String varstatName) {
		this.varstatName = varstatName;
	}

	public String getVarstatParentid() {
		return this.varstatParentid;
	}
	public void setVarstatParentid(String varstatParentid) {
		this.varstatParentid = varstatParentid;
	}

	public int getVarstatSeq() {
		return this.varstatSeq;
	}
	public void setVarstatSeq(int varstatSeq) {
		this.varstatSeq = varstatSeq;
	}

}
