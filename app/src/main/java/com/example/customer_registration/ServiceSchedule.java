package com.example.customer_registration;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ServiceSchedule extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    ImageView backarrowsrvsdj;
    EditText etsrvsddatej, etsrvresdtimej, etsrvsddesj;
    Calendar cal;
    Spinner spinnersrvsdpriorityj, spinnersrvsdtypej;
    String[] listsrvsdprority = {"Service Priority","Normal"};
    String[] listsrvsdtype = {"Service Type","Installation"};
    Button btnsrvsdacceptj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srvschedule);

        init();
        seldate();
        time();
        spinnerinit();
    }

    private void init() {
        backarrowsrvsdj = findViewById(R.id.backarrowsrvsd);
        etsrvsddatej = findViewById(R.id.etsrvsddate);
        etsrvresdtimej = findViewById(R.id.etsrvsdtime);
        etsrvsddesj = findViewById(R.id.etsrvsddes);
        cal = Calendar.getInstance();
        spinnersrvsdpriorityj = findViewById(R.id.spinnersrvsdpriority);
        spinnersrvsdtypej = findViewById(R.id.spinnersrvsdtype);
        btnsrvsdacceptj = findViewById(R.id.btnsrvsdaccept);

        backarrowsrvsdj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnsrvsdacceptj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    private void seldate() {
        String date_n = new SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(new Date());
        etsrvsddatej.setText(date_n);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, month);
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        etsrvsddatej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ServiceSchedule.this, date, cal
                        .get(Calendar.YEAR), cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etsrvsddatej.setText(sdf.format(cal.getTime()));
    }

    void time() {
        String date_n = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        etsrvresdtimej.setText(date_n);
        etsrvresdtimej.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ServiceSchedule.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        etsrvresdtimej.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, false);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });
    }

    void spinnerinit () {

        spinnersrvsdpriorityj.setOnItemSelectedListener(this);
        spinnersrvsdtypej.setOnItemSelectedListener(this);

        ArrayAdapter spinnersrvsdpriorit = new ArrayAdapter(this, R.layout.spinner_item, listsrvsdprority);
        ArrayAdapter spinnersrvsdtyp = new ArrayAdapter(this, R.layout.spinner_item, listsrvsdtype);

        spinnersrvsdpriorit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnersrvsdtyp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnersrvsdpriorityj.setAdapter(spinnersrvsdpriorit);
        spinnersrvsdtypej.setAdapter(spinnersrvsdtyp);
    }

    private void validate() {
        final String edtxsrvrequmnt = etsrvsddesj.getText().toString();

        if(edtxsrvrequmnt.isEmpty()){
            etsrvsddesj.requestFocus();
            etsrvsddesj.setError("Description cannot be Empty");
    }else if (edtxsrvrequmnt.length() > 100) {
            etsrvsddesj.requestFocus();
            etsrvsddesj.setError("Product Model too long, it should be 100 or less");
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}