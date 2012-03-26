/*
 * Weazzer Android Application
 * 
 */
package weazzer.gui;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import weazzer.wear.ClothesSuggestion;
import weazzer.wear.ClothingArticle.UserSex;
import weazzer.wear.SuggestionsEngine;
import weazzer.weather.DummyProvider;
import weazzer.weather.WeatherData;
import weazzer.weather.WeatherLocation;
import weazzer.weather.WeatherProvider;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.Toast;

/**
 * The Class MainPanelActivity.
 */
public class MainPanelActivity extends Activity {

	/**
	 * Listen on swipes, taps, etc.
	 * 
	 * @author ze 
	 * 
	 */
	class MainPanelGestureDetector extends SimpleOnGestureListener {
		private static final int SWIPE_MIN_DISTANCE = 20;
		private static final int SWIPE_MAX_OFF_PATH = 100;
		private static final int SWIPE_THRESHOLD_VELOCITY = 30;
		/**
		 * Whose events are listened.
		 */
		View owner;

		public MainPanelGestureDetector(View owner) {
			super();
			this.owner = owner;
		}

		@Override
		public boolean onDown(MotionEvent e) {
			// Taps on the four next periods.
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

		// All swipes on the main image shift currentPeriod.
		void rightSwipe() {
			if (owner == findViewById(R.id.mainWeatherImageView)) {
				if (currentPeriod > 0)
					currentPeriod--;
			}
			refreshUI();
		}

		void leftSwipe() {
			if (owner == findViewById(R.id.mainWeatherImageView)) {
				if (currentPeriod == 3)
					toLongTermAction(owner);
				else if (currentPeriod < 3)
					currentPeriod++;
			}
			refreshUI();
		}

		// Up, down swipes on clothes shift the current clothe
		// index in the array.
		void upSwipe() {
			if (owner == findViewById(R.id.mainWeatherImageView)) {
				if (currentPeriod == 3)
					toLongTermAction(owner);
				else if (currentPeriod < 3)
					currentPeriod++;
			}
			if (owner == findViewById(R.id.TopClothesView)) {
				onTopDownPress(owner);
			}
			if (owner == findViewById(R.id.BottomClothesView)) {
				onBottomDownPress(owner);
			}
			if (owner == findViewById(R.id.OvercoatClothesView)) {
				onOvercoatDownPress(owner);
			}
			refreshUI();
		}

		void downSwipe() {
			if (owner == findViewById(R.id.mainWeatherImageView)) {
				if (currentPeriod > 0)
					currentPeriod--;
			}
			if (owner == findViewById(R.id.TopClothesView)) {
				onTopUpPress(owner);
			}
			if (owner == findViewById(R.id.BottomClothesView)) {
				onBottomUpPress(owner);
			}
			if (owner == findViewById(R.id.OvercoatClothesView)) {
				onOvercoatUpPress(owner);
			}
			refreshUI();
		}

		/**
		 * Detect Fling (Swipe).
		 */
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

	/** The gender from preferences. */
	private String gender;
	/** The current weather provider. */
	private WeatherProvider weatherProvider;
	/** A period from 0 to 3. */
	private int currentPeriod;
	/** 'C or 'F from preferences. */
	private String measurementUnitSuffix;
	/** Metric or Farenheit from preferences. */
	private String systemUnit;
	/** The location from preferences. */
	private WeatherLocation weatherLocation;
	/** The current suggestion engine. */
	private SuggestionsEngine suggestionsEngine;
	/** The current clothes selection. */
	private ClothesSuggestion clothesSuggestion[];
	/** The current weather. */
	private List<WeatherData> weather;
	private SharedPreferences prefs;
	private String windSuffix;

	/**
	 * The listener interface for receiving myTouch events. The class that is
	 * interested in processing a myTouch event implements this interface, and
	 * the object created with that class is registered with a component using
	 * the component's <code>addMyTouchListener<code> method. When
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
		 * @param gestureDetector
		 *            the gesture detector
		 */
		public MyTouchListener(GestureDetector gestureDetector) {
			super();
			this.mGestureDetector = gestureDetector;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see android.view.View.OnTouchListener#onTouch(android.view.View,
		 * android.view.MotionEvent)
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
	 * @param savedInstanceState
	 *            the saved instance state
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Add swipe detectors to everything that needs it.
		int swipedImgIds[] = { R.id.TopClothesView, R.id.BottomClothesView,
				R.id.OvercoatClothesView, R.id.mainWeatherImageView,
				R.id.firstNextPeriodLayout, R.id.secondNextPeriodLayout,
				R.id.thirdNextPeriodLayout, R.id.fourthNextPeriodLayout };
		for (int id : swipedImgIds) {
			View view = findViewById(id);
			GestureDetector mGestureDetector = new GestureDetector(
					new MainPanelGestureDetector(view));
			MyTouchListener mGestureListener = new MyTouchListener(
					mGestureDetector);

			view.setOnTouchListener(mGestureListener);
		}

		// Initialize providers and indexes.
		weatherProvider = new DummyProvider();
		suggestionsEngine = new SuggestionsEngine(getApplicationContext());
		currentPeriod = 0;
		clothesSuggestion = new ClothesSuggestion[4];
	}

