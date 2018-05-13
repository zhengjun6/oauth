package com.junge.bootoauth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.junge.bootoauth.entity.User;

@Mapper
public interface UserDao {
	 List<User> selectAll();
	 User selectbyUsername(@Param("name") String name);
	 
}
