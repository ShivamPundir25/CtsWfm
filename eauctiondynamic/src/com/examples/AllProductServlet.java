package com.examples;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DataDao;
import com.dao.DataDaoImpl;
import com.model.Product;

/**
 * Servlet implementation class AllProductServlet
 */
@WebServlet("/AllProductServlet")
public class AllProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllProductServlet() {
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
			String categoryid = request.getParameter("categoryid");
			List<Product> list= datadao.allProduct(categoryid);
			
			if(list.isEmpty()) {
				RequestDispatcher rd=request.getRequestDispatcher("noproduct.jsp");
				rd.forward(request, response);
			}
			else {
			request.setAttribute("products",list);
	        RequestDispatcher rd=request.getRequestDispatcher("productsavailable.jsp");
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
