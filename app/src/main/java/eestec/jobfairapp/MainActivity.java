package eestec.jobfairapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton imgBtn1 = (ImageButton) findViewById(R.id.imageButton);
        imgBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "O nama", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton imgBtn2 = (ImageButton) findViewById(R.id.imageButton2);
        imgBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Raspored", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton imgBtn3 = (ImageButton) findViewById(R.id.imageButton3);
        imgBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Mapa", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton imgBtn4 = (ImageButton) findViewById(R.id.imageButton4);
        imgBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Kompanije", Toast.LENGTH_SHORT).show();
            }
        });
    }



}