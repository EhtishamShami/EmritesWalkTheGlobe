package com.example.abubakernazir.emirateswalktheglobe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FriendsFragment extends Fragment {
    public FriendsFragment() {
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
        View rootView=inflater.inflate(R.layout.fragment_friends, container, false);

        List<Data> data = fill_with_data();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recentfriends_recyle);
        Recycler_View_Adapter adapter = new Recycler_View_Adapter(data, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        /////////////Vertical View codes goes down here
        RecyclerView verticalrecycler = (RecyclerView) rootView.findViewById(R.id.my_allfriends_recyle);
        Recycler_View_Adapter verticaladpater = new Recycler_View_Adapter(data, getActivity());
        verticalrecycler.setAdapter(verticaladpater);
        verticalrecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        return rootView;
    }
    public List<Data> fill_with_data() {

        List<Data> data = new ArrayList<>();

        data.add(new Data("Batman", R.drawable.img_person));
        data.add(new Data("X-Men", R.drawable.img_person));
        data.add(new Data("Captain", R.drawable.img_person));
        data.add(new Data("Kung Fu", R.drawable.img_person));
        data.add(new Data("Warcraft",  R.drawable.img_person));
        data.add(new Data("Alice", R.drawable.img_person));

        return data;
    }
}
