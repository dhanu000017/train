package console;

import org.json.simple.JSONObject;

public class Cusdetails {

	public int CusId;
	public int TrainId;
	public String TrainFrom;
	public String TrainTo;
	public int NumOfSeats;
	public String PhoneNum;
	public String DateAndTime;
	public String DTime;
	
	public Cusdetails(int cusId, int trainId, String trainFrom, String trainTo, int numOfSeats, String phoneNum,
			String dateAndTime) {
		
		CusId = cusId;
		TrainId = trainId;
		TrainFrom = trainFrom;
		TrainTo = trainTo;
		NumOfSeats = numOfSeats;
		PhoneNum = phoneNum;
		String arr[]=dateAndTime.split(" ");
		String arr2[]=arr[0].split("-");
		DateAndTime = arr2[2]+"/"+arr2[1]+"/"+arr2[0];
		DTime = arr[1];
	}
	
	public JSONObject jsobj() {
		JSONObject jsonobj2=new JSONObject();
		jsonobj2.put("CusId", CusId);
		jsonobj2.put("TrainId", TrainId);
		jsonobj2.put("TrainFrom", TrainFrom);
		jsonobj2.put("TrainTo", TrainTo);
		jsonobj2.put("NumOfSeats", NumOfSeats);
		jsonobj2.put("PhoneNum", PhoneNum);
		jsonobj2.put("DateAndTime", DateAndTime);
		jsonobj2.put("Time", DTime);
		return jsonobj2;
	}
	
	
}
