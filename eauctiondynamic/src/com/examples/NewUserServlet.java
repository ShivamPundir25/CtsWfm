package com.examples;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DataDao;
import com.dao.DataDaoImpl;
import com.model.User;

/**
 * Servlet implementation class NewUserServlet
 */
@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserServlet() {
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
		response.setContentType("text/html");
		String userId = request.getParameter("userid");
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String pwd = request.getParameter("password");
		String rpwd = request.getParameter("repassword");
		String add = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String pin= request.getParameter("pin");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String acc = request.getParameter("paypalaccount");
		
		if(pwd.equals(rpwd))
		{
		   User user = new User();
		   user.setUserid(userId);
		   user.setFirstname(fname);
		   user.setLastname(lname);
		   user.setPassword(pwd);
		   user.setAddress(add);
		   user.setCity(city);
		   user.setState(state);
		   user.setPin(pin);
		   user.setPhone(phone);
		   user.setEmail(email);
		   user.setPaypalaccount(acc);
		   int count = datadao.newUserRegistration(user);
		   RequestDispatcher rd=request.getRequestDispatcher("registrationsuccess.jsp");
		   rd.forward(request, response);
		}
		
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("registrationfailure.jsp");
			rd.forward(request, response);
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
