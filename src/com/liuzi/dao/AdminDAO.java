package com.liuzi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.liuzi.bean.Admin;
import com.liuzi.helper.DBConnect;


public class AdminDAO {
	public static boolean isLoginOK(Admin a,String identity) {	        //登陆操作
		String sql1="select * from admin where admin_Id = '"+a.getAdmin_Id()+"' and password ='"+a.getPassword()+"'and identity ='"+identity+"'";
		String sql2="select * from admin where phone = '"+a.getAdmin_Id()+"' and password ='"+a.getPassword()+"'and identity ='"+identity+"'";
		if(DBConnect.isOK(sql1)||DBConnect.isOK(sql2)){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean ischeckres(String phone){       //检查手机号
		String sql="select * from admin where phone ='"+phone+"'";
		if(DBConnect.isOK(sql)){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isRegisterOK(Admin res){
		SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		String admin_Id = df.format(new Date())+res.getPhone().substring(7,11);
		String identity="1";
		
		String sql="INSERT INTO admin VALUES ('"+admin_Id+"','"+res.getPassword()+
				"','"+res.getName()+"','"+res.getPhone()+"','"+identity+"')";
		
		if(DBConnect.isInsertOK(sql)){
			return true;
		}else{
			return false;
		}
	}
}
