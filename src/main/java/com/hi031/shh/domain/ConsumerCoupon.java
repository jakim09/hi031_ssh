package com.hi031.shh.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
//@Table(uniqueConstraints=@UniqueConstraint(columnNames={"itemId","userId"}))
@Getter
@Setter
public class ConsumerCoupon implements Serializable{
	@Id
	@Column(name="consumer_coupon_id")
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int consumerCouponId;
	
	@ManyToOne
	@JoinColumn(name="consumer_user_id")
	private ConsumerAccount consumer;
	
	@ManyToOne
	@JoinColumn(name="coupon_id")
	private Coupon coupon;
	
	@Column(name="download_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private String downloadDate;
	
	private int state; //0:사용 가능, 1:사용완료, -1:기한 만료
	
//	public int getState() {
//		if ()
//		return -1;
//	}
	
}
