package com.junge.bootoauth.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.junge.bootoauth.entity.ClientDetail;

@Mapper
public interface ClientDetailDao {
	ClientDetail getById(@Param("clientId") String clientId);
}
