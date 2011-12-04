package weazzer.gui;

import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.widget.ImageView;

public class MainPanelGestureDetector  extends SimpleOnGestureListener {
	private static final int SWIPE_MIN_DISTANCE = 50;
	private static final int SWIPE_MAX_OFF_PATH = 50;
	private static final int SWIPE_THRESHOLD_VELOCITY = 50;
	View owner;

	public MainPanelGestureDetector(View owner) {
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
}
