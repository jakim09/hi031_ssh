package com.hi031.shh.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
//@Table(uniqueConstraints=@UniqueConstraint(columnNames={"itemId","userId"}))
@Getter
@Setter
public class Coupon implements Serializable {
	@Id
	@Column(name="coupon_id")
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	
}
