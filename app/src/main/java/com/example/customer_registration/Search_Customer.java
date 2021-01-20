package com.example.customer_registration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Search_Customer extends AppCompatActivity {
    private static RecyclerView.Adapter ad;
    private RecyclerView.LayoutManager lm;
    private static RecyclerView rv;
    private static ArrayList<DataMaodel> dm;
    static View.OnClickListener mcl;
    FloatingActionButton fb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__customer);

        rv = (RecyclerView) findViewById(R.id.my_recycler_view);
        fb = findViewById(R.id.fab);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Search_Customer.this,MainActivity.class);
                startActivity(in);
            }
        });


        rv.setHasFixedSize(true);

        lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setItemAnimator(new DefaultItemAnimator());

        dm = new ArrayList<DataMaodel>();
        for (int i = 0; i < MyData.custnameArray.length; i++) {
            dm.add(new DataMaodel(
                    MyData.custnameArray[i],
                    MyData.custtypeArray[i],
                    MyData.cityArray[i],
                    MyData.custnoArray[i],
                    MyData.id_[i]
            ));
        }
        ad = new CustomAdapter(dm,this);
        rv.setAdapter(ad);
    }

}