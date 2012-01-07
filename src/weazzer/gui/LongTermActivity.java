/**
 * 
 */
package weazzer.gui;

import java.util.ArrayList;

import weazzer.weather.DummyProvider;
import weazzer.weather.WeatherForecast;
import weazzer.weather.WeatherLocation;
import weazzer.weather.WeatherProvider.MeasurementUnit;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

/**
 * @author cosmin
 * 
 */
public class LongTermActivity extends Activity {

	WeatherLocation weatherLocation;
	MeasurementUnit mu;
	String systemUnit;
	
	@Override
	public void onStart() {
		super.onStart();
		setContentView(R.layout.long_term);

		getPreferences();

		DummyProvider provider = new DummyProvider();
		provider.setMeasurementUnit(mu);
		provider.setLocation(weatherLocation);
		ArrayList<WeatherForecast> forecast = provider.getWeatherForecast(7);
		
		final ListView lv1 = (ListView) findViewById(R.id.nextDaysView);
		lv1.setAdapter(new WeatherForecastAdapter(this, forecast, systemUnit));
	}
	
	private void getPreferences() {
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		systemUnit = prefs.getString("suPref", "Metric");
		mu = MeasurementUnit.Farenheit;;
		if (systemUnit.equals("Metric"))
			mu = MeasurementUnit.Celsius;
		// Weather location - null if missing
		// Get the selected value
		String[] locations = prefs.getString("locationPref", "").split("[,]");
		// Check if it's ok
		if (locations.length != 2) {
			prefs.edit().remove("locationPref").commit();
			Toast.makeText(
					getBaseContext(),
					"Missing location information. Please set your location in the settings section!",
					Toast.LENGTH_LONG).show();
			weatherLocation = new WeatherLocation("Bucharest", "Romania");
		} else {
			weatherLocation = new WeatherLocation();
			weatherLocation.city = prefs.getString("cityLocationPref",
					"Bucharest");
			weatherLocation.country = prefs.getString("countryLocationPref",
					"Romania");
		}
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
			break;
		case R.id.refresh_menu_button:
			onStart();
			break;
		default:
			return super.onOptionsItemSelected(item);
		}
		return true;
	}
}

