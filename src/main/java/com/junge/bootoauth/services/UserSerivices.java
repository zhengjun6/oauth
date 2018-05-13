package com.junge.bootoauth.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.junge.bootoauth.entity.User;

@Transactional(rollbackFor=Exception.class)
public interface UserSerivices {
	List<User> selectAll();
}
