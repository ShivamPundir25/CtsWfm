package com.examples;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
		String pid = request.getParameter("productid");
		Cookie[] cookies = request.getCookies();
		String sid = cookies[0].getValue();
		String cid = request.getParameter("categoryid");
		String pname = request.getParameter("productname");
		String sd = request.getParameter("shortdescription");
		String dd = request.getParameter("detailedescription");
		String sprice = request.getParameter("startingprice");
		String sdate = request.getParameter("bidstartdate");
		String edate = request.getParameter("bidenddate");
		
		Product product = new Product();
		product.setProductid(pid);
		product.setSellerid(sid);
		product.setCategoryid(cid);
		product.setProductname(pname);
		product.setShortdescription(sd);
		product.setDetailedescription(dd);
		product.setStartingprice(sprice);
		product.setBidstartdate(sdate);
		product.setBidenddate(edate);
	
	    int count = datadao.addProduct(product);
	    
	    if(count!=0) {
		//RequestDispatcher rd=request.getRequestDispatcher("registrationsuccess.jsp");
	    RequestDispatcher rd=request.getRequestDispatcher("psuccess.jsp");
		rd.forward(request, response);
	    }
		
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("pfailure.jsp");
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
