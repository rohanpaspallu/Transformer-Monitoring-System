package com.example.rohanpaspallu.dummy_tms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.nio.file.attribute.AclEntry;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.transform.Transformer;

/**
 * Created by ROHAN PASPALLU on 2017-10-14.
 */

public class Home_activity extends Activity {



    private ViewPager vp_slider;
    private LinearLayout ll_dots;
    SliderPagerAdapter sliderPagerAdapter;
    ArrayList<String> slider_image_list;
    private TextView[] dots;
    int page_position = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        Button complaint = (Button) findViewById(R.id.complaint);
        Button notifications = (Button) findViewById(R.id.notifications);
        Button transformers = (Button) findViewById(R.id.transformers);
        final Button about_us = (Button) findViewById(R.id.about_us);
        Button contact_us = (Button) findViewById(R.id.contact_us);
        Button history = (Button) findViewById(R.id.history);


        final Button logout = (Button) findViewById(R.id.logout);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SharedPreferences sharedpreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.clear();

                editor.commit();

                Intent i = new Intent(getApplicationContext(), Login_activity.class);
                startActivity(i);


            }
        });

        complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent complaintIntent = new Intent(Home_activity.this, Complaint.class);
                startActivity(complaintIntent);
            }
        });

        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notificationsIntent = new Intent(Home_activity.this, Notifiations.class);
                startActivity(notificationsIntent);
            }
        });

        transformers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transformersIntent = new Intent(Home_activity.this, Transformers.class);
                startActivity(transformersIntent);
            }
        });

        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about_usIntent = new Intent(Home_activity.this, About_us.class);
                startActivity(about_usIntent);
            }
        });

        contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contact_usIntent = new Intent(Home_activity.this, Contact_us.class);
                startActivity(contact_usIntent);
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent historyIntent = new Intent(Home_activity.this, History.class);
                startActivity(historyIntent);
            }
        });


        vp_slider = (ViewPager) findViewById(R.id.vp_slider);
        ll_dots = (LinearLayout) findViewById(R.id.ll_dots);
//                fragment = new Furniture();
//                if (fragment != null) {
//                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                    ft.replace(R.id.content_frame, fragment);
//                    ft.commit();
//                }
//                drawerLayout.closeDrawers();
        init();

// method for adding indicators
        addBottomDots(0);

        final Handler handler = new Handler();

        final Runnable update = new Runnable() {
            public void run() {
                if (page_position == slider_image_list.size()) {
                    page_position = 0;
                } else {
                    page_position = page_position + 1;
                }
                vp_slider.setCurrentItem(page_position, true);
            }
        };

        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 100, 5000);

    }


    private void init() {




        slider_image_list = new ArrayList<>();

//Add few items to slider_image_list ,this should contain url of images which should be displayed in slider
// here i am adding few sample image links, you can add your own

        slider_image_list.add("http://192.168.43.88/admin_panel/images/img1.png");
        slider_image_list.add("http://192.168.43.88/admin_panel/images/img2.jpg");
        slider_image_list.add("http://192.168.43.88/admin_panel/images/img3.jpg");
        slider_image_list.add("http://192.168.43.88/admin_panel/images/img4.jpg");




        sliderPagerAdapter = new SliderPagerAdapter(Home_activity.this, slider_image_list);
        vp_slider.setAdapter(sliderPagerAdapter);

        vp_slider.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[slider_image_list.size()];

        ll_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(Home_activity.this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#FFFFFF"));
            ll_dots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(Color.parseColor("#b83b3f"));
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