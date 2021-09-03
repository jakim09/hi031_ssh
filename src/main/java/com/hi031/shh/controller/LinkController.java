package com.hi031.shh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hi031.shh.domain.Coupon;
import com.hi031.shh.domain.Link;
import com.hi031.shh.domain.ResponseWrapper;
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
		return shh.insertLink(link);
	}
	
	@ResponseBody
	@PutMapping("/{state}")  
	public Link updateCoupon(@PathVariable("state") int state,  
            @RequestBody Link link) throws Exception {
		link.setState(state);
		Link updated = shh.insertLink(link);
		
		return updated;
	}
	
	@ResponseBody
	@RequestMapping(path="/{proposerId}/{receiverId}", method=RequestMethod.GET)
	public List<Link> getLink(@PathVariable String proposerId, @PathVariable String receiverId) throws Exception {
		return shh.getLinksByProposer(proposerId);
	}
	
	@ResponseBody
	@RequestMapping(path="/{proposerId}", method=RequestMethod.GET)
	public ResponseWrapper getLinks(@PathVariable String proposerId) throws Exception {
		List<Link> results = shh.getLinksByProposer(proposerId);
		long total = shh.countByProposerId(proposerId);
		
		responseWrapper = new ResponseWrapper(total, (List<Object>)(Object)results);
		
		return responseWrapper;
	}
	
	@ResponseBody
	@DeleteMapping("/{linkId}")  
	  public void deleteBook(@PathVariable("linkId") String linkId) {  
	    shh.removeLink(linkId);  
	  }  
	
}
