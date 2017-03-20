package com.example.ciz.test;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import java.lang.ref.WeakReference;

public class SplashScreen extends Activity {
    // Create a static nested class that extends Runnable to start the main Activity
    private static class StartMainActivityRunnable implements Runnable {
    // Make sure we keep the source Activity as a WeakReference
        private WeakReference mActivity;

        private StartMainActivityRunnable(Activity activity) {
            mActivity = new WeakReference(activity);
        }

        @Override
        public void run() {
            // Check that the reference is valid and execute the code
            if (mActivity.get() != null) {
                Activity activity = (Activity) mActivity.get();
                Intent mainIntent = new Intent(activity, MainActivity.class);
                activity.startActivity(mainIntent);
                activity.finish();
            }
        }
    }

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 850;

    // Declare the Handler as a member variable
    private Handler mHandler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        // Pass a new instance of StartMainActivityRunnable with reference to 'this'.
        mHandler.postDelayed(new StartMainActivityRunnable(this), SPLASH_DISPLAY_LENGTH);
    }
}