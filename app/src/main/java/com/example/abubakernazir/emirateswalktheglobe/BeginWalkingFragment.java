package com.example.abubakernazir.emirateswalktheglobe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BeginWalkingFragment extends Fragment {
    public BeginWalkingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rotView=inflater.inflate(R.layout.fragment_begin_walking, container, false);
        return rotView;
    }
}
