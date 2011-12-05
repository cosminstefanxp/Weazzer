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
	 * The Enum MeasurementUnit.
	 */
	public enum MeasurementUnit {
		/** Celsius units. */
		Celsius,
		/** Farenheit units. */
		Farenheit
	}
	
	/**
	 * Gets the current weather. It should return a 4 element List with the weather from now, 6 hours, 12 hours and 18 hours from now.
	 *
	 * @return the current weather
	 */
	public ArrayList<WeatherData> getCurrentWeather();
	
	/**
	 * Gets the weather forecast for a given number of days.
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
	
	/**
	 * Gets the measurement unit for the weather data.
	 *
	 * @return the measurement unit
	 */
	public MeasurementUnit getMeasurementUnit();
	
	/**
	 * Sets the measurement unit for the weather data.
	 *
	 */
	public void setMeasurementUnit();
	
}
