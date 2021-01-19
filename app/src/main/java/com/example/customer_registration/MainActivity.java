package com.example.customer_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity  implements  AdapterView.OnItemSelectedListener {
    String[] country = {"Customer Type"};
    String[] custclass = {"Customer Class"};
    String[] state = {"Gujarat"};
    String[] city = {"Vadoadara"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerinit();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    void spinnerinit () {
        Spinner spinnercusttype = findViewById(R.id.spinnercusttype);
        Spinner spinnercustclass = findViewById(R.id.spinnercustclass);
        Spinner spinnerstate = findViewById(R.id.spinnestate);
        Spinner spinnercity = findViewById(R.id.spinnercity);

        spinnercusttype.setOnItemSelectedListener(this);
        spinnercustclass.setOnItemSelectedListener(this);
        spinnerstate.setOnItemSelectedListener(this);
        spinnercity.setOnItemSelectedListener(this);

        ArrayAdapter spinnercustt = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,country);
        ArrayAdapter spinnercustc = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,custclass);
        ArrayAdapter spinnerst = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,state);
        ArrayAdapter spinnerct = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,city);

        spinnercustt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnercustc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerst.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerct.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnercusttype.setAdapter(spinnercustt);
        spinnercustclass.setAdapter(spinnercustc);
        spinnerstate.setAdapter(spinnerst);
        spinnercity.setAdapter(spinnerct);
    }
}
