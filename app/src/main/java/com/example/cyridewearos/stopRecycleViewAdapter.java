package com.example.cyridewearos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class stopRecycleViewAdapter extends RecyclerView.Adapter<stopRecycleViewAdapter.RecyclerViewHolder> {

    private ArrayList<StopsFormat> dataSource = new ArrayList<StopsFormat>();
    public interface AdapterCallback{
        void onItemClicked(Integer menuPosition);
    }
    private AdapterCallback callback;

    private Context context;


    public stopRecycleViewAdapter(Context context, ArrayList<StopsFormat> dataArgs, AdapterCallback callback){
        this.context = context;
        this.dataSource = dataArgs;
        this.callback = callback;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_menu_item,parent,false);

        RecyclerViewHolder stopRecyclerViewHolder = new RecyclerViewHolder(view);

        return stopRecyclerViewHolder;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        RelativeLayout menuContainer;
        TextView stopItem;

        public RecyclerViewHolder(View view) {
            super(view);
            menuContainer = view.findViewById(R.id.menu_container);
            stopItem = view.findViewById(R.id.menu_item);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        StopsFormat data_provider = dataSource.get(position);
        holder.stopItem.setTextSize(15.0f);
        holder.stopItem.setText(data_provider.getName().replace(" at ", " @ ").replace(" Avenue ", " Ave "));

        holder.menuContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                if(callback != null) {
                    callback.onItemClicked(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }
}

class stopItem {
    private String text;


    public stopItem() {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}