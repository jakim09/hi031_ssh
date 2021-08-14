package com.hi031.shh.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class BusinessAccount implements Serializable {
	@Id
	@Column(name="business_user_id")
	private String businessUserId;
	private String password;
	private String name;
	private String email;
	@Column(name="business_num")
	private int businessNum;
	@OneToMany
	@JoinColumn(name="business_user_id")
	private List<Store> stores;
	private int state;
	
	public BusinessAccount() {}
	
	public BusinessAccount(String businessUserId, String password, String name, String email, int businessNum,
			List<Store> stores) {
		super();
		this.businessUserId = businessUserId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.businessNum = businessNum;
		this.stores = stores;
	}



	public String getBusinessUserId() {
		return businessUserId;
	}

	public void setBusinessUserId(String businessUserId) {
		this.businessUserId = businessUserId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBusinessNum() {
		return businessNum;
	}

	public void setBusinessNum(int businessNum) {
		this.businessNum = businessNum;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}

	
}
