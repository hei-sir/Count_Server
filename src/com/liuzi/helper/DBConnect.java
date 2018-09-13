package com.liuzi.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.liuzi.bean.Admin;

public class DBConnect {
	public static boolean isOK(String sql) {	  
    	Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
        String driver="com.mysql.jdbc.Driver";
        int rows=0;
        try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/count?" +
				                                   "user=root&password=");
			//3.3 
			
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				rows++;
			}
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					pstmt=null;
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					conn=null;
				}
			}
		}
		if(rows>0){
			return true;
		}else{
			return false;
		}
    }
}
