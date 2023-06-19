package com.example.cypherithm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cypherinth.AESUtils;
import com.example.cypherinth.BlowfishUtils;
import com.example.cypherinth.Cypherithm;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2;
    EditText e1;
    Spinner spinner;

    LinearLayout l1,l2;
    String [] algorithm = {"none","AES", "BlowFish"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tvencrypted);
        tv2 = findViewById(R.id.tvdecrypted);
        l1 = findViewById(R.id.llt1);
        l2 = findViewById(R.id.llt2);
        e1 = findViewById(R.id.etinput);
        spinner =findViewById(R.id.spinner);


        ArrayAdapter<String> adapter= new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,algorithm);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String input = e1.getText().toString();
                tv1.setText("");
                String temp;
                switch (i){

                    case 0:
                        break;
                    case 1:
                        l1.setVisibility(View.VISIBLE);
                        l2.setVisibility(View.VISIBLE);
                        String key = "ThisIsASecretKey";

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
                        break;
                    case 2:
                        l1.setVisibility(View.VISIBLE);
                        l2.setVisibility(View.VISIBLE);
                        String password = "ThisIsAPassword";
                        if (input != ""){
                            try {
                                String encrypted = BlowfishUtils.encrypt(MainActivity.this,
                                        input,password);
                                tv1.setText(encrypted);
                                String decrypted = BlowfishUtils.decrypt(MainActivity.this,
                                        encrypted,password);
                                tv2.setText(decrypted);

                            } catch (Exception e) {
                                Toast.makeText(MainActivity.this, "Exception occured", Toast.LENGTH_SHORT).show();
                            }
                        }
                    break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}