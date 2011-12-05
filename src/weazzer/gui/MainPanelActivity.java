/*
 * Weazzer Android Application
 * 
 */
package weazzer.gui;

import java.lang.reflect.Field;

import weazzer.wear.ClothesSuggestion;
import weazzer.wear.ClothingArticle.UserSex;
import weazzer.wear.SuggestionsEngine;
import weazzer.weather.DummyProvider;
import weazzer.weather.WeatherData;
import weazzer.weather.WeatherLocation;
import weazzer.weather.WeatherProvider;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * The Class MainPanelActivity.
 */
public class MainPanelActivity extends Activity {
	
	class MainPanelGestureDetector  extends SimpleOnGestureListener {
		private static final int SWIPE_MIN_DISTANCE = 50;
		private static final int SWIPE_MAX_OFF_PATH = 100;
		private static final int SWIPE_THRESHOLD_VELOCITY = 50;
		View owner;

		public MainPanelGestureDetector(View owner) {
			super();
			this.owner = owner;
		}
		
		@Override
		public boolean onDown(MotionEvent e) {
			if (owner == findViewById(R.id.fourthNextPeriodLayout)) {
				currentPeriod = 3;
				refreshUI();
			}
			if (owner == findViewById(R.id.thirdNextPeriodLayout)) {
				currentPeriod = 2;
				refreshUI();
			}
			if (owner == findViewById(R.id.secondNextPeriodLayout)) {
				currentPeriod = 1;
				refreshUI();
			}
			if (owner == findViewById(R.id.firstNextPeriodLayout)) {
				currentPeriod = 0;
				refreshUI();
			}
							
			return true;
		}

		void rightSwipe() {
			if(owner == findViewById(R.id.mainWeatherImageView)) {
				if(currentPeriod>0)
					currentPeriod--;
			}
			refreshUI();
		}

		void leftSwipe() {
			if(owner == findViewById(R.id.mainWeatherImageView)) {
				if(currentPeriod<3)
					currentPeriod++;
			}
			refreshUI();
		}

		void upSwipe() {
			if(owner == findViewById(R.id.mainWeatherImageView)) {
				if(currentPeriod<3)
					currentPeriod++;
			}
			refreshUI();
		}

		void downSwipe() {		
			if(owner == findViewById(R.id.mainWeatherImageView)) {
				if(currentPeriod>0)
					currentPeriod--;
			}
			refreshUI();
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			float dX = e2.getX() - e1.getX();
			float dY = e1.getY() - e2.getY();
			if (Math.abs(dY) < SWIPE_MAX_OFF_PATH
					&& Math.abs(velocityX) >= SWIPE_THRESHOLD_VELOCITY
					&& Math.abs(dX) >= SWIPE_MIN_DISTANCE) {
				if (dX > 0) {
					rightSwipe();
				} else {
					leftSwipe();
				}
				return true;
			} else if (Math.abs(dX) < SWIPE_MAX_OFF_PATH
					&& Math.abs(velocityY) >= SWIPE_THRESHOLD_VELOCITY
					&& Math.abs(dY) >= SWIPE_MIN_DISTANCE) {
				if (dY > 0) {
					upSwipe();
				} else {
					downSwipe();
				}
				return true;
			}
			return false;
		}
	}

	/** The gender. */
	String gender;
	WeatherProvider weatherProvider;
	int currentPeriod;
	String measurementUnitSuffix;
	WeatherLocation weatherLocation;
	
	ClothesSuggestion clothesSuggestion;
	
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

		int swipedImgIds[] = {R.id.TopClothesView, R.id.BottomClothesView, R.id.OvercoatClothesView, R.id.mainWeatherImageView,
				R.id.firstNextPeriodLayout, R.id.secondNextPeriodLayout, R.id.thirdNextPeriodLayout, R.id.fourthNextPeriodLayout};
		for (int id : swipedImgIds) {
			View view = findViewById(id);
			GestureDetector mGestureDetector = new GestureDetector(
					new MainPanelGestureDetector(view));
			MyTouchListener mGestureListener = new MyTouchListener(mGestureDetector);
	
			view.setOnTouchListener(mGestureListener);
		}
		
