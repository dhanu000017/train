package SampleServlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import console.DbManager;
import console.Train;
import console.customer;

/**
 * Servlet implementation class CancellTiceket
 */
//@WebServlet("/CancellTiceket")
public class CancellTiceket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancellTiceket() {
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
		System.out.println("cancell my ticket");
		Train objectTrain2=new Train();
		String FrDetails=(String) request.getParameter("FrDetails");
		String ToDetails=(String) request.getParameter("ToDetails");
		String daDetails=(String) request.getParameter("daDetails");
		String clasDetails=(String) request.getParameter("clasDetails");
		String seaDetails=(String) request.getParameter("seaDetails");
		String us=(String) request.getAttribute("username");
		
		String TrainId=(String) request.getParameter("TrainId");
		String Trainname=(String) request.getParameter("Trainname");
		String Timing=(String) request.getParameter("Timing");
		String Price=(String) request.getParameter("Price");
		String NumOfSeats=(String) request.getParameter("NumOfSeats");
		String Duration=(String) request.getParameter("Duration");
		
		
		int seats=0;
		int trint=0;
		String trtim="";
		
		try {
			seats=Integer.parseInt(seaDetails);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 try {
			   	PreparedStatement ps = DbManager.con.prepareStatement("select * from trainDetails where TrainFrom like ? && TrainTo like ? && status like ?");
			   	ps.setString(1, "%" + FrDetails + "%");
			   	ps.setString(2, "%" + ToDetails + "%");
			   	ps.setString(3,"running");
			   	ResultSet rs = ps.executeQuery();
			     if (rs.next()) {
			       trint=rs.getInt(1);
			       trtim=rs.getString(3);
			     }
			   } catch (Exception e) {
			     // TODO: handle exception
			   	System.out.println("error occured in DB 4");
			   	}
		 customer cusl2= DbManager.getingcu(us);
		DbManager.CancellTicket(trint,seats,daDetails,trtim,clasDetails);
		 DbManager.cancelbooking(cusl2.Id,trint,seats,cusl2.phoneNum,daDetails,Timing,Duration); 
		
	}

}
