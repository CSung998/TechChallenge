package openNMSChallenge;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class InputParserTest {
	
	private Map<String, Object> ymlObjectMap;

	@Test
	public void parseInputFromYaml() throws FileNotFoundException {
		Map<String, Object> ymlObjectMap = InputParser.parseInputFromYaml("etc/config/files/snmp.yaml");
		
		assertNotNull(ymlObjectMap);
	}
	
	@Test(expected=NullPointerException.class)
	public void parseInputFromYaml_null() throws FileNotFoundException {
		ymlObjectMap = InputParser.parseInputFromYaml("etc/config/files/testsnmpnull.yaml");
	}
	
	@Test(expected=FileNotFoundException.class)
	public void parseInputFromYaml_noFile() throws FileNotFoundException {
		ymlObjectMap = InputParser.parseInputFromYaml("etc/config/files/snmp1.yaml");
	}
	
	@Test
	public void convertYamlToList() throws FileNotFoundException {
		Map<String, Object> ymlObjectMap = InputParser.parseInputFromYaml("etc/config/files/snmp.yaml");
		
		List<String> oidPrefixList = InputParser.convertYamlToList(ymlObjectMap);
		
		assertTrue(oidPrefixList.contains(".1.3.6.1.6.3.1.1.5"));
	}
}
