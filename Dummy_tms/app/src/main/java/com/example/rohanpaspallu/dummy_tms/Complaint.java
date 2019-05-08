package com.example.rohanpaspallu.dummy_tms;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static com.example.rohanpaspallu.dummy_tms.R.id.num;

/**
 * Created by ROHAN PASPALLU on 2017-11-24.
 */

public class Complaint extends Activity{

    RequestQueue requestQueue;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complaint);

        final Spinner trans = (Spinner)findViewById(R.id.trans);
        final Spinner capacity = (Spinner) findViewById(R.id.capacity);
        SharedPreferences sharedpreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        final String email = sharedpreferences.getString("email_id", "");

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd / MM / yyyy ");
        final  String date =  mdformat.format(calendar.getTime());

        // Toast.makeText(getApplicationContext(), email+date, Toast.LENGTH_LONG).show();

        String[] transformerType = {"Select type of transformer","CRGO","Amorphous"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Complaint.this, R.layout.row_spinner, transformerType);
        trans.setAdapter(adapter);

        String[] transformerCapacity = {"Select capacity of transformer","11kv","25kv","50kv","75kv","100kv"};
        ArrayAdapter<String> capacityadapter = new ArrayAdapter<String>(Complaint.this, R.layout.row_spinner2, transformerCapacity);
        capacity.setAdapter(capacityadapter);

        final EditText edt_desription = (EditText)findViewById(R.id.complaint_description);


        Button btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String str_trans = trans.getSelectedItem().toString();
                final String str_des = edt_desription.getText().toString();


                requestQueue = Volley.newRequestQueue(getApplicationContext());
                final ProgressDialog progressDialog = new ProgressDialog(Complaint.this);
                progressDialog.setMessage("Patience is appreciated...");
                progressDialog.show();

                final StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.43.88/admin_panel/webservice/complaint_register.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

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
                        map.put("type", str_trans);
                        map.put("Description", str_des);
                        map.put("c_date", date);
                        map.put("email_id", email);


//                            map.put("idproof", spinnerIdentityNo.getSelectedItem().toString());
//                            map.put("identityno", editTextIdentityNo.getText().toString());
                        return map;
                    }


                };
                requestQueue.add(stringRequest);






            }
        });



    }
}