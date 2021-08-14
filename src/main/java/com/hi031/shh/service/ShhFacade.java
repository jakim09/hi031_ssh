package com.hi031.shh.service;

import java.util.List;

import com.hi031.shh.domain.BusinessAccount;
import com.hi031.shh.domain.ConsumerAccount;
import com.hi031.shh.domain.Coupon;

public interface ShhFacade {
	BusinessAccount businessLogin(String businessUserId, String password);
	BusinessAccount insertBusinessAccount(BusinessAccount businessAccount);
	String findBusinessUserId(String name, String email);
	BusinessAccount findBusinessPw(String businessUserId, String email);
	BusinessAccount getBusinessAccount(String businessUserId);
	BusinessAccount updateBusinessAccount(BusinessAccount businessAccount);
	BusinessAccount removeBusinessAccount(BusinessAccount businessAccount);

	ConsumerAccount consumerLogin(String consumerUserId, String password);
	ConsumerAccount insertConsumerAccount(ConsumerAccount consumerAccount);
	String findConsumerUserId(String name, String email);
	ConsumerAccount findConsumerPw(String consumerUserId, String email);
	ConsumerAccount getConsumerAccount(String consumerUserId);
	ConsumerAccount updateConsumerAccount(ConsumerAccount consumerAccount);
	ConsumerAccount removeConsumerAccount(ConsumerAccount consumerAccount);
	
	Coupon insertCoupon(Coupon coupon);
	Coupon updateCoupon(Coupon coupon);
	void removeCoupon(Coupon coupon);
	Coupon getCoupon(int couponId);
	List<Coupon> getCoupons(int storeId);
	long getCount(int storeId);
	
}
