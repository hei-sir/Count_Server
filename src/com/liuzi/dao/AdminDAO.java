package com.liuzi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.liuzi.bean.Admin;
import com.liuzi.helper.DBConnect;


public class AdminDAO {
	public static boolean isLoginOK(Admin a) {	  
		String sql="select * from admin where admin_Id = "+a.getAdmin_Id()+" and password ="+a.getPassword()+"";
		if(DBConnect.isOK(sql)){
			return true;
		}else{
			return false;
		}
	}
}
