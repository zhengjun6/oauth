package com.junge.bootoauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.junge.bootoauth.pdutil.PasswordConfig;
import com.junge.bootoauth.pdutil.PasswordUtil;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//@MapperScan("com.junge.bootoauth.dao")
public class App 
{
    public static void main( String[] args )
    {
//    	StringBuffer  result =new StringBuffer();
//    PasswordUtil.md5(result,"123","root");
//    System.err.println(result);
        SpringApplication.run(App.class, args);
    }
}
