package SampleServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;

import console.DbManager;
import console.customer;
import console.loginManager;

/**
 * Servlet implementation class servlet_Example
 */

//@WebServlet("/servlet_Example")
public class servlet_Example extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public void init(){
		String name=getServletConfig().getInitParameter("StudentName");
		System.out.println(name);
	}
	
    public servlet_Example() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("servlet at").append(request.getContextPath());
		System.out.println("2345neveen");	
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String finame=(String) request.getParameter("FirstName");
		String laname=(String) request.getParameter("LastName");
		String usname=(String) request.getParameter("Username");
		String mobnum=(String) request.getParameter("MobileNumber");
		String pass=(String) request.getParameter("password");
		
		
		System.out.println("name"+usname);
		customer obj1 = loginManager.signUp(finame,laname,usname,mobnum,pass);
		response.getWriter().append(obj1.Id+"	is your Id");
//		request.setAttribute("customerObject", obj1);
		
		UUID uid = UUID.randomUUID();
		Cookie cookie = new Cookie("SessionId", uid.toString());
		try {
			PreparedStatement st=DbManager.con.prepareStatement("insert into session value(?,?)");
			st.setString(1, uid.toString());
			st.setString(2,usname);
			st.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		response.addCookie(cookie);
		System.out.println(cookie);
	}
	
	

}
