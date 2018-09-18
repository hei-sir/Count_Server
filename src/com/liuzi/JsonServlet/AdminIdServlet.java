package com.liuzi.JsonServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.User;
import com.liuzi.bean.Admin;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * Servlet implementation class AdminIdServlet
 */
@WebServlet("/AdminIdServlet")
public class AdminIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Admin> list;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
	       response.setCharacterEncoding("utf-8");
	         PrintWriter out=response.getWriter();
	        
	        list=PrapareData();
	 //        out.write(list.toString());
	        
	        
	        JSONArray array=new JSONArray();
	         
	         for(Admin bean: list)
	        {
	            JSONObject obj=new JSONObject();
	             
	             try{
	            	 
	                 obj.put("admin_Id",bean.getAdmin_Id() );
	                 obj.put("phone", bean.getPhone());
	                 obj.put("name", bean.getName());
	                 obj.put("identity", bean.getIdentity());
	                 
	                 
	             }
	             catch(Exception e){
	                 
	            }
	             
	            
	         array.add(obj);
	            
	             
	         }
	         out.write(array.toString());
	         out.flush();
	         out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 super.doGet(request, response);
	}
	private List<Admin> PrapareData()
    {
	
		Admin a=new Admin();
	   	Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
        String driver="com.mysql.jdbc.Driver";
        String sql="select * from admin";
        int rows=0;
        try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/count?" +
				                                   "user=root&password=");
			//3.3 
			
			pstmt=conn.prepareStatement(sql);
			
			
			
			
			rs = pstmt.executeQuery();
			list=new ArrayList<Admin>();
			if(rs.first()){
				do{
					a.setAdmin_Id(rs.getString("admin_Id"));
					a.setPhone(rs.getString("phone"));
					a.setName(rs.getString("name"));
					a.setIdentity(rs.getString("identity"));
				
				 Admin a1=new Admin();
				 a1.setAdmin_Id(a.getAdmin_Id());
				 a1.setPhone(a.getPhone());
				 a1.setName(a.getName());
				 a1.setIdentity(a.getIdentity());
			        list.add(a1);
				}while(rs.next());
				
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
      
   
   return list;
    
   }

}
