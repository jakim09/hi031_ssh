package com.hi031.shh.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

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
   
   @ManyToOne(cascade = {})
   @JoinColumn(name="consumer_user_id", insertable = false, updatable = false)
   private ConsumerAccount consumer;
   
   @Column(name="consumer_user_id")
   private String consumerUserId;
   
   @ManyToOne(cascade = {}, targetEntity = Coupon.class, fetch = FetchType.LAZY)
   @JoinColumn(name="coupon_id", insertable = false, updatable = false)
   @JsonIgnore
   private Coupon coupon;
   
   @Column(name="receipt_id")
   private int receiptId;
   
   @Column(name="coupon_id")
   private int couponId;
   
   @Column(name="download_date")
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   private String downloadDate;
   
   @Column(name="finish_date")
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   private String finishDate;
   
   @Column(name="use_date")
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   private String useDate;
   
   private int state; //1:사용 가능, 0:사용완료, -1:기한 만료


   public ConsumerCoupon() {
      super();
   }
   
   public ConsumerCoupon(String consumerUserId, int couponId, int receiptId, String downloadDate, String finishDate) {
	   this.downloadDate = downloadDate;
	   this.couponId = couponId;
	   this.state = 1;
	   this.receiptId = receiptId;
	   this.finishDate = finishDate;
	   this.consumerUserId = consumerUserId;
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

   public String getDownloadDate() {
      return downloadDate;
   }

   public void setDownloadDate(String downloadDate) {
      this.downloadDate = downloadDate;
   }

   public String getFinishDate() {
      return finishDate;
   }

   public void setFinishDate(String finishDate) {
      this.finishDate = finishDate;
   }

   public String getUseDate() {
      return useDate;
   }

   public void setUseDate(String useDate) {
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
   
   
   
}