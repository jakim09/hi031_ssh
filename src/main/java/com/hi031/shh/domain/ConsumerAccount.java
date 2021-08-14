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
public class ConsumerAccount implements Serializable {
	@Id
	@Column(name="consumer_user_id")
	private String consumerUserId;
	private String password;
	private String name;
	private String email;
	@OneToMany
	@JoinColumn(name="consumer_user_id")
	private List<Coupon> coupons;
	private int state;

	public ConsumerAccount() {}
	
	public ConsumerAccount(String consumerUserId, String password, String name, String email, List<Coupon> coupons) {
		super();
		this.consumerUserId = consumerUserId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.coupons = coupons;
	}

	public String getConsumerUserId() {
		return consumerUserId;
	}
	public void setConsumerUserId(String consumerUserId) {
		this.consumerUserId = consumerUserId;
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
	public List<Coupon> getCoupons() {
		return coupons;
	}
	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
