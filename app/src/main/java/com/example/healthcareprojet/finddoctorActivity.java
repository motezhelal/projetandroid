package com.example.healthcareprojet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class finddoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finddoctor);
        CardView exit=findViewById(R.id.cardFDback);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(finddoctorActivity.this,homeActivity.class));
            }
        });
        CardView familyphysician=findViewById(R.id.cardFDFamilyPhysician);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(finddoctorActivity.this, doctordetailsActivity.class);
                it.putExtra("title","Family Physicians");
                startActivity(it);
            }


        });
        CardView dieticiann=findViewById(R.id.cardFDDietician);
        dieticiann.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(finddoctorActivity.this, doctordetailsActivity.class);
                it.putExtra("title","Dieticians");
                startActivity(it);
            }


        });
        CardView dentist=findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(finddoctorActivity.this, doctordetailsActivity.class);
                it.putExtra("title","Dentists");
                startActivity(it);
            }


        });
    }
}