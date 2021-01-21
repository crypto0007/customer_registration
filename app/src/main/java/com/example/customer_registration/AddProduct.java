package com.example.customer_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AddProduct extends AppCompatActivity implements  AdapterView.OnItemSelectedListener{
    String[] listprtcat = {"Product Category","Sat"};
    String[] listprtnam = {"Product Name","ISFA"};

    Spinner spinnerprtcat, spinnerprtnam;

    Calendar cal;
    EditText editcal, editprtmodel, editprtno;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        init();
        calend();
    }

    void init(){
        spinnerprtcat = findViewById(R.id.spinnerprtcat);
        spinnerprtnam = findViewById(R.id.spinnerprtnam);
        cal = Calendar.getInstance();
        editcal = (EditText) findViewById(R.id.etprtdate);
        editprtmodel = (EditText) findViewById(R.id.etprtmodel);
        editprtno = (EditText) findViewById(R.id.etprtno);
        submit = findViewById(R.id.btnSubmint);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

        spinnerinit();
    }

    void spinnerinit () {

        spinnerprtcat.setOnItemSelectedListener(this);
        spinnerprtnam.setOnItemSelectedListener(this);

        ArrayAdapter spinnerprtcatt = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listprtcat);
        ArrayAdapter spinnerprtnamm = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listprtnam);

        spinnerprtcatt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerprtnamm.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerprtcat.setAdapter(spinnerprtcatt);
        spinnerprtnam.setAdapter(spinnerprtnamm);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    void calend(){
        String date_n = new SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(new Date());
        editcal.setText(date_n);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, month);
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        editcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(AddProduct.this, date, cal
                        .get(Calendar.YEAR), cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editcal.setText(sdf.format(cal.getTime()));
    }

    private void validate() {
        //final String edtxcal = editcal.getText().toString();
        final String edtxprtmodel = editprtmodel.getText().toString();
        final String edtxprtno = editprtno.getText().toString();

         if (spinnerprtcat.getSelectedItem().equals("Product Category")) {
            //may be you want to ignorecase using equalsIgnoreCase() method
            //display message that you haven't selected anything
            Toast.makeText(this, "please select Product Category", Toast.LENGTH_SHORT).show();
        }else if (spinnerprtnam.getSelectedItem().equals("Product Name")) {
            //may be you want to ignorecase using equalsIgnoreCase() method
            //display message that you haven't selected anything
            Toast.makeText(this, "please select Product Name", Toast.LENGTH_SHORT).show();
        }else if (edtxprtmodel.isEmpty()) {
             editprtmodel.requestFocus();
             editprtmodel.setError("Field can't be empty");
        }else if (edtxprtmodel.length() > 30) {
             editprtmodel.requestFocus();
             editprtmodel.setError("Product Model too long, it should be 30 or less");
        }else if (edtxprtno.isEmpty()) {
             editprtno.requestFocus();
             editprtno.setError("Field can't be empty");
         }else if (edtxprtno.length() > 30) {
             editprtno.requestFocus();
             editprtno.setError("Product Number too long, it should be 30 or less");
         }
    }
}