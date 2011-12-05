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
	MeasurementUnit measurementUnit=MeasurementUnit.Celsius;
	
	/** The location. */
	String location="Bucharest";
	
	/**
	 * Instantiates a new dummy provider.
	 */
	public DummyProvider() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see weazzer.weather.WeatherProvider#getCurrentWeather()
	 */
	public ArrayList<WeatherData> getCurrentWeather() {
		WeatherData wd=new WeatherData();
		
		wd.humidity=0.8f;
		wd.temperature=15f;
		wd.weatherCondition="Sunny";
		wd.when=new GregorianCalendar();
		wd.windSpeed=12f;
		
		ArrayList<WeatherData> weatherList=new ArrayList<WeatherData>();
		weatherList.add(wd);
		weatherList.add(wd);
		weatherList.add(wd);
		weatherList.add(wd);
		weatherList.add(wd);
		
		return weatherList;
	}


	/* (non-Javadoc)
	 * @see weazzer.weather.WeatherProvider#getWeatherForecast(int)
	 */
	public ArrayList<WeatherForecast> getWeatherForecast(int daysCount) {
		
		ArrayList<WeatherForecast> wf=new ArrayList<WeatherForecast>();
		for(int i=0;i<daysCount;i++)
		{
			WeatherForecast forecast=new WeatherForecast();
			forecast.forecastDate=new GregorianCalendar();
			forecast.forecastDate.add(Calendar.DAY_OF_MONTH, i);
			forecast.tempMax=24f+i;
			forecast.tempMin=16f-i;
			forecast.weatherCondition="Rain";
			forecast.windDirection="NE";
			forecast.windSpeed=14f;
			
			wf.add(forecast);
		}
		return wf;
	}


	/* (non-Javadoc)
	 * @see weazzer.weather.WeatherProvider#getMeasurementUnit()
	 */
	public MeasurementUnit getMeasurementUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see weazzer.weather.WeatherProvider#setMeasurementUnit()
	 */
	public void setMeasurementUnit() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see weazzer.weather.WeatherProvider#getSelectedLocation()
	 */
	@Override
	public WeatherLocation getSelectedLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see weazzer.weather.WeatherProvider#getSuggestedLocation(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<WeatherLocation> getSuggestedLocation(String country, String city) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see weazzer.weather.WeatherProvider#setLocation(weazzer.weather.WeatherLocation)
	 */
	@Override
	public void setLocation(WeatherLocation location) {
		// TODO Auto-generated method stub
		
	}

}
