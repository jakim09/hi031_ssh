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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name="consumer_coupon")
@Getter
@Setter
public class ConsumerCoupon implements Serializable{
	
	@Id
	@Column(name="consumer_coupon_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int consumerCouponId;
	
	@ManyToOne
	@JoinColumn(name="consumer_user_id", insertable = false, updatable = false)
	private ConsumerAccount consumer;
	
	@Column(name="consumer_user_id")
	private String consumerUserId;
	
	
	@ManyToOne
	@JoinColumn(name="coupon_id")
	private Coupon coupon;
	
	@Column(name="download_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private String downloadDate;
	
	private int state; //0:�궗�슜 媛��뒫, 1:�궗�슜�셿猷�, -1:湲고븳 留뚮즺
	
	@Column(name="store_id")
	private int storeId;
	
	@Column(name="receipt_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String receiptDate;
	
//		return -1;
//	}
	
	public int getConsumerCouponId() {
		return consumerCouponId;
	}

	public void setConsumerCouponId(int consumerCouponId) {
		this.consumerCouponId = consumerCouponId;
	}

	public ConsumerAccount getConsumer() {
		return consumer;
	}

	public void setConsumer(ConsumerAccount consumer) {
		this.consumer = consumer;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public String getDownloadDate() {
		return downloadDate;
	}

	public void setDownloadDate(String downloadDate) {
		this.downloadDate = downloadDate;
	}

	public String getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(String receiptDate) {
		this.receiptDate = receiptDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getConsumerUserId() {
		return consumerUserId;
	}

	public void setConsumerUserId(String consumerUserId) {
		this.consumerUserId = consumerUserId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	
}
