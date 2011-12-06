/**
 * 
 */
package weazzer.gui;

import java.util.ArrayList;

import weazzer.weather.DummyProvider;
import weazzer.weather.WeatherForecast;
import android.app.Activity;
import android.os.Bundle;
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

		DummyProvider provider = new DummyProvider();
		ArrayList<WeatherForecast> forecast = provider.getWeatherForecast(7);

		final ListView lv1 = (ListView) findViewById(R.id.nextDaysView);
		lv1.setAdapter(new WeatherForecastAdapter(this, forecast));
	}
}
