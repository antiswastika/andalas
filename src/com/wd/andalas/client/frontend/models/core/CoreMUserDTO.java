package com.wd.andalas.client.frontend.models.core;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.wd.andalas.server.backend.models.core.CoreMUser;
import com.wd.andalas.server.backend.models.core.CoreMUserRole;

public class CoreMUserDTO implements Serializable {

	/********** Inisiasi **********/
	private static final long serialVersionUID = 1L;
	
	private String user_id;
	private Date created_at;
	private String created_by;
	private Date updated_at;
	private String updated_by;
	private String user_desc;
	private String user_name;
	private String user_password;
	private String user_email;
	private String varstat_id;
	private String user_f_question;
	private String user_f_answer;
	private String user_avatar;
	private Byte user_lock;
	private Byte user_deleteable;
	private Date user_activedate;
	private Date user_expiredate;
	private List<CoreMUserRole> coreMUserRoles;

	/********** Main Methods **********/
	public CoreMUserDTO() { }

	public CoreMUserDTO(CoreMUser obj) {
		super();
		this.user_id = obj.getUserId();
		this.created_at = obj.getCreatedAt();
		this.created_by = obj.getCreatedBy();
		this.updated_at = obj.getUpdatedAt();
		this.updated_by = obj.getUpdatedBy();
		this.user_desc = obj.getUserDesc();
		this.user_name = obj.getUserName();
		this.user_password = obj.getUserPassword();
		this.user_email = obj.getUserEmail();
		this.varstat_id = obj.getVarstatId();
		this.user_f_question = obj.getUserFQuestion();
		this.user_f_answer = obj.getUserFAnswer();
		this.user_avatar = obj.getUserAvatar();
		this.user_lock = obj.getUserLock();
		this.user_deleteable = obj.getUserDeleteable();
		this.user_activedate = obj.getCreatedAt();
		this.user_expiredate = obj.getUserExpiredate();
		this.coreMUserRoles = obj.getCoreMUserRoles();
	}
	
	/********** Setter Getter **********/
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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

	public String getUser_desc() {
		return user_desc;
	}
	public void setUser_desc(String user_desc) {
		this.user_desc = user_desc;
	}

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getVarstat_id() {
		return varstat_id;
	}
	public void setVarstat_id(String varstat_id) {
		this.varstat_id = varstat_id;
	}

	public String getUser_f_question() {
		return user_f_question;
	}
	public void setUser_f_question(String user_f_question) {
		this.user_f_question = user_f_question;
	}

	public String getUser_f_answer() {
		return user_f_answer;
	}
	public void setUser_f_answer(String user_f_answer) {
		this.user_f_answer = user_f_answer;
	}

	public String getUser_avatar() {
		return user_avatar;
	}
	public void setUser_avatar(String user_avatar) {
		this.user_avatar = user_avatar;
	}

	public Byte getUser_lock() {
		return user_lock;
	}
	public void setUser_lock(Byte user_lock) {
		this.user_lock = user_lock;
	}

	public Byte getUser_deleteable() {
		return user_deleteable;
	}
	public void setUser_deleteable(Byte user_deleteable) {
		this.user_deleteable = user_deleteable;
	}

	public Date getUser_activedate() {
		return user_activedate;
	}
	public void setUser_activedate(Date user_activedate) {
		this.user_activedate = user_activedate;
	}

	public Date getUser_expiredate() {
		return user_expiredate;
	}
	public void setUser_expiredate(Date user_expiredate) {
		this.user_expiredate = user_expiredate;
	}
	
	public List<CoreMUserRole> getCoreMUserRoles() {
		return coreMUserRoles;
	}
	public void setCoreMUserRoles(List<CoreMUserRole> coreMUserRoles) {
		this.coreMUserRoles = coreMUserRoles;
	}

}
