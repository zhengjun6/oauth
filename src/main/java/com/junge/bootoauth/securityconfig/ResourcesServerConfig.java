package com.junge.bootoauth.securityconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
public class ResourcesServerConfig {
	@EnableResourceServer
	@Configuration
	 protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{
		private static final String DEMO_RESOURCE_ID = "zjoauth"; 
		
		//配置
		@Override
		public void configure(HttpSecurity http) throws Exception {
			// TODO Auto-generated method stub
//			
//		     http.requestMatchers().antMatchers("/zjoauth/**")
//		        .and().authorizeRequests().anyRequest().authenticated();
			
			http
//             Since we want the protected resources to be accessible in the UI as well we need
//             session creation to be allowed (it's disabled by default in 2.0.6)
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            .and()
            .requestMatchers()
            .anyRequest()
            .and()
            .anonymous()
            .and()
            .authorizeRequests()
//            .antMatchers("/product/**").access("#oauth2.hasScope('select') and hasRole('ROLE_USER')")
            .antMatchers("/zjoauth/**").authenticated()
            ;//配置order访问控制，必须认证过后才可以访问
		}
		@Override
		public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
			// TODO Auto-generated method stub
			  resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
//			super.configure(resources);
		}
	 }
}
