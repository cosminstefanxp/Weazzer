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
	@Override
	public WeatherData getCurrentWeather() {
		WeatherData wd=new WeatherData();
		
		wd.humidity=0.8f;
		wd.temperature=15f;
		wd.weatherCondition=WeatherCondition.Clear;
		wd.when=new GregorianCalendar();
		wd.windSpeed=12f;
		
		return wd;
	}

	/* (non-Javadoc)
	 * @see weazzer.weather.WeatherProvider#getLocation()
	 */
	@Override
	public String getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see weazzer.weather.WeatherProvider#getWeatherForecast(int)
	 */
	@Override
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
	@Override
	public void setLocation() {
		// TODO Auto-generated method stub

	}

	@Override
	public MeasurementUnit getMeasurementUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMeasurementUnit() {
		// TODO Auto-generated method stub
		
	}

}
