package SampleServlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class BookingValidation
 */
//@WebFilter("/BookingValidation")
public class BookingValidation extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public BookingValidation() {
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
       System.out.println("booking validation filter is working");
       
   	String FrDetails=(String) request.getParameter("FrDetails");
	String ToDetails=(String) request.getParameter("ToDetails");
	String daDetails=(String) request.getParameter("daDetails");
	String clasDetails=(String) request.getParameter("clasDetails");
	String seaDetails=(String) request.getParameter("seaDetails");
      boolean bookingValidation=false;
       String [] FromArray={"mathalamparai","erode","sengottai","salem","tiruchendur","kalakadu","chennai","kovai","chengalpattu","tenkasi"};
       String [] ToArray={"kadaiyam","palani","chennai","madurai","mathalamparai","thirunelveli","ramanathapuram","thoothukudi","tenkasi"};
       List Fromlist =Arrays.asList(FromArray);
       List Tolist =Arrays.asList(ToArray);
       
       if(Fromlist.contains(FrDetails)&&(Tolist.contains(ToDetails))) {
    	   System.out.println("booking validation ");
    	   bookingValidation=true;
       }
       if(bookingValidation) {
   		chain.doFilter(request, response);

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
