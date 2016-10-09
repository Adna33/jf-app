package eestec.jobfairapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class CompanyDetailsActivity extends AppCompatActivity {

    int ID;
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
        TextView tv1=(TextView) findViewById(R.id.tv_detalji_company);
        //get id selektovane kompanije
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int value=extras.getInt("COMPANY_CONTENT");
            ID=value;
            tv1.setText(String.valueOf(value));

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
