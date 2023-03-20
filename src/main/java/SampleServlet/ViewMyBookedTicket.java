package SampleServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import console.Cusdetails;
import console.DbManager;

/**
 * Servlet implementation class ViewMyBookedTicket
 */
//@WebServlet("/ViewMyBookedTicket")
public class ViewMyBookedTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMyBookedTicket() {
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
		System.out.println("hvhv");
		String name=(String) request.getAttribute("username");
		System.out.println(name);
		List<Cusdetails> myli=DbManager.viewticket(DbManager.getingcustomerId(name));
		 JSONArray jsarr=new  JSONArray();
		 for (Cusdetails i : myli) {
			jsarr.add(i.jsobj());
		}
		 response.getWriter().append(jsarr.toString());
		
	}

}
