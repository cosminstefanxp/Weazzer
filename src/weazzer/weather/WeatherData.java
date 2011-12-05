/*
 * Weazzer Android Application
 * 
 */
package weazzer.weather;

import java.util.Calendar;

import weazzer.weather.WeatherProvider.WeatherCondition;

/**
 * The Class WeatherData that stores information about real weather.
 * Based on http://www.worldweatheronline.com/free-weather-feed.aspx
 */
public class WeatherData {
	
	
	/** The when. */
	public Calendar when;
	
	/** The temperature. */
	public Float temperature;
	
	/** The wind speed. */
	public Float windSpeed;
	
	/** The humidity. */
	public Float humidity;
	
	/** The weather condition. */
	public WeatherCondition weatherCondition;
	
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
	
	public Float getHumidity() {
		return humidity;
	}
	
	public void sethumidity(Float humidity) {
		this.humidity = humidity;
	}
	
	
}
