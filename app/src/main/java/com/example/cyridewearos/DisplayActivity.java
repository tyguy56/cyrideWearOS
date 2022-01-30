package com.example.cyridewearos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

public class DisplayActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent intent = getIntent();
        String id = intent.getStringExtra(Intent.EXTRA_TEXT);
        String color = intent.getStringExtra(Intent.EXTRA_CONTENT_QUERY);
        String stopName= intent.getStringExtra("stopName");



        ImageView imageView = findViewById(R.id.routeIndicator);
        Drawable background = imageView.getBackground();
        GradientDrawable gradientDrawable = (GradientDrawable) background;
        gradientDrawable.setStroke(5, Color.parseColor(color));

        String url = "https://mycyride.com/Stop/" + id + "/Arrivals?customerID=187";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                TextView text = (TextView)findViewById(R.id.info);

                try
                {
                    Gson gson = new Gson();
                    ArrivalsFormat[] arrival = gson.fromJson(response, ArrivalsFormat[].class);
                    text.setText(stopName + "\n\n" + arrival[0].getArrivals().get(0).getArriveTime());
                }
                catch(IndexOutOfBoundsException e)
                {
                    text.setText("No buses currently available");
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        VolleySingleton.getInstance(DisplayActivity.this).addToRequestQueue(request);
        final Handler handler = new Handler();
        final int delay = 30000;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                VolleySingleton.getInstance(DisplayActivity.this).addToRequestQueue(request);
                handler.postDelayed(this,delay);
            }
        }, delay);
    }
}
