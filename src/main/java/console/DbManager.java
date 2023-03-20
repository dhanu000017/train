package console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.apache.log4j.Level;

public class DbManager {
    static String AdminName;
    static String AdminPass;
	static int seat;
	static String tim;
	static String fr1;
    static String to1;
   public  static Connection con;
  static {
	  try {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/train_ticket", "dhanu", "8754199675");
	  } catch (Exception e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		  System.out.println("Database connection failed");
	  }

  		}
  
  public static int getcountcustomers() {

	  try {
//	      customer.logg.log(Level.INFO,"Entering getcountcustomers method "+LocalDateTime.now());
		  Statement stmt = con.createStatement();
		  ResultSet rs = stmt.executeQuery("select count(*) from Customer");
      if (rs.next()) {
    	  return rs.getInt(1);
      		}
	  	} catch (SQLException e) {
	  		// TODO Auto-generated catch block
	  		System.out.println("error occured in DB 1");
    }
//	  customer.logg.log(Level.INFO,"Exiting from getcountcustomers method "+LocalDateTime.now());
	  return 0;
  }

  public static void addingdata(customer cus) {
//    customer.logg.log(Level.INFO,"Entering addingdata method "+LocalDateTime.now());
    PreparedStatement ps;
    try {
    	ps = con.prepareStatement("insert into Customer values(?,?,?,?,?,?,?)");
    	ps.setInt(1, cus.Id);
    	ps.setString(2, cus.usname);
    	ps.setString(3, cus.firstname);
    	ps.setString(4, cus.lastname);
    	ps.setString(5, cus.phoneNum);
    	ps.setString(6, cus.password);
    	ps.setString(7, "cus");
    	ps.executeUpdate();
    } catch (SQLException e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();
    	System.out.println("error occured in DB 2");
    }
//    customer.logg.log(Level.INFO,"Exiting addingdata method "+LocalDateTime.now());
  }
  
  public static customer getingcus(String na) {
    PreparedStatement ps;
    try {
//    	customer.logg.log(Level.INFO,"Entering getingcus method"+LocalDateTime.now());
    	ps = con.prepareStatement("select * from Customer where UserName =  ?");
    	ps.setString(1, na);
    	ResultSet rs = ps.executeQuery();
      if (rs.next()) {
    	  return new customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7));
      }
    } catch (SQLException e) {
    	// TODO Auto-generated catch block
    	System.out.println("error occured in DB 3");
    }
//    customer.logg.log(Level.INFO,"Exiting getingcus method"+LocalDateTime.now());
    return null;
  }

 
  
  public static List <Train> searchingTrainfrom(String trfrom, String trto) {
//	  customer.logg.log(Level.INFO,"Entering searchingTrainfrom method "+LocalDateTime.now());
	  List < Train > li = new ArrayList < > ();
    try {
    	PreparedStatement ps = con.prepareStatement("select * from trainDetails where TrainFrom like ? && TrainTo like ? && status like ?");
    	ps.setString(1, "%" + trfrom + "%");
    	ps.setString(2, "%" + trto + "%");
    	ps.setString(3,"running");
    	ResultSet rs = ps.executeQuery();
      while (rs.next()) {
    	  li.add(new Train(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9),rs.getString(10), rs.getString(11)));
      }
    } catch (Exception e) {
      // TODO: handle exception
    	System.out.println("error occured in DB 4");
    	}
