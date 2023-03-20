package console;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;


public class customer extends Thread{
  public String firstname;
  public String lastname;
  public String usname;
  public String phoneNum;
  public int Id;
  public String Role;
  public  String doj1;
  public  String doj;
  public String password;
  public boolean dateboolean=true;
  Train tr;
  Scanner scan = new Scanner(System.in);
  Calendar calendar = Calendar.getInstance();
//  static Logger logg = Logger.getLogger(customer.class.getName());


 //---------------------------------------------------------------------Instance--------------------------------		 
  
  
  public customer(String name1, String name2,String usname1,String phoneNum ,String password) {
//	customer.logg.log(Level.INFO, name1 + " " + name2 + " Entering customer class constructor " + LocalDateTime.now());
    this.firstname = name1;
    this.lastname = name2;
    this.usname=usname1;
    this.phoneNum = phoneNum;
    this.password=password;
    this.Id=DbManager.getcountcustomers()+1;
//    customer.logg.log(Level.INFO,"Exiting customer class constructor"+LocalDateTime.now());
    }
  
  public customer(int int1, String usstring, String fistring,String laname, String numstring, String passstring,String Role) {
		// TODO Auto-generated constructor stub
//  	customer.logg.log(Level.INFO,"Entering customer class constructor"+LocalDateTime.now());
	this.Id=int1;
	this.usname=usstring;
	this.firstname=fistring;
	this.lastname=laname;
	this.phoneNum=numstring;
	this.password=passstring;
	this.Role=Role;
//  	customer.logg.log(Level.INFO,"Exiting customer class constructor"+LocalDateTime.now());
  	}

  public JSONObject jsobj2() {
		JSONObject jsonobj3=new JSONObject();
		jsonobj3.put("Id", Id);
		jsonobj3.put("usname", usname);
		jsonobj3.put("firstname", firstname);
		jsonobj3.put("lastname", lastname);
		jsonobj3.put("phoneNum", phoneNum);
		jsonobj3.put("password", password);
		jsonobj3.put("Role", Role);
		return jsonobj3;
	}
  
  
  
  
	public List<Train> bookaticket(String FrDetails,String ToDetails,String date2,String Class2) {
//			customer.logg.log(Level.INFO,"Entering bookaticket method"+LocalDateTime.now());	
			
    	 	String trfrom=FrDetails;
    	 	String trto=ToDetails;
    	 	String date1=date2;
    	    String class1=Class2;
 		 	List<Train> li1=DbManager.searchingTrainfrom(trfrom,trto);
 		 	if(li1.size()==0) {

 		 		List<Integer> tr4=DbManager.searchingmidTrainfrom(trfrom,trto);
 		 		List<Train> tr5=DbManager.searchingTrainFromId(tr4);
 		 		
 		 		return tr5;
 		 	}
 		 	return li1;
	}
 		 	
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	public List<Train> bookaticket(String FrDetails,String ToDetails,String date2,String Class2) {
////		customer.logg.log(Level.INFO,"Entering bookaticket method"+LocalDateTime.now());	
//		
//	 	String trfrom=FrDetails;
//	 	String trto=ToDetails;
//	 	String date1=date2;
//	    String class1=Class2;
//		 	List<Train> li1=DbManager.searchingTrainfrom(trfrom,trto);
//		 	if(li1.size()==0) {
////		 		List<Train> liofmid=DbManager.searchingmidTrainfrom(trfrom,trto);
////		 		return liofmid;
//		 		return li1;
//		 	}
//		 	
//		 	return li1;
//}
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
  
	
     public void viewbookedticket() {
//    	 customer.logg.log(Level.INFO,"Entering viewbookedticket method"+LocalDateTime.now());
    	DbManager.viewticket(Id);
//    	customer.logg.log(Level.INFO,"Exiting viewbookedticket method"+LocalDateTime.now());
      }

  
  }
