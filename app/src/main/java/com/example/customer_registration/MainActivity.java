package com.example.customer_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity  implements  AdapterView.OnItemSelectedListener {
    String[] country = {"Customer Type","Important"};
    String[] custclass = {"Customer Class","NRI"};
    String[] state = {"Gujarat","Goa"};
    String[] city = {"Vadoadara","Gaya"};
    EditText edtxcutnme, edtxAdd1, edtxAdd2, edtxpin, edtxcall, edtxemail, edtxattach;
    Spinner spinnercusttype, spinnercustclass, spinnerstate, spinnercity;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    void init(){
        spinnercusttype = findViewById(R.id.spinnercusttype);
        spinnercustclass = findViewById(R.id.spinnercustclass);
        spinnerstate = findViewById(R.id.spinnestate);
        spinnercity = findViewById(R.id.spinnercity);

        edtxcutnme = findViewById(R.id.etcutnam);
        edtxAdd1 =findViewById(R.id.etAdd1);
        edtxAdd2 =findViewById(R.id.etAdd2);
        edtxpin =findViewById(R.id.etpin);
        edtxcall =findViewById(R.id.etcontact);
        edtxemail =findViewById(R.id.etemail);
        edtxattach =findViewById(R.id.etAttach);

        Button submit = findViewById(R.id.btnSubmint);

        spinnerinit();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validate();
                Intent in = new Intent(MainActivity.this,Search_Customer.class);
                startActivity(in);
            }
        });
    }

    void spinnerinit () {

            spinnercusttype.setOnItemSelectedListener(this);
            spinnercustclass.setOnItemSelectedListener(this);
            spinnerstate.setOnItemSelectedListener(this);
            spinnercity.setOnItemSelectedListener(this);

            ArrayAdapter spinnercustt = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, country);
            ArrayAdapter spinnercustc = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, custclass);
            ArrayAdapter spinnerst = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, state);
            ArrayAdapter spinnerct = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, city);

            spinnercustt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnercustc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerst.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerct.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinnercusttype.setAdapter(spinnercustt);
            spinnercustclass.setAdapter(spinnercustc);
            spinnerstate.setAdapter(spinnerst);
            spinnercity.setAdapter(spinnerct);
        }



    private void validate() {
        final String editcutnme = edtxcutnme.getText().toString();
        final String editAdd1 = edtxAdd1.getText().toString();
        final String editAdd2 = edtxAdd2.getText().toString();
        final String editpin = edtxpin.getText().toString();
        final String editcall = edtxcall.getText().toString();
        final String editemail = edtxemail.getText().toString();
        final String editattach = edtxattach.getText().toString();

        if (editcutnme.isEmpty()) {
            edtxcutnme.requestFocus();
            edtxcutnme.setError("Field can't be empty");
        }else if (editcutnme.length() < 3) {
            edtxcutnme.requestFocus();
            edtxcutnme.setError("Username too short");
        } else if (editcutnme.length() > 15) {
            edtxcutnme.requestFocus();
            edtxcutnme.setError("Username too long");
        } else if (spinnercusttype.getSelectedItem().equals("Customer Type")) {
            //may be you want to ignorecase using equalsIgnoreCase() method
            //display message that you haven't selected anything
            Toast.makeText(this, "please select Customer Type", Toast.LENGTH_SHORT).show();
        }else if (spinnercustclass.getSelectedItem().equals("Customer Class")) {
            //may be you want to ignorecase using equalsIgnoreCase() method
            //display message that you haven't selected anything
            Toast.makeText(this, "please select Customer Class", Toast.LENGTH_SHORT).show();
        }else if (spinnerstate.getSelectedItem().equals("Gujarat")) {
            //may be you want to ignorecase using equalsIgnoreCase() method
            //display message that you haven't selected anything
            Toast.makeText(this, "please select State", Toast.LENGTH_SHORT).show();
        }else if (spinnerstate.getSelectedItem().equals("Vadoadara")) {
            //may be you want to ignorecase using equalsIgnoreCase() method
            //display message that you haven't selected anything
            Toast.makeText(this, "please select City", Toast.LENGTH_SHORT).show();
        }else if (editAdd1.isEmpty()) {
            edtxAdd1.requestFocus();
            edtxAdd1.setError("Field can't be empty");
        }else if (editAdd1.length() < 3) {
            edtxAdd1.requestFocus();
            edtxAdd1.setError("Address too short");
        } else if (editAdd1.length() > 50) {
            edtxAdd1.requestFocus();
            edtxAdd1.setError("Address too long");
        }else if (editAdd2.isEmpty()) {
            edtxAdd2.requestFocus();
            edtxAdd2.setError("Field can't be empty");
        }else if (editAdd2.length() < 3) {
            edtxAdd2.requestFocus();
            edtxAdd2.setError("Address too short");
        } else if (editAdd2.length() > 50) {
            edtxAdd2.requestFocus();
            edtxAdd2.setError("Address too long");
        }else if (editpin.isEmpty()) {
            edtxpin.requestFocus();
            edtxpin.setError("Field can't be empty");
        }else if (edtxpin.getText().length() < 6) {
            edtxpin.requestFocus();
            edtxpin.setError("Pin code should be of 6 didgits");
        }else if (editcall.isEmpty()) {
            edtxcall.requestFocus();
            edtxcall.setError("Field can't be empty");
        }else if (edtxcall.getText().length() < 10) {
            edtxcall.requestFocus();
            edtxcall.setError("Contact Number should be of 10 digits only");
        }if (editemail.isEmpty()) {
            edtxemail.requestFocus();
            edtxemail.setError("Field can't be empty");
        }if(!edtxemail.getText().toString().trim().matches(emailPattern)){
            edtxemail.requestFocus();
            edtxemail.setError("Pealse enter valid email");
        }
    }
}

