package otpCodeDB;

import java.security.Key;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class OJDBCDecrypt {
	private static String encryptMD5Key = "AA5B3D4D1E7FBA9CDF7B3D4D1E3AB927145B23456E7FBA22";

	static final String DB_URL ="jdbc:oracle:thin:@//172.25.15.17:1590/ubadevdb";
	static final String USER = "RIB_UAT_APP_USER_R2";
	static final String PASS = "rib_UAT_APP_USER_R2321";
	public static void main(String args[])throws SQLException {  

		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@10.5.30.200:1590:BRAC_UAT_R2",USER,PASS);	
			System.out.println("------------------------------------");
			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@//172.25.15.17:1590/ubadevdb","RIB_UAT_APP_USER_R2","rib_UAT_APP_USER_R2321");

//			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@//172.25.15.17:1590/ubadevdb","RIB_UAT_APP_USER_R2","rib_UAT_APP_USER_R2321");
			Statement stmt=con.createStatement();  
			//ResultSet rs=stmt.executeQuery("select * from user_otp_maintenance tatus_id='PENDING' order by generated_datetime desc"); 
//			//ResultSet rs=stmt.executeQuery("select * from user_otp_maintenance where status_id='PENDING' order by generated_datetime desc");  			
		//	ResultSet rs=stmt.executeQuery("select * from user_otp_maintenance where cif_number='00117434'and status_id='PENDING' and ROWNUM <= 1 order by id desc");  
		
			//ResultSet rs=stmt.executeQuery("select * from user_otp_maintenance where cif_number='00117434'and status_id='PENDING' and ROWNUM <= 1 order by id desc");  
			
			ResultSet rs=stmt.executeQuery("select otp_number from user_otp_maintenance where cif_number='00117434'and status_id='PENDING' order by id desc");  
	
			

			for(int i=0; i<1; i++)
			{
				
			
			
			System.out.println("------Result fetched---------");			
			while(rs.next())  {
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				String otp =rs.getString("otp_number");
				System.out.println(otp+"finalvalue");
				String decrptedOtp=		decryptUsingMD5(otp);
				System.out.println(decrptedOtp);
				if (i  == 0)
				{
					break;
				}
			}
			
			
			}
			
			stmt.close();
			con.close(); 
		}
	catch(Exception e){
		System.out.println(e);
	}  
	  
	}  
	public static String decryptUsingMD5(String input) throws Exception {
		String decText = null;
		Key key1 = null;
		byte[] message = java.util.Base64.getDecoder().decode(input);
		int index = message.length - 9;
		byte[] encTxt = new byte[index];
		byte[] iv1 = new byte[8];
		byte[] len = new byte[1];		
		System.arraycopy(message, 0, encTxt, 0, index);
		System.arraycopy(message, index, iv1, 0, 8);
		System.arraycopy(message, index + 8, len, 0, 1);
		int length = (int) len[0];
		try {

			final MessageDigest md = MessageDigest.getInstance("md5");
			final byte[] digestOfPassword = md.digest(encryptMD5Key.getBytes("utf-8"));
			final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
			for (int j = 0, k = 16; j < 8;) {
				keyBytes[k++] = keyBytes[j++];
			}
			DESedeKeySpec spec = new DESedeKeySpec(keyBytes);
			SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
			key1 = keyfactory.generateSecret(spec);
			final IvParameterSpec iv = new IvParameterSpec(iv1);
			final Cipher decipher = Cipher.getInstance("DESede/CBC/NoPadding");
			decipher.init(Cipher.DECRYPT_MODE, key1, iv);
			final byte[] plainText = decipher.doFinal(encTxt);
			byte[] decByte = new byte[length];
			System.arraycopy(plainText, 0, decByte, 0, length);
			decText = new String(decByte, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Decrypted :: " + decText);
		return decText;
	}
	
}
