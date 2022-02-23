package com.example.lesson04.dao;

import org.apache.ibatis.annotations.Param;

public interface UserDAO {

	public String insertUser(
			@Param("name") String name,
			@Param("yyyymmdd") String yyyymmdd,
			@Param("email") String email,
			@Param("introduce") String introduce);
}
