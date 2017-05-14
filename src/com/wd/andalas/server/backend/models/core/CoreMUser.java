package com.wd.andalas.server.backend.models.core;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.wd.andalas.client.frontend.models.core.CoreMUserDTO;

/**
 * The persistent class for the core_m_varstatic database table.
 *
 */
@Entity
@Table(name = "core_m_user")
@NamedQuery(name = "CoreMUser.findAll", query = "SELECT c FROM CoreMUser c")
public class CoreMUser implements Serializable {

	/********** Inisiasi **********/
	private static final long serialVersionUID = 1L;

	/********** Main Methods **********/
	public CoreMUser() { }

	// Just copy the fields from CoreMVarstaticDTO (client side) to this server side class
	public CoreMUser(CoreMUserDTO obj) {
		this.userId = obj.getUser_id();
		this.createdAt = obj.getCreated_at();
		this.createdBy = obj.getCreated_by();
		this.updatedAt = obj.getUpdated_at();
		this.updatedBy = obj.getUpdated_by();
		this.userActivedate = obj.getUser_activedate();
		this.userAvatar = obj.getUser_avatar();
		this.userDeleteable = obj.getUser_deleteable();
		this.userDesc = obj.getUser_desc();
		this.userEmail = obj.getUser_email();
		this.userExpiredate = obj.getUser_expiredate();
		this.userFAnswer = obj.getUser_f_answer();
		this.userFQuestion = obj.getUser_f_question();
		this.userLock = obj.getUser_lock();
		this.userName = obj.getUser_name();
		this.userPassword = obj.getUser_password();
		this.varstatId = obj.getVarstat_id();
		this.coreMUserRoles = obj.getCoreMUserRoles();
	}

	@Id
	@GenericGenerator(name="custom_id_generator_muser", strategy="com.wd.andalas.server.backend.models.core.CoreMUserIdGenerator")
	@GeneratedValue(generator="custom_id_generator_muser")
	@Column(name="user_id", unique=true, nullable=false, length=23)
	private String userId;

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

	@Temporal(TemporalType.DATE)
	@Column(name="user_activedate")
	private Date userActivedate;

	@Column(name="user_avatar", length=255)
	private String userAvatar;

	@Column(name="user_deleteable", nullable=false)
	private byte userDeleteable;

	@Column(name="user_desc", length=255)
	private String userDesc;

	@Column(name="user_email", nullable=false, length=255)
	private String userEmail;

	@Temporal(TemporalType.DATE)
	@Column(name="user_expiredate")
	private Date userExpiredate;

	@Column(name="user_f_answer", nullable=false, length=255)
	private String userFAnswer;

	@Column(name="user_f_question", length=255)
	private String userFQuestion;

	@Column(name="user_lock", nullable=false)
	private byte userLock;

	@Column(name="user_name", nullable=false, length=255)
	private String userName;

	@Column(name="user_password", nullable=false, length=64)
	private String userPassword;

	@Column(name="varstat_id", nullable=false, length=23)
	private String varstatId;

	//bi-directional many-to-one association to CoreMUserRole
	@OneToMany(mappedBy="coreMUser")
	private List<CoreMUserRole> coreMUserRoles;

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public Date getUserActivedate() {
		return this.userActivedate;
	}

	public void setUserActivedate(Date userActivedate) {
		this.userActivedate = userActivedate;
	}

	public String getUserAvatar() {
		return this.userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public byte getUserDeleteable() {
		return this.userDeleteable;
	}

	public void setUserDeleteable(byte userDeleteable) {
		this.userDeleteable = userDeleteable;
	}

	public String getUserDesc() {
		return this.userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getUserExpiredate() {
		return this.userExpiredate;
	}

	public void setUserExpiredate(Date userExpiredate) {
		this.userExpiredate = userExpiredate;
	}

	public String getUserFAnswer() {
		return this.userFAnswer;
	}

	public void setUserFAnswer(String userFAnswer) {
		this.userFAnswer = userFAnswer;
	}

	public String getUserFQuestion() {
		return this.userFQuestion;
	}

	public void setUserFQuestion(String userFQuestion) {
		this.userFQuestion = userFQuestion;
	}

	public byte getUserLock() {
		return this.userLock;
	}

	public void setUserLock(byte userLock) {
		this.userLock = userLock;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getVarstatId() {
		return this.varstatId;
	}

	public void setVarstatId(String varstatId) {
		this.varstatId = varstatId;
	}

	public List<CoreMUserRole> getCoreMUserRoles() {
		return this.coreMUserRoles;
	}

	public void setCoreMUserRoles(List<CoreMUserRole> coreMUserRoles) {
		this.coreMUserRoles = coreMUserRoles;
	}

	public CoreMUserRole addCoreMUserRole(CoreMUserRole coreMUserRole) {
		getCoreMUserRoles().add(coreMUserRole);
		coreMUserRole.setCoreMUser(this);

		return coreMUserRole;
	}

	public CoreMUserRole removeCoreMUserRole(CoreMUserRole coreMUserRole) {
		getCoreMUserRoles().remove(coreMUserRole);
		coreMUserRole.setCoreMUser(null);

		return coreMUserRole;
	}

}
