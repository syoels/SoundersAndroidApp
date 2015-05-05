package com.example.musicsaround;

import com.example.musicsaround.dj.DJActivity;
import com.example.musicsaround.speaker.SpeakerActivity;
import com.example.musicsaround.Settings;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity{
private GestureDetector gestureDetector;

        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);


            //Remove title bar
            this.requestWindowFeature(Window.FEATURE_NO_TITLE);
            //Remove notification bar
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            //set content view AFTER ABOVE sequence (to avoid crash)
            this.setContentView(R.layout.activity_main);


            gestureDetector = new GestureDetector(new SwipeGestureDetector());

            final Button button = (Button) findViewById(R.id.splitSettings);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), Settings.class);
                    startActivity(intent);
                }
            });
        }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }

  /* ... */

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (gestureDetector.onTouchEvent(event)) {
                return true;
            }
            return super.onTouchEvent(event);
        }

        private void onLeftSwipe() {
            Intent intent = new Intent(this, DJActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

        }

        private void onRightSwipe() {
            Intent intent = new Intent(this, SpeakerActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
        }

// Private class for gestures
private class SwipeGestureDetector
        extends GestureDetector.SimpleOnGestureListener {
    // Swipe properties, you can change it to make the swipe
    // longer or shorter and speed
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 200;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2,
                           float velocityX, float velocityY) {
        try {
            float diffAbs = Math.abs(e1.getY() - e2.getY());
            float diff = e1.getX() - e2.getX();

            if (diffAbs > SWIPE_MAX_OFF_PATH)
                return false;

            // Left swipe
            if (diff > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                MainActivity.this.onLeftSwipe();

                // Right swipe
            } else if (-diff > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                MainActivity.this.onRightSwipe();
            }
        } catch (Exception e) {
            Log.e("YourActivity", "Error on gestures");
        }
        return false;
    }
}
}