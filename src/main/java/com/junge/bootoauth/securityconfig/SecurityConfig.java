package com.junge.bootoauth.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.junge.bootoauth.pdutil.PasswordConfig;
import com.junge.bootoauth.pdutil.SaltConfig;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
    UserDetailsService userDetailsService;
	@Autowired
	PasswordConfig pd;
	@Autowired
	SaltConfig salt;
	 @Bean
	    @Override
	    protected UserDetailsService userDetailsService(){
	        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	        manager.createUser(User.withUsername("user_1").password("123456").authorities("USER").build());
	        manager.createUser(User.withUsername("user_2").password("123456").authorities("USER").build());
	        return manager;
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	
	    	http.authorizeRequests()
//	    	  .antMatchers("/**").permitAll()//spring security对路径不拦截
              .anyRequest().authenticated()//所有请求需要认证即登录后才能访问
              .and()
              .formLogin()
              .permitAll()
              .and()
          .logout()
              .permitAll();
	        // @formatter:on
	    }
	    
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    	DaoAuthenticationProvider au=new DaoAuthenticationProvider();
	    	au.setUserDetailsService(userDetailsService);
	    	au.setPasswordEncoder(pd);
	    	au.setSaltSource(salt);
	    	auth.authenticationProvider(au);
//	    	auth.userDetailsService(userDetailsService);
	    }
	    
//	    @Override
//	    public void configure(WebSecurity web) throws Exception {
////	      String ignoring = env.getProperty("msi.auth.ignoring","/health|/info");
//	      web.ignoring().antMatchers("/**");
//	    }

}
