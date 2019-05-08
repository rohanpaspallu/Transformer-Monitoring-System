package com.example.rohanpaspallu.dummy_tms;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
 * Created by ROHAN PASPALLU on 2017-08-12.
 */

public  class Register extends Activity{
    RequestQueue requestQueue;
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerpage);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        TextView tx = (TextView)findViewById(R.id.textView2);
        final EditText eemp_id=(EditText) findViewById(R.id.emp_id);
        final EditText eemp_name =(EditText)findViewById(R.id.emp_name);
        final EditText edesignation = (EditText) findViewById(R.id.designation);
        final EditText econtact = (EditText)findViewById(R.id.contact);
        final EditText eemail = (EditText) findViewById(R.id.email);
        final EditText epassword = (EditText)findViewById(R.id.password);
        final EditText econfirm_password = (EditText) findViewById(R.id.confirm_password);
        Button submit = (Button) findViewById(R.id.submit);
        Button reset  = (Button)findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(Register.this,Register.class);
                startActivity(i1);
            }
        });


        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "Capture_it_2.ttf");

        tx.setTypeface(custom_font);









        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String emp_id = eemp_id.getText().toString();
                final String emp_name = eemp_name.getText().toString();
                final String designation = edesignation.getText().toString();
                final String contact = econtact.getText().toString();
                final String email = eemail.getText().toString();
                final String password = epassword.getText().toString();
                final String confirm_password = econfirm_password.getText().toString();

                if(password.equals(confirm_password)) {
                    final ProgressDialog progressDialog = new ProgressDialog(Register.this);
                    progressDialog.setMessage("Patience is appreciated...");
                    progressDialog.show();

                    final StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.43.88/admin_panel/webservice/user_registration.php", new Response.Listener<String>() {
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
                            map.put("emp_id", emp_id);
                            map.put("emp_name", emp_name);
                            map.put("designation", designation);
                            map.put("mobile_no", contact);
                            map.put("email_id", email);
                            map.put("password", password);

//                            map.put("idproof", spinnerIdentityNo.getSelectedItem().toString());
//                            map.put("identityno", editTextIdentityNo.getText().toString());
                            return map;
                        }


                    };
                    requestQueue.add(stringRequest);
                }

                else
                {
                    Toast.makeText(getApplicationContext(),"password doesnt match:  RETRY",Toast.LENGTH_LONG).show();
                }


            }
        });








    }
}
