package com.hi031.shh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hi031.shh.domain.BusinessAccount;
import com.hi031.shh.service.ShhFacade;

@RestController
public class BusinessAccountController {

	@Autowired
	private ShhFacade shh;

	// 로그인
	@ResponseBody
	@RequestMapping(value="/api/v1/businessLogin", method=RequestMethod.POST)
	public BusinessAccount businessLogin(@RequestBody String businessUserId, @RequestBody String password) throws Exception {
		BusinessAccount userSession = shh.businessLogin(businessUserId, password);
		// session 설정 (방법 생각..)
		// ...
		
		return userSession;
	}
	
	// 로그아웃
	@ResponseBody
	@RequestMapping(value="/api/v1/businessLogout", method=RequestMethod.GET)
	public BusinessAccount businessLogout(@RequestBody BusinessAccount userSession) throws Exception {
		// session 해제 (방법 생각..)
		// ...
		
		return userSession;
	}
	
	// 회원 가입
	@ResponseBody
	@RequestMapping(value="/api/v1/businessSignup", method=RequestMethod.POST)
	public BusinessAccount insertBusinessAccount(@RequestBody BusinessAccount businessAccount) throws Exception {
		return shh.insertBusinessAccount(businessAccount);
	}

	// 아이디 찾기
	@ResponseBody
	@RequestMapping(value="/api/v1/findingBusinessUserId", method=RequestMethod.POST)
	public String findUserId(@RequestBody String name, @RequestBody String email) throws Exception {
		String businessUserId = shh.findBusinessUserId(name, email);
		return businessUserId;
	}
	
	// 패스워드 찾기
	@ResponseBody
	@RequestMapping(value="/api/v1/findingBusinessPw", method=RequestMethod.GET)
	public String findUserPw(@RequestBody String businessUserId,
			@RequestBody String email) throws Exception {
		BusinessAccount result = shh.findBusinessPw(businessUserId, email);
		if (result != null) {
			// email로 임시 pw 전송
			// ...
		}
		return email;
	}

	// 회원 수정 정보 가져오기
	@ResponseBody
	@RequestMapping(path="/api/v1/businessUser", method=RequestMethod.GET)
	public BusinessAccount getBusinessAccount(@PathVariable String businessUserId) throws Exception {
		return shh.getBusinessAccount(businessUserId);
	}
	
	// 회원 수정 submit
	@ResponseBody
	@RequestMapping(value="/api/v1/businessUser", method=RequestMethod.PUT)
	public BusinessAccount updateBusinessAccount(@RequestBody BusinessAccount businessAccount) throws Exception {
		return shh.updateBusinessAccount(businessAccount);
	}
	
	// 회원 탈퇴
	@ResponseBody
	@RequestMapping(value="/api/v1/businessUser", method=RequestMethod.DELETE)
	public BusinessAccount removeBusinessAccount(@RequestBody BusinessAccount businessAccount) throws Exception {
		return shh.removeBusinessAccount(businessAccount);
	}

	
}
