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
}
