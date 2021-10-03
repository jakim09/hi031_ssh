package com.hi031.shh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hi031.shh.domain.BusinessAccount;
import com.hi031.shh.domain.Coupon;
import com.hi031.shh.domain.Link;
import com.hi031.shh.domain.ResponseWrapper;
import com.hi031.shh.domain.Store;
import com.hi031.shh.service.ShhFacade;

@RestController
@RequestMapping("/api/v1/link")
public class LinkController {

	@Autowired
	private ShhFacade shh;
	
	private ResponseWrapper responseWrapper;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public Link insertLink(@RequestBody Link link) throws Exception {
		System.out.println(link.getProposerId() + "&" + link.getReceiverId() + "의 연게 등록");
		return shh.insertLink(link);
	}
	
	@ResponseBody
	@RequestMapping(path="/size", method=RequestMethod.GET)
	public ResponseWrapper getSize(@RequestParam(value = "storeid", required = true) String storeId) throws Exception {
		List<Link> results = shh.getLinkAlarm(1, storeId);
		
		responseWrapper = new ResponseWrapper(results.size(), (List<Object>)(Object)results);
		
		return responseWrapper;
	}
	
	@ResponseBody
	@GetMapping("/alarm")
	public ResponseWrapper getLinkAlarm(@RequestParam(value = "storeid") String storeId) throws Exception {
		List<Link> links = shh.getLinkAlarm(1, storeId);

		responseWrapper = new ResponseWrapper(links.size(), (List<Object>)(Object)links);
		
		return responseWrapper;
	}
	
	@ResponseBody
	@PutMapping("/alarm/watched")
	public ResponseWrapper updateLinkAlarm(@RequestParam(value = "storeid") String storeId) throws Exception {
		List<Link> links = shh.getLinkAlarm(1, storeId);
		for(Link link : links) {
			link.setIsWatched(-1);
			shh.insertLink(link);
		}

		responseWrapper = new ResponseWrapper(links.size(), (List<Object>)(Object)links);
		
		return responseWrapper;
	}
	
	@ResponseBody
	@PutMapping("/alarm/return")
	public ResponseWrapper updateLinkAlarmReturn(@RequestParam(value = "storeid") String storeId) throws Exception {
		List<Link> links = shh.getLinkAlarm(-1, storeId);
		for(Link link : links) {
			link.setIsWatched(1);
			shh.insertLink(link);
		}

		responseWrapper = new ResponseWrapper(links.size(), (List<Object>)(Object)links);
		
		return responseWrapper;
	}
	
	//GET 본인 상점과 현재 연계된 다른 상점들 리스트
	@ResponseBody
	@GetMapping
	public ResponseWrapper getMyLinkList(@RequestParam(value = "store", required = true) String storeId) throws Exception {
		List<Link> results = shh.getLinks(storeId, 1, 1); //승인완료 상태, 연결 중 상태

		responseWrapper = new ResponseWrapper(results.size(), (List<Object>)(Object)results);
		
		return responseWrapper;
	}
	
	//완성
	@ResponseBody
	@PutMapping
	public Link updateLink(@RequestParam(value = "linkid") String linkId, @RequestParam(value = "state") int state,
			@RequestParam(value = "management") int management) throws Exception {
		Link link = shh.getLinkByLinkId(linkId);
		link.setState(state);
		link.setManagement(management);
		
		return shh.insertLink(link);
	}
	
	//완료
	@ResponseBody
	@RequestMapping(path="/incoming/{storeId}", method=RequestMethod.GET)
	public ResponseWrapper getIncomingLink(@PathVariable String storeId) throws Exception {
		List<Link> results = shh.getLinksByReceiverId(storeId);
		
		responseWrapper = new ResponseWrapper(results.size(), (List<Object>)(Object)results);
		
		return responseWrapper;
	}
	
	//완료
	@ResponseBody
	@RequestMapping(path="/outcoming/{storeId}", method=RequestMethod.GET)
	public ResponseWrapper getOutcomingLink(@PathVariable String storeId) throws Exception {
		List<Link> results = shh.getLinksByProposerId(storeId);
		
		responseWrapper = new ResponseWrapper(results.size(), (List<Object>)(Object)results);
		
		return responseWrapper;
	}
	
	//완성
	@ResponseBody
	@RequestMapping(path="/detail/{proposerId}/{receiverId}", method=RequestMethod.GET)
	public Link getLink(@PathVariable String proposerId, @PathVariable String receiverId) throws Exception {
		return shh.getLink(proposerId, receiverId);
	}
	
	//완성
	@ResponseBody
	@DeleteMapping()  
	  public void deleteLink(@RequestBody Link link) {  
	    shh.removeLink(link);  
	  }  
	
}
