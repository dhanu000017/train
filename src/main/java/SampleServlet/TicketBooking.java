package SampleServlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import console.DbManager;
import console.Train;
import console.customer;

/**
 * Servlet implementation class TicketBooking
 */
//@WebServlet("/TicketBooking")
public class TicketBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketBooking() {
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
		List <Train>  trde= new ArrayList<>();
		
		Train objectTrain=new Train();
		
		String FrDetails=(String) request.getParameter("FrDetails");
		String ToDetails=(String) request.getParameter("ToDetails");
		String daDetails=(String) request.getParameter("daDetails");
		String clasDetails=(String) request.getParameter("clasDetails");
		String seaDetails=(String) request.getParameter("seaDetails");
		String us=(String) request.getAttribute("username");
		customer cusli= DbManager.getingcu(us);
		List <Train>trli=cusli.bookaticket(FrDetails,ToDetails,daDetails,clasDetails);
	    JSONArray js=new  JSONArray();
	   for (Train i : trli) {
		   trde.add(i);
		   objectTrain=i;
		   JSONObject obj = i.getJson();
		   try {
			   PreparedStatement pr = DbManager.con.prepareStatement("select Price from stops where TrainId = ? and StopName=?");
			   pr.setInt(1, i.getTrainId());
			   pr.setString(2, ToDetails);
			   ResultSet rs = pr.executeQuery();
			   rs.next();
			   obj.put("Price", rs.getInt(1));
		   }catch (Exception e) {
			// TODO: handle exception
		}
		   js.add(obj);
	   }
	   
	   response.getWriter().append(js.toString());
	 
		}

}
