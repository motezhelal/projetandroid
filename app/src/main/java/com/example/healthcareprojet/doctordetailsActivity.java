package com.example.healthcareprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class doctordetailsActivity extends AppCompatActivity {
    TextView tv ;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctordetails);
        tv = findViewById(R.id.textViewDDTitle);
        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(doctordetailsActivity.this,finddoctorActivity.class));
            }
        });

    }
}