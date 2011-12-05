/*
 * Weazzer Android Application
 * 
 */
package weazzer.weather;

import java.util.Calendar;

/**
 * The Class WeatherData that stores information about real weather.
 * Based on http://www.worldweatheronline.com/free-weather-feed.aspx
 */
public class WeatherData {
	
	
	public Float getHumidity() {
		return humidity;
	}

	public String getWeatherCondition() {
		return weatherCondition;
	}

	public void setWeatherCondition(String weatherCondition) {
		this.weatherCondition = weatherCondition;
	}

	public void setHumidity(Float humidity) {
		this.humidity = humidity;
	}

	/** The when. */
	public Calendar when;
	
	/** The temperature. */
	public Float temperature;
	
	/** The wind speed. */
	public Float windSpeed;
	
	/** The humidity. */
	public Float humidity;
	
	/** The weather condition. */
	public String weatherCondition;
	
	public Calendar getWhen() {
		return when;
	}
	
	public void setWhen(Calendar when) {
		this.when = when;
	}
	
	public Float getTemperature() {
		return temperature;
	}
	
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}
	
	public Float getWindSpeed() {
		return windSpeed;
	}
	
	public void setWindSpeed(Float windSpeed) {
		this.windSpeed = windSpeed;
	}
	
	
}
