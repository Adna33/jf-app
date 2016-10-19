package eestec.jobfairapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by XMAN on 8.10.2016.
 */
public class NewsActivity extends AppCompatActivity {

    ListView list;
    NewsAdapter adapter;
    ArrayList<News> newsList;
    String content;
    String newsId;
    String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null)
        {

            actionBar.setDisplayHomeAsUpEnabled(true); //Set this to true if selecting "home" returns up by a single level in your UI rather than back to the top level or front page.
            actionBar.setHomeAsUpIndicator(R.drawable.left_arrow); // set a custom icon for the default home button
        }


        newsList = new ArrayList<News>();
        new CompaniesAsyncTask().execute("http://api.jobfair.ba/api/posts");

        list = (ListView)findViewById(R.id.listViewNews);
        adapter = new NewsAdapter(this, R.layout.news_row, newsList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                    Intent myIntent = new Intent(view.getContext(), NewsDetailsActivity.class);
                    content = newsList.get(position).getContent();
                    title = newsList.get(position).getName();
                     newsId= newsList.get(position).getId();
                    myIntent.putExtra("NEWS_CONTENT",content);
                    myIntent.putExtra("NEWS_TITLE",title);
                    myIntent.putExtra("NEWS_ID",newsId);
                    startActivityForResult(myIntent, 0);


                }

        });
    }


    public class CompaniesAsyncTask extends AsyncTask<String, Void, Boolean> {


        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String result = "";

        @Override
        protected Boolean doInBackground(String... params) {
            try {

                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();

                if(connection.getResponseCode() != HttpURLConnection.HTTP_OK){ return false; }

                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                result = sb.toString();

                JSONArray companies = new JSONArray(result);


                for (int i = 0; i < companies.length(); i++) {
                    JSONObject object = companies.getJSONObject(i);

                    News news = new News();
                    news.setId(object.getString("id"));
                    news.setName(object.getString("naslov"));
                    news.setDescription(object.getString("opis"));
                    news.setContent(object.getString("sadrzaj"));


                    newsList.add(news);

                }

                return true;
            }
            catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            adapter.notifyDataSetChanged();
            if(result == false)
                Toast.makeText(getApplicationContext(), "Nije moguće učitati podatke", Toast.LENGTH_LONG).show();

        }
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