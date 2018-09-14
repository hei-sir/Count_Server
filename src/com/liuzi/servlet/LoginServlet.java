package com.liuzi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liuzi.bean.Admin;
import com.liuzi.dao.AdminDAO;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	
        out.println("GET");
        out.flush();
        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //ȡ��URL�е��˺��������
        String admin_Id = request.getParameter(Admin.ADMIN_ID);
        String password = request.getParameter(Admin.PASSWORD);
        String status=request.getParameter(Admin.STATUS);
        String name=request.getParameter(Admin.NAME);
        String phone=request.getParameter(Admin.PHONE);
	    String identity=request.getParameter(Admin.IDENTITY);
        Admin a=new Admin(admin_Id,password);             //��½
        Admin res=new Admin(phone,name,password);         //ע��
        if(status.equals("1")){
		    boolean st = AdminDAO.isLoginOK(a);         //��½���
            if(st){
        	    out.println("OK");
		    }else{
                out.println("Wrong");
		    }
        }else if(status.equals("2")){             //ע�����û�����ֻ��Ų���ע��
        	boolean sts=AdminDAO.ischeckres(phone);
        	if(sts){
        		out.println("Wrong");        //��ʾ���ֻ���ע��
        	}else{
        		boolean st = AdminDAO.isRegisterOK(res);        
                if(st){
            	    out.println("OK");
    		    }else{
                    out.println("Wrong");
    		    }
        	}
        }else if(status.equals("3")){         //�һ�������֤�ֻ���
        	boolean sts=AdminDAO.ischeckres(phone);
        	if(sts){
        		out.println("OK");        //��ʾ���ֻ�����
            }else{
            	out.println("Wrong");     //���ֻ�δע��
            }
        }
   

        out.flush();
        out.close();
	
	}

}
