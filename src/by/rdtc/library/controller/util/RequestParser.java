package by.rdtc.library.controller.util;

import java.util.HashMap;
import java.util.Map;

public class RequestParser {
	private static final String PARAM_DELIMETER="&";
	private static final String VALUE_DELIMETER="=";
	
	public static Map<String,String> getParameters(String request){
		Map<String,String> paramsMap=new HashMap<>();
		String[] params=request.split(PARAM_DELIMETER);
		
		String key;
		String value;
		
		for(String param:params){
			if(param.indexOf(VALUE_DELIMETER)!=-1){
				key=param.substring(0,param.indexOf(VALUE_DELIMETER));
				value=param.substring(param.indexOf(VALUE_DELIMETER)+1);
				paramsMap.put(key,value);
			}
		}
		return paramsMap;
	}
}
