/*
 * Weazzer Android Application
 * 
 */
package weazzer.weather;

import java.util.Calendar;


/**
 * The Class WeatherForecast that stores information about the weather which is forecasted.
 * Based on http://www.worldweatheronline.com/free-weather-feed.aspx
 */
public class WeatherForecast {

	
	public Calendar getForecastDate() {
		return forecastDate;
	}

	public void setForecastDate(Calendar forecastDate) {
		this.forecastDate = forecastDate;
	}

	public Float getTempMax() {
		return tempMax;
	}

	public void setTempMax(Float tempMax) {
		this.tempMax = tempMax;
	}

	public Float getTempMin() {
		return tempMin;
	}

	public void setTempMin(Float tempMin) {
		this.tempMin = tempMin;
	}

	public Float getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(Float windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public String getWeatherCondition() {
		return weatherCondition;
	}

	public void setWeatherCondition(String weatherCondition) {
		this.weatherCondition = weatherCondition;
	}

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
	public String weatherCondition;
	
	
}
