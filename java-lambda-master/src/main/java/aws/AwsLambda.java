package aws;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class AwsLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AwsLambda awsLambda = new AwsLambda();
		System.out.println(awsLambda.lambdaMetodo());
	}
	
	
	public String lambdaMetodo() {
	    
		Map<String, String> crunchifyMap = new HashMap<String, String>();
		crunchifyMap.put("Google", "San Jose");
		crunchifyMap.put("Facebook", "Mountain View");
		crunchifyMap.put("Crunchify", "NYC");
		crunchifyMap.put("Twitter", "SFO");
		crunchifyMap.put("Microsoft", "Seattle");
 
		// Use this builder to construct a Gson instance when you need to set configuration options other than the default.
		GsonBuilder gsonMapBuilder = new GsonBuilder();
 
		Gson gsonObject = gsonMapBuilder.create();
 
		String JSONObject = gsonObject.toJson(crunchifyMap);
		
	    
	    return JSONObject;
	}
	
	public String lambdaString() {		
	    
	    return "{\"data\":{angelo,40}}";
	}
	

}
