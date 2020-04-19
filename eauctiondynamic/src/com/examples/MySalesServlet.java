package com.examples;

import java.io.IOException;
import java.util.ArrayList;
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
import com.model.Product;
import com.model.Transactions;

/**
 * Servlet implementation class MySalesServlet
 */
@WebServlet("/MySalesServlet")
public class MySalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MySalesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		try {
		DataDao datadao = new DataDaoImpl();
		response.setContentType("text/html");
		Cookie[] cookies = request.getCookies();
		String sellerid = cookies[0].getValue();
		List<Transactions> list= datadao.mySales(sellerid);
	     if(list.isEmpty()) {
			RequestDispatcher rd=request.getRequestDispatcher("nosales.jsp");
			rd.forward(request, response);
		}
		else {
		request.setAttribute("sales",list);
		
        RequestDispatcher rd=request.getRequestDispatcher("mysales.jsp");
		rd.forward(request, response);
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
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
