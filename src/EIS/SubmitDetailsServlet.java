package EIS;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCheck
 */

public class SubmitDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	doGet(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	String parkingID1 = (String)request.getParameter("parkingID");
    	String parkingID = "p"+parkingID1.split(" ")[1];
    	String recipientCar=(String)request.getParameter("recipient-car");
    	System.out.println("hello: "+recipientCar);
//    	if(recipientCar=null)
//    	{
    	String recipientName=(String)request.getParameter("recipient-name");
    	String recipientEmail=(String)request.getParameter("recipient-email");
    	String recipientPhone=(String)(request.getParameter("recipient-phone"));
    	String startDate=(String)(request.getParameter("recipient-inDate"));
    	String startTime=(String)(request.getParameter("recipient-intime"));
    	String endDate=(String)(request.getParameter("endDate"));
    	String endTime=(String)(request.getParameter("endTime"));
    	
    	
    	String startDateTime = startDate + " "+startTime+":00:000";
    	String endDateTime = endDate + " "+endTime+":00:000";
    	ArrayList<UserDetails> al=new ArrayList<UserDetails>();
    	UserDetails userDetails = new UserDetails();
    	
    	userDetails.setParkingID(parkingID);
    	
    	userDetails.setCarLicense(recipientCar);
    	userDetails.setUserEmail(recipientEmail);
    	userDetails.setUserName(recipientName);
    	userDetails.setUserPhone(recipientPhone);
    	userDetails.setStartTime(startDateTime);
    	userDetails.setEndTime(endDateTime);
    	
    	
    	al.add(userDetails);
    	
    	
    	
		response.setContentType("text/html");
	
		DBConnection db=new DBConnection();

		db.updateDetails(al,parkingID);
		response.sendRedirect("index.jsp");
		

    }
		
}
