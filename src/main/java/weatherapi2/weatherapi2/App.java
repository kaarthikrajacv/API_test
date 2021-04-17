package weatherapi2.weatherapi2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

/**
 * Hello world!
 *
 */
public class App 
{
	
	int a;
	float b;
	
	static int c=0;
	
	public App() {
	}
    public App(int a, float b) {
    	super();
		this.a = a;
		this.b = b;
	}

	public static void main( String[] args ) throws Exception
    {
		
RestAssured.baseURI = "http://api.openweathermap.org";
    	
    	RequestSpecification request = RestAssured.given();
    	
    	Map<String, Object> queryparam = new HashMap<>();
    	
    	queryparam.put("q", "coimbatore");
    	queryparam.put("appid", "5661a8ed7941f24452984807b47e5b89");
    	//queryparam.put(null, null);
    	
    	Response response = request.given().queryParams(queryparam)
    			.when().get("/data/2.5/weather");
    	
    	
    	//JsonPath responJson = response.jsonPath();
    	
    	String base = response.asString();
    	
    	JSONArray arr = new JSONArray();
    	
    	arr.put(1);
    	arr.put(2.1);
    	arr.put("sads");
    	
    	JSONObject dsd = new JSONObject();
    	dsd.put("test", arr);
    	dsd.put("dskd", "dsc");
    	
    	parse(dsd.toString());
    	
//    	JSONObject obj = new JSONObject(base);
//    	
//    	for(Object ob : obj.getJSONArray("weather")) {
//    		System.out.println(ob);
//    		
//    		JSONObject o = new JSONObject(ob.toString());
//    		
//    		System.out.println("The jso object insede array is "+ o);
//    	}
//    	
//    	System.out.println(obj.getJSONArray("weather").get(0));
    	
    	
    }
	
	public static void parse(String json) throws Exception  {
	       //JsonFactory factory = new JsonFactory();

	       ObjectMapper mapper = new ObjectMapper();
	       JsonNode rootNode = mapper.readTree(json);  

	       Iterator<Map.Entry<String,JsonNode>> fieldsIterator = rootNode.fields();
	       while (fieldsIterator.hasNext()) {

	           Map.Entry<String,JsonNode> field = fieldsIterator.next();
	           
	        	   if(field.getValue().isArray()) {
	        		
	        		   for(JsonNode node : field.getValue()) {
	        			   if(node.isObject()) {
	        			   parse(node.toString());
	        			   }
	        			   else {
	        				   System.out.println(node.asText());
	        			   }
	        		   }
	        	   }
	        	   else if(field.getValue().isObject()) {
	        		   parse(field.getValue().toString());
	        	   }else {
	        		   System.out.println("Key: " + field.getKey() + "\nValue: " + field.getValue() +"\n");
	        	   }
//        	   if(!field.getValue().isObject() && !field.getValue().isArray()) {
//        		   System.out.println("Key: " + field.getKey() + "\tValue:" + field.getValue());
//        	   }
        	   
	       }
	}
	
	
}
