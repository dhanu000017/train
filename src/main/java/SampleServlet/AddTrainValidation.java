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
 * Servlet Filter implementation class AddTrainValidation
 */
//@WebFilter("/AddTrainValidation")
public class AddTrainValidation extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AddTrainValidation() {
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

		// pass the resquest along the filter chain
		
		String TrainID=(String) request.getParameter("TrainID");
		String TrainNAME=(String) request.getParameter("TrainNAME");
		String TrainTime=(String) request.getParameter("TrainTime");
		String duration=(String) request.getParameter("duration");
		String TrainFROM=(String) request.getParameter("TrainFROM");
		String TrainTO=(String) request.getParameter("TrainTO");
		String TrainPrice=(String) request.getParameter("TrainPrice");
		String First=(String) request.getParameter("First");
		String Second=(String) request.getParameter("Second");
		String count=(String) request.getParameter("count");
		String array=(String) request.getParameter("array");
		
		
		if(TrainID!=null&&TrainNAME!=null&&TrainTime!=null&&TrainFROM!=null&&TrainTO!=null&&TrainPrice!=null&&First!=null&&Second!=null&&count!=null&&duration!=null) {
			
			if(TrainID.length()!=0&&TrainNAME.length()!=0&&TrainTime.length()!=0&&TrainFROM.length()!=0&&TrainTO.length()!=0&&TrainPrice.length()!=0&&First.length()!=0&&Second.length()!=0&&count.length()!=0&&duration.length()!=0) {
				
				try {
					String arr[]=TrainTime.split(":");
					String arr2[]=duration.split(":");
					chain.doFilter(request, response);
				} catch (Exception e) {
					response.getWriter().append("Update Cancelled");
					// TODO: handle exception
					
				}
				
			}
			else {
				response.getWriter().append("Update Cancelled");
			}
			
		}
		else {
			response.getWriter().append("Update Cancelled");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
