//package console;
//
//import java.util.Scanner;
//
//	public class checking {
//		int viewId;
//		String viewPass;
//		Scanner scan=new Scanner(System.in);
//		
//	public customer checkingView() {
//		
//		
//		while(true) {
//			try {
//				System.out.println("Enter your Id");
//				viewId=scan.nextInt();
//				scan.nextLine();
//				break;
//			} catch (Exception e) {
//				// TODO: handle exception
//				System.out.println("enter your Id");
//			}
//			
//		}
//		
//		while(true) {
//			try {
//				System.out.println("Enter your password");
//				viewPass=scan.nextLine();
//				
//				customer cusobj4 = DbManager.getingcus(viewId);
//				
//				 if (cusobj4 == null) {
//				      System.out.println("user not found");
//				      return null;
//				    }
//				    else if (cusobj4.password.equals(viewPass)) {
//				      return cusobj4;
//				    }
//				    else {
//				      System.out.println("password wrong");
//				      return null;
//				    }
//			} catch (Exception e) {
//				// TODO: handle exception
//				System.out.println("enter your password");
//
//			}
//		}
//
//}
//}
