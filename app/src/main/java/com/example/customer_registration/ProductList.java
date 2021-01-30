package com.example.customer_registration;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ProductList extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinnerprtlistcatj;
    ImageView backarrowprtlistj, btprtlitfilj;
    CardView prtlitfilterlayoutj;
    EditText etprtsearchj;
    FloatingActionButton fabprtlitj;
    String[] listprtcat = {"Product Category", "water purifier"};
    private static CustomAdapterProductList prtlitad;
    private RecyclerView.LayoutManager prtlitlm;
    private static RecyclerView prtlitrv;
    private static ArrayList<DataModelProductList> dmpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        init();
        spinnerinit();
        showhidesrvfil();
        searchoption();
        arrayAdpater();
    }

    private void init() {
        spinnerprtlistcatj =  findViewById(R.id.spinnerprtlistcat);
        backarrowprtlistj = findViewById(R.id.backarrowprtlist);
        btprtlitfilj = findViewById(R.id.btprtlitfil);
        prtlitfilterlayoutj = findViewById(R.id.prtlitfilterlayout);
        etprtsearchj = findViewById(R.id.etprtsearch);
        prtlitrv = findViewById(R.id.prt_my_recycler_view);
        fabprtlitj = findViewById(R.id.fabprtlit);

        backarrowprtlistj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fabprtlitj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(ProductList.this,AddProduct.class);
                startActivity(in);
            }
        });
    }

    private void spinnerinit() {

        spinnerprtlistcatj.setOnItemSelectedListener(this);

        ArrayAdapter spinnerprtlistca = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listprtcat);

        spinnerprtlistca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerprtlistcatj.setAdapter(spinnerprtlistca);
    }

    private void showhidesrvfil() {
        btprtlitfilj.setOnClickListener(new View.OnClickListener() {

            boolean visble;

            @Override
            public void onClick(View v) {
                visble = !visble;
                prtlitfilterlayoutj.setVisibility(visble ? View.VISIBLE : View.GONE);
            }
        });
    }

    private void searchoption() {
        etprtsearchj.addTextChangedListener(new TextWatcher() {
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
        ArrayList<DataModelProductList> filteredList = new ArrayList<>();
        for (DataModelProductList item : dmpl) {
            if (item.getprtlitname().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        prtlitad.updateList(filteredList);
    }

    void arrayAdpater() {
        prtlitrv.setHasFixedSize(true);

        prtlitlm = new LinearLayoutManager(this);
        prtlitrv.setLayoutManager(prtlitlm);
        prtlitrv.setItemAnimator(new DefaultItemAnimator());

        dmpl = new ArrayList<DataModelProductList>();
        for (int i = 0; i < MyDataProductList.prtlitnameArray.length; i++) {
            dmpl.add(new DataModelProductList(
                    MyDataProductList.prtlitnameArray[i],
                    MyDataProductList.prtlitdateArray[i],
                    MyDataProductList.prtlitmodelArray[i],
                    MyDataProductList.prtlitInvonoArray[i],
                    MyDataProductList.prtlitsrnnoeArray[i],
                    MyDataProductList.id_[i]
            ));
        }
        prtlitad = new CustomAdapterProductList(dmpl);
        prtlitrv.setAdapter(prtlitad);
        prtlitrv.addItemDecoration(new DividerItemDecoration(ProductList.this,DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}