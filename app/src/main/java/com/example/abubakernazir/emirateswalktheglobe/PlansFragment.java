package com.example.abubakernazir.emirateswalktheglobe;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class PlansFragment extends Fragment {

    public PlansFragment() {
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
        View rootView=inflater.inflate(R.layout.fragment_plans, container, false);

        List<Routedata> data = fill_with_data();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.tours_list);
        Tour_data_Adapter adapter = new Tour_data_Adapter(data, getActivity());
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        recyclerView.addItemDecoration(new GridSpacingItemDecoration(12, dpToPx(10), false));
        return rootView;
    }
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
    public List<Routedata> fill_with_data() {

        List<Routedata> data = new ArrayList<>();

        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));
        data.add(new Routedata("Sharjah", "17km"));
        data.add(new Routedata("Abu dhabi - muskan ","0km"));
        data.add(new Routedata("India to South Africa", "20km"));

        return data;
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

}
