package com.example.cypherithm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cypherinth.AESUtils;
import com.example.cypherinth.Cypherithm;

public class MainActivity extends AppCompatActivity {

    Button eytndyt;
    TextView tv1,tv2;
    EditText e1;
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
        e1 = findViewById(R.id.etinput);

        eytndyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.VISIBLE);
                String key = "ThisIsASecretKey";

                String input = e1.getText().toString();
                String temp;

                if (input != ""){

                    try {
                        String encrypted = AESUtils.encrypt(MainActivity.this,
                                input,key);
                        tv1.setText(encrypted);
                        String decrypted = AESUtils.decrypt(MainActivity.this,
                                encrypted,key);
                        tv2.setText(decrypted);


                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Exception occured", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });

    }
}