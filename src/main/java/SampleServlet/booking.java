package SampleServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import console.DbManager;
import console.customer;

/**
 * Servlet implementation class booking
 */
//@WebServlet("/booking")
public class booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public booking() {
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
		
		
		String FrDetails=(String) request.getParameter("from");
		String ToDetails=(String) request.getParameter("to");
		String daDetails=(String) request.getParameter("date");
		String clasDetails=(String) request.getParameter("class");
		String seaDetails=(String) request.getParameter("seats");
		
		String TrainId=(String) request.getParameter("TrainId");
		String Trainname=(String) request.getParameter("Trainname");
		String Timing=(String) request.getParameter("Timing");
		String Price=(String) request.getParameter("Price");
		String NumOfSeats=(String) request.getParameter("NumOfSeats");
		String Duration=(String) request.getParameter("Duration");
		
		String us=(String) request.getAttribute("username");
		
		int noos=0;
		int id=0;
		int pri=0;
		int totalse=0;
		String result;
		try {
			noos=Integer.parseInt(seaDetails);
			id=Integer.parseInt(TrainId);
			pri=Integer.parseInt(Price);
			totalse=Integer.parseInt(NumOfSeats);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("parse");
		}
		
		customer cusl2= DbManager.getingcu(us);		
		DbManager.gettingTrainSeats(id,noos);
//		   DbManager.booking(id,noos,daDetails,Timing); 
		int count= DbManager.searching(id,daDetails,Timing);
		 if(count==0) {
			List<Integer> seats=DbManager.gettingNoSeats(id);
			DbManager.insertSeats(id,seats.get(0),seats.get(1),daDetails,Timing);
			 result=DbManager.updateseat(id,noos,daDetails,Timing,clasDetails);
		 }
		 else {
			  result= DbManager.updateseat(id,noos,daDetails,Timing,clasDetails);
		 }
		 
			 DbManager.bookingDetails(cusl2.Id,id,noos,cusl2.phoneNum,daDetails,Timing,Duration,ToDetails); 
		
		   
		  
		   response.getWriter().append(result);
	}

}
