package weatherapi2.weatherapi2;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown=true)
public class WeatherDetails {
	
	String base;
	
	Coord coord;
	
	MainWeatherDetails main;
	
	JsonNode weather;
	
	//Map<String, Double> coord;
	
	public WeatherDetails() {}


	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		
		this.base = base;
	}


	public Coord getCoord() {
		return coord;
	}


	public void setCoord(Coord coord) {
		this.coord = coord;
	}


	public MainWeatherDetails getMain() {
		return main;
	}


	public void setMain(MainWeatherDetails main) {
		this.main = main;
	}


	public JsonNode getWeather() {
		return weather;
	}


	public void setWeather(JsonNode weather) {
		this.weather = weather;
	}
	
	

	
}