//    customer.logg.log(Level.INFO,"Exiting searchingTrainfrom method "+LocalDateTime.now());
    return li;
  	}

  public static void gettingTrainSeats(int TrainId, int nos) {
    try {
//      customer.logg.log(Level.INFO,"Entering gettingTrainSeats method "+LocalDateTime.now());	 
      PreparedStatement ps = con.prepareStatement("select * from trainDetails where TrainId = ?");
      ps.setInt(1, TrainId);
      ResultSet rs = ps.executeQuery();
    while (rs.next()) {
    	tim=rs.getString(3);
    	fr1=rs.getString(4);
//    	to1=rs.getString(5);
    	int pric = rs.getInt(6);
        int se = rs.getInt(7);
        seat = se - nos;
        System.out.println("Total price of the ticket = "+(nos*pric));
    	}
    } catch (Exception e) {
      // TODO: handle exception
    	System.out.println("error occured in DB 5");
    }
//    customer.logg.log(Level.INFO,"Exiting gettingTrainSeats method "+LocalDateTime.now());
   }

  public static void booking(int trainId, int nos,String doj,String tim) {
    try {
//      customer.logg.log(Level.INFO,"Entering booking method "+LocalDateTime.now());	   
    	System.out.println("booking");
//    	String  tim="07:00:00";
      PreparedStatement ps = con.prepareStatement("insert into bookingDetails values(?,?,?)");
      ps.setInt(1, trainId);
      ps.setInt(2, seat);
      ps.setString(3,doj+" "+tim);
      ps.executeUpdate();
   } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println("error occured in DB 6");
    }
//    customer.logg.log(Level.INFO,"Exitting from booking method "+LocalDateTime.now());	   
  }
  
  public static void bookingDetails(int Id,int trainid,int numofseats,String phoneNum, String doj,String tim,String dur,String to) {
//	  customer.logg.log(Level.INFO,"Entering bookingDetails method "+LocalDateTime.now());

      PreparedStatement ps1;
	try {
		ps1 = con.prepareStatement("insert into cusDetails values(?,?,?,?,?,?,?,?)");
		ps1.setInt(1,Id);
		ps1.setInt(2,trainid);
		ps1.setString(3,fr1);
		ps1.setString(4,to);
		ps1.setInt(5,numofseats);
		ps1.setString(6,phoneNum);
		ps1.setString(7,doj+" "+tim);
		ps1.setString(8,dur);
		ps1.executeUpdate();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		 
	      System.out.println("error occured in DB 7");
	}
//     customer.logg.log(Level.INFO,"Exitting bookingDetails method "+LocalDateTime.now());	   
  }
  
  public static void cancelbooking(int Id,int trainid,int numofseats,String phoneNum, String doj,String tim,String dur) {
//	  customer.logg.log(Level.INFO,"Entering bookingDetails method "+LocalDateTime.now());

      PreparedStatement ps1;
	try {
		ps1 = con.prepareStatement("delete from cusDetails where CusId=? && TrainId =? && TrainFrom=? && TrainTo = ? && NumofSeats = ? && mobNum = ? && TrainTime=? && duration=? ");
		ps1.setInt(1,Id);
		ps1.setInt(2,trainid);
		ps1.setString(3,fr1);
		ps1.setString(4,to1);
		ps1.setInt(5,numofseats);
		ps1.setString(6,phoneNum);
		ps1.setString(7,doj+" "+tim);
		ps1.setString(8,dur);
		ps1.executeUpdate();
	System.out.println("delete");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		 
	      System.out.println("error occured in DB 7");
	}
//     customer.logg.log(Level.INFO,"Exitting bookingDetails method "+LocalDateTime.now());	   
  }
  
  
  //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  public static  List<Cusdetails> viewticket(int ID) {
	  List<Cusdetails> list = new ArrayList<>();
	  
      try {		
//    	customer.logg.log(Level.INFO," Entering viewticket method "+LocalDateTime.now());
		PreparedStatement ps = con.prepareStatement("select * from cusDetails where CusId = ?");
		ps.setInt(1,ID);
		 ResultSet rs = ps.executeQuery();
	      while (rs.next()) {

	    	  Cusdetails objCusdetails= new Cusdetails(rs.getInt(1), rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7));
	    	  list.add(objCusdetails);
	      }
 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
	      System.out.println("error occured in DB 8");
	}
      return list;
