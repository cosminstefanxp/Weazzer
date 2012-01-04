/**
 * 
 */
package weazzer.gui;

import java.util.ArrayList;

import weazzer.weather.DummyProvider;
import weazzer.weather.WeatherForecast;
import weazzer.weather.WeatherProvider.MeasurementUnit;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

/**
 * @author cosmin
 * 
 */
public class LongTermActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.long_term);

		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		String measurementUnit = prefs.getString("muPref", "Celsius");
		MeasurementUnit mu = MeasurementUnit.Farenheit;;
		if (measurementUnit.equals("Celsius"))
			mu = MeasurementUnit.Celsius;

		DummyProvider provider = new DummyProvider();
		provider.setMeasurementUnit(mu);
		ArrayList<WeatherForecast> forecast = provider.getWeatherForecast(7);
		
		final ListView lv1 = (ListView) findViewById(R.id.nextDaysView);
		lv1.setAdapter(new WeatherForecastAdapter(this, forecast, measurementUnit));
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.settings_menu_button:
			Intent settingsActivity = new Intent(getBaseContext(),
					SettingsPanelActivity.class);
			startActivity(settingsActivity);
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}

