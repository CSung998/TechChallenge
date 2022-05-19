package openNMSChallenge;

import java.util.List;

public class OIDFilter {

	public static void comparePrefixToOid(List<String> oidList, String oid) {
		
		if (oidList.contains(oid)) {
			System.out.println(oid+": true");
		} else System.out.println(oid+": false");
	}
}
