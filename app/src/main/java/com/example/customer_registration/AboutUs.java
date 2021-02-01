package com.example.customer_registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AboutUs extends AppCompatActivity {
    Button btnvtacj, btnvppj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        init();
    }

    private void init(){
        btnvtacj = findViewById(R.id.btnvtac);
        btnvppj = findViewById(R.id.btnvpp);

        btnvtacj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AboutUs.this,Termsandconditions.class));
            }
        });
        btnvppj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AboutUs.this,Privacypolicy.class));
            }
        });
    }
}