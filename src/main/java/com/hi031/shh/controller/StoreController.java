package com.hi031.shh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hi031.shh.domain.Coupon;
import com.hi031.shh.domain.ResponseWrapper;
import com.hi031.shh.domain.Store;
import com.hi031.shh.service.ShhFacade;

@RestController
@RequestMapping("/api/v1/store")
public class StoreController {
	
	@Autowired
	private ShhFacade shh;
	private ResponseWrapper responseWrapper;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public Store insertStore(@RequestBody Store store) throws Exception {
		return shh.insertStore(store);
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT)
	public Store updateStore(@RequestBody Store store) throws Exception {
		return shh.updateStore(store);
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.DELETE)
	public void removeStore(@RequestBody Store store) throws Exception {
		shh.removeStore(store);
	}
	
	@ResponseBody
	@RequestMapping(path="/{storeId}", method=RequestMethod.GET)
	public Store getStore(@PathVariable int storeId) throws Exception {
		return shh.getStore(storeId);
	}
	
	@ResponseBody
	@RequestMapping(path="/{businessUserId}", method=RequestMethod.GET)
	public ResponseWrapper getMyStores(@PathVariable String businessUserId) throws Exception {
		List<Store> results = shh.getMyStores(businessUserId);
		long total = shh.getMyStoreCount(businessUserId);
		
		responseWrapper = new ResponseWrapper(total, (List<Object>)(Object)results);
		
		return responseWrapper;
	}

}
