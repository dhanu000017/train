package console;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.apache.catalina.connector.Response;
import org.apache.log4j.Level;

public class loginManager {

  public static customer signUp(String finame, String laname,String usname, String mobnum, String pass) {
	  
//	customer.logg.log(Level.INFO," Entering sign up method"+LocalDateTime.now());
  
    String name1, name2, usname1 ,password, mobnumber;
    
      name1 = finame;
    
//-----------------------------------------------------------getting first name-------------------------
      name2 = laname;
     

      usname1=usname;
  //-----------------------------------------------------------getting last name-------------------------

      mobnumber = mobnum;
    
    
  //-----------------------------------------------------------getting mobile number-------------------------
      password = pass;
     

  //-----------------------------------------------------------getting password-------------------------

    customer newcusobj = new customer(name1, name2,usname1, mobnumber, password);
    DbManager.addingdata(newcusobj);
    
    System.out.println(newcusobj.Id + " is your id");
//	customer.logg.log(Level.INFO," Exiting sign up method"+LocalDateTime.now());
    return newcusobj;

  }

  public static customer login(String Loginna,String LoginPass) {
//	customer.logg.log(Level.INFO,"Entering login method"+LocalDateTime.now());
   String getingna=Loginna;
  
//      try {
//    	customer.logg.log(Level.INFO,"getting id from the user in login method"+LocalDateTime.now());
//        getingna =Integer.parseInt(Loginna);
//      } catch (Exception e) {
//        // TODO: handle exception
//          }
  
    String getingpass =LoginPass;
    System.out.println(getingpass);
   
    customer cusobj3 = DbManager.getingcus(getingna);

    if (cusobj3 == null) {
      System.out.println("user not found");
      
//      mainClass.main(new String[] {"e"});
      return null;
    }
    else if (cusobj3.password.equals(getingpass)) {
      System.out.println(cusobj3.Role);
    	System.out.println("correct");
      return cusobj3;
    }
    else {
      System.out.println("password wrong");
      return null;
    }

//  }

}
}