package com.hi031.shh.service;

import java.util.List;

import com.hi031.shh.domain.BusinessAccount;
import com.hi031.shh.domain.ConsumerAccount;
import com.hi031.shh.domain.Coupon;
import com.hi031.shh.domain.Link;
import com.hi031.shh.domain.Store;

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
	Link insertLink(Link link);
	Link updateLink(Link link);
	Link getLink(BusinessAccount proposer, BusinessAccount receiver);
	List<Link> getLinks(String storeId);
	long countByProposer(BusinessAccount proposer);
	List<Link> getLinksByReceiver(BusinessAccount receiver);
	List<Link> getLinksByProposer(BusinessAccount proposer);
	void removeLink(String linkId);
	
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