//      customer.logg.log(Level.INFO," Exitting from viewticket method "+LocalDateTime.now());
      }
  
  //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

  
  public static void adminView() {
	  try {
//		  	customer.logg.log(Level.INFO,"Entering adminView method "+LocalDateTime.now());
			PreparedStatement ps = con.prepareStatement("select * from cusDetails");
			ResultSet rs = ps.executeQuery();
		      while (rs.next()) {

		    	 System.out.println(rs.getInt(1)+"  "+ rs.getInt(2)+"  "+ rs.getString(3)+"  "+ rs.getString(4)+"  "+rs.getInt(5)+"  "+rs.getString(6)+"  "+rs.getString(7));
		      }
//		    customer.logg.log(Level.INFO,"Exiting from adminView method "+LocalDateTime.now());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		      System.out.println("error occured in DB 9");
			}
  }
  public static void AddTrain(int trid,String trna,String trtim,String trst,String tred,int trpr,int trse)
  {
	  try {
//		  customer.logg.log(Level.INFO,"Entering AddTrain method "+LocalDateTime.now());
	      PreparedStatement ps = con.prepareStatement("insert into trainDetails values(?,?,?,?,?,?,?)");
	      ps.setInt(1, trid);
	      ps.setString(2, trna);
	      ps.setString(3,trtim);
	      ps.setString(4, trst)	;
	      ps.setString(5, tred);
	      ps.setInt(6,trpr);
	      ps.setInt(7,trse);
	      ps.executeUpdate();
//		  customer.logg.log(Level.INFO,"Storeing data in database in AddTrain method "+LocalDateTime.now());
		  System.out.println("Train added sucessfully");
//		  customer.logg.log(Level.INFO,"Exiting from AddTrain method "+LocalDateTime.now());
	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	        System.out.println("error occured in DB 10");
	    	}

  }
  
  public static void ViewTrainDetails() {
	  
	  try {
//		  	customer.logg.log(Level.INFO,"Entering ViewTrainDetails method "+LocalDateTime.now());
			PreparedStatement ps = con.prepareStatement("select * from trainDetails");
			ResultSet rs = ps.executeQuery();
		      while (rs.next()) {

		    	 System.out.println(rs.getInt(1)+"  "+ rs.getString(2)+"  "+ rs.getString(3)+"  "+ rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getInt(6)+"  "+rs.getInt(7));
		      }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
		      System.out.println("error occured in DB 11");
		}
//	  customer.logg.log(Level.INFO,"Exitting from ViewTrainDetails method "+LocalDateTime.now());
  }
  //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  public static int searching(int Trainid,String doj,String tim) {
	  int count=0;
	  try {
	      PreparedStatement ps = con.prepareStatement("select count(*) from ticketsDeatils where TrainId=? && TrainTime=?");
	      ps.setInt(1,Trainid);
	      ps.setString(2,doj+" "+tim);
	      ResultSet rs = ps.executeQuery();
			 if(rs.next()) {
			count=rs.getInt(1);
				      }  
	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	        System.out.println("error occured in DB 12");
	    	}
	  System.out.println(count);
	  return count;
  }

  public static void insertSeats(int Trainid ,int Fisnos,int secnos,String doj,String tim) {
	  try {
		  
	      PreparedStatement ps = con.prepareStatement("insert into ticketsDeatils values(?,?,?,?)");
	      ps.setInt(1,Trainid);
	      ps.setInt(2,Fisnos);
	      ps.setInt(3,secnos);
	      ps.setString(4,doj+" "+tim);
	      
	      ps.executeUpdate();
	     System.out.println("Train added sucessfully");

	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	        System.out.println("error occured in DB 12");
	    	}
  }
  public static String updateseat(int Trainid,int nos,String doj,String tim,String cl) {
	 List <Integer> seats=gettingNoSeats(Trainid);
	 
	  if(cl.equals("FIRST CLASS") && nos<=seats.get(0)) {
		  try {
		      PreparedStatement ps = con.prepareStatement("update ticketsDeatils set FirstClass=FirstClass-? where TrainId=? && TrainTime= ?");
		      ps.setInt(1,nos);
		      ps.setInt(2,Trainid);
		      ps.setString(3,doj+" "+tim);
		      ps.executeUpdate();
		    } catch (SQLException e) {
		      // TODO Auto-generated catch block
		        System.out.println("error occured in DB 12");
		    	}
		  return "Ticket Booked successful";
	  }
	  else if(cl.equals("SECOND CLASS") && nos<=seats.get(1)) {
		  try {
		      PreparedStatement ps = con.prepareStatement("update ticketsDeatils set SecondClass=SecondClass-? where TrainId=? && TrainTime= ?");
		      ps.setInt(1,nos);
		      ps.setInt(2,Trainid);
		      ps.setString(3,doj+" "+tim);
		      ps.executeUpdate();
		    } catch (SQLException e) {
		      // TODO Auto-generated catch block
		        System.out.println("error occured in DB 12");
		    	}
		  return "Ticket Booked Successful";
	  }
	  else {
		  return	"invalid  train tickets";
	  }
	  
  }
  
  public static List<Integer> gettingNoSeats(int trainId){
		List<Integer> seats=new ArrayList<>();
		try {
			 PreparedStatement pr=con.prepareStatement("select * from trainDetails where TrainId =? && status=?");
			 pr.setInt(1,trainId);
			 pr.setString(2, "running");
			 ResultSet rs = pr.executeQuery();
			 if(rs.next()) {
				 seats.add(rs.getInt(8));
				 seats.add(rs.getInt(9));
				      }  
		} catch (Exception e) {
			// TODO: handle exception
		} 
		  return seats;  
	  }
  //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

  public static void updateAdminName(String nameofadmin,String passofadmin) {
	  try {
//		  	customer.logg.log(Level.INFO,"Entering updateAdminName method "+LocalDateTime.now());
		  	PreparedStatement ps = con.prepareStatement("update Customer set UserName=? , password=? where Id=?");
		  	ps.setString(1,nameofadmin);
		  	ps.setString(2,passofadmin);
		  	ps.setInt(3,1);
		  	ps.executeUpdate();
		  	System.out.println("Admin Name updated sucessfully");

	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	        System.out.println("error occured in DB 13");
	    	}
//	  customer.logg.log(Level.INFO,"Exiting updateAdminName method "+LocalDateTime.now());
  }
