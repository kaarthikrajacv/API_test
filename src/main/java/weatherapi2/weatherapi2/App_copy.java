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
public class App_copy
{
	

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
    	
    	ObjectMapper mapper = new ObjectMapper();
    	
    	WeatherDetails weatherDetails = mapper.readValue(response.asString(), WeatherDetails.class);
    	
    	JsonNode weather = weatherDetails.getWeather();
    	
    	if(weather.isArray()) {
    		
    		weather.forEach(w->{
    			
    			System.out.println("The description is  " +w.get("description"));
    		});
    		
//    		Iterator<Map.Entry<String, JsonNode>> weatherList = weather.fields();
//    		
//    		while(weatherList.hasNext()) {
//    			
//    			
//    			
//    			Map.Entry<String, JsonNode> field = weatherList.next();
//    			
//    			if(field.getValue().isArray()) {
//    				
//    			field.getValue().forEach(w ->{
//    				System.out.println(w);
//    			});
//    			}
//    			
//    			
//    		}
    	}
    	
    	//System.out.println(weatherDetails.getMain().getPressure());
    	
    	//WeatherDetails weatherDetails = response.as(WeatherDetails.class);
    	
    	
    	//System.out.println(weatherDetails.getBase());
    	
    	
    	//String base = response.asString();
    	
    	//System.out.println("The response is " +base);
    	
    	
    	
    }
	

	
	
}
