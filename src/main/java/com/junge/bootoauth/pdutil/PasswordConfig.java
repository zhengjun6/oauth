package com.junge.bootoauth.pdutil;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 实现MD5及加盐操作
 * @author zj
 *
 */
@Service
public class PasswordConfig implements PasswordEncoder{

	@Override
	public String encodePassword(String rawPass, Object salt) {
		// TODO Auto-generated method stub
		
		 return PasswordUtil.encodePassword("MD5", rawPass, salt);
	}

	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
		// TODO Auto-generated method stub
		 return PasswordUtil.decodePassword(encPass, rawPass, salt);
	}

}
