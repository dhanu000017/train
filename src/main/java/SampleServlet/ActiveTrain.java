package SampleServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import console.DbManager;

/**
 * Servlet implementation class ActiveTrain
 */
//@WebServlet("/ActiveTrain")
public class ActiveTrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActiveTrain() {
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
		String ActiveTheTrain=(String) request.getParameter("TrainIdForActive");
		int trId=0;
		try {
			trId=Integer.parseInt(ActiveTheTrain);
		} catch (Exception e) {
			// TODO: handle exception
		}
		DbManager.activeTrain(trId);
		DbManager.actitrain(trId);
		response.getWriter().append("Successfully Updated");
	}

}
