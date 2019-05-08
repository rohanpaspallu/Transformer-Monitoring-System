package com.example.rohanpaspallu.dummy_tms;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.SharedLibraryInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login_activity extends AppCompatActivity {
EditText edt_emp_id,edt_password;
    Button btn_login,btn_register;
    RequestQueue requestQueue;
Boolean yourBool = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

            requestQueue = Volley.newRequestQueue(getApplicationContext());
            edt_emp_id = (EditText)findViewById(R.id.emp_id);
            edt_password = (EditText)findViewById(R.id.password);

            btn_login = (Button)findViewById(R.id.login);

            btn_register = (Button)findViewById(R.id.register);

            btn_register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Login_activity.this,Register.class);
                    startActivity(i);
                }
            });



            btn_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    final  String emp_id = edt_emp_id.getText().toString();
                    final  String password = edt_password.getText().toString();





                    final ProgressDialog progressDialog = new ProgressDialog(Login_activity.this);
                    progressDialog.setMessage("Loading...");
                    progressDialog.show();
                    final StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.43.88/admin_panel/webservice/user_login.php", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(Login_activity.this, "" + response, Toast.LENGTH_LONG).show();

                            String abc = "success";
                            if (response.equals(abc)) {
                                // Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(getApplicationContext(),Home_activity.class);
                                startActivity(i);
                                progressDialog.cancel();

                                SharedPreferences sharedpreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedpreferences.edit();

                                editor.putString("email_id", emp_id);

                                editor.commit();
                                edt_emp_id.setText("");
                                edt_password.setText("");
                            } else {
                                Toast.makeText(Login_activity.this, "Email or Password were Wrong.\n Try Again...", Toast.LENGTH_LONG).show();
                                progressDialog.cancel();
                            }


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
                            map.put("password", password);

//                            map.put("idproof", spinnerIdentityNo.getSelectedItem().toString());
//                            map.put("identityno", editTextIdentityNo.getText().toString());
                            return map;
                        }


                    };
                    requestQueue.add(stringRequest);









                }
            });










    }



    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);//***Change Here***
        startActivity(intent);
        finish();
        System.exit(0);
    }


}
