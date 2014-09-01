package test;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		  int today2 = new Date().getDate();
//		  Date today = new Date();
//		  Date myDate = new Date(today.getYear(),today.getMonth(),today.getDay());
//		  int myDate2 = myDate.getDate();
//		  System.out.println("My Date is"+myDate);    
//		  System.out.println("Today Date is"+today);
//		  if (today2 == myDate2 )
//			  System.out.println(today2);
//		  
		
		  int aaa = new Date().getMonth();
		  int bbb = new Date().getDate();
		  int ccc = new Date().getYear()+1900;
		  String datum = aaa+"-"+bbb+"-"+ccc;
		  System.out.println(datum);
		  String s = "812014"
		  		+ "	 20140901 "
		  		+ "  2014";
		  if(s.equals(datum)){
			  System.out.println("ginekologija lacok");
		  }
		  
	}

}
