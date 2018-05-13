package com.junge.bootoauth.pdutil;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
public class SaltConfig implements SaltSource{

	@Override
	public Object getSalt(UserDetails user) {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

}
