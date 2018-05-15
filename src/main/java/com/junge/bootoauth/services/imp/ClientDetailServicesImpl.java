package com.junge.bootoauth.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import com.junge.bootoauth.dao.ClientDetailDao;
import com.junge.bootoauth.entity.ClientDetail;
@Service
@Primary
public class ClientDetailServicesImpl implements ClientDetailsService{
	
	@Autowired
	  private ClientDetailDao dao;
	
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		// TODO Auto-generated method stub
		ClientDetail client =dao.getById(clientId);
		
		 ClientDetails clientD = new SampleClientDetails(client);
		return clientD;
	}

}
