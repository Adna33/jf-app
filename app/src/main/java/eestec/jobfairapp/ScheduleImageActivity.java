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

        raspored=(ImageView)findViewById(R.id.iv_raspored);
        PhotoViewAttacher photoView = new PhotoViewAttacher(raspored);
        photoView.update();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
