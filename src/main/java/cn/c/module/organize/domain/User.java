package cn.c.module.organize.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.c.core.domain.DateEntity;

@Entity
@Table(name="tab_User")
public class User extends DateEntity {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 邮箱
	 */
	private String mail;
	/**
	 * 手机
	 */
	private String telephone;
	/**
	 * 是否是管理员
	 */
	@Column(name="isAdmin")
	private boolean admin;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
