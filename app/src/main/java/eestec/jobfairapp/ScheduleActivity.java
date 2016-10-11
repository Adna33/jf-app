package eestec.jobfairapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher;

/**
 * Created by XMAN on 13.9.2016.
 */
public class ScheduleActivity extends AppCompatActivity {
    private ViewSwitcher mViewSwitcher;
    private GestureDetector mGestureDetector;

    Boolean switched;
    private String TAG = ScheduleActivity.class.getSimpleName();

    int[] resources = {
            R.drawable.tlocrt_test,
            R.drawable.jf_raspored_test
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null)
        {

            actionBar.setDisplayHomeAsUpEnabled(true); //Set this to true if selecting "home" returns up by a single level in your UI rather than back to the top level or front page.
            actionBar.setHomeAsUpIndicator(R.drawable.left_arrow); // set a custom icon for the default home button
        }
        // Get the ViewFlipper
        mViewSwitcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);

// Add all the images to the ViewFlipper
        for (int i = 0; i < resources.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(resources[i]);
            mViewSwitcher.addView(imageView);
        }
        CustomGestureDetector customGestureDetector = new CustomGestureDetector();
        mGestureDetector = new GestureDetector(this, customGestureDetector);
        Toast.makeText(getApplicationContext(), "SKICA SAJMA", Toast.LENGTH_SHORT).show();
        switched=true;


    }
    class CustomGestureDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            // Swipe left (next)
            if (e1.getX() > e2.getX()) {
                mViewSwitcher.setInAnimation(ScheduleActivity.this, R.anim.left_in);
                mViewSwitcher.setOutAnimation(ScheduleActivity.this, R.anim.left_out);
                mViewSwitcher.showNext();
                if(switched) {Toast.makeText(getApplicationContext(), "SKICA RASPOREDA", Toast.LENGTH_SHORT).show(); switched=false;}
                else {Toast.makeText(getApplicationContext(), "SKICA SAJMA", Toast.LENGTH_SHORT).show();  switched=true;}

            }

            // Swipe right (previous)
            if (e1.getX() < e2.getX()) {
                mViewSwitcher.setInAnimation(ScheduleActivity.this, R.anim.right_in);
                mViewSwitcher.setOutAnimation(ScheduleActivity.this, R.anim.right_out);

                mViewSwitcher.showPrevious();
                if(switched) {Toast.makeText(getApplicationContext(), "SKICA RASPOREDA", Toast.LENGTH_SHORT).show(); switched=false;}
                else {Toast.makeText(getApplicationContext(), "SKICA SAJMA", Toast.LENGTH_SHORT).show();  switched=true;}


            }



            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);

        return super.onTouchEvent(event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.gesture, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}