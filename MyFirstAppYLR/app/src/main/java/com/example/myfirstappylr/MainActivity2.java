package com.example.myfirstappylr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button sendmessage = findViewById(R.id.btnSendMessage);
        EditText textbox = findViewById(R.id.textbox);
        EditText number = findViewById(R.id.Number);
        EditText decimalnumber = findViewById(R.id.DecimalNumber);
        Switch btnswitch = findViewById(R.id.switch1);
        btnswitch.setChecked(false);

        sendmessage.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity3.class);

            boolean switchState = btnswitch.isChecked();

            intent.putExtra("text", textbox.getText().toString());
            intent.putExtra("number", number.getText().toString());
            double decimal = Double.parseDouble(decimalnumber.getText().toString());
            intent.putExtra("decimal_number", decimal);
            intent.putExtra("switch_value", switchState);


            startActivity(intent);

        });
    }
}