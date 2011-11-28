/*
 * Weazzer Android Application
 * 
 */
package weazzer.weather;

import java.util.ArrayList;

/**
 * WeatherProvider is used as the source for the weather information. The way it obtains the data is 
 * implementation specific.
 */
public interface WeatherProvider {

	/**
	 * The Enum WeatherCondition.
	 */
	public enum WeatherCondition {	
		/** Rain. */
		Rain, 
		 /** Clear. */
		 Clear, 
		 /** Snow. */
		 Snow, 
		 /** Fog. */
		 Fog
	};
	
	/**
	 * Gets the current weather.
	 *
	 * @return the current weather
	 */
	public WeatherData getCurrentWeather();
	
	/**
	 * Gets the weather forecast for a given number of days
	 *
	 * @param daysCount the days count
	 * @return the weather forecast
	 */
	public ArrayList<WeatherForecast> getWeatherForecast(int daysCount);

	/**
	 * Gets the location for the weather data.
	 *
	 * @return the location
	 */
	public String getLocation();
	
	/**
	 * Sets the location for the weather data.
	 *
	 */
	public void setLocation();
	
}
