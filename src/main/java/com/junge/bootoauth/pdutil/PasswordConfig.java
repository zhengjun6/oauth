package com.junge.bootoauth.pdutil;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
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
		 StringBuffer result = new StringBuffer();
		 Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		    md5.setEncodeHashAsBase64(true);
		    result.append(md5.encodePassword(rawPass, salt));
		    return result.toString();
//		 return PasswordUtil.encodePassword("MD5", rawPass, salt);
	}

	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
		// TODO Auto-generated method stub
		StringBuffer result = new StringBuffer();
		 Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		    md5.setEncodeHashAsBase64(true);
		    result.append(md5.encodePassword(rawPass, salt));
		    if(encPass.equals(result.toString()))
		    	return true;
		    return false;
		
//		 return PasswordUtil.decodePassword(encPass, rawPass, salt);
	}

}
