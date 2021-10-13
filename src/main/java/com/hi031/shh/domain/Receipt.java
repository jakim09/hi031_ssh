package com.hi031.shh.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name="receipt", uniqueConstraints={
		@UniqueConstraint(
				columnNames={"consumer_user_id", "store_id", "receipt_date"}
			)
		})
@Getter
@Setter
public class Receipt implements Serializable {
   @Id
   @Column(name="receipt_id")
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int receiptId;
   
   @Column(name="receipt_date")
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private String receiptDate;
   
   @ManyToOne
   @JoinColumn(name="store_id")
   private Store store;
   
   @ManyToOne
   @JoinColumn(name="consumer_user_id")
   private ConsumerAccount consumerAccount;    //store.name, logoImage 사용해야 함
}