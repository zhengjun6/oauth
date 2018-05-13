package com.junge.bootoauth.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junge.bootoauth.dao.UserDao;
import com.junge.bootoauth.entity.User;
import com.junge.bootoauth.services.UserSerivices;
@Service
public class UserServiceImp implements UserSerivices{
	@Autowired
	private UserDao dao;
	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		
		return dao.selectAll();
	}

}
