package com.example.customer_registration;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class QuerySupport extends AppCompatActivity implements  AdapterView.OnItemSelectedListener{

    ImageView backarrowqrysuppj;
    Spinner spinnermodulej;
    String[] listmodule ={"Module","yolo"};
    EditText etqrysuppemailj, etqrysuppdesj;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    Button btnSubmintj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_support);
        init();
        spinnerinit();
    }

    private void init(){
        backarrowqrysuppj = findViewById(R.id.backarrowqrysupp);
        spinnermodulej = findViewById(R.id.spinnermodule);
        etqrysuppemailj = findViewById(R.id.etqrysuppemail);
        etqrysuppdesj = findViewById(R.id.etqrysuppdes);
        btnSubmintj = findViewById(R.id.btnSubmint);

        backarrowqrysuppj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSubmintj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    void spinnerinit () {

        spinnermodulej.setOnItemSelectedListener(this);

        ArrayAdapter spinnerprtcatt = new ArrayAdapter(this,R.layout.spinner_item, listmodule);

        spinnerprtcatt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnermodulej.setAdapter(spinnerprtcatt);
    }

   private void validate() {
       final String editdes = etqrysuppdesj.getText().toString();

       if(!etqrysuppemailj.getText().toString().trim().matches(emailPattern)){
           etqrysuppemailj.requestFocus();
           etqrysuppemailj.setError("Pealse enter valid email");
       }else if(editdes.isEmpty()){
           etqrysuppdesj.requestFocus();
           etqrysuppdesj.setError("Description cannot be Empty");
       }else if (editdes.length() > 100) {
           etqrysuppdesj.requestFocus();
           etqrysuppdesj.setError("Description too long, it should be 100 or less");
       }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}