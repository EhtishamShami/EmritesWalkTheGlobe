package com.example.abubakernazir.emirateswalktheglobe;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Shami on 11/15/2016.
 */

public class TourViewHolder extends RecyclerView.ViewHolder {

    CardView cv;
    TextView title;
    TextView kms;

    TourViewHolder(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.tourcardView);
        title = (TextView) itemView.findViewById(R.id.routetitle);
        kms = (TextView) itemView.findViewById(R.id.routekms);
    }
}