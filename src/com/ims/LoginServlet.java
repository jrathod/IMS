package com.ims;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imscore.ConnectDatabase;

/**
 * Servlet implementation class LoginServelt
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw= response.getWriter();
		
		pw.write("get");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean approvedLogin=false;
		PrintWriter pw= response.getWriter();
		
		pw.write("post by jigar");
		
		ConnectDatabase connectDb= new ConnectDatabase();
		String uname= request.getParameter("username");
		String pwd= request.getParameter("password");
		approvedLogin= connectDb.checkCredentials(uname, pwd);
		
		if(approvedLogin){
			System.out.println("login "+approvedLogin);
			request.setAttribute("username", uname);
			RequestDispatcher rd =request.getRequestDispatcher("/JSP/UserHome.jsp");
			rd.forward(request, response);
			
			
		}
		
	}

}
