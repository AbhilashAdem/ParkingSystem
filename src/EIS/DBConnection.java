package EIS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.lang.Class;

public class DBConnection 
{

	private static Connection conn=null;
	private static Statement statement=null;
	private static ResultSet res=null;

	DBConnection db = null;

	public void connectToDB()
	{

		try
		{
			String connectionString =  
					"jdbc:sqlserver://localhost:1433;"  
							+ "database=eis2;"  
							+ "user=him;"  
							+ "password=him;";  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			conn=DriverManager.getConnection(connectionString);
			statement = conn.createStatement();  
			System.out.println("Connect to DB");

//			String selectSql = "SELECT * from dbo.p1";  
//			ResultSet resultSet = statement.executeQuery(selectSql);  
//
//			//        Print results from select statement  
//			while (resultSet.next())   
//			{  
//				System.out.println(resultSet.getString("slot_number")+" "+resultSet.getString("avalability"));  
//			}  
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public Map<String,List<String>> getAvailableSlots() {
		db = new DBConnection();
		db.connectToDB();
		Map<String,List<String>> noOfSlot = new HashMap<String,List<String>>();
		try {
			for(int i =1 ; i<=7;i++) {

				String slot = "SELECT COUNT(avalability) AS Free_Space FROM p"+i+" WHERE avalability=1";
				res = statement.executeQuery(slot);
				List<String> list = new ArrayList<String>();
				int available = 0;
				String color = "";
				while(res.next()) {
					available = res.getInt(1);
					if(available > 5)
						color = "green";
					else if (available<5 && available>0)
						color = "orange";
					else 
						color = "red";

					list.add(color);
					list.add(""+available);

					noOfSlot.put("p"+i, list);
				}
			}		 
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Top ten Query Problem ");
			e.printStackTrace();
		}
		finally {

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) { }
			}
			if (res != null) {
				try {
					res.close();
				} catch (SQLException e) { }
			}
			if (conn != null) {
				try {
					System.out.println("Connection Closed");
					conn.close();
				} catch (SQLException e) { }
			}
		}


		return noOfSlot;
	}
	// }


	public void updateDetails(List<UserDetails> al,String pID) {
		if(db == null) {
			db = new DBConnection();
			db.connectToDB();
		}
		
    	UserDetails userDetails = al.get(0);
    	Date startDate = null;
    	Date endDate = null;
    	String license = userDetails.getCarLicense();
    	String email = userDetails.getUserEmail();
    	String name = userDetails.getUserName();
    	String phone = userDetails.getUserPhone();
    	String parkingID = userDetails.getParkingID();
    	String startDateTime = userDetails.getStartTime();
    	String endDateTime = userDetails.getEndTime();
    	
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	
    	try
        {
            startDate = simpleDateFormat.parse(startDateTime);
            endDate = simpleDateFormat.parse(endDateTime);
        }
        catch (ParseException e)
        {
            System.out.println("Exception "+e);
        }
    	
    	float hours = (float)((endDate.getTime() - startDate.getTime())/3600000);
    	float price = 10 * hours;
    	
    	
    	String slotNumberQuery = "SELECT TOP 1 slot_number as Slot_number FROM "+parkingID+" where avalability=1";
    	int slotNumber =0;
    	try {
			res = statement.executeQuery(slotNumberQuery);
			while(res.next()) {
				slotNumber = res.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
    	String avalabilityUpdate= "UPDATE "+parkingID+" SET avalability = 0 WHERE slot_number= "+slotNumber+"";
    	try {
			int x = statement.executeUpdate(avalabilityUpdate);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    
    	String insertUser = "Insert into u1 (username, user_email, User_phone, car_license, timeentry,timeexit_,Slot_number,parkingid) values ('"+name+"','"+email+"','"+phone+"','"+license+"','"+startDateTime+"','"+endDateTime+"','"+slotNumber+"','"+parkingID+"')";
    	String insertUser2 = "Insert into u2 (username, user_email, User_phone, car_license, timeentry,timeexit_,Slot_number) values ('"+name+"','"+email+"','"+phone+"','"+license+"','"+startDateTime+"','"+endDateTime+"','"+slotNumber+"')";
//		String updateUser = "Update u1 set SET user_name ='"+name+"' , user_email ='"+email+"' , User_phone='"+phone+"' , car_license ='"+license+"' , timeentry =21:59:59.999 , timexit_ =23:59:59.999" ;
		try {
			int status = statement.executeUpdate(insertUser);
			System.out.println("Record is inserted into DBUSER table!");

			SendMail s = new SendMail();
			s.sendMailToUser(email, slotNumber,price,endDateTime);

		} catch (SQLException e) {
			e.printStackTrace();
		}
   	
		try {
			int status = statement.executeUpdate(insertUser2);
			System.out.println("Record is inserted into DBUSER table!");

		//	SendMail s = new SendMail();
			//s.sendMailToUser(email, slotNumber);

		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    

	}

	// public static void main(String args[]) {
	//	 connectToDB();
	// }
}