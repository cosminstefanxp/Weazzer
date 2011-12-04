package weazzer.gui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainPanelActivity extends Activity {

	class MyTouchListener implements View.OnTouchListener {
		GestureDetector mGestureDetector = null;

		public MyTouchListener(GestureDetector gestureDetector) {
			super();
			this.mGestureDetector = gestureDetector;
		}

		public boolean onTouch(View v, MotionEvent aEvent) {
			if (mGestureDetector.onTouchEvent(aEvent))
				return true;
			else
				return false;
		}
	}

	String gender;	

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ImageView imagine = (ImageView) findViewById(R.id.TopClothesView);
		GestureDetector mGestureDetector = new GestureDetector(
				new MyGestureDetector(imagine));
		MyTouchListener mGestureListener = new MyTouchListener(mGestureDetector);

		imagine.setOnTouchListener(mGestureListener);
	}

	@Override
	public void onStart() {
		super.onStart();
		getPrefs();
	}

	private void getPrefs() {
		// Get the xml/preferences.xml preferences
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		gender = prefs.getString("genderPref", "male");
	}

	public void ApasaMaButtonClickEvent(View view) {
		Toast.makeText(this, "Salutare Diana, Vali, Filip & Cosmin",
				Toast.LENGTH_SHORT).show();
	}

	public void TrollClickEvent(View view) {
		Intent settingsActivity = new Intent(getBaseContext(),
				LongTermActivity.class);
		startActivity(settingsActivity);
	}

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

	public void SettingsMenuButtonClickEvent(View view) {
		Intent settingsActivity = new Intent(getBaseContext(),
				SettingsPanelActivity.class);
		startActivity(settingsActivity);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}

	class MyGestureDetector extends SimpleOnGestureListener {
		private static final int SWIPE_MIN_DISTANCE = 50;
		private static final int SWIPE_MAX_OFF_PATH = 50;
		private static final int SWIPE_THRESHOLD_VELOCITY = 50;
		View owner;

		public MyGestureDetector(View owner) {
			super();
			this.owner = owner;
		}

		// Amazingly enough, this must return true
		@Override
		public boolean onDown(MotionEvent e) {
			return true;
		}

		void rightSwipe() {
		}

		void leftSwipe() {

		}

		void upSwipe() {

		}

		void downSwipe() {
			ImageView imageView = (ImageView) owner;
			imageView.setImageResource(R.drawable.sun);
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
	};

}