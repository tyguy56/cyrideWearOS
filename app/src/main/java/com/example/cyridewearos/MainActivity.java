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



public class MainActivity extends Activity {

    static ArrayList<Routes> busRoutes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        WearableRecyclerView wearableRecyclerView = findViewById(R.id.recycler_launcher_view);

        wearableRecyclerView.setEdgeItemsCenteringEnabled(true);
        wearableRecyclerView.setCircularScrollingGestureEnabled(true);
        wearableRecyclerView.setLayoutManager(
                new WearableLinearLayoutManager(this));


        Gson gson = new Gson();

        StringRequest request = new StringRequest(Request.Method.GET, "https://mycyride.com/Region/0/Routes", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Type userListType = new TypeToken<ArrayList<Routes>>(){}.getType();

                busRoutes = gson.fromJson(response,userListType);

                wearableRecyclerView.setAdapter(new recycleViewAdapter(MainActivity.this, busRoutes, new recycleViewAdapter.AdapterCallback() {
                    @Override
                    public void onItemClicked(Integer menuPosition) {
                        Intent intent = new Intent(MainActivity.this,selectionActivity.class);
                        intent.putExtra(Intent.EXTRA_TEXT, Integer.toString(busRoutes.get(menuPosition).getID()));
                        intent.putExtra(Intent.EXTRA_CONTENT_QUERY,busRoutes.get(menuPosition).getColor());
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