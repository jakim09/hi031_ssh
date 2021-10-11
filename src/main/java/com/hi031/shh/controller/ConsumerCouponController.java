package com.hi031.shh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hi031.shh.domain.ConsumerCoupon;
import com.hi031.shh.service.ShhFacade;

@RestController
@RequestMapping("/api/v1/coupon/user")
public class ConsumerCouponController {

	@Autowired
	private ShhFacade shh;
	
//	private ResponseWrapper responseWrapper;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public ConsumerCoupon insertConsumerCoupon(@RequestBody ConsumerCoupon coupon) throws Exception {
		return shh.insertConsumerCoupon(coupon);
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT)
	public ConsumerCoupon updateConsumerCoupon(@RequestBody ConsumerCoupon coupon) throws Exception {
		return shh.updateConsumerCoupon(coupon);
	}

	
	@ResponseBody
	@RequestMapping(path="/{consumerCouponId}", method=RequestMethod.GET)
	public ConsumerCoupon getConsumerCoupon(@PathVariable int consumerCouponId) throws Exception {
		return shh.getConsumerCoupon(consumerCouponId);
	}
	
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
