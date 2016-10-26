package eestec.jobfairapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by XMAN on 8.10.2016.
 */
public class NewsDetailsActivity extends AppCompatActivity {
    String newsId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsdetails);


        TextView content = (TextView) findViewById(R.id.newsContent);
        TextView tv_title = (TextView) findViewById(R.id.news_details_name);

        ImageView image = (ImageView) findViewById(R.id.news_image) ;
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String value = extras.getString("NEWS_CONTENT");
            newsId=extras.getString("NEWS_ID");
            String title=extras.getString("NEWS_TITLE");
            content.setText(value);
            tv_title.setText(title);


        }

        if(newsId != null)
         new LoadImageTask(image).execute("http://api.jobfair.ba/static/news/t_"+newsId+".jpg");

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

