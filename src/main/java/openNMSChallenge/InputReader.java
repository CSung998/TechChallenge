package openNMSChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {

	public static String readOidFromSysIn() throws IOException {
		String oid;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the OID you would like to verify:"); 
		oid = br.readLine(); 
		System.out.println("OID entered: [" +oid+"]" ); 
		
		return oid;
	}
	
}
