package com.wd.andalas.server.backend.models.core;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "core_m_varstatic")
public class CoreMVarstatic {

	@Id
	//@GeneratedValue(generator="increment")
	//@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "varstat_id")
	private String varstat_id;
	@Column(name = "created_at")
	private Date created_at;
	@Column(name = "created_by")
	private String created_by;
	@Column(name = "updated_at")
	private Date updated_at;
	@Column(name = "updated_by")
	private String updated_by;
	@Column(name = "varstat_desc")
	private String varstat_desc;
	@Column(name = "varstat_name")
	private String varstat_name;
	@Column(name = "varstat_seq")
	private int varstat_seq;
	@Column(name = "varstat_group")
	private String varstat_group;
	@Column(name = "varstat_parentid")
	private String varstat_parentid;
	@Column(name = "varstat_icon")
	private String varstat_icon;
	@Column(name = "varstat_lock")
	private int varstat_lock;
	@Column(name = "varstat_deleteable")
	private int varstat_deleteable;
	@Column(name = "varstat_activedate")
	private Date varstat_activedate;
	@Column(name = "varstat_expiredate")
	private Date varstat_expiredate;

	/*********************************** CONSTRUCTORS ***********************************/
	public CoreMVarstatic() {
		// this form used by Hibernate
	}

	public String getVarstat_id() {
		return varstat_id;
	}
	public void setVarstat_id(String varstat_id) {
		this.varstat_id = varstat_id;
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

	public String getVarstat_desc() {
		return varstat_desc;
	}
	public void setVarstat_desc(String varstat_desc) {
		this.varstat_desc = varstat_desc;
	}

	public String getVarstat_name() {
		return varstat_name;
	}
	public void setVarstat_name(String varstat_name) {
		this.varstat_name = varstat_name;
	}

	public int getVarstat_seq() {
		return varstat_seq;
	}
	public void setVarstat_seq(int varstat_seq) {
		this.varstat_seq = varstat_seq;
	}

	public String getVarstat_group() {
		return varstat_group;
	}
	public void setVarstat_group(String varstat_group) {
		this.varstat_group = varstat_group;
	}

	public String getVarstat_parentid() {
		return varstat_parentid;
	}
	public void setVarstat_parentid(String varstat_parentid) {
		this.varstat_parentid = varstat_parentid;
	}

	public String getVarstat_icon() {
		return varstat_icon;
	}
	public void setVarstat_icon(String varstat_icon) {
		this.varstat_icon = varstat_icon;
	}

	public int getVarstat_lock() {
		return varstat_lock;
	}
	public void setVarstat_lock(int varstat_lock) {
		this.varstat_lock = varstat_lock;
	}

	public int getVarstat_deleteable() {
		return varstat_deleteable;
	}
	public void setVarstat_deleteable(int varstat_deleteable) {
		this.varstat_deleteable = varstat_deleteable;
	}

	public Date getVarstat_activedate() {
		return varstat_activedate;
	}
	public void setVarstat_activedate(Date varstat_activedate) {
		this.varstat_activedate = varstat_activedate;
	}

	public Date getVarstat_expiredate() {
		return varstat_expiredate;
	}
	public void setVarstat_expiredate(Date varstat_expiredate) {
		this.varstat_expiredate = varstat_expiredate;
	}

}
