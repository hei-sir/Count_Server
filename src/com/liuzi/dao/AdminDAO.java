package com.liuzi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.liuzi.bean.Admin;
import com.liuzi.helper.DBConnect;


public class AdminDAO {
	public static boolean isLoginOK(Admin a) {	        //登陆操作
		String sql="select * from admin where admin_Id = "+a.getAdmin_Id()+" and password ="+a.getPassword()+"";
		if(DBConnect.isOK(sql)){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean ischeckres(String phone){       //检查手机号
		String sql="select * from admin where phone ="+phone+"";
		if(DBConnect.isOK(sql)){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isRegisterOK(Admin res){
		String admin_Id = "1";
		String identity="1";
		
		String sql="INSERT INTO admin VALUES ("+admin_Id+","+res.getPassword()+
				","+res.getPhone()+","+res.getName()+","+identity+")";
		
		if(DBConnect.isInsertOK(sql)){
			return true;
		}else{
			return false;
		}
	}
}
