package com.hi031.shh.service;

import java.util.List;

import com.hi031.shh.domain.Coupon;
import com.hi031.shh.domain.Link;

public interface ShhFacade {
	Coupon insertCoupon(Coupon coupon);
	Coupon updateCoupon(Coupon coupon);
	void removeCoupon(Coupon coupon);
	Coupon getCoupon(int couponId);
	List<Coupon> getCoupons(int storeId);
	long getCount(int storeId);
	Link insertLink(Link link);
	Link updateLink(Link link);
	Link getLink(int proposerId, int receiverId);
	List<Link> getLinks(int storeId);
	long countByProposerId(int proposerId);
	List<Link> getLinksByReceiver(int receiverId);
	List<Link> getLinksByProposer(int proposerId);
	void removeLink(int linkId);
}
