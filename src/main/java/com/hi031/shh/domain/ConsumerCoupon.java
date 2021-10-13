package com.hi031.shh.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@ManyToOne(cascade = {}, targetEntity = ConsumerAccount.class, fetch = FetchType.LAZY)
	@JoinColumn(name="consumer_user_id", insertable = false, updatable = false)
	@JsonIgnore
	private ConsumerAccount consumer;
	
	@Column(name="consumer_user_id")
	private String consumerUserId;
	
	@ManyToOne(cascade = {})
	@JoinColumn(name="coupon_id", insertable = false, updatable = false)
	private Coupon coupon;
	
	@Column(name="coupon_id")
	private int couponId;
	
	@ManyToOne(cascade = {})
	@JoinColumn(name="receipt_id")
	private Receipt receipt;
	
	@Column(name="receipt_id", insertable = false, updatable = false)
	private int receiptId;
	
	@Column(name="download_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime downloadDate;
	
	@Column(name="finish_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime finishDate;
	
	@Column(name="use_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime useDate;

	private int state; //1:사용 가능, 0:사용완료, -1:기한 만료
	
	@Transient
	private int remainingDay;

	
	public ConsumerCoupon() {
		super();
	}
	
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

	public String getConsumerUserId() {
		return consumerUserId;
	}

	public void setConsumerUserId(String consumerUserId) {
		this.consumerUserId = consumerUserId;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public LocalDateTime getDownloadDate() {
		return downloadDate;
	}

	public void setDownloadDate(LocalDateTime downloadDate) {
		this.downloadDate = downloadDate;
	}

	public LocalDateTime getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDateTime finishDate) {
		this.finishDate = finishDate;
	}

	public LocalDateTime getUseDate() {
		return useDate;
	}

	public void setUseDate(LocalDateTime useDate) {
		this.useDate = useDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}
	
	public Receipt getReceipt() {
		return receipt;
	}
	
	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public int getRemainingDay() {
		return remainingDay;
	}

	public void setRemainingDay(int remainingDay) {
		this.remainingDay = remainingDay;
	}
	
	
}