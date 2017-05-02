package com.wd.andalas.server.backend.models.core;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the core_m_varstatic database table.
 *
 */
@Entity
@Table(name = "core_m_user_role")
@NamedQuery(name = "CoreMUserRole.findAll", query = "SELECT c FROM CoreMUserRole c")
public class CoreMUserRole implements Serializable {

	/********** Inisiasi **********/
	private static final long serialVersionUID = 1L;

	/********** Main Methods **********/
	public CoreMUserRole() { }

	// Just copy the fields from CoreMVarstaticDTO (client side) to this server side class
	/*public CoreMUser(CoreMUserDTO obj) {
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
	}*/

	@Id
	@GenericGenerator(name="custom_id_generator_muserrole", strategy="com.wd.andalas.server.backend.models.core.CoreMUserRoleIdGenerator")
	@GeneratedValue(generator="custom_id_generator_muserrole")
	@Column(name="urole_id", unique=true, nullable=false, length=23)
	private String uroleId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at", nullable=false)
	private Date createdAt;

	@Column(name="created_by", nullable=false, length=255)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at", nullable=false)
	private Date updatedAt;

	@Column(name="updated_by", length=255)
	private String updatedBy;

	@Column(name="varstat_id", nullable=false, length=23)
	private String varstatId;

	//bi-directional many-to-one association to CoreMUser
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private CoreMUser coreMUser;

	public String getUroleId() {
		return this.uroleId;
	}

	public void setUroleId(String uroleId) {
		this.uroleId = uroleId;
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

	public String getVarstatId() {
		return this.varstatId;
	}

	public void setVarstatId(String varstatId) {
		this.varstatId = varstatId;
	}

	public CoreMUser getCoreMUser() {
		return this.coreMUser;
	}

	public void setCoreMUser(CoreMUser coreMUser) {
		this.coreMUser = coreMUser;
	}

}
