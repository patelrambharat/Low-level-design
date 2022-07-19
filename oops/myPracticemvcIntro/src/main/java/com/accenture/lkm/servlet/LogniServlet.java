package com.accenture.lkm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.lkm.business.bean.LoginBean;
import com.accenture.lkm.dao.LoginDAO;


//@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1 and 2 Tasks Fetching and TypeCasting
		String userName = request.getParameter("uname");
		String password =  request.getParameter("upassword");
		//System.out.println(userName);
		//System.out.println(password);
		//2 and 3 Making the model Object and populating the model object
		LoginBean loginBean =  new LoginBean();
		loginBean.setPassword(password);
		loginBean.setUserName(userName);
		
		// 4 
		LoginDAO loginDAO =  new LoginDAO();
		String ret=loginDAO.validateLogin(loginBean);
		
		if(ret.equals("success")){
			request.getRequestDispatcher("success.html"). forward(request, response);
		}
		
		else{
			request.getRequestDispatcher("failure.html"). forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
