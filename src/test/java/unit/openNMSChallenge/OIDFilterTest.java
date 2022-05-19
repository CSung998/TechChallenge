package openNMSChallenge;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class OIDFilterTest {
	
	@Test
	public void comparePrefixToOidTest() {
		
		List<String> oidList = Arrays.asList(".1.3.6.1.6.3.1.1.5",".1.3.6.1.2.1.10.166.3");
		String oid = ".1.3.6.1.6.3.1.1.5";
		
		assertTrue(oidList.contains(oid));
	}
	
	@Test
	public void comparePrefixToOidTest_false() {
		
		List<String> oidList = Arrays.asList(".1.3.6.1.6.3.1.1",".1.3.6.1.2.1.10.166");
		String oid = ".1.3.6.1.6.3.1.1.5";
		
		assertFalse(oidList.contains(oid));
	}
}
