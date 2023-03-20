package SampleServlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import console.DbManager;

 





/**
 * Servlet implementation class AddTrain
 */
//@WebServlet("/AddTrain")
public class AddTrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTrain() {
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
		String TrainID=(String) request.getParameter("TrainID");
		String TrainNAME=(String) request.getParameter("TrainNAME");
		String TrainTime=(String) request.getParameter("TrainTime");
		String TrainFROM=(String) request.getParameter("TrainFROM");
		String TrainTO=(String) request.getParameter("TrainTO");
		String TrainPrice=(String) request.getParameter("TrainPrice");
		String First=(String) request.getParameter("First");
		String Second=(String) request.getParameter("Second");
		String duration=(String) request.getParameter("duration");
		String count=(String) request.getParameter("count");
		String array=(String) request.getParameter("array");
		int trainid=0;
		int count2=0;
		int pri=0;
		int fir=0;
		int sec=0;
		
		
		try {
			trainid=Integer.parseInt(TrainID);
			count2=Integer.parseInt(count);
			pri=Integer.parseInt(TrainPrice);
			fir=Integer.parseInt(First);
			sec=Integer.parseInt(Second);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(TrainID);
		JSONParser obj =new JSONParser();
		try {
			JSONArray jsobj=(JSONArray) obj.parse(array);
			DbManager.AddingTrain(trainid,TrainNAME,TrainTime,TrainFROM,TrainTO,pri,fir,sec,duration);
			for(int i=0; i<jsobj.size();i++) {
				System.out.println(""+((JSONObject)jsobj.get(i)).get("StationPrice"));
				DbManager.AddingTrainStops(trainid,i+1, TrainFROM, ""+((JSONObject)jsobj.get(i)).get("StationName"), Integer.parseInt(""+((JSONObject)jsobj.get(i)).get("StationPrice")), "running");
			}
			response.getWriter().append("Successfully Updated");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			response.getWriter().append("Update Cancelled");
			e.printStackTrace();
		}
		

			
			
		
		
	}

}
