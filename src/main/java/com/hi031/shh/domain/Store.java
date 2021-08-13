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

@SuppressWarnings("serial")
@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames="store_id"))

public class Store implements Serializable {
	@Id
	@SequenceGenerator(name="STOREID_SEQ_GEN", sequenceName="STOREID_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STOREID_SEQ_GEN")
	
	@Column(name="store_id")
	private int storId;
	@Column(name="business_user_id")
	private String businessUserId;
	@Column(name="main_category_id")
	private int mainCategoryId;
	@Column(name="sub_category_id")
	private int subCategoryId;
	private String name;
	private String address1;
	private String address2;
	private String telephone;
	@Column(name="store_image1")
	private String storeImage1;
	@Column(name="storeImage2")
	private String store_image2;
	@Column(name="storeImage3")
	private String store_image3;
	@Column(name="logoImage")
	private String logo_image;
	private String introduce;
	@Column(name="short_introduce")
	private String shortIntroduce;
	public int getStorId() {
		return storId;
	}
	public void setStorId(int storId) {
		this.storId = storId;
	}
	public String getBusinessUserId() {
		return businessUserId;
	}
	public void setBusinessUserId(String businessUserId) {
		this.businessUserId = businessUserId;
	}
	public int getMainCategoryId() {
		return mainCategoryId;
	}
	public void setMainCategoryId(int mainCategoryId) {
		this.mainCategoryId = mainCategoryId;
	}
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getStoreImage1() {
		return storeImage1;
	}
	public void setStoreImage1(String storeImage1) {
		this.storeImage1 = storeImage1;
	}
	public String getStore_image2() {
		return store_image2;
	}
	public void setStore_image2(String store_image2) {
		this.store_image2 = store_image2;
	}
	public String getStore_image3() {
		return store_image3;
	}
	public void setStore_image3(String store_image3) {
		this.store_image3 = store_image3;
	}
	public String getLogo_image() {
		return logo_image;
	}
	public void setLogo_image(String logo_image) {
		this.logo_image = logo_image;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getShortIntroduce() {
		return shortIntroduce;
	}
	public void setShortIntroduce(String shortIntroduce) {
		this.shortIntroduce = shortIntroduce;
	}
	
	
}
