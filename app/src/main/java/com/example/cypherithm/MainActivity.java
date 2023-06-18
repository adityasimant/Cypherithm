package com.example.cypherithm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cypherinth.Cypherithm;

public class MainActivity extends AppCompatActivity {

    Button eytndyt;
    TextView tv1,tv2;
    LinearLayout l1,l2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eytndyt = findViewById(R.id.btnencryptndecrypt);
        tv1 = findViewById(R.id.tvencrypted);
        tv2 = findViewById(R.id.tvdecrypted);
        l1 = findViewById(R.id.llt1);
        l2 = findViewById(R.id.llt2);

        eytndyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.VISIBLE);
                tv1.setText("Working");
                tv2.setText("Working");
                Cypherithm.test(MainActivity.this,"Hello world!");
            }
        });

    }
}