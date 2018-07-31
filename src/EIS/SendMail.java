package EIS;


import java.util.Date;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail 
{
	private Message msg;
	private String addressFrom ;
	private String addressTo;
	private String subject; 
	private String addressCC;
	private String id;
	private InternetAddress mailbox;
	private String endLine;
	private String text ;
	final String username;
	final String password;

	
	
	public SendMail()
	{
		id="testparkingsystem@gmail.com";
		username = "testparkingsystem@gmail.com";
		password = "parkingsystem";
		endLine="This is an auto-generated mail. Please do not reply to this mail";
	}
	
	public String getAddressFrom() {
		return "testparkingsytem@gmail.com"; 
			}

	public void setAddressFrom(String addressFrom) {
		this.addressFrom = addressFrom;
	}

	public String getAddressTo() {
		return addressTo;
	}

	public void setAddressTo(String addressTo) {
		this.addressTo = addressTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	public Session getSession()
	{
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
//
//				props.put("mail.smtp.host", "smtp.gmail.com");
//			//	props.put("mail.smtp.host","10.20.50.22");
//		props.put("mail.smtp.socketFactory.port", "465");
		//props.put("host",host);
		return (Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  }));
		
	}
	
	public void setAddressCC(String currmngrid) {
		// TODO Auto-generated method stub
		this.addressCC=currmngrid;
		
	}

	public String getAddressCC() {
		// TODO Auto-generated method stub
		return addressCC;
	}
	
	
	public void sendMailToUser(String userEmail,int slotNumber,float price,String endTime)
	{    
		System.out.println("Sending mail to USer  "+userEmail);
	   
	     Message msg = new MimeMessage(getSession());
	      setAddressTo(userEmail);
	      setAddressCC(id);
	      try
	      {
	      msg.setFrom(new InternetAddress(getAddressFrom()));
	      InternetAddress[] addresses = InternetAddress.parse(addressTo);
	      msg.setRecipients(Message.RecipientType.TO, addresses);
	      InternetAddress addressCC[]=InternetAddress.parse(getAddressCC());
	      msg.addRecipients(Message.RecipientType.CC,addressCC);
	      msg.setSubject("You slot is booked with slot number"+slotNumber);
	      msg.setSentDate(new Date());
	      

	      msg.setText("Your slot number is "+slotNumber+" \n"+ "Estimated Parking Price:$"+price+"\n End Time:"+endTime+"\n\n"+endLine);
	      
	      Transport.send(msg);
	      System.out.println("done");
	      }
	      catch (Exception e) {
	          e.printStackTrace();
	        }
	}
	
