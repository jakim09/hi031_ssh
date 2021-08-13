package com.hi031.shh.service;

import java.util.List;

import com.hi031.shh.domain.Coupon;
import com.hi031.shh.domain.Store;

public interface ShhFacade {
	Coupon insertCoupon(Coupon coupon);
	Coupon updateCoupon(Coupon coupon);
	void removeCoupon(Coupon coupon);
	Coupon getCoupon(int couponId);
	List<Coupon> getCoupons(int storeId);
	long getCount(int storeId);
	
	Store insertStore(Store store);
	Store updateStore(Store store);
	void removeStore(Store store);
	Store getStore(int storeId);
	List<Store> getMyStores(String businessUserId);
	List<Store> getAllStores();
	List<Store> getStoresByName(int type, String keyword, int start, int end);
	List<Store> getStoresByMainCategory(int type, String keyword, int start, int end);
	List<Store> getStoresBySubCategory(int type, String keyword, int start, int end);
	List<Store> getStoresByLocation(int type, String keyword, int start, int end);
	long getMyStoreCount(String businessUserId);

	}
