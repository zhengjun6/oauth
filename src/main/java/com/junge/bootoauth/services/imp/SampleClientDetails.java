package com.junge.bootoauth.services.imp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import com.junge.bootoauth.entity.ClientDetail;



public class SampleClientDetails implements ClientDetails {

	 ClientDetail clientDetail;

	  public SampleClientDetails(ClientDetail clientDetail) {
	    this.clientDetail = clientDetail;
	  }
	
	@Override
	public String getClientId() {
		// TODO Auto-generated method stub
		return clientDetail.getClient_id();
	}

	@Override
	public Set<String> getResourceIds() {
		// TODO Auto-generated method stub
		String resids=clientDetail.getResource_ids();
	    if(resids!=null){
	    	Set<String> s=new HashSet<>();
	    	String[] re=resids.split(",");
	    	for(int i=0;i<re.length;i++){
	    		s.add(re[i]);
	    	}
	    	return s;
//	      return Stream.of(resids.split(",")).collect(Collectors.toSet());
	    }
	    return null;
	}

	@Override
	public boolean isSecretRequired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getClientSecret() {
		// TODO Auto-generated method stub
		return clientDetail.getClient_secret();
	}

	@Override
	public boolean isScoped() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Set<String> getScope() {
		// TODO Auto-generated method stub
		String scope=clientDetail.getScope();
	    if(scope!=null){
	 	    	Set<String> s=new HashSet<>();
	 	    	String[] re=scope.split(",");
	 	    	for(int i=0;i<re.length;i++){
	 	    		s.add(re[i]);
	 	    	}
	 	    	return s;
	    }
	    return null;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		// TODO Auto-generated method stub
		  String grantype=clientDetail.getAuthorized_grant_types();
		    if(grantype!=null){
//		      return Stream.of(grantype.split(",")).collect(Collectors.toSet());
		    	Set<String> s=new HashSet<>();
	 	    	String[] re=grantype.split(",");
	 	    	for(int i=0;i<re.length;i++){
	 	    		s.add(re[i]);		 
	 	    		}
	 	    	return s;
}
		    return null;
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		 List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		    auths.add(new GrantedAuthority() {
		      private static final long serialVersionUID = 1L;

		      @Override
		      public String getAuthority() {
		        return "USER";
		      }
		    });
		    return auths;
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return clientDetail.getAccess_token_validity();
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return clientDetail.getRefresh_token_validity();
	}

	@Override
	public boolean isAutoApprove(String scope) {
		// TODO Auto-generated method stub
		 if(scope!=null && scope.equals(clientDetail.getAutoapprove())){
		      return true;
		    }
		    return false;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		// TODO Auto-generated method stub
		return null;
	}

}
