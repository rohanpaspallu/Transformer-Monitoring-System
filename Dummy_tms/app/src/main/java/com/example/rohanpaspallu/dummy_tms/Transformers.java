package com.example.rohanpaspallu.dummy_tms;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ROHAN PASPALLU on 2017-11-24.
 */

public class Transformers extends Activity{
    RequestQueue requestQueue;
    WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transformers);
       webView = (WebView) findViewById(R.id.webview);


abc();


    }
    public void abc(){
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        final ProgressDialog progressDialog = new ProgressDialog(Transformers.this);
        progressDialog.setMessage("Patience is appreciated...");
        progressDialog.show();

        final StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.43.174/", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               // Toast.makeText(getApplicationContext(), ""+response, Toast.LENGTH_LONG).show();
                webView.loadData(response, "text/html", "UTF-8");

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        abc();
                    }
                },3000);

                progressDialog.cancel();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "No internet Connection", Toast.LENGTH_LONG).show();
                progressDialog.cancel();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> map = new HashMap<String, String>();


//                            map.put("idproof", spinnerIdentityNo.getSelectedItem().toString());
//                            map.put("identityno", editTextIdentityNo.getText().toString());
                return map;
            }


        };
        requestQueue.add(stringRequest);




    }
}
