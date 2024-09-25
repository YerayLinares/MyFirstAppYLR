package com.example.myfirstappylr;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvchain = findViewById(R.id.TextBoxResult);
        TextView tvnumber = findViewById(R.id.NumberBoxResult);
        TextView tvdecimal = findViewById(R.id.DecimalNumberBoxResult);
        TextView tvboolean = findViewById(R.id.booleanbox);
        Intent intent = getIntent();

        String number = intent.getStringExtra("number");
        double decimal = intent.getDoubleExtra("decimal_number", 0.0);


        tvchain.setText(intent.getStringExtra("text"));
        tvnumber.setText(number);
        tvdecimal.setText(String.valueOf(decimal));
        boolean switchState = getIntent().getBooleanExtra("switch_value", false);

        if (switchState) {
            tvboolean.setText("true");
        } else {
            tvboolean.setText("false");
        }

        Button back = findViewById(R.id.btnback);
        Button start = findViewById(R.id.btnstart);

        back.setOnClickListener(v ->{
            Intent newintent = new Intent(MainActivity3.this, MainActivity2.class);

            startActivity(newintent);
        });

        start.setOnClickListener(v ->{
            Intent newintent = new Intent(this, MainActivity.class);

            startActivity(newintent);
        });
    }
}