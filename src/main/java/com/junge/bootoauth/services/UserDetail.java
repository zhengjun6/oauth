package com.junge.bootoauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.junge.bootoauth.dao.UserDao;

@Service
public class UserDetail implements UserDetailsService{
  @Autowired
  UserDao dao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	com.junge.bootoauth.entity.User user=dao.selectbyUsername(username);
	if(user!=null){
			return new User(username, user.getPd(), true, true, true, true,
					AuthorityUtils.NO_AUTHORITIES);}
	return null;
	

	}
//	JdbcClientDetailsService
}
