package com.hi031.shh.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
//@Table(uniqueConstraints=@UniqueConstraint(columnNames={"itemId","userId"}))
@Getter
@Setter
public class Coupon implements Serializable{
	@Id
	@Column(name="coupon_id")
//	@SequenceGenerator(name="COUPONID_SEQ_GEN", sequenceName="COUPONID_SEQ", initialValue=1, allocationSize=1)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COUPONID_SEQ_GEN")
	private int couponId;
	
	@Column(name="store_id")
	private int storeId;
	
	private String name;
	
	private String description;
	
	private int validity;
	
	@Column(name="is_available")
	private boolean available;
	
	@Column(name="start_date")
	private String startDate;
	
	@Column(name="finish_date")
	private String finishDate;
	
	public Coupon() {}

	public Coupon(int couponId, int storeId, String name, String description, int validity, boolean available,
			String startDate, String finishDate) {
		super();
		this.couponId = couponId;
		this.storeId = storeId;
		this.name = name;
		this.description = description;
		this.validity = validity;
		this.available = available;
		this.startDate = startDate;
		this.finishDate = finishDate;
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
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
