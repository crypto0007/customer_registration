package com.example.customer_registration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ServiceAllocatePopup extends AppCompatActivity{

    final AlertDialog dialogBuilder = new AlertDialog.Builder(this).create();
    LayoutInflater inflater = this.getLayoutInflater();
    View dialogView = inflater.inflate(R.layout.activity_srv_allocate, null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srv_allocate);

    }

}