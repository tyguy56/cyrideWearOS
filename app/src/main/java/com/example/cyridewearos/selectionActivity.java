package com.example.cyridewearos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class selectionActivity extends Activity {

    static ArrayList<DirectionsFormat> directions = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);

            Intent intent = getIntent();
            String id = intent.getStringExtra(Intent.EXTRA_TEXT);
            String color = intent.getStringExtra(Intent.EXTRA_CONTENT_QUERY);
            WearableRecyclerView wearableRecyclerView = findViewById(R.id.recycler_launcher_view);

            wearableRecyclerView.setEdgeItemsCenteringEnabled(true);
            wearableRecyclerView.setCircularScrollingGestureEnabled(true);
            wearableRecyclerView.setLayoutManager(
                    new WearableLinearLayoutManager(this));


            Gson gson = new Gson();

            String url = "https://www.mycyride.com/Route/" + id + "/Directions/";

            StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    Type userListType = new TypeToken<ArrayList<DirectionsFormat>>(){}.getType();

                    directions = gson.fromJson(response,userListType);


                    wearableRecyclerView.setAdapter(new stopRecycleViewAdapter(selectionActivity.this, directions.get(0).getStops(), new stopRecycleViewAdapter.AdapterCallback() {
                        @Override
                        public void onItemClicked(Integer menuPosition) {
                            Intent intent = new Intent(selectionActivity.this, DisplayActivity.class);
                            intent.putExtra(Intent.EXTRA_TEXT, Integer.toString(directions.get(0).getStops().get(menuPosition).getID()));
                            intent.putExtra(Intent.EXTRA_CONTENT_QUERY,color);
                            intent.putExtra("stopName", directions.get(0).getStops().get(menuPosition).getName());
                            startActivity(intent);
                        }
                    }));
                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }
            );

            VolleySingleton.getInstance(this).addToRequestQueue(request);

        }

    }
