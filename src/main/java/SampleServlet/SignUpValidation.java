package SampleServlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class SignUpValidation
 */
//@WebFilter("/servlet_Example")
public class SignUpValidation extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public SignUpValidation() {
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
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("filter 3"); 
		boolean DataValidation=false;
		String expname = "^[A-Za-z\\s]{3,20}+";
		String expname2 = "^[A-Za-z\\s]{1,20}+";
		String expnum = "^[0-9]{10}";
		String exppass = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$_%^,&*-]).{8,}$";
		String FirstName=(String) request.getParameter("FirstName");
		String LastName=(String) request.getParameter("LastName");
		String UserName=(String) request.getParameter("Username");
		String MobileNumber=(String) request.getParameter("MobileNumber");
		String password=(String) request.getParameter("password");
 if(FirstName!=null&&LastName!=null&&UserName!=null&&MobileNumber!=null&&password!=null) {
	 
	 
	 if ((FirstName.matches(expname))&&(LastName.matches(expname2))&&(UserName.matches(expname))&&(MobileNumber.matches(expnum))&&(password.matches(exppass))) {
		 chain.doFilter(request, response);
      } else {
    	  response.getWriter().append("Enter Valid Input") ;
      }
 }
		 
		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
