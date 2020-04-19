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
import com.model.Product;

/**
 * Servlet implementation class ProductDetails
 */
@WebServlet("/ProductDetails")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetails() {
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
			String productid = request.getParameter("productid");
			//creating cookie
		     Cookie pid=new Cookie("productid", productid);
			//adding cookie in response
			response.addCookie(pid);
			List<Product> list= datadao.productDetails(productid);
			String maxAmount=datadao.maxAmount(productid);
	        request.setAttribute("pdetails",list);
	        request.setAttribute("amount",maxAmount);
	        // take it in next page
	        RequestDispatcher rd=request.getRequestDispatcher("productdetails.jsp");
			rd.forward(request, response);
			
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
