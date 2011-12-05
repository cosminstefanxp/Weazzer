/**
 * 
 */
package weazzer.weather;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * The Class DummyProvider.
 * 
 * @author cosmin
 */
public class DummyProvider implements WeatherProvider {

	/** The measurement unit. */
	MeasurementUnit measurementUnit = MeasurementUnit.Celsius;

	/** The location. */
	String location = "Bucharest";

	/**
	 * Instantiates a new dummy provider.
	 */
	public DummyProvider() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see weazzer.weather.WeatherProvider#getCurrentWeather()
	 */
	public ArrayList<WeatherData> getCurrentWeather() {

		ArrayList<WeatherData> weatherList = new ArrayList<WeatherData>();
		for (int i = 1; i < 5; i++) {
			WeatherData wd = new WeatherData();

			wd.humidity = i * 0.8f;
			wd.temperature = i * 2f;
			wd.weatherCondition = i != 2 ? "Sunny" : "Rain";
			wd.when = i == 1 ? "Now" : i == 2 ? "In 2H" : i == 3 ? "In 5H"
					: "In 10H";
			wd.windSpeed = i * 2f;
			wd.icon = i != 2 ? "sunny" : "rain";
			weatherList.add(wd);
		}

		return weatherList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see weazzer.weather.WeatherProvider#getWeatherForecast(int)
	 */
	public ArrayList<WeatherForecast> getWeatherForecast(int daysCount) {

		ArrayList<WeatherForecast> wf = new ArrayList<WeatherForecast>();
		for (int i = 0; i < daysCount; i++) {
			WeatherForecast forecast = new WeatherForecast();
			forecast.forecastDate = new GregorianCalendar();
			forecast.forecastDate.add(Calendar.DAY_OF_MONTH, i);
			forecast.tempMax = 24f + i;
			forecast.tempMin = 16f - i;
			forecast.weatherCondition = "Rain";
			forecast.windDirection = "NE";
			forecast.windSpeed = 14f;
			forecast.icon = "sunny";

			wf.add(forecast);
		}
		return wf;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see weazzer.weather.WeatherProvider#getMeasurementUnit()
	 */
	public MeasurementUnit getMeasurementUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see weazzer.weather.WeatherProvider#setMeasurementUnit()
	 */
	public void setMeasurementUnit() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see weazzer.weather.WeatherProvider#getSelectedLocation()
	 */
	public WeatherLocation getSelectedLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * weazzer.weather.WeatherProvider#getSuggestedLocation(java.lang.String,
	 * java.lang.String)
	 */
	public ArrayList<WeatherLocation> getSuggestedLocation(String country,
			String city) {
		// TODO Auto-generated method stub
		ArrayList<WeatherLocation> locations = new ArrayList<WeatherLocation>();
		locations.add(new WeatherLocation("Pitesti", "Romania"));
		locations.add(new WeatherLocation("Bucuresti", "Romania"));

		return locations;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * weazzer.weather.WeatherProvider#setLocation(weazzer.weather.WeatherLocation
	 * )
	 */
	public void setLocation(WeatherLocation location) {
		// TODO Auto-generated method stub

	}

}
