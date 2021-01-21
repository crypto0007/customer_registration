package com.example.customer_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ServiceInformation extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] listsrvtype = {"Service Type","Installation"};

    Spinner spinnersrvtp;

    Calendar cal;
    EditText editsrvdate, editsrvtime, editsrvrermnt;

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_information);

        init();
        calend();
        time();
        
    }

    void init() {
        spinnersrvtp = findViewById(R.id.spinnersrvtype);
        cal = Calendar.getInstance();
        editsrvdate = (EditText) findViewById(R.id.etsrvdate);
        editsrvtime = (EditText) findViewById(R.id.etsrvtime);
        editsrvrermnt = (EditText) findViewById(R.id.etsrvreqmnnt);
        submit = findViewById(R.id.btnSubmint);

        spinnerinit();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    void spinnerinit () {

        spinnersrvtp.setOnItemSelectedListener(this);

        ArrayAdapter spinnersrvtpe = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listsrvtype);

        spinnersrvtpe.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnersrvtp.setAdapter(spinnersrvtpe);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    void calend(){
        String date_n = new SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(new Date());
        editsrvdate.setText(date_n);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, month);
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        editsrvdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ServiceInformation.this, date, cal
                        .get(Calendar.YEAR), cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editsrvdate.setText(sdf.format(cal.getTime()));
    }

    void time(){
        String date_n = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        editsrvtime.setText(date_n);
        editsrvtime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ServiceInformation.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        editsrvtime.setText( hourOfDay + ":" + minute);
                    }
                }, hour, minute, false);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });
    }

    private void validate() {
        final String edtxsrvrequmnt = editsrvrermnt.getText().toString();

        if (spinnersrvtp.getSelectedItem().equals("Service Type")) {
            //may be you want to ignorecase using equalsIgnoreCase() method
            //display message that you haven't selected anything
            Toast.makeText(this, "please select Service Type", Toast.LENGTH_SHORT).show();
        }else if (edtxsrvrequmnt.length() > 50) {
            editsrvrermnt.requestFocus();
            editsrvrermnt.setError("Product Model too long, it should be 50 or less");
        }
    }
}