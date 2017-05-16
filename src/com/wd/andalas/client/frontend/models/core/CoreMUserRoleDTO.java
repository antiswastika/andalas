package com.wd.andalas.client.frontend.models.core;

import java.io.Serializable;
import java.util.Date;

import com.wd.andalas.server.backend.models.core.CoreMUser;
import com.wd.andalas.server.backend.models.core.CoreMUserRole;

public class CoreMUserRoleDTO implements Serializable {

	/********** Inisiasi **********/
	private static final long serialVersionUID = 1L;
		
	private String urole_id;
	private Date created_at;
	private String created_by;
	private Date updated_at;
	private String updated_by;
	private String varstat_id;
	private CoreMUser coreMUser;

	/********** Main Methods **********/
	public CoreMUserRoleDTO() { }

	public CoreMUserRoleDTO(CoreMUserRole obj) {
		super();		
		this.urole_id = obj.getUroleId();
		this.created_at = obj.getCreatedAt();
		this.created_by = obj.getCreatedBy();
		this.updated_at = obj.getUpdatedAt();
		this.updated_by = obj.getUpdatedBy();
		this.varstat_id = obj.getVarstatId();
		this.coreMUser = obj.getCoreMUser();
	}
	
	/********** Setter Getter **********/
	public String getUrole_id() {
		return urole_id;
	}
	public void setUrole_id(String urole_id) {
		this.urole_id = urole_id;
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

	public String getVarstat_id() {
		return varstat_id;
	}
	public void setVarstat_id(String varstat_id) {
		this.varstat_id = varstat_id;
	}

	public CoreMUser getCoreMUser() {
		return coreMUser;
	}
	public void setCoreMUser(CoreMUser coreMUser) {
		this.coreMUser = coreMUser;
	}	

}
