package console;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;
import org.apache.log4j.Level;




public class adminPage {
	Scanner sca=new Scanner(System.in);
		String tridma = "^[0-9]{6}";
	  	String trnam1 = "^[A-Za-z\\s]{3,30}+";
	  	String trid1;
		String trna;
		String trst;
		String trtim;
		String tred;
		String trpr1;
		String trse1;
		String nameofadmin;
		String adminpass;
		String delTrain;
		int trid;
		int trpr;
		int trse;
	protected void adminUse() throws IOException {
//	 customer.logg.log(Level.INFO," Entering from adminuse method "+LocalDateTime.now());
	 System.out.println("enter the user name ");
	 String login=sca.nextLine();
	 System.out.println("enter password ");
	 String pass=sca.nextLine();
	 customer cusobj1;
  
  //---------------------------------------------------------------------Instance--------------------------------
  
  if(login.equals(DbManager.AdminName) && pass.equals(DbManager.AdminPass)) {	
	  
	  adminlogin:
        while(true) {
              System.out.println("0-->to exit\n1-->To view passanger details\n2-->To add train\n3-->To view train details\n4-->change Admin name\n5-->change Admin Password\n6-->cancel a train");
              String use2=sca.nextLine();
         switch(use2) {
         
         case "0":
          	  System.out.println("thank you!!!");
          	  mainClass.main(new String[] {"e"});
          	  break;
         case "1":
               DbManager.adminView();
               break;
         case "2":
            	addingTrain();
          	  	break;
         case "3":
            	DbManager.ViewTrainDetails();
          	  	break;
         case "4":
        	 while(true) {
        		 try {
// 					customer.logg.log(Level.INFO,"getting admin name from adminUse method"+LocalDateTime.now());
        			System.out.println("Please enter your admin name");
             	 	nameofadmin=sca.nextLine();
             	 		if(nameofadmin.matches(trnam1)) {
             	 			 //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
             	 			
//             	 			DbManager.updateAdminName(nameofadmin);
             	 			
             	 			 //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
             	 			break;	
             	 	}
             	 	System.out.println("please enter your name properly");
				} catch (Exception e) {
					// TODO: handle exception
				}
        	 }
        	    
         case "5":
        	    System.out.println("Please enter your admin password");
       	    	adminpass=sca.nextLine();
       	    	if(adminpass!=null) {
       	    	 //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
       	    		
//        	    DbManager.updateAdminPass(adminpass);
       	    		
       	    	 //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
       	  		break;
       	    	}
       	    	System.out.println("password most have some letter");
       	    	
         case "6":
        	 while(true) {
        		 try {
        			 System.out.println("Please enter your train id");
        			 delTrain=sca.nextLine();
        			 int deltrain=Integer.parseInt(delTrain);
        			 //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        			 
//             	 		DbManager.deletingTrain(delTrain);
        			 
        			 //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            	  		break;	
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("please enter your id properly");
				}
        	 }
         default :
          		  System.out.println("enter a valid input");
            }
        }

  }
  else {
		 System.out.println("you are not a user !!!");
			mainClass.main(new String[] {"e"});
	 	}
	}
	
		public void addingTrain() {
		
			while(true) {
				try {
//					customer.logg.log(Level.INFO," Entering addingTrain method "+LocalDateTime.now());
					System.out.println("Enter the Id of the train");
					trid1=sca.nextLine();
					 if(trid1.matches(tridma)) {
						 trid=Integer.parseInt(trid1);
						 break; 
					 }
					System.out.println("enter 6 digit number");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("enter only number");
				}
				
				
			}
			
			while(true) {
//				customer.logg.log(Level.INFO," getting train name in  addingTrain method "+LocalDateTime.now());
				System.out.println("Enter the name of the train");
				 trna=sca.nextLine();
				 
				if (trna.matches(trnam1)) {
			          break;
			        } else {
			          System.out.println("invalid train name");
			        }
				}
			
			while(true) {
				try {
//					customer.logg.log(Level.INFO," getting timing of the train in addingTrain method "+LocalDateTime.now());
					System.out.println("Enter the timing of the train (HH:MM)");
				    String trti=sca.nextLine();
				    String spti[]=trti.split(":");
				    trtim=spti[0]+":"+spti[1]+":00";
				    int hh=Integer.parseInt(spti[0]);
				    int mm=Integer.parseInt(spti[1]);
				    if((hh>=0&&hh<=24)&&(mm>=0&&mm<60))
				    break;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("enter time in number");
				}
			}
			
			
			while (true) {
//				customer.logg.log(Level.INFO," getting starting place of the train in addingTrain method "+LocalDateTime.now());
				System.out.println("enter the starting place of the train");
			    trst=sca.nextLine();
				
				if (trst.matches(trnam1)) {
			          break;
			        } else {
			          System.out.println("invalid from address");
			        }
				
			}
			
			while (true) {
//				customer.logg.log(Level.INFO," getting ending place of the train in addingTrain method "+LocalDateTime.now());
				System.out.println("enter the ending place of the train");
				tred=sca.nextLine();
				
				if (tred.matches(trnam1)) {
			          break;
			        } else {
			          System.out.println("invalid to address");
			        }
				
			}
			
			while (true) {
				try {
//					customer.logg.log(Level.INFO," getting price of the ticket in addingTrain method "+LocalDateTime.now());
					System.out.println("enter the price of the ticket");
				    trpr1=sca.nextLine();
					trpr=Integer.parseInt(trpr1);
					break;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("enter only number");
				}
				
				
			}
			
			 while (true) {
				 try {
//						customer.logg.log(Level.INFO," getting number of seats in the train in addingTrain method "+LocalDateTime.now());
						System.out.println("enter the seats of the train");
						trse1=sca.nextLine();
						
						trse=Integer.parseInt(trse1);
						break;
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("enter only number");
					}
			      
			    }
			
			 DbManager.AddTrain(trid,trna,trtim,trst,tred,trpr,trse);
//				customer.logg.log(Level.INFO," Exiting from addingTrain method "+LocalDateTime.now());
		}

		

}


