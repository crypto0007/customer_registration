package com.example.customer_registration;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ServiceHistory extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static CustomAdapterServiceHistory srvrhisad;
    private RecyclerView.LayoutManager srvrhislm;
    private static RecyclerView srvrhisrv;
    private static ArrayList<Datamodelsrvhistory> dssh;
    ImageView btsrvhisfilj;
    CardView srvhislayoutj;
    String[] listsrvtype = {"Service Type", "installation"};
    String[] listsrvsat = {"Service Status", "Delay"};
    Button btnsrvfilappj;

    Spinner spinnersrvhissrvtypej, spinnersrvhissrvtatj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_history);
        arrayAdpater();
        init();
        spinnerinit();


    }

    private void init(){
        btsrvhisfilj = findViewById(R.id.btsrvhisfil);
        srvhislayoutj = findViewById(R.id.srvhislayout);
        spinnersrvhissrvtypej = findViewById(R.id.spinnersrvhissrvtype);
        spinnersrvhissrvtatj = findViewById(R.id.spinnersrvhissrvtat);
        btnsrvfilappj = findViewById(R.id.btnsrvfilapp);

        btsrvhisfilj.setOnClickListener(new View.OnClickListener() {
            boolean visble;

            @Override
            public void onClick(View v) {
                visble = !visble;
                srvhislayoutj.setVisibility(visble ? View.VISIBLE : View.GONE);
            }
        });

        btnsrvfilappj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validate();
            }
        });
    }

    void arrayAdpater() {
        srvrhisrv = (RecyclerView) findViewById(R.id.srv_his_my_recycler_view);
        srvrhisrv.setHasFixedSize(true);

        srvrhislm = new LinearLayoutManager(this);
        srvrhisrv.setLayoutManager(srvrhislm);
        srvrhisrv.setItemAnimator(new DefaultItemAnimator());

        dssh = new ArrayList<Datamodelsrvhistory>();
        for (int i = 0; i < MyDataSrvhistory.srvrhisnameArray.length; i++) {
            dssh.add(new Datamodelsrvhistory(
                    MyDataSrvhistory.srvrhisnameArray[i],
                    MyDataSrvhistory.srvrhisdateArray[i],
                    MyDataSrvhistory.srvhisprtnameArray[i],
                    MyDataSrvhistory.srvrhistypeArray[i],
                    MyDataSrvhistory.srvhisreqrmentArray[i],
                    MyDataSrvhistory.srvhisdateandtimeArray[i],
                    MyDataSrvhistory.srvrhistechArray[i],
                    MyDataSrvhistory.srvrhissrvchrgArray[i],
                    MyDataSrvhistory.srvrhissrremrkArray[i],
                    MyDataSrvhistory.id_[i]
            ));
        }
        srvrhisad = new CustomAdapterServiceHistory(dssh);
        srvrhisrv.setAdapter(srvrhisad);
        srvrhisrv.addItemDecoration(new DividerItemDecoration(ServiceHistory.this,DividerItemDecoration.VERTICAL));
    }

    void spinnerinit() {
        spinnersrvhissrvtypej.setOnItemSelectedListener(this);
        spinnersrvhissrvtatj.setOnItemSelectedListener(this);

        ArrayAdapter spinnersrvtpe = new ArrayAdapter(this, R.layout.spinner_item2, listsrvtype);
        ArrayAdapter spinnersrvt = new ArrayAdapter(this, R.layout.spinner_item2, listsrvsat);

        spinnersrvtpe.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnersrvt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnersrvhissrvtypej.setAdapter(spinnersrvtpe);
        spinnersrvhissrvtatj.setAdapter(spinnersrvt);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void validate() {
        //final String edtxcal = editcal.getText().toString();


        if (spinnersrvhissrvtypej.getSelectedItem().equals("Service Type")) {
            //may be you want to ignorecase using equalsIgnoreCase() method
            //display message that you haven't selected anything
            Toast.makeText(this, "please select Service Type", Toast.LENGTH_SHORT).show();
        } else if (spinnersrvhissrvtatj.getSelectedItem().equals("Service Status")) {
            //may be you want to ignorecase using equalsIgnoreCase() method
            //display message that you haven't selected anything
            Toast.makeText(this, "please select Service Status", Toast.LENGTH_SHORT).show();
        }
    }
}