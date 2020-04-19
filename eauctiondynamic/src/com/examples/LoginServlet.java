package com.examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DataDao;
import com.dao.DataDaoImpl;
import com.model.User;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		DataDao datadao = new DataDaoImpl();
		List<User> user = datadao.getAllCreds();
		response.setContentType("text/html");
		boolean flag = false;
		String uname = request.getParameter("userid");
		String pwd = request.getParameter("password");
		
		for(User u: user) {
			if(u.getUserid().equals(uname) && u.getPassword().equals(pwd)) {
				Cookie loginCookie = new Cookie("uname",uname);
				response.addCookie(loginCookie);
				flag=true;
				break;
			}
		}
		
		if(flag)
		       {
				RequestDispatcher rd=request.getRequestDispatcher("usertype.jsp");
				rd.forward(request, response);
			
				}
		else
				
		 {
			RequestDispatcher rd=request.getRequestDispatcher("indexfailure.jsp");
			rd.forward(request, response);
			//rd.include(request, response);
		//may be forward here
		 }
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
