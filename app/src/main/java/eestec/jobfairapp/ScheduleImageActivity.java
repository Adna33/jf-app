package eestec.jobfairapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ScheduleImageActivity extends AppCompatActivity {

    ImageView raspored;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_image);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null)
        {

            actionBar.setDisplayHomeAsUpEnabled(true); //Set this to true if selecting "home" returns up by a single level in your UI rather than back to the top level or front page.
            actionBar.setHomeAsUpIndicator(R.drawable.left_arrow); // set a custom icon for the default home button
        }
        raspored=(ImageView)findViewById(R.id.iv_raspored);
        PhotoViewAttacher photoView = new PhotoViewAttacher(raspored);
        photoView.update();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, ScheduleActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
