package com.hi031.shh.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name="coupon")
@Getter
@Setter
public class Coupon implements Serializable {
	@Id
	@Column(name="coupon_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int couponId;
	
	@ManyToOne
	@JoinColumn(name="store_id")
	private Store store; 	//store.name, logoImage 사용해야 함

	private String name;
	
	private String description;
	
	private int validity;
	
	@Column(name="is_available")
	private boolean available;
	
	@Column(name="start_date")
	private String startDate;
	
	@Column(name="finish_date")
	private String finishDate;
	
	public Coupon() {
		super();
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}
	
	
	
	
}
