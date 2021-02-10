package testcases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OJDBC {
	static final String DB_URL ="jdbc:oracle:thin:@10.5.30.200:1590/BRAC_UAT_R2";
	static final String USER = "RIB_UAT_APP_USER_R2";
	static final String PASS = "rib_UAT_APP_USER_R2321";
	public static void main(String args[])throws SQLException {  
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.5.30.200:1590:BRAC_UAT_R2",USER,PASS);	
			System.out.println("------------------------------------");
			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@//10.5.30.200:1590/ubaprod","RIB_UAT_APP_USER_R2","rib_UAT_APP_USER_R2321");
			Statement stmt=con.createStatement();  
			//ResultSet rs=stmt.executeQuery("select * from user_otp_maintenance tatus_id='PENDING' order by generated_datetime desc"); 
//			ResultSet rs=stmt.executeQuery("select * from user_otp_maintenance where status_id='PENDING' order by generated_datetime desc");  			
			ResultSet rs=stmt.executeQuery("select * from user_otp_maintenance where cif_number='00117434'and status_id='PENDING' and ROWNUM <= 1 order by id desc");  
			System.out.println(rs +"value");
			System.out.println("------Result fetched---------");			
			while(rs.next())  {
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				String otp =rs.getString("otp_number");
				System.out.println(otp+"finalvalue");
			}
			
			stmt.close();
			con.close(); 
		}
	catch(Exception e){
		System.out.println(e);
	}  
	  
	}  
}
