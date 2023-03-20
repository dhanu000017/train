package console;

import org.json.simple.JSONObject;


public class Train {
	public int TrainId;
	public String Trainname;
	public String Timing;
	public String TrainFrom;
	public String TrainTo;
	public int Price;
	public int NumOfSeats;
	public int FirstClass;
	public int SecondClass;
	public String Status;
	public String duration;
	
	public int getTrainId() {
		return TrainId;
	}

	public void setTrainId(int trainId) {
		TrainId = trainId;
	}

	public String getTrainname() {
		return Trainname;
	}

	public void setTrainname(String trainname) {
		Trainname = trainname;
	}

	public String getTiming() {
		return Timing;
	}

	public void setTiming(String timing) {
		Timing = timing;
	}

	public String getTrainFrom() {
		return TrainFrom;
	}

	public void setTrainFrom(String trainFrom) {
		TrainFrom = trainFrom;
	}

	public String getTrainTo() {
		return TrainTo;
	}

	public void setTrainTo(String trainTo) {
		TrainTo = trainTo;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public int getNumOfSeats() {
		return NumOfSeats;
	}

	public void setNumOfSeats(int numOfSeats) {
		NumOfSeats = numOfSeats;
	}

	public Train(String Trainname){
//		customer.logg.log(Level.INFO,"Entering train class construtor"+LocalDateTime.now());
		System.out.println(TrainId+"  train id");
		this.TrainId=TrainId;
		this.Trainname=Trainname;
		this.Timing=Timing;
		this.TrainFrom=TrainFrom;
		this.TrainTo=TrainTo;
		this.Price=Price;
		this.NumOfSeats=NumOfSeats;
//		customer.logg.log(Level.INFO,"Exiting ticket class construtor"+LocalDateTime.now());
	}
	
	public Train(int i, String string, String string2, String string3, String string4, int j, int k, int l, int m) {
		// TODO Auto-generated constructor stub
		this.TrainId=i;
		this.Trainname=string;
		this.Timing=string2;
		this.TrainFrom=string3;
		this.TrainTo=string4;
		this.Price=j;
		this.NumOfSeats=k;
		this.FirstClass=l;
		this.SecondClass=m;
	}
	
	public Train(int i, String string, String string2, String string3, String string4, int j, int k, int l, int m,String status,String duration) {
		// TODO Auto-generated constructor stub
		this.TrainId=i;
		this.Trainname=string;
		this.Timing=string2;
		this.TrainFrom=string3;
		this.TrainTo=string4;
		this.Price=j;
		this.NumOfSeats=k;
		this.FirstClass=l;
		this.SecondClass=m;
		this.Status=status;
		this.duration=duration;
	}

	public String toString() {
		return "Train Id:  "+TrainId+"Train name:  "+Trainname+"\nTrain Time:  "+Timing+"\nFrom:  "+TrainFrom+"\nTo:  "+TrainTo+"\nPrice:  "+Price;
	}
	
	public JSONObject getJson() {
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("TrainId", TrainId);
		jsonobj.put("Trainname", Trainname);
		jsonobj.put("Timing", Timing);
		jsonobj.put("TrainFrom", TrainFrom);
		jsonobj.put("TrainTo", TrainTo);
		jsonobj.put("NumOfSeats", NumOfSeats);
		jsonobj.put("Duration", duration);
		return jsonobj;
	}
	
	public JSONObject getJson2() {
		JSONObject jsonobj4=new JSONObject();
		jsonobj4.put("TrainId", TrainId);
		jsonobj4.put("Trainname", Trainname);
		jsonobj4.put("Timing", Timing);
		jsonobj4.put("TrainFrom", TrainFrom);
		jsonobj4.put("TrainTo", TrainTo);
		jsonobj4.put("Price", Price);
		jsonobj4.put("NumOfSeats", NumOfSeats);
		jsonobj4.put("FirstClass", FirstClass);
		jsonobj4.put("SecondClass", SecondClass);
		jsonobj4.put("Status", Status);
		jsonobj4.put("Duration", duration);
		return jsonobj4;
	}
	
	public Train(){
		
	}
}
