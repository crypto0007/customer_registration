package com.example.customer_registration;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ServiceCompletion extends AppCompatActivity {

    EditText etsrvcompdatej, etsrvcomptimej, etsrvcompchargej, etsrvcompdesj;
    Calendar cal;
    ImageView ivattachcompj,backarrowcompj;
    TextView prtlitfilenamej;
    final String TAG = "pathSC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_comlpetion);

        init();
        seldate();
        time();
    }

    private void init() {
        ivattachcompj = findViewById(R.id.ivattachcomp);
        etsrvcompdatej = findViewById(R.id.etsrvcompdate);
        etsrvcomptimej = findViewById(R.id.etsrvcomptime);
        etsrvcompchargej = findViewById(R.id.etsrvcompcharge);
        etsrvcompdesj = findViewById(R.id.etsrvcompdes);
        cal = Calendar.getInstance();
        prtlitfilenamej = findViewById(R.id.prtlitfilename);
        backarrowcompj = findViewById(R.id.backarrowcomp);

        Intent intent = getIntent();
        String extra = intent.getStringExtra("filepath");
        Log.d(TAG, String.valueOf(extra));
        prtlitfilenamej.setText(extra);

        ivattachcompj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(ServiceCompletion.this,Signature.class);
                startActivity(in);
            }
        });

        backarrowcompj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void seldate() {
        String date_n = new SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(new Date());
        etsrvcompdatej.setText(date_n);
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, month);
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etsrvcompdatej.setText(sdf.format(cal.getTime()));
    }

    void time() {
        String date_n = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        etsrvcomptimej.setText(date_n);
        etsrvcomptimej.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(ServiceCompletion.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        etsrvcomptimej.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, false);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });
    }

    private void validate() {
        final String etsrvcompcharg = etsrvcompchargej.getText().toString();
        final String etsrvcompde = etsrvcompdesj.getText().toString();

        if(etsrvcompcharg.isEmpty()){
            etsrvcompchargej.requestFocus();
            etsrvcompchargej.setError("charges cannot be Empty");
        }else if(etsrvcompde.isEmpty()){
            etsrvcompdesj.requestFocus();
            etsrvcompdesj.setError("Description cannot be Empty");
        }else if (etsrvcompde.length() > 100) {
            etsrvcompdesj.requestFocus();
            etsrvcompdesj.setError("Description too long, it should be 100 or less");
        }
    }

}