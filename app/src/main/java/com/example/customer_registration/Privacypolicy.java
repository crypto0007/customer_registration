package com.example.customer_registration;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Privacypolicy extends AppCompatActivity {
    ImageView backarrowwebviewppj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacypolicy);

        backarrowwebviewppj = findViewById(R.id.backarrowwebviewpp);

        backarrowwebviewppj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        isConnect();
    }

    private void showDialogbox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Please connect to internet...");
        builder.setCancelable(false);
        builder.setPositiveButton("WIFI", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                   }
               });
        builder.setPositiveButton("Mobile Data", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS));
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.cancel();
                   }
               });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void isConnect() {

        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            // connected to the internet
            if ((((NetworkInfo) activeNetwork).getType() == ConnectivityManager.TYPE_WIFI) || (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)) {
                //Toast.makeText(this, "IDK", Toast.LENGTH_SHORT).show();
                webview();
            }
//            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
//                //Toast.makeText(this, "WIFI", Toast.LENGTH_SHORT).show();
//            }
//            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE){
//                //Toast.makeText(this, "Mobile Date", Toast.LENGTH_SHORT).show();
//            }
            // not connected to the internet
        }else {
            showDialogbox();
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void webview(){
        WebView webView = (WebView) findViewById(R.id.webview);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl("https://policies.google.com/privacy?hl=en-IN&fg=1");
    }
}