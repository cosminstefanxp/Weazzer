/*
 * Weazzer Android Application
 * 
 */
package weazzer.gui;

import weazzer.weather.DummyProvider;
import weazzer.weather.WeatherData;
import weazzer.weather.WeatherLocation;
import weazzer.weather.WeatherProvider;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * The Class MainPanelActivity.
 */
public class MainPanelActivity extends Activity {

	/** The gender. */
	String gender;
	WeatherProvider weatherProvider;
	int currentPeriod;
	WeatherLocation weatherLocation;
	
	/**
	 * The listener interface for receiving myTouch events.
	 * The class that is interested in processing a myTouch
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addMyTouchListener<code> method. When
	 * the myTouch event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see MyTouchEvent
	 */
	class MyTouchListener implements View.OnTouchListener {
		
		/** The my gesture detector. */
		GestureDetector mGestureDetector = null;

		/**
		 * Instantiates a new my touch listener.
		 *
		 * @param gestureDetector the gesture detector
		 */
		public MyTouchListener(GestureDetector gestureDetector) {
			super();
			this.mGestureDetector = gestureDetector;
		}

		/* (non-Javadoc)
		 * @see android.view.View.OnTouchListener#onTouch(android.view.View, android.view.MotionEvent)
		 */
		public boolean onTouch(View v, MotionEvent aEvent) {
			if (mGestureDetector.onTouchEvent(aEvent))
				return true;
			else
				return false;
		}
	}


	/**
	 * Called when the activity is first created.
	 *
	 * @param savedInstanceState the saved instance state
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		int swipedImgIds[] = {R.id.TopClothesView, R.id.BottomClothesView, R.id.OvercoatClothesView, R.id.mainWeatherImageView};
		for (int id : swipedImgIds) {
			ImageView imagine = (ImageView) findViewById(id);
			GestureDetector mGestureDetector = new GestureDetector(
					new MainPanelGestureDetector(imagine));
			MyTouchListener mGestureListener = new MyTouchListener(mGestureDetector);
	
			imagine.setOnTouchListener(mGestureListener);
		}
		
		weatherProvider = new DummyProvider();
		currentPeriod = 0;
		refreshUI();
	}

	private void refreshUI() {
		WeatherData currentWeatherData = weatherProvider.getCurrentWeather().get(currentPeriod);
		ImageView centralImage = (ImageView) findViewById(R.id.mainWeatherImageView);
		centralImage.setImageResource(getResourceIdForWeatherBig(currentWeatherData.getWeatherCondition()));		
	}

	private int getResourceIdForWeatherBig(String weatherCondition) {
		weatherCondition = weatherCondition.toLowerCase();
		if(weatherCondition.equals("sunny")) {
			return R.drawable.big_sunny;
		} else {
			return R.drawable.big_rain;
		}
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onStart()
	 */
	@Override
	public void onStart() {
		super.onStart();
		getPreferences();
	}


	/**
	 * Gets the preferences from the system preferences in Android.
	 *
	 * @return the preferences
	 */
	private void getPreferences() {
		// Get the xml/preferences.xml preferences 
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		
		//Gender
		gender = prefs.getString("genderPref", "male");
		
		//Weather location
		weatherLocation=new WeatherLocation();
		weatherLocation.city=prefs.getString("cityLocationPref", "Bucharest");
		weatherLocation.country=prefs.getString("countryLocationPref", "Romania");		
	}

	/* (non-Javadoc)
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

	/**
	 * Settings menu button click event.
	 *
	 * @param view the view
	 */
	public void SettingsMenuButtonClickEvent(View view) {
		Intent settingsActivity = new Intent(getBaseContext(),
				SettingsPanelActivity.class);
		startActivity(settingsActivity);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}
	
	public void toLongTermAction(View v) {		
		Intent activity = new Intent(getBaseContext(),
				LongTermActivity.class);
		startActivity(activity);
	}


}