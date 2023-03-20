package SampleServlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import console.DbManager;
import console.customer;
import console.loginManager;

/**
 * Servlet implementation class login_Servlet
 */
//@WebServlet("/login_Servlet")
public class login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_Servlet() {
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
		String Loginna=(String) request.getParameter("User_na");
		String LoginPass=(String) request.getParameter("Password2");
		JSONObject json = new JSONObject();
		customer objectcus=loginManager.login(Loginna,LoginPass);

		if(objectcus!=null&&objectcus.Role.equals("Admin")) {
			  response.getWriter().append("ADMIN");
		}

		
		
		if(objectcus!=null) {
			json.put("Status", 200);
		}
		else {
			json.put("reason","user not found");
			json.put("Status", 500);
		}
			UUID uid = UUID.randomUUID();
			Cookie cookie = new Cookie("SessionId", uid.toString());
			try {
				PreparedStatement st=DbManager.con.prepareStatement("insert into session value(?,?)");
				st.setString(1, uid.toString());
				st.setString(2,Loginna);
				st.execute();
			}
			catch(Exception e) {
				System.out.println("database error");
			}
//			cookie.setSecure(true);
			response.addCookie(cookie);
			System.out.println(cookie);
			response.getWriter().write(json.toString());
		}
//		else {
//			json.put("Status", 500);
//		}
		
//		doGet(request, response);
	}


