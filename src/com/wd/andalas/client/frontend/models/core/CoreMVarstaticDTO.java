package com.wd.andalas.client.frontend.models.core;

import java.io.Serializable;
import java.util.Date;

import com.wd.andalas.server.backend.models.core.CoreMVarstatic;

public class CoreMVarstaticDTO implements Serializable {

	/********** Inisiasi **********/
	private static final long serialVersionUID = 1L;
	private String varstat_id;
	private Date created_at;
	private String created_by;
	private Date updated_at;
	private String updated_by;
	private String varstat_desc;
	private String varstat_name;
	private Integer varstat_seq;
	private String varstat_group;
	private String varstat_parentid;
	private String varstat_icon;
	private Byte varstat_lock;
	private Byte varstat_deleteable;
	private Date varstat_activedate;
	private Date varstat_expiredate;

	/********** Main Methods **********/
	public CoreMVarstaticDTO() { }

	// Just copy the fields from server side class to CoreMVarstaticDTO (client side)
	public CoreMVarstaticDTO(CoreMVarstatic obj) {
		super();
		this.varstat_id = obj.getVarstatId();
		this.created_at = obj.getCreatedAt();
		this.created_by = obj.getCreatedBy();
		this.updated_at = obj.getUpdatedAt();
		this.updated_by = obj.getUpdatedBy();
		this.varstat_activedate = obj.getVarstatActivedate();
		this.varstat_deleteable = obj.getVarstatDeleteable();
		this.varstat_desc = obj.getVarstatId();
		this.varstat_expiredate = obj.getVarstatExpiredate();
		this.varstat_group = obj.getVarstatDesc();
		this.varstat_icon = obj.getVarstatIcon();
		this.varstat_lock = obj.getVarstatLock();
		this.varstat_name = obj.getVarstatName();
		this.varstat_parentid = obj.getVarstatId();
		this.varstat_seq = obj.getVarstatSeq();
	}

	/********** Setter Getter **********/
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

	public Integer getVarstat_seq() {
		return varstat_seq;
	}
	public void setVarstat_seq(Integer varstat_seq) {
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

	public Byte getVarstat_lock() {
		return varstat_lock;
	}
	public void setVarstat_lock(Byte varstat_lock) {
		this.varstat_lock = varstat_lock;
	}

	public Byte getVarstat_deleteable() {
		return varstat_deleteable;
	}
	public void setVarstat_deleteable(Byte varstat_deleteable) {
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