	/**
	 * Do stuff that don't change at user interaction. Is called by onStart().
	 */
	private void initializeUI() {
		try {
			for (int currentPeriod = 0; currentPeriod < 4; currentPeriod++) {
				WeatherData currentWeatherData = weather.get(currentPeriod);
				String prefix = null;
				switch (currentPeriod) {
				case 0:
					prefix = "first";
					break;
				case 1:
					prefix = "second";
					break;
				case 2:
					prefix = "third";
					break;
				case 3:
					prefix = "fourth";
					break;
				}
				int idTemperatureLabel = R.id.class.getField(
						prefix + "NextPeriodValueLabel").getInt(null);
				TextView temperatureLabel = (TextView) findViewById(idTemperatureLabel);
				temperatureLabel.setText(convertTemp(currentWeatherData
						.getTemperature()) + measurementUnitSuffix);
				int idWhenLabel = R.id.class.getField(
						prefix + "NextPeriodTitleLabel").getInt(null);
				TextView whenLabel = (TextView) findViewById(idWhenLabel);
				whenLabel.setText(currentWeatherData.getWhen());
				int idImage = R.id.class.getField(
						prefix + "NextPeriodImageView").getInt(null);
				ImageView imageView = (ImageView) findViewById(idImage);
				imageView.setImageResource(getResourceIdForWeather(false,
						currentWeatherData.getIcon()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		TextView locationLabel = (TextView) findViewById(R.id.locationLabel);
		locationLabel.setText(weatherLocation.city.substring(0,1).toUpperCase()+weatherLocation.city.substring(1));
	}

	/**
	 * Do stuff that change at user interaction. Is called by onStart() after
	 * initializeUI and after all user interaction.
	 */
	private void refreshUI() {
		// weather stuff.
		WeatherData currentWeatherData = weather.get(currentPeriod);
		ImageView centralImage = (ImageView) findViewById(R.id.mainWeatherImageView);
		centralImage.setImageResource(getResourceIdForWeather(true,
				currentWeatherData.getIcon()));
		TextView feelsLike = (TextView) findViewById(R.id.feelsLikeLabel);
		feelsLike.setText(convertTemp(currentWeatherData.getFeelsLike())
				+ measurementUnitSuffix);
		TextView weatherNowLabel = (TextView) findViewById(R.id.mainTemperatureLabel);
		TextView windLabel = (TextView) findViewById(R.id.windLabel);
		windLabel.setText("wind: "
				+ convertWind(currentWeatherData.getWindSpeed()) + " "
				+ windSuffix);

		weatherNowLabel
				.setText(convertTemp(currentWeatherData.getTemperature())
						+ measurementUnitSuffix);
		LinearLayout columnLayouts[] = {
				(LinearLayout) findViewById(R.id.firstNextPeriodLayout),
				(LinearLayout) findViewById(R.id.secondNextPeriodLayout),
				(LinearLayout) findViewById(R.id.thirdNextPeriodLayout),
				(LinearLayout) findViewById(R.id.fourthNextPeriodLayout) };
		for (int i = 0; i < 4; i++) {
			if (i == currentPeriod)
				columnLayouts[i].setBackgroundColor(Color.rgb(100, 100, 100));
			else
				columnLayouts[i].setBackgroundColor(Color.rgb(0, 0, 0));
		}

		// clothes stuff

		int bottomIndex = clothesSuggestion[currentPeriod].getBottomIndex();
		int topIndex = clothesSuggestion[currentPeriod].getTopIndex();
		int overcoatIndex = clothesSuggestion[currentPeriod].getOvercoatIndex();
		if (bottomIndex == 0) {
			((ImageView) findViewById(R.id.bottomTopArrow))
					.setVisibility(ImageView.INVISIBLE);
		} else {
			((ImageView) findViewById(R.id.bottomTopArrow))
					.setVisibility(ImageView.VISIBLE);
		}

		if (topIndex == 0) {
			((ImageView) findViewById(R.id.upTopArrow))
					.setVisibility(ImageView.INVISIBLE);
		} else {
			((ImageView) findViewById(R.id.upTopArrow))
					.setVisibility(ImageView.VISIBLE);
		}

		if (overcoatIndex == 0) {
			((ImageView) findViewById(R.id.overcoatTopArrow))
					.setVisibility(ImageView.INVISIBLE);
		} else {
			((ImageView) findViewById(R.id.overcoatTopArrow))
					.setVisibility(ImageView.VISIBLE);
		}

		if (bottomIndex == clothesSuggestion[currentPeriod]
				.getBottomSuggestions().size() - 1) {
			((ImageView) findViewById(R.id.downBottomArrow))
					.setVisibility(ImageView.INVISIBLE);
		} else {
			((ImageView) findViewById(R.id.downBottomArrow))
					.setVisibility(ImageView.VISIBLE);
		}

		if (overcoatIndex == clothesSuggestion[currentPeriod]
				.getOvercoatSuggestions().size() - 1) {
			((ImageView) findViewById(R.id.downOvercoatArrow))
					.setVisibility(ImageView.INVISIBLE);
		} else {
			((ImageView) findViewById(R.id.downOvercoatArrow))
					.setVisibility(ImageView.VISIBLE);
		}

		if (topIndex == clothesSuggestion[currentPeriod].getTopSuggestions()
				.size() - 1) {
			((ImageView) findViewById(R.id.downTopArrow))
					.setVisibility(ImageView.INVISIBLE);
		} else {
			((ImageView) findViewById(R.id.downTopArrow))
					.setVisibility(ImageView.VISIBLE);
		}

		int resourceId = clothesSuggestion[currentPeriod]
				.getBottomSuggestions().get(bottomIndex).getResource();
		((ImageView) findViewById(R.id.BottomClothesView))
				.setImageResource(resourceId);
		resourceId = clothesSuggestion[currentPeriod].getTopSuggestions()
				.get(topIndex).getResource();
		((ImageView) findViewById(R.id.TopClothesView))
				.setImageResource(resourceId);
		resourceId = clothesSuggestion[currentPeriod].getOvercoatSuggestions()
				.get(overcoatIndex).getResource();
		((ImageView) findViewById(R.id.OvercoatClothesView))
				.setImageResource(resourceId);

		if (clothesSuggestion[currentPeriod].getAccessoriesSelect().get(0)) {
			((ImageView) findViewById(R.id.firstExtraView))
					.setImageResource(clothesSuggestion[currentPeriod]
							.getAccessoriesSuggestions().get(0).getResource());
			((ImageView) findViewById(R.id.firstX))
					.setVisibility(ImageView.INVISIBLE);
		} else {
			((ImageView) findViewById(R.id.firstExtraView))
					.setImageResource(clothesSuggestion[currentPeriod]
							.getAccessoriesSuggestions().get(0)
							.getResourceGray());
			((ImageView) findViewById(R.id.firstX))
					.setVisibility(ImageView.VISIBLE);
		}
		if (clothesSuggestion[currentPeriod].getAccessoriesSelect().get(1)) {
			((ImageView) findViewById(R.id.secondExtraView))
					.setImageResource(clothesSuggestion[currentPeriod]
							.getAccessoriesSuggestions().get(1).getResource());
			((ImageView) findViewById(R.id.secondX))
					.setVisibility(ImageView.INVISIBLE);
		} else {
			((ImageView) findViewById(R.id.secondExtraView))
					.setImageResource(clothesSuggestion[currentPeriod]
							.getAccessoriesSuggestions().get(1)
							.getResourceGray());
			((ImageView) findViewById(R.id.secondX))
					.setVisibility(ImageView.VISIBLE);
		}
		if (clothesSuggestion[currentPeriod].getAccessoriesSelect().get(2)) {
			((ImageView) findViewById(R.id.thirdExtraView))
					.setImageResource(clothesSuggestion[currentPeriod]
							.getAccessoriesSuggestions().get(2).getResource());
			((ImageView) findViewById(R.id.thirdX))
					.setVisibility(ImageView.INVISIBLE);
		} else {
			((ImageView) findViewById(R.id.thirdExtraView))
					.setImageResource(clothesSuggestion[currentPeriod]
							.getAccessoriesSuggestions().get(2)
							.getResourceGray());
			((ImageView) findViewById(R.id.thirdX))
					.setVisibility(ImageView.VISIBLE);
		}

		if (currentPeriod == 0) {
			((ImageView) findViewById(R.id.imageView1))
					.setVisibility(ImageView.INVISIBLE);
		} else {
			((ImageView) findViewById(R.id.imageView1))
					.setVisibility(ImageView.VISIBLE);
		}
	}

	private String convertTemp(Float temperature) {
		Float newTemperature = temperature;
		// convert if Fahrenheit
		if (!systemUnit.equals("Metric")) {
			newTemperature = temperature * 9 / 5 + 32;
		}
		return (new DecimalFormat("#").format(newTemperature));
	}

	private String convertWind(Float wind) {
		Float newWind = wind;
		// convert if Fahrenheit
		if (!windSuffix.equals("mph")) {
			newWind = wind / 1.6f;
		}
		return (new DecimalFormat("#").format(newWind));
	}

	private int getResourceIdForWeather(Boolean big, String iconName) {
		String prefix = big ? "big_" : "small_";
		try {
			Field field = R.drawable.class.getField(prefix + iconName);
			return field.getInt(null);
		} catch (SecurityException e) { //
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onStart()
	 */
	@Override
	public void onStart() {
		super.onStart();
		getPreferences();
		weatherProvider.setLocation(weatherLocation);
		try {
			weather = weatherProvider.getCurrentWeather();
			
			for (int period = 0; period < 4; period++)
				clothesSuggestion[period] = suggestionsEngine.getSuggestion(
						weather.get(period),
						gender.equals("male") ? UserSex.Male : UserSex.Female);
			initializeUI();
			refreshUI();
		} catch (Exception e) {
			showDialog(0);
		}
	}

	/**
	 * Gets the preferences from the system preferences in Android.
	 * 
	 * @return the preferences
	 */
	private void getPreferences() {
		// Get the xml/preferences.xml preferences
		prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

		// Gender
		gender = prefs.getString("genderPref", "male");
		// Measurement unit
		systemUnit = prefs.getString("suPref", "Metric");
		measurementUnitSuffix = systemUnit.equals("Metric") ? "°C" : "°F";
		windSuffix = systemUnit.equals("Metric") ? "km/h" : "mph";

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

	/**
	 * On pressing the arrow for long term.
	 * 
	 * @param v
	 */
	public void toLongTermAction(View v) {
		Intent activity = new Intent(getBaseContext(), LongTermActivity.class);
		startActivity(activity);
	}

	/**
	 * On pressing the save button.
	 * 
	 * @param v
	 */
	public void onSaveSuggestions(View v) {
		WeatherData currentWeatherData = weather.get(currentPeriod);
		suggestionsEngine.updateUserChoice(currentWeatherData,
				clothesSuggestion[currentPeriod]);
		Context context = getApplicationContext();
		CharSequence text = "Choice saved!";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();

		for (int period = 0; period < 4; period++)
			if (period != currentPeriod)
				clothesSuggestion[period] = suggestionsEngine.getSuggestion(
						weather.get(period),
						gender.equals("male") ? UserSex.Male : UserSex.Female);
	}

	public void onFirstExtraToggle(View v) {
		ArrayList<Boolean> choice = clothesSuggestion[currentPeriod]
				.getAccessoriesSelect();
		choice.set(0, !choice.get(0));
		refreshUI();
	}

	public void onSecondExtraToggle(View v) {
		ArrayList<Boolean> choice = clothesSuggestion[currentPeriod]
				.getAccessoriesSelect();
		choice.set(1, !choice.get(1));
		refreshUI();
	}

	public void onThirdExtraToggle(View v) {
		ArrayList<Boolean> choice = clothesSuggestion[currentPeriod]
				.getAccessoriesSelect();
		choice.set(2, !choice.get(2));
		refreshUI();
	}

	public void onLeftArrowPress(View v) {
		if (currentPeriod > 0)
			currentPeriod--;
		refreshUI();
	}

	public void onRightArrowPress(View v) {
		if (currentPeriod == 3)
			toLongTermAction(null);
		else if (currentPeriod < 3)
			currentPeriod++;
		refreshUI();
	}

	public void onOvercoatDownPress(View v) {
		if (clothesSuggestion[currentPeriod].getOvercoatIndex() < clothesSuggestion[currentPeriod]
				.getOvercoatSuggestions().size() - 1) {
			clothesSuggestion[currentPeriod]
					.setOvercoatIndex(clothesSuggestion[currentPeriod]
							.getOvercoatIndex() + 1);
		}
		refreshUI();
	}

	public void onBottomDownPress(View v) {
		if (clothesSuggestion[currentPeriod].getBottomIndex() < clothesSuggestion[currentPeriod]
				.getBottomSuggestions().size() - 1) {
			clothesSuggestion[currentPeriod]
					.setBottomIndex(clothesSuggestion[currentPeriod]
							.getBottomIndex() + 1);
		}
		refreshUI();
	}

	public void onTopDownPress(View v) {
		if (clothesSuggestion[currentPeriod].getTopIndex() < clothesSuggestion[currentPeriod]
				.getTopSuggestions().size() - 1) {
			clothesSuggestion[currentPeriod]
					.setTopIndex(clothesSuggestion[currentPeriod].getTopIndex() + 1);
		}
		refreshUI();
	}

	public void onTopUpPress(View v) {
		if (clothesSuggestion[currentPeriod].getTopIndex() > 0) {
			clothesSuggestion[currentPeriod]
					.setTopIndex(clothesSuggestion[currentPeriod].getTopIndex() - 1);
		}
		refreshUI();
	}

	public void onBottomUpPress(View v) {
		if (clothesSuggestion[currentPeriod].getBottomIndex() > 0) {
			clothesSuggestion[currentPeriod]
					.setBottomIndex(clothesSuggestion[currentPeriod]
							.getBottomIndex() - 1);
		}
		refreshUI();
	}

	public void onOvercoatUpPress(View v) {
		if (clothesSuggestion[currentPeriod].getOvercoatIndex() > 0) {
			clothesSuggestion[currentPeriod]
					.setOvercoatIndex(clothesSuggestion[currentPeriod]
							.getOvercoatIndex() - 1);
		}
		refreshUI();
	}

	protected Dialog onCreateDialog(int id) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Internet connection cannot be found.")
				.setCancelable(false)
				.setPositiveButton("Exit",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								MainPanelActivity.this.finish();
							}
						});
		AlertDialog alert = builder.create();

		return alert;
	}
}