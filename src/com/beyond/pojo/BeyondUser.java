package com.beyond.pojo;

import java.sql.Timestamp;

/**
 * BeyondsUser entity. @author MyEclipse Persistence Tools
 */

public class BeyondUser implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userLogin;
	private String userName;
	private String userPassword;
	private String createUser;
	private Timestamp createTime;
	private String logins;
	private Integer status;

	// Constructors

	/** default constructor */
	public BeyondUser() {
	}

	/** minimal constructor */
	public BeyondUser(String userLogin, String userName, String userPassword,
			String createUser, Timestamp createTime, Integer status) {
		this.userLogin = userLogin;
		this.userName = userName;
		this.userPassword = userPassword;
		this.createUser = createUser;
		this.createTime = createTime;
		this.status = status;
	}

	/** full constructor */
	public BeyondUser(String userLogin, String userName, String userPassword,
			String createUser, Timestamp createTime, String logins,
			Integer status) {
		this.userLogin = userLogin;
		this.userName = userName;
		this.userPassword = userPassword;
		this.createUser = createUser;
		this.createTime = createTime;
		this.logins = logins;
		this.status = status;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserLogin() {
		return this.userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
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

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getLogins() {
		return this.logins;
	}

	public void setLogins(String logins) {
		this.logins = logins;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}