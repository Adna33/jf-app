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
 * Created by XMAN on 13.9.2016.
 */
public class CompaniesActivity extends AppCompatActivity {

    ListView list;
    CompanyAdapter adapter;
    ArrayList<Company> companyList;
    String name;
    String occupation;
    String web;
    String adresa;
    String email;
    String tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companies);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null)
        {

            actionBar.setDisplayHomeAsUpEnabled(true); //Set this to true if selecting "home" returns up by a single level in your UI rather than back to the top level or front page.
            actionBar.setHomeAsUpIndicator(R.drawable.left_arrow); // set a custom icon for the default home button
        }

        companyList = new ArrayList<Company>();
        new CompaniesAsyncTask().execute("http://api.jobfair.ba/api/kompanije");

        list = (ListView)findViewById(R.id.listView);
        adapter = new CompanyAdapter(this, R.layout.company_details, companyList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long id) {
                Intent myIntent = new Intent(CompaniesActivity.this, CompanyDetailsActivity.class);
                name = companyList.get(position).getName();
                occupation = companyList.get(position).getOkupacija();
                web = companyList.get(position).getWeb();
                adresa = companyList.get(position).getAdresa();
                email = companyList.get(position).getEmail();
                tel = companyList.get(position).getTelefon();
                myIntent.putExtra("COMPANY_NAME",name);
                myIntent.putExtra("COMPANY_OCC",occupation);
                myIntent.putExtra("COMPANY_WEB",web);
                myIntent.putExtra("COMPANY_ADRESS",adresa);
                myIntent.putExtra("COMPANY_MAIL",email);
                myIntent.putExtra("COMPANY_TEL",tel);
                startActivityForResult(myIntent, 0);
            }
        });

    }


    public class CompaniesAsyncTask extends AsyncTask<String, Void, Boolean>{


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
                JSONArray companies = new JSONArray(result);


                for (int i = 0; i < companies.length(); i++) {
                    JSONObject object = companies.getJSONObject(i);

                    Company company = new Company();
                    company.setId(object.getInt("id"));
                    company.setName(object.getString("name"));
                    company.setOkupacija(object.getString("occupation"));
                    company.setEmail(object.getString("email"));
                    company.setWeb(object.getString("web"));
                    company.setAdresa(object.getString("address"));
                    company.setTelefon(object.getString("phone"));

                   companyList.add(company);

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