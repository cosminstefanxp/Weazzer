/*
 * Weazzer Android Application
 * 
 */
package weazzer.gui;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;

import weazzer.weather.WeatherForecast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * The Class WeatherForecastAdapter.
 */
public class WeatherForecastAdapter extends BaseAdapter {

	/** The forecast. */
	private static ArrayList<WeatherForecast> forecast;

	/** The inflater. */
	private LayoutInflater mInflater;
	
	private String systemUnit;
	
	private String measurementUnitSuffix;

	/**
	 * Instantiates a new weather forecast adapter.
	 * 
	 * @param context
	 *            the context
	 * @param results
	 *            the results
	 */
	public WeatherForecastAdapter(Context context,
			ArrayList<WeatherForecast> results,
			String systemUnit) {
		forecast = results;
		mInflater = LayoutInflater.from(context);
		this.systemUnit = systemUnit;
		measurementUnitSuffix = systemUnit.equals(
				"Metric") ? "°C" : "°F";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getCount()
	 */
	public int getCount() {
		return forecast.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getItem(int)
	 */
	public Object getItem(int position) {
		return forecast.get(position);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getItemId(int)
	 */
	public long getItemId(int position) {
		return position;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getView(int, android.view.View,
	 * android.view.ViewGroup)
	 */
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.custom_row_view, null);
			holder = new ViewHolder();
			holder.forecastDate = (TextView) convertView
					.findViewById(R.id.forecastDate);
			holder.temp = (TextView) convertView.findViewById(R.id.temperatureLabel);			
			holder.weatherCondition = (ImageView) convertView
					.findViewById(R.id.weatherImageView);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.forecastDate.setText(forecast.get(position).getForecastDate()
				.get(Calendar.DAY_OF_MONTH)
				+ "/"
				+ (forecast.get(position).getForecastDate().get(Calendar.MONTH)+1));
		holder.temp.setText(convertTemp(forecast.get(position).getTempMin())
				+" to " + convertTemp(forecast.get(position).getTempMax()) 
						+ measurementUnitSuffix);	
		holder.weatherCondition.setImageResource(getResourceIdForWeather(false,
				forecast.get(position).getIcon()));
		return convertView;
	}
	
	private Float convertTemp(Float temperature) {
		// convert if Fahrenheit
		if(!systemUnit.equals("Metric")) {
			return temperature*9/5+32;
		}
		return temperature;
	}

	private int getResourceIdForWeather(Boolean big, String iconName) {
		String prefix = big ? "big_" : "small_";
		try {
			Field field = R.drawable.class.getField(prefix + iconName);
			return field.getInt(null);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * The Class ViewHolder.
	 */
	static class ViewHolder {

		/** The forecast date. */
		TextView forecastDate;

		/** The temp max. */
		TextView temp;
		
		/** The weather condition. */
		ImageView weatherCondition;
	}
	
}