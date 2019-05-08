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
public class Notification_adapter extends RecyclerView.Adapter<Notification_adapter.ViewHolder> {

    Context context;

    List<Actors> getDataAdapter;

    public static final String MyPREFERENCES = "MyPrefs" ;


    //Permision code that will be checked in the method onRequestPermissionsResult
    private int STORAGE_PERMISSION_CODE = 23;
    public static final String KEY_EMAIL = "email_id";

    public Notification_adapter(List<Actors> getDataAdapter, Context context){

        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_notification, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        final Actors getDataAdapter1 =  getDataAdapter.get(position);


        Viewholder.title.setText(getDataAdapter1.getName());
        Viewholder.desc.setText(getDataAdapter1.getCountry());
        Viewholder.date.setText(getDataAdapter1.getLatitute());


        final String url = "http://192.168.43.88/admin_panel/" + getDataAdapter1.getDiscount();
        Glide.with(context).load(url).into(Viewholder.Image);



//        Viewholder.Order_now.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
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
//
//                    });
//
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

        public TextView title,date,type,email_id,desc;
        public ImageView Image;
        public RatingBar Rating;
        //  public Button Order_now;

        public ViewHolder(View itemView) {

            super(itemView);

            title = (TextView) itemView.findViewById(R.id.textView2);
            desc = (TextView) itemView.findViewById(R.id.textView5);
            date = (TextView) itemView.findViewById(R.id.textView6);


             Image = (ImageView) itemView.findViewById(R.id.imageView3);

            // Order_now = (Button)itemView.findViewById(R.id.button2);


        }
    }
}
