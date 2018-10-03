package cn.zy.dao;

import java.sql.SQLException;

import cn.zy.model.User;

/*
 * 用户登录注册接口
 * Author:Janefane
 * */

public interface Userdao  {
	//注册方法
	 boolean userRegist(User user)throws SQLException;
	
	//登录方法
	 User userLogin(User user)throws Exception;
	
	 
	 
	 //登录方法
	// User userLogin(String username ,String password)throws Exception;
}
