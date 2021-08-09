package com.hi031.shh.service;

import java.util.List;

import com.hi031.shh.domain.Coupon;

public interface ShhFacade {
	Coupon insertCoupon(Coupon coupon);
	Coupon updateCoupon(Coupon coupon);
	void removeCoupon(Coupon coupon);
	Coupon getCoupon(int couponId);
	List<Coupon> getCoupons(int storeId);
	long getCount(int storeId);
}
