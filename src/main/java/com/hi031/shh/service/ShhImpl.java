package com.hi031.shh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hi031.shh.domain.BusinessAccount;
import com.hi031.shh.domain.ConsumerAccount;
import com.hi031.shh.domain.Coupon;
import com.hi031.shh.domain.Link;
import com.hi031.shh.repository.CouponRepository;
import com.hi031.shh.repository.LinkRepository;
import com.hi031.shh.repository.BusinessAccountRepository;
import com.hi031.shh.repository.ConsumerAccountRepository;

import com.hi031.shh.domain.Store;
import com.hi031.shh.mapper.StoreMapper;
import com.hi031.shh.repository.CouponRepository;
import com.hi031.shh.repository.StoreRepository;

@Service
public class ShhImpl implements ShhFacade {
	@Autowired
	private BusinessAccountRepository businessAccountRepo;
	@Autowired
	private ConsumerAccountRepository consumerAccountRepo;
	@Autowired
	private CouponRepository couponRepo;
	
	@Autowired
	private StoreRepository storeRepo;
	@Autowired
	private StoreMapper storeMapper;

	@Override
	public BusinessAccount businessLogin(String businessUserId, String password) {
		Optional<BusinessAccount> result = businessAccountRepo.findByBusinessUserIdAndPassword(businessUserId, password);
		
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	@Override
	public BusinessAccount insertBusinessAccount(BusinessAccount businessAccount) {
		return businessAccountRepo.save(businessAccount);
	}

	@Override
	public String findBusinessUserId(String name, String email) {
		Optional<BusinessAccount> result = businessAccountRepo.findByNameAndEmail(name, email);

		if (result.isPresent()) {
			return result.get().getBusinessUserId();
		} else {
			return null;
		}
	}

	@Override
	public BusinessAccount findBusinessPw(String businessUserId, String email) {
		Optional<BusinessAccount> result = businessAccountRepo.findByBusinessUserIdAndEmail(businessUserId, email);

		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	@Override
	public BusinessAccount getBusinessAccount(String businessUserId) {
		Optional<BusinessAccount> result = businessAccountRepo.findByBusinessUserId(businessUserId);
		
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	@Override
	public BusinessAccount updateBusinessAccount(BusinessAccount businessAccount) {
		return businessAccountRepo.save(businessAccount);
	}

	@Override
	public BusinessAccount removeBusinessAccount(BusinessAccount businessAccount) {
		businessAccount.setState(2);

		return businessAccountRepo.save(businessAccount);
	}

	@Override
	public ConsumerAccount consumerLogin(String consumerUserId, String password) {
		Optional<ConsumerAccount> result = consumerAccountRepo.findByConsumerUserIdAndPassword(consumerUserId, password);
		
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	@Override
	public ConsumerAccount insertConsumerAccount(ConsumerAccount consumerAccount) {
		return consumerAccountRepo.save(consumerAccount);
	}

	@Override
	public String findConsumerUserId(String name, String email) {
		Optional<ConsumerAccount> result = consumerAccountRepo.findByNameAndEmail(name, email);

		if (result.isPresent()) {
			return result.get().getConsumerUserId();
		} else {
			return null;
		}
	}

	@Override
	public ConsumerAccount findConsumerPw(String consumerUserId, String email) {
		Optional<ConsumerAccount> result = consumerAccountRepo.findByConsumerUserIdAndEmail(consumerUserId, email);

		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	@Override
	public ConsumerAccount getConsumerAccount(String consumerUserId) {
		Optional<ConsumerAccount> result = consumerAccountRepo.findByConsumerUserId(consumerUserId);	
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	@Autowired
	private LinkRepository linkRepo;
	
	@Override
	public ConsumerAccount updateConsumerAccount(ConsumerAccount consumerAccount) {
		return consumerAccountRepo.save(consumerAccount);
	}

	@Override
	public ConsumerAccount removeConsumerAccount(ConsumerAccount consumerAccount) {
		consumerAccount.setState(2);
		
		return consumerAccountRepo.save(consumerAccount);
	}
	
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

  public Store insertStore(Store store) {
		Store newStore = storeRepo.save(store);
		return newStore;
	}

	@Override
	public Store updateStore(Store store) {
		Store updateStore = storeRepo.save(store);
		return updateStore;
	}

	@Override
	public void removeStore(Store store) {
		storeRepo.delete(store);
	}

	@Override
	public Store getStore(int storeId) {
		Optional<Store> result = storeRepo.findById(storeId);
		
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Store> getMyStores(String businessUserId) {
		return storeRepo.findByBusinessUserId(businessUserId);
	}

	@Override
	public List<Store> getAllStores() {
		return (List<Store>) storeRepo.findAll();
	}

	@Override
	public List<Store> getStoresByName(int type, String keyword, int start, int end) {
		return storeMapper.getStoresByName(keyword, start, end);
	}

	@Override
	public List<Store> getStoresByMainCategory(int type, String keyword, int start, int end) {
		return storeMapper.getStoresByMainCategory(keyword, start, end);
	}

	@Override
	public List<Store> getStoresBySubCategory(int type, String keyword, int start, int end) {
		return storeMapper.getStoresBySubCategory(keyword, start, end);
	}

	@Override
	public List<Store> getStoresByLocation(int type, String keyword, int start, int end) {
		return storeMapper.getStoresByLocation(keyword, start, end);
	}

	@Override
	public long getMyStoreCount(String businessUserId) {
		return storeRepo.countByBusinessUserId(businessUserId);
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
