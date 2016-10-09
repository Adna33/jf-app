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

    int ID;
    Company selectedCompany;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_details);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null)
        {
            //omogucavanje back buttona
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.left_arrow);
        }
        ID=1;

        //get id selektovane kompanije
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int value=extras.getInt("COMPANY_CONTENT");
            ID=value;
            //tv1.setText(String.valueOf(value));
            selectedCompany = new Company();
            new CompanyAsyncTask().execute("http://api.jobfair.ba/api/kompanija/"+ID);
            if(selectedCompany!=null){
            TextView name = (TextView) findViewById(R.id.tv_company_name);
            name.setText(selectedCompany.getName());
            TextView occupation = (TextView) findViewById(R.id.tv_okupacija);
            occupation.setText(selectedCompany.getOkupacija());
            TextView web = (TextView) findViewById(R.id.tv_web);
            web.setText(selectedCompany.getWeb());
            TextView adresa = (TextView) findViewById(R.id.tv_adresa);
            adresa.setText(selectedCompany.getAdresa());
            TextView email = (TextView) findViewById(R.id.tv_mail);
            email.setText(selectedCompany.getEmail());
            TextView tel = (TextView) findViewById(R.id.tv_telefon);
            tel.setText(selectedCompany.getTelefon());}
            else Toast.makeText(getApplicationContext(), "Kompanija trenutno nema dodatne podatke", Toast.LENGTH_LONG).show();

        }
        else Toast.makeText(getApplicationContext(), "Greska pri ucitavanju detalja", Toast.LENGTH_LONG).show();





    }
    public class CompanyAsyncTask extends AsyncTask<String, Void, Boolean> {


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

                //InputStream in = new BufferedInputStream(connection.getInputStream());
                JSONObject object = new JSONObject(result);
                // JSONArray companies = new JSONArray(result);


                selectedCompany.setId(object.getInt("id"));
                selectedCompany.setName(object.getString("name"));
                selectedCompany.setEmail(object.getString("email"));
                selectedCompany.setWeb(object.getString("web"));
                selectedCompany.setTelefon(object.getString("phone"));
                selectedCompany.setAdresa(object.getString("address"));
                selectedCompany.setOkupacija(object.getString("occupation"));

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

            if(result == false)
                Toast.makeText(getApplicationContext(), "Nije moguće učitati podatke", Toast.LENGTH_LONG).show();

        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