//	public static void main(String args[]) {
//		SendMail s = new SendMail();
//		s.sendMailToUser("aayushgupta1990@gmail.com", 101);
//	}
	
	
/*	
	public void sendMailToCurrentManager(String currmngrid,String jid,String sub,String ename)
	{    
	
	   
	     Message msg = new MimeMessage(getSession());
	      setAddressTo(currmngrid);
	      setAddressCC(id);
	      try
	      {
	      msg.setFrom(new InternetAddress(getAddressFrom()));
	      InternetAddress[] addresses = InternetAddress.parse(addressTo);
	      msg.setRecipients(Message.RecipientType.TO, addresses);
	      InternetAddress addressCC[]=InternetAddress.parse(getAddressCC());
	      msg.addRecipients(Message.RecipientType.CC,addressCC);
	      msg.setSubject(sub);
	      msg.setSentDate(new Date());
	      

	      msg.setText("Employee "+ ename+" has applied for IJP Job "+jid+"\n\n"+endLine);
	      
	      Transport.send(msg);
	      }
	      catch (Exception e) {
	          e.printStackTrace();
	        }
	}
	
	//not to be done now
	public void sendMailToApplicant(String currmngrid,String empemailid, String appid,String jid,String sub)
	{	

		setAddressTo(empemailid);
		setAddressCC(id+","+currmngrid);
		Message msg = new MimeMessage(getSession());
	    
	      try
	      {
	      msg.setFrom(new InternetAddress(getAddressFrom()));
	     InternetAddress address=new InternetAddress(getAddressTo());
	     InternetAddress addressCC[]=InternetAddress.parse(getAddressCC());
	     msg.setRecipient(Message.RecipientType.TO, address);
	      msg.addRecipients(Message.RecipientType.CC,addressCC);
	      msg.setSubject(sub);
	      msg.setSentDate(new Date());

	      msg.setText("Application for Job "+ jid+" and Application ID "+appid+" received\n\n"+endLine);
	      Transport.send(msg);
	}
    catch (Exception e) {
        e.printStackTrace();
      }
		
	}
	

	public void sendMailToHiringManager(String hirmngremailid,String jid,String sub, String appid)
	{

		System.out.println("Inside sendMailToHiringManager, attributes are:- " +hirmngremailid+"  "+jid+"  "+sub+"  "+appid);
		setAddressTo(hirmngremailid);
		setAddressCC(id);
		
	      Message msg = new MimeMessage(getSession());
	      ApplicantDetails appDet=new ApplicantDetails();
	      DBConnection db=new DBConnection();
	      appDet=db.getApplicantDetailsByAppID(appid, jid);
	      String empid=appDet.getEmpid();
	      String empname=appDet.getEmp_name();
	      String currmgr=appDet.getCurr_manager_name();
	      String currmgrmail=appDet.getCurr_manager_email();
	      String empacc=appDet.getEmp_account();
	      String emp_job=appDet.getEmp_job();
	      String empline=appDet.getEmp_line();
	      String exp=appDet.getTotal_exp_years()+"years "+appDet.getTotal_exp_months()+"months";
	      String mgr_rep=currmgr.replace(".", " ");
	      String [] mgr_name=mgr_rep.split("@");   
	      try
	      {
	      msg.setFrom(new InternetAddress(getAddressFrom()));
	      InternetAddress[] addresses = InternetAddress.parse(addressTo);
		  msg.setRecipients(Message.RecipientType.TO, addresses);
		  InternetAddress addressCC[]=InternetAddress.parse(getAddressCC());
		  msg.addRecipients(Message.RecipientType.CC,addressCC);
	      msg.setSubject(sub);
	      msg.setSentDate(new Date());

	      msg.setContent("You have received application for JobId "+jid+"\n"+"Please find applicant details below: "+"\n\n"+ 
	    			"<table border=1><tbody><tr><td>Employee ID:</td><td>"+empid+"</td></tr>"+
	    			"<tr><td>Name:</td><td>"+empname+"</td></tr>"+
	    			"<tr><td>Current Manager:</td><td>"+mgr_name[0]+"</td></tr>"+
	    			"<tr><td>Account:</td><td>"+empacc+"</td></tr>"+
	    			"<tr><td>Job:</td><td>"+emp_job+"</td></tr>"+
	    			"<tr><td>Total experience:</td><td>"+exp+"</td></tr></tbody></table>"+"\n\n"+
	    			"Link For IJP - http://psgijp/ <br><br>"+
	    			"This is an auto-generated mail. Please do not reply to this mail"
	    			,"text/html;charset=utf-8"
	    		  );
	      Transport.send(msg);
	      }
	      catch (Exception e) {
	          e.printStackTrace();
	        }
	  		
	}
	public void sendMailForApplicantStatusChange(String currmngrid,String empemailid, String appid,String jid)
	{	

		setAddressTo(empemailid);
		//setAddressCC(id+","+currmngrid);
		setAddressCC(id);
		setSubject("Status Change For Applicant ID "+appid);
	      Message msg = new MimeMessage(getSession());
	    
	      try
	      
	      {
	      msg.setFrom(new InternetAddress(getAddressFrom()));
	     InternetAddress address=new InternetAddress(getAddressTo());
	     InternetAddress addressCC[]=InternetAddress.parse(getAddressCC());
	     msg.setRecipient(Message.RecipientType.TO, address);
	      msg.addRecipients(Message.RecipientType.CC,addressCC);
	      msg.setSubject(getSubject());
	      msg.setSentDate(new Date());

	      msg.setText("Status for your Application ID "+appid+" has been changed.\n\nPlease check Applicant Dashboard to view the updated status.\n\n\n"+endLine);
	      Transport.send(msg);
	}
    catch (Exception e) {
        e.printStackTrace();
      }
		
	}
 */	
	
	/*
	 import javax.swing.JEditorPane; 
	 import javax.swing.JFrame; 
	 public class HtmlContent extends JFrame { 
	 public static void main(String args[]) { 
	 new HtmlContent().start(); } 
	 void start() { 
	 try { 
	 String html; 
	 html="<html><head><title>Simple Page</title></head>"; 
	 html+="<body bgcolor='#777779'><hr/><font size=50>This is Html content</font><hr/>"; 
	 html+="</body></html>"; 
	 JEditorPane ed1=new JEditorPane("text/html",html); 
	 add(ed1); 
	 setVisible(true); 
	 setSize(600,600); 
	 setDefaultCloseOperation(EXIT_ON_CLOSE); } 
	 catch(Exception e) { 
	 e.printStackTrace(); 
	 System.out.println("Some problem has occured"+e.getMessage()); } 
	 } }
	*/
	

}
