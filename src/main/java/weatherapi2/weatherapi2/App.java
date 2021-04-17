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
import io.restassured.internal.RestAssuredResponseImpl;
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
    	
    	
    	String base = response.asString();
    	
    	//System.out.println("The response is " +base);
    	
    	JSONObject respJson = new JSONObject(response.asString());
    	
    	JSONArray  jarray = respJson.getJSONArray("weather");
    	
    	/**JSONArray testArray = new JSONArray();
    	testArray.put(1);
    	testArray.put("djshdj");
    	testArray.put(3.3);
    	
    	JSONObject testJsonObj = new JSONObject();
    	testJsonObj.put("numArray", testArray);
    	
    	JSONArray  testJarray = testJsonObj.getJSONArray("numArray");
    	
    	System.out.println(testJarray);**/
    	
    	for(Object ob : jarray) {
    		
    		
    		JSONObject weatherJsonObj = new JSONObject(ob.toString());
    		
    		//System.out.println(weatherJsonObj.get("description"));
    		
    		//System.out.println("The weather json object is " +ob);
    		
    		parse1(base);
    		
    	}
    	
    }
	
	
	public static void parse1(String json) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode rootNode = mapper.readTree(json);
		
		System.out.println("The root node is " +rootNode);
		
		Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.fields();
		
		while(fieldsIterator.hasNext()) {
			
			Map.Entry<String, JsonNode> field = fieldsIterator.next();
			
			if(field.getValue().isArray()) {
				
				
				for(JsonNode node : field.getValue()) {
					
					parse1(node.toString());
				
				}
			}else if(field.getValue().isObject()) {
				parse1(field.getValue().toString());
				
			}
			
			else {
				
				if(field.getKey().equals("base")) {
					Assert.assertEquals(field.getValue(), "stations");
				}
				
				System.out.println("Key is " + field.getKey() + "\n and the value is " + field.getValue() + "\n");
				
			}
			
		}
		
		
		
		
		
		
	}
	
	
}
