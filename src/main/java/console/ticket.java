package console;

import java.time.LocalDateTime;

import org.apache.log4j.Level;

public class ticket {
	
public int cusId;
public int TrainId;
public int NumOfTickets;
public String bookedTime;

 public ticket(int cusId,int TrainId,int NumOfTickets,String bookedTime) {
//	 customer.logg.log(Level.INFO,"Entering ticket class construtor"+LocalDateTime.now());
	 this.cusId=cusId;
	 this.TrainId=TrainId;
	 this.NumOfTickets=NumOfTickets;
	 this.bookedTime=bookedTime;
//	 customer.logg.log(Level.INFO,"Exiting ticket class construtor"+LocalDateTime.now());
 }
}
