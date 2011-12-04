/*
 * Weazzer Android Application
 * 
 */
package weazzer.weather;

import java.util.Calendar;

import weazzer.weather.WeatherProvider.WeatherCondition;

/**
 * The Class WeatherForecast that stores information about the weather which is forecasted.
 * Based on http://www.worldweatheronline.com/free-weather-feed.aspx
 */
public class WeatherForecast {

	
	/** The forecast date. */
	public Calendar forecastDate;
	
	/** The max temperature. */
	public Float tempMax;
	
	/** The min temperature. */
	public Float tempMin;
	
	/** The wind speed. */
	public Float windSpeed;
	
	/** The wind direction. */
	public String windDirection;
	
	/** The weather condition. */
	public WeatherCondition weatherCondition;
}
