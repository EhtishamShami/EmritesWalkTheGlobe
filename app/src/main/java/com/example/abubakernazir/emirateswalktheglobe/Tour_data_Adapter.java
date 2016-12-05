package com.example.abubakernazir.emirateswalktheglobe;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

/**
 * Created by Shami on 11/15/2016.
 */

public class Tour_data_Adapter extends RecyclerView.Adapter<TourViewHolder>  {
    List<Routedata> list = Collections.emptyList();
    Context context;

    public Tour_data_Adapter(List<Routedata> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public TourViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tourslist, parent, false);
        TourViewHolder holder = new TourViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(TourViewHolder holder, int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.title.setText(list.get(position).title);
        holder.kms.setText(list.get(position).route);

        //animate(holder);

    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, Routedata data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Routedata data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

}
