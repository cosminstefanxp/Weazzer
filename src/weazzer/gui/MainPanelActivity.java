/*
 * Weazzer Android Application
 * 
 */
package weazzer.gui;

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
import android.widget.Toast;

/**
 * The Class MainPanelActivity.
 */
public class MainPanelActivity extends Activity {

	/** The gender. */
	String gender;
	
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

		ImageView imagine = (ImageView) findViewById(R.id.TopClothesView);
		GestureDetector mGestureDetector = new GestureDetector(
				new MainPanelGestureDetector(imagine));
		MyTouchListener mGestureListener = new MyTouchListener(mGestureDetector);

		imagine.setOnTouchListener(mGestureListener);
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
	 * Gets the preferences.
	 *
	 * @return the preferences
	 */
	private void getPreferences() {
		// Get the xml/preferences.xml preferences
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		gender = prefs.getString("genderPref", "male");
	}

	/**
	 * Apasa ma button click event.
	 *
	 * @param view the view
	 */
	public void ApasaMaButtonClickEvent(View view) {
		//TODO: de sters -- crap
		Toast.makeText(this, "Salutare Diana, Vali, Filip & Cosmin",
				Toast.LENGTH_SHORT).show();
	}

	/**
	 * Troll click event.
	 *
	 * @param view the view
	 */
	public void TrollClickEvent(View view) {
		//TODO: de sters -- crap
		Intent settingsActivity = new Intent(getBaseContext(),
				LongTermActivity.class);
		startActivity(settingsActivity);
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
	
	public void toLongTermAction() {		
		Intent activity = new Intent(getBaseContext(),
				LongTermActivity.class);
		startActivity(activity);
	}


}