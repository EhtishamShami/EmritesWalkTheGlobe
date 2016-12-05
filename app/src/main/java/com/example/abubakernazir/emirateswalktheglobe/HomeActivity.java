package com.example.abubakernazir.emirateswalktheglobe;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.abubakernazir.emirateswalktheglobe.R.id.pager;

public class HomeActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    //This is our tablayout
    private TabLayout tabLayout;
    //This is our viewPager
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //Adding toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setCustomView(this.setTabView(0,false)));
        tabLayout.addTab(tabLayout.newTab().setCustomView(this.setTabView(1,false)));
        tabLayout.addTab(tabLayout.newTab().setCustomView(this.setTabView(2,false)));
        tabLayout.addTab(tabLayout.newTab().setCustomView(this.setTabView(3,false)));
        tabLayout.addTab(tabLayout.newTab().setCustomView(this.setTabView(4,false)));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(pager);
        viewPager.setMotionEventSplittingEnabled(false);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return true;
            }

        });


        //Creating our pager adapter
        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());
        //Adding adapter to pager
        viewPager.setAdapter(adapter);


        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);


    }

    public View setTabView(int position, boolean selected) {
        View v = LayoutInflater.from(this).inflate(R.layout.customtab, null);
       TextView tv = (TextView) v.findViewById(R.id.tab_text);
        ImageView img=(ImageView)v.findViewById(R.id.tab_image);
        if(position==0) {
            img.setImageResource(R.mipmap.profile);
            tv.setText("ME");
        }
        if(position==1){

            img.setImageResource(R.mipmap.friends);
            tv.setText("FRIENDS");
        }
        if(position==2){
            img.setImageResource(R.mipmap.virtual_tour);
            tv.setText("VIRTUAL TOUR");
        }


        if(position==3){
            img.setImageResource(R.mipmap.plans);
            tv.setText("PLANS");
        }

        if(position==4){
            img.setImageResource(R.mipmap.begin);
            tv.setText("BEGIN");
        }

            return v;
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}


