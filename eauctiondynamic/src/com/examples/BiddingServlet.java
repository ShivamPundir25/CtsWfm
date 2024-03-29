package com.examples;

import java.io.IOException;
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

/**
 * Servlet implementation class BiddingServlet
 */
@WebServlet("/BiddingServlet")
public class BiddingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BiddingServlet() {
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
		String bidamount = request.getParameter("bidamount");
		Cookie[] cookies=request.getCookies();
		
		String bidderid = cookies[0].getValue();
		String productid=cookies[1].getValue();
		
		int result =datadao.bidTransaction(productid,bidderid,bidamount);
		if(result!=0) {
			RequestDispatcher rd=request.getRequestDispatcher("tsuccess.jsp");
			rd.forward(request, response);
		}
		else {
        RequestDispatcher rd=request.getRequestDispatcher("tfailure.jsp");
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