//  
//  
  public static void updateAdminPass(String adminPass) {
	  try {
//		  customer.logg.log(Level.INFO,"Entering updateAdminPass method "+LocalDateTime.now());
	      PreparedStatement ps = con.prepareStatement("update adminpass set Pass1=?");
	      ps.setString(1,adminPass);
	      ps.executeUpdate();
	      System.out.println("password updated sucessfully");
	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	        System.out.println("error occured in DB 14");
	    	}
//	  customer.logg.log(Level.INFO,"Exiting updateAdminName method "+LocalDateTime.now());
  }

  
  public static void deletingTrain(int  trainid) {
	  try {
//		  customer.logg.log(Level.INFO,"Entering deletingTrain method "+LocalDateTime.now());
	      PreparedStatement ps = con.prepareStatement("update trainDetails set status = ? where TrainId=?");
	      ps.setString(1,"stopped");
	      ps.setInt(2,trainid);
	      ps.executeUpdate();
	      System.out.println("train deleted sucessfully");

	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	        System.out.println("error occured in DB 17");
	    	}
//	  customer.logg.log(Level.INFO,"Exitting deletingTrain method "+LocalDateTime.now());
  }
  
  public static void activeTrain(int  trainid) {
	  try {
//		  customer.logg.log(Level.INFO,"Entering deletingTrain method "+LocalDateTime.now());
	      PreparedStatement ps = con.prepareStatement("update trainDetails set status = ? where TrainId=?");
	      ps.setString(1,"running");
	      ps.setInt(2,trainid);
	      ps.executeUpdate();
	      System.out.println("train activated sucessfully");

	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	        System.out.println("error occured in DB 17");
	    	}
//	  customer.logg.log(Level.INFO,"Exitting deletingTrain method "+LocalDateTime.now());
  }
  
  public static customer getingcu(String na) {
	    PreparedStatement ps;
	    try {
	    	
//	    	customer.logg.log(Level.INFO,"Entering getingcus method"+LocalDateTime.now());
	    	ps = con.prepareStatement("select * from Customer where UserName =  ?");
	    	ps.setString(1, na);
	    	ResultSet rs = ps.executeQuery();
	      if (rs.next()) {
	    	  return (new customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7)));
	      }
	    } catch (SQLException e) {
	    	// TODO Auto-generated catch block
	    	System.out.println("error occured in DB 3");
	    }
