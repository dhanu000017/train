package SampleServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import console.DbManager;
import console.Train;

/**
 * Servlet implementation class ViewAllTrainsDetailses
 */
//@WebServlet("/ViewAllTrainsDetailses")
public class ViewAllTrainsDetailses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllTrainsDetailses() {
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
		List<Train> myli3=DbManager.ViewAllTrainDe();
		JSONArray jsarr2=new  JSONArray();
		 for (Train i : myli3) {
			jsarr2.add(i.getJson2());
		}
		 response.getWriter().append(jsarr2.toString());
		
	}

}
