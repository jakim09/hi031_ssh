package com.hi031.shh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hi031.shh.domain.Coupon;
import com.hi031.shh.domain.Link;
import com.hi031.shh.repository.CouponRepository;
import com.hi031.shh.repository.LinkRepository;

@Service
public class ShhImpl implements ShhFacade {
	@Autowired
	private CouponRepository couponRepo;

	@Autowired
	private LinkRepository linkRepo;
	
	@Override
	public Coupon insertCoupon(Coupon coupon) {
		Coupon newCoupon = couponRepo.save(coupon);
		return newCoupon;
	}

	@Override
	public Coupon updateCoupon(Coupon coupon) {
		Coupon updateCoupon = couponRepo.save(coupon);
		return updateCoupon;
	}

	@Override
	public void removeCoupon(Coupon coupon) {
		couponRepo.delete(coupon);
	}

	@Override
	public Coupon getCoupon(int couponId) {
		Optional<Coupon> result = couponRepo.findById(couponId);
		
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Coupon> getCoupons(int storeId) {
		return couponRepo.findByStoreId(storeId);
	}

	@Override
	public long getCount(int storeId) {
		return couponRepo.countByStoreId(storeId);
	}

	@Override
	public Link insertLink(Link link) {
		Link newLink = linkRepo.save(link);
		return newLink;
	}
	
	@Override
	public Link updateLink(Link link) {
		Link updateLink = linkRepo.save(link);
		return updateLink;
	}

	public void removeLink(int linkId) {
		linkRepo.deleteById(linkId);
	}
	
	@Override
	public Link getLink(int proposerId, int receiverId) {
		return linkRepo.findByProposerIdAndReceiverId(proposerId, receiverId);
	}
	
	@Override
	public List<Link> getLinks(int storeId) {
		return (List<Link>) linkRepo.findAll(Sort.by(Sort.Direction.DESC, "linkid"));
	}
	
	@Override
	public List<Link> getLinksByReceiver(int receiverId) {
		return (List<Link>) linkRepo.findAll(Sort.by(Sort.Direction.DESC, "receiverId"));
	}
	
	@Override
	public List<Link> getLinksByProposer(int proposerId) {
		return (List<Link>) linkRepo.findAll(Sort.by(Sort.Direction.DESC, "proposerId"));
	}
	
	@Override
	public long countByProposerId(int proposerId) {
		return linkRepo.countByProposerId(proposerId);
	}

}
