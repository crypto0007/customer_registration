package com.example.customer_registration;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ServiceRequest extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //private static RecyclerView.Adapter srvrqustad;
    private static CustomAdapterSrvRequst srvrqustad;
    private RecyclerView.LayoutManager srvrqustlm;
    private static RecyclerView srvrqustrv;
    private static ArrayList<DatamodelSrvRequst> dmsr;
    EditText etsrvsearchj;
    ImageView filtershj,backarrowpsrvrqustj;
    CardView srvfilterlayoutj;
    Calendar srvcal, c, fc;
    EditText editsrtcal, editendcal;
    String[] listsrvtype = {"Service Type", "installation"};
    String[] listsrvsat = {"Service Status", "Delay"};

    Spinner spinnersrvtypej, spinnersrvtatj;

    Button btnsrvfilappj;


      //srvrqustrv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

//    MaterialDatePicker.Builder materialDateBuilder = MaterialDatePicker.Builder.dateRangePicker();
//    final MaterialDatePicker materialDatePicker = materialDateBuilder.build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_request);



        init();
        arrayAdpater();
        searchoption();
        showhidesrvfil();
        srtcalend();
        endcalend();
        spinnerinit();
        getPreviousDate();
        cuurentdate();
    }

    void init() {
        srvrqustrv = (RecyclerView) findViewById(R.id.srv_my_recycler_view);
        etsrvsearchj = (EditText) findViewById(R.id.etsrvsearch);
        filtershj = (ImageView) findViewById(R.id.btnsrvfil);
        srvfilterlayoutj = (CardView) findViewById(R.id.srvfilterlayout);
        srvcal = Calendar.getInstance();
        editsrtcal = (EditText) findViewById(R.id.editstartdate);
        editendcal = (EditText) findViewById(R.id.editenddate);
        spinnersrvtypej = findViewById(R.id.spinnersrvtype);
        spinnersrvtatj = findViewById(R.id.spinnersrvtat);
        backarrowpsrvrqustj = findViewById(R.id.backarrowpsrvrqust);

        btnsrvfilappj = (Button) findViewById(R.id.btnsrvfilapp);

        backarrowpsrvrqustj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnsrvfilappj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validate();
            }
        });
    }

    void spinnerinit() {

        spinnersrvtypej.setOnItemSelectedListener(this);
        spinnersrvtatj.setOnItemSelectedListener(this);

        ArrayAdapter spinnersrvtpe = new ArrayAdapter(this, R.layout.spinner_item2, listsrvtype);
        ArrayAdapter spinnersrvt = new ArrayAdapter(this, R.layout.spinner_item2, listsrvsat);

        spinnersrvtpe.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnersrvt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnersrvtypej.setAdapter(spinnersrvtpe);
        spinnersrvtatj.setAdapter(spinnersrvt);
    }

    void arrayAdpater() {
        srvrqustrv.setHasFixedSize(true);

        srvrqustlm = new LinearLayoutManager(this);
        srvrqustrv.setLayoutManager(srvrqustlm);
        srvrqustrv.setItemAnimator(new DefaultItemAnimator());

        dmsr = new ArrayList<DatamodelSrvRequst>();
        for (int i = 0; i < MyDataSrvRqust.srvrqustnameArray.length; i++) {
            dmsr.add(new DatamodelSrvRequst(
                    MyDataSrvRqust.srvrqustnameArray[i],
                    MyDataSrvRqust.srvrqustdateArray[i],
                    MyDataSrvRqust.srvqustcontactArray[i],
                    MyDataSrvRqust.srvqustAddArray[i],
                    MyDataSrvRqust.srvqustInvonoArray[i],
                    MyDataSrvRqust.srvrqustsrnnoeArray[i],
                    MyDataSrvRqust.srvrqusttypeArray[i],
                    MyDataSrvRqust.srvstatArray[i],
                    MyDataSrvRqust.id_[i]
            ));
        }
        srvrqustad = new CustomAdapterSrvRequst(dmsr);
        srvrqustrv.setAdapter(srvrqustad);
        srvrqustrv.addItemDecoration(new DividerItemDecoration(ServiceRequest.this,DividerItemDecoration.VERTICAL));
    }

    void showhidesrvfil() {
        filtershj.setOnClickListener(new View.OnClickListener() {

            boolean visble;

            @Override
            public void onClick(View v) {
                visble = !visble;
                srvfilterlayoutj.setVisibility(visble ? View.VISIBLE : View.GONE);
            }
        });
    }

    void searchoption() {
        etsrvsearchj.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                
            }

            @Override
            public void afterTextChanged(Editable s) {

                // filter your list from your input
                filter(s.toString());
                //you can use runnable postDelayed like 500 ms to delay search text
            }
        });
    }

    void filter(String text) {
        ArrayList<DatamodelSrvRequst> filteredList = new ArrayList<>();
        for (DatamodelSrvRequst item : dmsr) {
            if (item.getsrvrqustcust().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        srvrqustad.updateList(filteredList);
    }

    void srtcalend() {

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                srvcal.set(Calendar.YEAR, year);
                srvcal.set(Calendar.MONTH, month);
                srvcal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        editsrtcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ServiceRequest.this, date, srvcal
                        .get(Calendar.YEAR), srvcal.get(Calendar.MONTH),
                        srvcal.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editendcal.setText(sdf.format(srvcal.getTime()));
    }

    void getPreviousDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -7);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
        String formattedPreviousDate = df.format(c.getTime());
        editsrtcal.setText(formattedPreviousDate);
    }

    private void updateDisplay(TextView dateDisplay, Calendar date) {
        editsrtcal.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(date.get(Calendar.DAY_OF_MONTH)).append("-")
                        .append(date.get(Calendar.MONTH) + 1).append("-")
                        .append(date.get(Calendar.YEAR)).append(" "));

        Log.d("msg", "date:" + (date.get(Calendar.DAY_OF_MONTH)) + (date.get(Calendar.MONTH) + 1) + (date.get(Calendar.YEAR)));

        fc = date;
    }


    private void cuurentdate(){
        String date_n = new SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(new Date());
        editendcal.setText(date_n);
    }
    void endcalend() {

        //long starttime = c.getTimeInMillis();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                srvcal.set(Calendar.YEAR, year);
                srvcal.set(Calendar.MONTH, month);
                srvcal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                Date fromDate, toDate;
                try {


                    //checks if the date chosen by the user is greater than the current system date.Doesnt allow to choose future date
                    if (c.after(srvcal) || c.equals(srvcal)) {

                        //checks if the from date edit text is empty or not
                        if (editsrtcal.getText().toString().isEmpty()) {

                            updateDisplay(editsrtcal, c);

                        //}
                    //else {
//converts the date in the from date edittextbox and active date to dd-mm-yyyy format
                            SimpleDateFormat sdf = new SimpleDateFormat("dd//MM//yy");

                            fromDate = sdf.parse(editsrtcal.getText().toString());
                            Log.d("fromdate", "" + fromDate);

                            String temp = (c.get(Calendar.DAY_OF_MONTH)) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + (c.get(Calendar.YEAR));
                            toDate = sdf.parse(temp);
                            Log.d("todate", "" + toDate);


//                            //checks if todate is greater or equal to from date
                            if ((toDate.after(fromDate)) || (toDate.equals(fromDate))) {
                                updateDisplay(editsrtcal, c);

                            } else {
                                Toast toast = new Toast(getBaseContext());
                                toast = Toast.makeText(ServiceRequest.this, "To date should be greater than From date", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER, 0, 0);
                                toast.show();
                            }
                        }
                    } else {
                        Toast toast = new Toast(getBaseContext());
                        toast = Toast.makeText(ServiceRequest.this, "Please enter a valid date", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                } catch (Exception e) {
                    Log.e("excepion", e.getMessage().toString());
                }
                //unregisterDateDisplay();
            }

            // endupdateLabel();
        };

        editendcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //materialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
                DatePickerDialog datePickerDialog = new DatePickerDialog(ServiceRequest.this, date,
                        srvcal.get(Calendar.YEAR),
                        srvcal.get(Calendar.MONTH),
                        srvcal.get(Calendar.DAY_OF_MONTH));
                //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                //datePickerDialog.getDatePicker().setMinDate(starttime);
//                String myFormat = "dd/MM/yy";
///                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
//            //Date date = sdf.parse(String.valueOf(Calendar.DAY_OF_MONTH));
//            //srvcal.add(Calendar.MONTH, -6);
//
            datePickerDialog.show();
//        }
//    });

//        materialDatePicker.addOnPositiveButtonClickListener(
//                new MaterialPickerOnPositiveButtonClickListener() {
//                    @SuppressLint("SetTextI18n")
//                    @Override
//                    public void onPositiveButtonClick(Object selection) {
//
//                        // if the user clicks on the positive
//                        // button that is ok button update the
//                        // selected date
//                        editsrtcal.setText(materialDatePicker.getHeaderText());
//                        // in the above statement, getHeaderText
//                        // is the selected date preview from the
//                        // dialog
//                    }
//                });
//            }
//        }
            }
        });
    }

    private void unregisterDateDisplay() {
        Log.d("startdate ", "" + (c.get(Calendar.DAY_OF_MONTH)) + (c.get(Calendar.MONTH) + 1) + (c.get(Calendar.YEAR)));
        Log.d("from date:", "-" + srvcal.DAY_OF_MONTH + srvcal.MONTH + srvcal.YEAR);
        editendcal = null;
        srvcal = null;
    }

//    private void endupdateLabel() {
//        String myFormat = "dd/MM/yy"; //In which you need put here
//        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
//        editendcal.setText(sdf.format(srvcal.getTime()));
//    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void validate() {
        //final String edtxcal = editcal.getText().toString();

        if (spinnersrvtypej.getSelectedItem().equals("Service Type")) {
            //may be you want to ignorecase using equalsIgnoreCase() method
            //display message that you haven't selected anything
            Toast.makeText(this, "please select Service Type", Toast.LENGTH_SHORT).show();
        } else if (spinnersrvtatj.getSelectedItem().equals("Service Status")) {
            //may be you want to ignorecase using equalsIgnoreCase() method
            //display message that you haven't selected anything
            Toast.makeText(this, "please select Service Status", Toast.LENGTH_SHORT).show();
        }
    }

}