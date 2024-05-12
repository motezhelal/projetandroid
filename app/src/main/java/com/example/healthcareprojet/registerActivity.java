package com.example.healthcareprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity {
    EditText edusername,edpassword,edconfirm,edemail;
    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edusername =findViewById(R.id.editTexregusername);
        edpassword =findViewById(R.id.editTexregpassword);
        edemail =findViewById(R.id.editTexregemail);
        edconfirm =findViewById(R.id.editTexregconfirmpassword);
        tv =findViewById(R.id.textViewexistinguser);
        btn=findViewById(R.id.buttonregister);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(registerActivity.this,loginActivity.class));
            }
        });
        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edusername.getText().toString();
                String email = edemail.getText().toString();
                String confirm = edconfirm.getText().toString();
                String password = edpassword.getText().toString();
                Database db=new Database(getApplicationContext(),"healthecareprojet",null,1);
                if (username.length() == 0 || password.length() == 0 || email.length() == 0 || confirm.length() == 0) {
                    Toast.makeText(getApplicationContext(), "please complete all details", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.compareTo(confirm) == 0) {
                        if (isValid(password)){
                            db.register(username,email,password);
                            Toast.makeText(getApplicationContext(), "record inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(registerActivity.this,loginActivity.class));
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "password must contain letter,digit annd symbol", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "password and confirm didin't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public static boolean isValid(String passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordhere.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int r = 0; r < passwordhere.length(); r++) {
                if (Character.isDigit(passwordhere.charAt(r))) {
                    f2 = 1;
                }
            }
            for (int s = 0; s < passwordhere.length(); s++) {
                char c = passwordhere.charAt(s);
                if (c >= 33 && c <= 46 || c == 64) {
                    f3 = 1;
                }
            }
            if (f1 == 1 && f2 == 1 && f3 == 1) {
                return true;

            }

        }
        return false;

    }
}