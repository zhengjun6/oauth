package com.junge.bootoauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResorcesUi {

	@RequestMapping("/zjoauth/haha")
	public String zjTest(){
		
		System.err.println("++++++++++++++++++++");
		return "zjoauth2";
	}
}
