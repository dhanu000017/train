package SampleServlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import console.DbManager;

/**
 * Servlet Filter implementation class AutenticationFilter
 */
//@WebFilter("/servlet_Example")
public class AutenticationFilter extends HttpFilter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AutenticationFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		boolean authenticated = false;
		System.out.println("auto");
//		String usname=(String) request.getParameter("Username");
		Cookie[] cookies = httpReq.getCookies();
		if(cookies!=null)
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("SessionId")) {
					try {
						PreparedStatement stmt = DbManager.con.prepareStatement("select * from session where SessionId = ?");
						stmt.setString(1, cookie.getValue());
						ResultSet set = stmt.executeQuery();
						if(set.next()) {
							String username = set.getString(2);
							request.setAttribute("username", username);
							authenticated = true;
						}
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
		if(authenticated) {
			chain.doFilter(request, response);
		}
		else {
			response.getWriter().write("authentication failed");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