//	    customer.logg.log(Level.INFO,"Exiting getingcus method"+LocalDateTime.now());
	    return null;
	  }

  
  public static int getingcustomerId(String na) {
	    PreparedStatement ps;
	    try {
	    	
//	    	customer.logg.log(Level.INFO,"Entering getingcus method"+LocalDateTime.now());
	    	ps = con.prepareStatement("select * from cusDetails where CusId = (select id from Customer where UserName =?)");
	    	ps.setString(1, na);
	    	ResultSet rs = ps.executeQuery();
	      if (rs.next()) {
	    	 return rs.getInt(1); 
	      }
	    } catch (SQLException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    	System.out.println("error occured in DB 3");
	    }
//	    customer.logg.log(Level.INFO,"Exiting getingcus method"+LocalDateTime.now());
	    return 0;
	  }

	  
 

  public static  List<customer> ViewAllPassengerDe() {
	  List<customer> list2 = new ArrayList<>();
	  
      try {		
//    	customer.logg.log(Level.INFO," Entering viewticket method "+LocalDateTime.now());
		PreparedStatement ps = con.prepareStatement("select * from Customer where Role =?");
		ps.setString(1,"cus");
		 ResultSet rs = ps.executeQuery();
	      while (rs.next()) {

	    	  customer objCusdetails= new customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7));
	    	  list2.add(objCusdetails);
	      }
 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
	      System.out.println("error occured in DB 8");
	}
      return list2;
//      customer.logg.log(Level.INFO," Exitting from viewticket method "+LocalDateTime.now());
      }
  
  public static  List<Train> ViewAllTrainDe() {
	  List<Train> list3 = new ArrayList<>();
	  
      try {		
//    	customer.logg.log(Level.INFO," Entering viewticket method "+LocalDateTime.now());
		PreparedStatement ps = con.prepareStatement("select * from trainDetails");
		 ResultSet rs = ps.executeQuery();
	      while (rs.next()) {
	    	  Train objCusdetailss= new Train(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getString(10),rs.getString(11));
	    	  list3.add(objCusdetailss);
	      }
 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
	      System.out.println("error occured in DB 8");
	}
      return list3;
//      customer.logg.log(Level.INFO," Exitting from viewticket method "+LocalDateTime.now());
      }
  
    
  public static void logout(String us) {
	  
	  try {		
//	    	customer.logg.log(Level.INFO," Entering viewticket method "+LocalDateTime.now());
			PreparedStatement ps = con.prepareStatement("delete from session where UserName=?");
			ps.setString(1, us);
			ps.executeUpdate();
		      
	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		      System.out.println("error occured in DB 8");
		      
		}
	  
  }
  
  
  public static void deltetrain(int trid) {
	  
	  try {		
//	    	customer.logg.log(Level.INFO," Entering viewticket method "+LocalDateTime.now());
			PreparedStatement ps = con.prepareStatement("update stops set status = ? where TrainId=?");
			ps.setString(1, "stopped");
			ps.setInt(2, trid);
			ps.executeUpdate();
		      
	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		      System.out.println("error occured in DB 8");
		      
		}
	  
	  
	  
  }
  
