package openNMSChallenge;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Launcher {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Map<String, Object> ymlObjectMap;
		List<String> oidPrefixList;
		String oid;
		
		Properties properties = new Properties();
		properties.load(new FileInputStream("etc/config/files/app.properties"));
		String pathToSnmpPrefixList = properties.getProperty("pathToSnmpPrefixList");
		
		//Read prefixes from snmp.yaml and parse to map
		ymlObjectMap = InputParser.parseInputFromYaml(pathToSnmpPrefixList);
		oidPrefixList = InputParser.convertYamlToList(ymlObjectMap);
		
		//Read input from stdin
		oid = InputReader.readOidFromSysIn();
		
		//Check OID against configured prefixes
		OIDFilter.comparePrefixToOid(oidPrefixList, oid);
	}
}
