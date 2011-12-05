/**
 * 
 */
package weazzer.weather;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author cosmin
 *
 */
public class DummyProvider implements WeatherProvider {

	MeasurementUnit measurementUnit=MeasurementUnit.Celsius;
	String location="Bucharest";
	
	/**
	 * 
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
		wd.weatherCondition=WeatherCondition.Clear;
		wd.when=new GregorianCalendar();
		wd.windSpeed=12f;
		
		ArrayList<WeatherData> weatherList=new ArrayList<WeatherData>();
		weatherList.add(wd);
		weatherList.add(wd);
		weatherList.add(wd);
		weatherList.add(wd);
		
		return weatherList;
	}

	/* (non-Javadoc)
	 * @see weazzer.weather.WeatherProvider#getLocation()
	 */
	public String getLocation() {
		// TODO Auto-generated method stub
		return null;
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
			forecast.weatherCondition=WeatherCondition.Rain;
			forecast.windDirection="NE";
			forecast.windSpeed=14f;
			
			wf.add(forecast);
		}
		return wf;
	}

	/* (non-Javadoc)
	 * @see weazzer.weather.WeatherProvider#setLocation()
	 */
	public void setLocation() {
		// TODO Auto-generated method stub

	}

	public MeasurementUnit getMeasurementUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setMeasurementUnit() {
		// TODO Auto-generated method stub
		
	}

}
