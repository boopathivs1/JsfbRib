package testcases;

import java.io.IOException;

import otpCodeDB.Datats;

public class Testingdata {

	public static void main(String[] args) throws NullPointerException, IOException  {
		// TODO Auto-generated method stub

String a[][]=		Datats.getAllSheetData("./data/Sheet.xlsx","c");
		System.out.println(a[0][0]);
		System.out.println(a[0][1]);
		System.out.println(a[0][2]);
		System.out.println(a[0][3]);
		
		
		
		
	}
}