package com.example.abubakernazir.emirateswalktheglobe;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.baoyz.actionsheet.ActionSheet;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileUpdateActivity extends AppCompatActivity implements ActionSheet.ActionSheetListener {
Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_update);
        ctx=this;
        CircleImageView img=(CircleImageView)findViewById(R.id.profile_image);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActionSheet.createBuilder(ProfileUpdateActivity.this, getSupportFragmentManager())
                        .setCancelButtonTitle("Cancel")
                        .setOtherButtonTitles("Item1", "Item2", "Item3", "Item4")
                        .setCancelableOnTouchOutside(true)
                        .setListener((ActionSheet.ActionSheetListener) ctx).show();
            }
        });



    }

    @Override
    public void onOtherButtonClick(ActionSheet actionSheet, int index) {
       // Toast.makeText(getApplicationContext(), "click item index = " + index,
        //        0).show();
    }

    @Override
    public void onDismiss(ActionSheet actionSheet, boolean isCancle) {
     //   Toast.makeText(getApplicationContext(), "dismissed isCancle = " + isCancle, 2).show();
    }
}
