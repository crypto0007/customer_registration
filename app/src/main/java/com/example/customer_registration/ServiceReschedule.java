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

public class ServiceReschedule extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageView backarrowsrvresdj;
    EditText etsrvresddatej, etsrvreresdtimej, etsrvresddesj;
    Calendar cal;
    Spinner spinnersrvresdpriorityj, spinnersrvresdtypej;
    String[] listsrvresdprority = {"Service Priority", "Normal"};
    String[] listsrvresdtype = {"Service Type", "Installation"};
    Button btnsrvresdacceptj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srv_reschedule);

        init();
        seldate();
        time();
        spinnerinit();
    }

    private void init() {
        backarrowsrvresdj = findViewById(R.id.backarrowsrvresd);
        etsrvresddatej = findViewById(R.id.etsrvresddate);
        etsrvreresdtimej = findViewById(R.id.etsrvresdtime);
        etsrvresddesj = findViewById(R.id.etsrvresddes);
        cal = Calendar.getInstance();
        spinnersrvresdpriorityj = findViewById(R.id.spinnersrvresdpriority);
        spinnersrvresdtypej = findViewById(R.id.spinnersrvresdtype);
        btnsrvresdacceptj = findViewById(R.id.btnsrvresdaccept);

        backarrowsrvresdj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnsrvresdacceptj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    private void seldate() {
        String date_n = new SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(new Date());
        etsrvresddatej.setText(date_n);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, month);
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        etsrvresddatej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ServiceReschedule.this, date, cal
                        .get(Calendar.YEAR), cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etsrvresddatej.setText(sdf.format(cal.getTime()));
    }

    void time() {
        String date_n = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        etsrvreresdtimej.setText(date_n);
        etsrvreresdtimej.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ServiceReschedule.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        etsrvreresdtimej.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, false);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });
    }

    void spinnerinit() {

        spinnersrvresdpriorityj.setOnItemSelectedListener(this);
        spinnersrvresdtypej.setOnItemSelectedListener(this);

        ArrayAdapter spinnersrvresdpriorit = new ArrayAdapter(this, R.layout.spinner_item, listsrvresdprority);
        ArrayAdapter spinnersrvresdtyp = new ArrayAdapter(this, R.layout.spinner_item, listsrvresdtype);

        spinnersrvresdpriorit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnersrvresdtyp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnersrvresdpriorityj.setAdapter(spinnersrvresdpriorit);
        spinnersrvresdtypej.setAdapter(spinnersrvresdtyp);
    }

    private void validate() {
        final String edtxsrvrequmnt = etsrvresddesj.getText().toString();

        if (edtxsrvrequmnt.isEmpty()) {
            etsrvresddesj.requestFocus();
            etsrvresddesj.setError("Description cannot be Empty");
        } else if (edtxsrvrequmnt.length() > 100) {
            etsrvresddesj.requestFocus();
            etsrvresddesj.setError("Product Model too long, it should be 100 or less");
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}