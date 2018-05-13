package com.junge.bootoauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junge.bootoauth.entity.User;
import com.junge.bootoauth.services.UserSerivices;

@RestController
public class ResorcesUi {
	@Autowired
	UserSerivices services;
	@RequestMapping("/zjoauth/haha")
	public String zjTest(){
		
		System.err.println("++++++++++++++++++++");
		return "zjoauth2";
	}
	
	@RequestMapping("/select")
	public List<User> select(){
		
		System.err.println("++++++++++++++++++++");
		return services.selectAll();
	}
}
