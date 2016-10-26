package eestec.jobfairapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
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

public class CompanyDetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_details);


        TextView tv_name = (TextView) findViewById(R.id.tv_company_name);
        TextView tv_occupation = (TextView) findViewById(R.id.tv_okupacija);
        TextView tv_web = (TextView) findViewById(R.id.tv_web);
        TextView tv_adresa = (TextView) findViewById(R.id.tv_adresa);
        TextView tv_email = (TextView) findViewById(R.id.tv_mail);
        TextView tv_tel = (TextView) findViewById(R.id.tv_telefon);
        Bundle extras = getIntent().getExtras();

        String logo ="";

        if (extras != null) {
            String name = extras.getString("COMPANY_NAME");
            String occupation = extras.getString("COMPANY_OCC");
            String web = extras.getString("COMPANY_WEB");
            String adresa = extras.getString("COMPANY_ADRESS");
            String email = extras.getString("COMPANY_MAIL");
            String tel = extras.getString("COMPANY_TEL");
            logo = extras.getString("COMPANY_LOGO");

            tv_name.setText(name);
            tv_occupation.setText(occupation);
            tv_web.setText(web);
            tv_adresa.setText(adresa);
            tv_email.setText(email);
            tv_tel.setText(tel);

        }

        else Toast.makeText(getApplicationContext(), "Kompanija trenutno nema dodatne podatke", Toast.LENGTH_LONG).show();


        ImageView image = (ImageView) findViewById(R.id.iv_company_logo) ;
        new LoadImageTask(image).execute(logo);

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
