package com.hi031.shh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hi031.shh.domain.ConsumerCoupon;
import com.hi031.shh.domain.Coupon;
import com.hi031.shh.domain.ResponseWrapper;
import com.hi031.shh.service.ShhFacade;

@RestController
@RequestMapping("/api/v1/coupon/user")
public class ConsumerCouponController {

	@Autowired
	private ShhFacade shh;
	
	private ResponseWrapper responseWrapper;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public ConsumerCoupon insertCoupon(@RequestBody ConsumerCoupon coupon) throws Exception {
		return shh.insertConsumerCoupon(coupon);
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT)
	public ConsumerCoupon updateCoupon(@RequestBody ConsumerCoupon coupon) throws Exception {
		return shh.updateConsumerCoupon(coupon);
	}

	
//	@ResponseBody
//	@RequestMapping(path="/{storeId}/{couponId}", method=RequestMethod.GET)
//	public Coupon getCoupon(@PathVariable int storeId, @PathVariable int couponId) throws Exception {
//		return shh.getCoupon(couponId);
//	}
	
//	@ResponseBody
//	@RequestMapping(path="/{storeId}", method=RequestMethod.GET)
//	public ResponseWrapper getConsumerCoupons(@PathVariable int consumerId) throws Exception {
//		List<Coupon> results = shh.getConsumerCoupons(consumerId);
//		long total = shh.getCount(consumerId);
//		
//		responseWrapper = new ResponseWrapper(total, (List<Object>)(Object)results);
//		
//		return responseWrapper;
//	}
	
}
