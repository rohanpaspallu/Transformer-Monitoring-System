package com.example.rohanpaspallu.dummy_tms;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.bumptech.glide.Glide;


import java.util.List;

/**
 * Created by JUNED on 6/16/2016.
 */
public class History_adapter extends RecyclerView.Adapter<History_adapter.ViewHolder> {

    Context context;

    List<Actors> getDataAdapter;

    public static final String MyPREFERENCES = "MyPrefs" ;


    //Permision code that will be checked in the method onRequestPermissionsResult
    private int STORAGE_PERMISSION_CODE = 23;
    public static final String KEY_EMAIL = "email_id";

    public History_adapter(List<Actors> getDataAdapter, Context context){

        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_history, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        final Actors getDataAdapter1 =  getDataAdapter.get(position);


        Viewholder.c_id.setText("C id :"+getDataAdapter1.getId());
        Viewholder.c_date.setText("Date :"+getDataAdapter1.getName());
        Viewholder.type.setText("Type :"+getDataAdapter1.getCountry());
        Viewholder.email_id.setText("Emp Id :"+getDataAdapter1.getDiscount());
        Viewholder.desc.setText("Description :"+getDataAdapter1.getLatitute());

//        final String url = "http://www.homadehigen.com/admin/" + getDataAdapter1.getImg1();
//        Glide.with(context).load(url).into(Viewholder.Image);
//        Viewholder.Order_now.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                SharedPreferences  sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
//                if (sharedpreferences.contains(KEY_EMAIL)) {
//
//
//
//
//
////                Toast.makeText(context.getApplicationContext(),
////                        "cat_id:"+getDataAdapter1.getId(), Toast.LENGTH_LONG).show();
//                    Intent i = new Intent(context,Packages_Activity_second.class);
//                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    i.putExtra("package_id",getDataAdapter1.getId());
//                    i.putExtra("package_name",getDataAdapter1.getName());
//                    i.putExtra("package_disc",getDataAdapter1.getDiscount());
//                    i.putExtra("package_price",getDataAdapter1.getRate());
//                    i.putExtra("package_image",url);
//                    context.startActivity(i);
//                }
//
//                else{
//                    final Dialog dialog = new Dialog(v.getContext());
//                    dialog.setContentView(R.layout.package_login_dialog);
//                    // dialog.setTitle("Title...");
//
//
//                    Button login  = (Button) dialog.findViewById(R.id.button7) ;
//                    login.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            Intent i1 = new Intent(context,Login.class);
//                            i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                            context.startActivity(i1);
//                        }
//                    });
//                    Button close  = (Button) dialog.findViewById(R.id.button8) ;
//                    close.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            dialog.cancel();
//                        }
//                    });
//                    dialog.show();
//
//
//                }
//
//            }
//
//        });










    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView c_id,c_date,type,email_id,desc;
        public ImageView Image;
        public RatingBar Rating;
      //  public Button Order_now;

        public ViewHolder(View itemView) {

            super(itemView);

            c_id = (TextView) itemView.findViewById(R.id.textView2);
            c_date = (TextView) itemView.findViewById(R.id.textView5);
            type = (TextView) itemView.findViewById(R.id.textView6);
            email_id = (TextView) itemView.findViewById(R.id.textView7);
            desc = (TextView) itemView.findViewById(R.id.textView8);

           // Image = (ImageView) itemView.findViewById(R.id.imageView);

           // Order_now = (Button)itemView.findViewById(R.id.button2);


        }
    }
}
