package com.example.rohanpaspallu.dummy_tms;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by swapnil on 7/5/2017.
 */

public class History extends Activity {

    private static final String REGISTER_URL = "http://www.homadehigen.com/webservice/mypacakgeorder.php";
    // private static final String RATING ="http://qrworld.kstechnologies.co/webservice.asmx/Filters";
    ProgressDialog pdialog;
    RequestQueue requestQueue;
    List<Actors> GetDataAdapter1;


    RecyclerView recyclerView;

    RecyclerView.LayoutManager recyclerViewlayoutManager;

    RecyclerView.Adapter recyclerViewadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
//        ImageView cart = (ImageView)findViewById(R.id.cart);
////        cart.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Intent i = new Intent(getApplicationContext(),Cart_activity.class);
////                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////                startActivity(i);
////            }
////        });
//        SharedPreferences preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//        final String firstname = preferences.getString("first_name", "");
//        final String mobile = preferences.getString("number", "");
//        final String regid = preferences.getString("reg_id", "");
//        ImageView back = (ImageView)findViewById(R.id.back);
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview1);



        GetDataAdapter1 = new ArrayList<>();

        pdialog= new ProgressDialog(History.this);
        pdialog.setMessage("Loading...");
        pdialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.43.88/admin_panel/webservice/display_history.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //   Toast.makeText(CityHotelList.this, "Welcome to QRWORLD"+response, Toast.LENGTH_LONG).show();
                        try{

                            JSONObject obj = new JSONObject(response);
                            final JSONArray user1 = obj.getJSONArray("data");
                            for (int j = 0; j < user1.length(); j++) {


                                Actors GetDataAdapter2 = new Actors();
                                JSONObject c = user1.getJSONObject(j);
                                GetDataAdapter2.setId(c.getString("c_id"));
                                GetDataAdapter2.setName(c.getString("c_date"));
                                GetDataAdapter2.setCountry(c.getString("type"));
                                GetDataAdapter2.setDiscount(c.getString("email_id"));
                                GetDataAdapter2.setLatitute(c.getString("Description"));






                                // Toast.makeText(CityHotelList.this, "imsge"+c.getString("img1"), Toast.LENGTH_LONG).show();
                                GetDataAdapter1.add(GetDataAdapter2);


                                recyclerViewadapter = new History_adapter(GetDataAdapter1, getApplicationContext());
                                recyclerView.setAdapter(recyclerViewadapter);

                                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            }

                        }catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();

                        }


                        pdialog.cancel();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                    }

                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> map = new HashMap<String, String>();
                return map;
            }

        };

        requestQueue.add(stringRequest);





    }
}
