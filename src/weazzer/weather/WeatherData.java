/*
 * Weazzer Android Application
 * 
 */
package weazzer.weather;

/**
 * The Class WeatherData that stores information about real weather. Based on
 * http://www.worldweatheronline.com/free-weather-feed.aspx
 */
public class WeatherData {

	/** The when description: Now, Tonight, Tomorrow, 21:00, etc. */
	public String when;

	/** The temperature. */
	public Float temperature;

	/** The wind speed. */
	public Float windSpeed;

	/** The humidity. */
	public Float humidity;

	/** The weather condition. */
	public String weatherCondition;

	/** The icon name. */
	public String icon;

	/**
	 * Gets the when description.
	 * 
	 * @return the when
	 */
	public String getWhen() {
		return when;
	}

	/**
	 * Sets the when when description.
	 * 
	 * @param when
	 *            the new when
	 */
	public void setWhen(String when) {
		this.when = when;
	}

	/**
	 * Gets the temperature.
	 * 
	 * @return the temperature
	 */
	public Float getTemperature() {
		return temperature;
	}

	/**
	 * Sets the temperature.
	 * 
	 * @param temperature
	 *            the new temperature
	 */
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	/**
	 * Gets the wind speed.
	 * 
	 * @return the wind speed
	 */
	public Float getWindSpeed() {
		return windSpeed;
	}

	/**
	 * Sets the wind speed.
	 * 
	 * @param windSpeed
	 *            the new wind speed
	 */
	public void setWindSpeed(Float windSpeed) {
		this.windSpeed = windSpeed;
	}

	/**
	 * Gets the humidity.
	 * 
	 * @return the humidity
	 */
	public Float getHumidity() {
		return humidity;
	}

	/**
	 * Gets the weather condition.
	 * 
	 * @return the weather condition
	 */
	public String getWeatherCondition() {
		return weatherCondition;
	}

	/**
	 * Sets the weather condition.
	 * 
	 * @param weatherCondition
	 *            the new weather condition
	 */
	public void setWeatherCondition(String weatherCondition) {
		this.weatherCondition = weatherCondition;
	}

	/**
	 * Sets the humidity.
	 * 
	 * @param humidity
	 *            the new humidity
	 */
	public void setHumidity(Float humidity) {
		this.humidity = humidity;
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon
	 *            the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

}
