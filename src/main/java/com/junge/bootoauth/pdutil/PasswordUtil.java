package com.junge.bootoauth.pdutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;




public class PasswordUtil {
	 public static void md5(StringBuffer result, String password, Object salt) {
//		    result.append(PasswordType.MD5);
		    Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		    md5.setEncodeHashAsBase64(true);
		    result.append(md5.encodePassword(password, salt));
		  }
	 
	 /**
	  * 加密
	  * @param type
	  * @param password
	  * @param salt
	  * @return
	  */
	 
	 public static String encodePassword(String type, String password, Object salt) {
		    StringBuffer result = new StringBuffer();
//		    switch (type) {
//		      case "MD5":
		        md5(result, password, salt);
//		        break;
//		      case "SHA":
////		        sha(result, password, salt);
//		        break;
////		      case SHA256:
////		        sha256(result, password, salt);
////		        break;
//		      default:
//		        break;
//		    }
		    return result.toString();
		  }
	 
	 
	 /**
	  * 解密
	  * @param secretkey
	  * @param password
	  * @param salt
	  * @return
	  */
	 public static boolean decodePassword(String secretkey, String password, Object salt) {

//		    Pattern pattern = Pattern.compile("^\\{.{2,5}\\}");
//		    Matcher matcher = pattern.matcher(secretkey);
//
//		    if (matcher.find() == false) {
//		      return false;
//		    }
		    StringBuffer result = new StringBuffer();
//		    PasswordType type = PasswordType.get(matcher.group());
//		    switch(type){
//		      case "MD5":
		    md5(result, password, salt);
//		        break;
//		      case SHA:
//		        sha(result, password, salt);
//		        break;
//		      case SHA256:
//		        sha256(result, password, salt);
//		        break;
//		      default:
//		        return false;
//		    }
		    // 验证通过
		    if(result.toString().equals(secretkey)){
		      return true;
		    }
		    // String prefix = result.
		    return false;
		  }
	 
}
