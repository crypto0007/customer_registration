package com.example.customer_registration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Search_Customer extends AppCompatActivity {
    private static RecyclerView.Adapter ad;
    private RecyclerView.LayoutManager lm;
    private static RecyclerView rv;
    private static ArrayList<DataMaodel> dm;
    static View.OnClickListener mcl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__customer);

        mcl = new MyOnClickListener(this);

        rv = (RecyclerView) findViewById(R.id.my_recycler_view);
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
        ad = new CustomAdapter(dm);
        rv.setAdapter(ad);
    }

    private static class MyOnClickListener implements View.OnClickListener {
        public MyOnClickListener(Search_Customer search_customer) {
        }

        @Override
        public void onClick(View v) {

        }
    }
}