public static void actitrain(int trid) {
	  
	  try {		
//	    	customer.logg.log(Level.INFO," Entering viewticket method "+LocalDateTime.now());
			PreparedStatement ps = con.prepareStatement("update stops set status = ? where TrainId=?");
			ps.setString(1, "running");
			ps.setInt(2, trid);
			ps.executeUpdate();
		      
	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		      System.out.println("error occured in DB 8");
		      
		}
  }
  
  
  public static List<Integer> searchingmidTrainfrom(String fr,String to) {
	  List <Integer> trainId=new ArrayList<>();
	  try {
	    	PreparedStatement ps = con.prepareStatement("select * from stops where TrainFrom like ? && StopName like ? && status like ?");
	    	ps.setString(1, "%" + fr + "%");
	    	ps.setString(2, "%" + to + "%");
	    	ps.setString(3,"running");
	    	ResultSet rs = ps.executeQuery();
	      while(rs.next()) {
		    	trainId.add(rs.getInt(1));  
	      }
	    } catch (Exception e) {
	      // TODO: handle exception
	    	System.out.println("error occured in DB 4");
	    	}
//	    customer.logg.log(Level.INFO,"Exiting searchingTrainfrom method "+LocalDateTime.now());
	    return trainId;
	    
  }
  
  
  public static List<Train> searchingTrainFromId(List<Integer> train_id) {
	  List <Train>tr=new ArrayList<>();
	  
	  try {
		  for(int i=0; i<train_id.size(); i++) {
			    PreparedStatement pr=con.prepareStatement("select * from trainDetails where TrainId =? && status=?");
				pr.setInt(1,train_id.get(i));
				pr.setString(2, "running");
				ResultSet rs = pr.executeQuery();
				while(rs.next()) {
					System.out.println(train_id.get(i));
					 tr.add(new Train(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getString(10),rs.getString(11)));
				      }  
			  
		  }
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return tr;
	  
	  
  }
  
 public static void AddingTrainStops(int trainid,int stopno,String from,String to,int price,String sta) {
	 
	 try {
		PreparedStatement pr =con.prepareStatement("insert into stops values(?,?,?,?,?,?)");
		pr.setInt(1,trainid);
		pr.setInt(2, stopno);
		pr.setString(3,from);
		pr.setString(4, to);
		pr.setInt(5,price);
		pr.setString(6, sta);
		pr.executeUpdate();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
 }
  
 
 public static void AddingTrain(int TrainId,String TrainName,String timing,String from,String to,int price,int FirstClass,int SecondClass,String duration) {
	 try {
		PreparedStatement pr =con.prepareStatement("insert into trainDetails values(?,?,?,?,?,?,?,?,?,?,?)");
		pr.setInt(1,TrainId);
		pr.setString(2, TrainName);
		pr.setString(3,timing);
		pr.setString(4, from);
		pr.setString(5,to);
		pr.setInt(6, price);
		pr.setInt(7, FirstClass+SecondClass);
		pr.setInt(8, FirstClass);
		pr.setInt(9, SecondClass);
		pr.setString(10, "running");
		pr.setString(11,duration);
		pr.executeUpdate();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
 }
 
 
 
 public static String CancellTicket(int Trainid,int nos,String doj,String tim,String cl) {
	 List <Integer> seats=gettingNoSeats(Trainid);
	 System.out.println(Trainid);
	 System.out.println(tim);
	  if(cl.equals("FIRST CLASS") && nos<=seats.get(0)) {
		  try {
		      PreparedStatement ps = con.prepareStatement("update ticketsDeatils set FirstClass=FirstClass+? where TrainId=? && TrainTime= ?");
		      ps.setInt(1,nos);
		      ps.setInt(2,Trainid);
		      ps.setString(3,doj+" "+tim);
		      ps.executeUpdate();
		    } catch (SQLException e) {
		      // TODO Auto-generated catch block
		        System.out.println("error occured in DB 12");
		    	}
		  return "Ticket Cancelled successful";
	  }
	  else if(cl.equals("SECOND CLASS") && nos<=seats.get(1)) {
		  try {
		      PreparedStatement ps = con.prepareStatement("update ticketsDeatils set SecondClass=SecondClass+? where TrainId=? && TrainTime= ?");
		      ps.setInt(1,nos);
		      ps.setInt(2,Trainid);
		      ps.setString(3,doj+" "+tim);
		      ps.executeUpdate();
		    } catch (SQLException e) {
		      // TODO Auto-generated catch block
		        System.out.println("error occured in DB 12");
		    	}
		  return "Ticket Cancelled Successful";
	  }
	  else {
		  return	"invalid  train tickets";
	  }
	  
  }
 

}