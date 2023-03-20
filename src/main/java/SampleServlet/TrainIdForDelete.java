package SampleServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import console.DbManager;

/**
 * Servlet implementation class TrainIdForDelete
 */
//@WebServlet("/TrainIdForDelete")
public class TrainIdForDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainIdForDelete() {
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
		String DeleteTheTrain=(String) request.getParameter("TrainIdForDelete");
		int trId=0;
		try {
			trId=Integer.parseInt(DeleteTheTrain);
		} catch (Exception e) {
			// TODO: handle exception
		}
		DbManager.deletingTrain(trId);
		DbManager.deltetrain(trId);
		response.getWriter().append("Successfully Updated");
	}

}