		weatherProvider = new DummyProvider();
		currentPeriod = 0;
	}
	
	/**
	 * Do stuff that don't change at user interaction. Is called by onStart().
	 */
	private void initializeUI() {
		try {
			for(int currentPeriod=0; currentPeriod<4; currentPeriod++) {
				WeatherData currentWeatherData = weatherProvider.getCurrentWeather().get(currentPeriod);
				String prefix = null;
				switch(currentPeriod) {
					case 0 : prefix = "first"; break;
					case 1: prefix = "second"; break;
					case 2: prefix = "third"; break;
					case 3: prefix = "fourth"; break;
				}
				int idTemperatureLabel = R.id.class.getField(prefix+"NextPeriodValueLabel").getInt(null);
				TextView temperatureLabel = (TextView) findViewById(idTemperatureLabel);
				temperatureLabel.setText(currentWeatherData.getTemperature()+measurementUnitSuffix);
				int idWhenLabel = R.id.class.getField(prefix+"NextPeriodTitleLabel").getInt(null);
				TextView whenLabel = (TextView) findViewById(idWhenLabel);
				whenLabel.setText(currentWeatherData.getWhen());
				int idImage = R.id.class.getField(prefix+"NextPeriodImageView").getInt(null);
				ImageView imageView = (ImageView) findViewById(idImage);
				imageView.setImageResource(getResourceIdForWeather(false, currentWeatherData.getIcon()));	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		TextView locationLabel = (TextView) findViewById(R.id.locationLabel);
		locationLabel.setText(weatherLocation.city);
	}
	
	
	/**
	 * Do stuff that change at user interaction. Is called by onStart() after initializeUI.
	 */
	private void refreshUI() {
		WeatherData currentWeatherData = weatherProvider.getCurrentWeather().get(currentPeriod);
		ImageView centralImage = (ImageView) findViewById(R.id.mainWeatherImageView);
		centralImage.setImageResource(getResourceIdForWeather(true, currentWeatherData.getIcon()));		
		TextView timeLabel = (TextView) findViewById(R.id.timeLabel);
		timeLabel.setText(currentWeatherData.getWhen());
		TextView humidityLabel = (TextView) findViewById(R.id.humidityLabel);
		humidityLabel.setText(currentWeatherData.getHumidity().toString());
		TextView windLabel = (TextView) findViewById(R.id.windLabel);
		windLabel.setText(currentWeatherData.getWindSpeed()+"km/h");
		TextView weatherNowLabel = (TextView) findViewById(R.id.weatherNowLabel);
		weatherNowLabel.setText(currentWeatherData.getTemperature().toString()+measurementUnitSuffix);		
		LinearLayout columnLayouts[] = {
				(LinearLayout) findViewById(R.id.firstNextPeriodLayout),
				(LinearLayout) findViewById(R.id.secondNextPeriodLayout),
				(LinearLayout) findViewById(R.id.thirdNextPeriodLayout),
				(LinearLayout) findViewById(R.id.fourthNextPeriodLayout) };
		for (int i=0;i<4;i++) {
			if (i==currentPeriod) 
				columnLayouts[i].setBackgroundColor(Color.rgb(100,100,100));
			else
				columnLayouts[i].setBackgroundColor(Color.rgb(0,0,0));
		}
		
		//clothes stuff
		clothesSuggestion = (new SuggestionsEngine()).getSuggestion(currentWeatherData, UserSex.Male);
		int bottomIndex = clothesSuggestion.getBottomIndex();
		((ImageView)findViewById(R.id.BottomClothesView))
			.setImageResource(clothesSuggestion.getBottomSuggestions().get(bottomIndex).getResource());
	}

	private int getResourceIdForWeather(Boolean big, String iconName) {
		String prefix = big?"big_":"small_";
		try {
			Field field = R.drawable.class.getField(prefix+iconName);
			return field.getInt(null);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
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

	/* (non-Javadoc)
	 * @see android.app.Activity#onStart()
	 */
	@Override
	public void onStart() {
		super.onStart();
		getPreferences();
		initializeUI();
		refreshUI();
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
		// TODO
		measurementUnitSuffix = "°C";		
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