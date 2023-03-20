package console;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;
import org.apache.log4j.Level;

public class mainClass {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
//    customer.logg.log(Level.INFO, "Entering main method " + LocalDateTime.now());
    customer cusObj = null;
    adminPage adminObj = new adminPage();
    //-------------------------------------------------------------objects-----------------------

    Scanner sc = new Scanner(System.in);
    boolean varboolean = true;
    //-------------------------------------------------------------instance-----------------------

    while (varboolean){
      System.out.println("""
        1--> admin 
        2--> passenger """);
        String charac = sc.nextLine();

        switch (charac) {
          
        case "1":
        	 try {
 				adminObj.adminUse();
 				break;
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.getMessage();
 			}        

        case "2":
          userlogin:
            while (true) {
              System.out.println("1-->sign up \n2-->log in");
              String use = sc.nextLine();

              switch (use) {

              case "1":
//            	  cusObj = loginManager.signUp();
            	  break;
              case "2":
//            	  cusObj = loginManager.login();
                  break;
              default:
            	  System.out.println("Enter valid input");
            	  continue userlogin;
              }
              	break userlogin;
            }
          varboolean = false;
          break;

        default:
          System.out.println("enter valid input !!!");
        }

      }
     
      try {
    	cusObj.run();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("error on tread");
	}
//      customer.logg.log(Level.INFO, " Exiting from main method " + LocalDateTime.now());
    }

  }