package openNMSChallenge;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.yaml.snakeyaml.Yaml;

public class InputParser {

	public static Map<String, Object> parseInputFromYaml(String pathToSnmpPrefixList) throws FileNotFoundException {
		InputStream inputStream = new FileInputStream(new File(pathToSnmpPrefixList));
		Yaml yml = new Yaml();
		
		Map<String, Object> ymlObjectMap = yml.load(inputStream);
		System.out.println(ymlObjectMap);
		
		if(MapUtils.isEmpty(ymlObjectMap)) 
			throw new NullPointerException("No prefix list found - Ensure trap type OID prefixes are configured");
		else
			return ymlObjectMap;
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> convertYamlToList(Map<String, Object> data) {
		List<String> oidList = new ArrayList<>();
		
		if(data.get("trap-type-oid-prefix") instanceof java.util.ArrayList) {
			 oidList = (List<String>) data.get("trap-type-oid-prefix");
		}
		System.out.println(oidList);
		return oidList;
	}
}
