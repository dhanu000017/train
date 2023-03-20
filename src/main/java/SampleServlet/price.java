package SampleServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import console.DbManager;

/**
 * Servlet implementation class price
 */
//@WebServlet("/price")
public class price extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public price() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String Price=(String) request.getParameter("Price");
		String seaDetails=(String) request.getParameter("seats");
		int nos=0;
		int pri=0;
		try {
			nos=Integer.parseInt(seaDetails);
			pri=Integer.parseInt(Price);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("parse");
		}
		response.getWriter().append("Total Price Of The Ticket : "+pri*nos);
	}

}
