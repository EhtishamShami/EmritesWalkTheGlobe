package com.example.abubakernazir.emirateswalktheglobe;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewPropertyAnimator;

/**
 * Created by abubakernazir on 11/11/16.
 */

public class CustomPager extends ViewPager {

        private boolean swipeable = true;

        public CustomPager(Context context) {
            super(context);
        }

        public CustomPager(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        // Call this method in your motion events when you want to disable or enable
// It should work as desired.
        public void setSwipeable(boolean swipeable) {
            this.swipeable = swipeable;
        }

        @Override
        public boolean onInterceptTouchEvent(MotionEvent arg0) {
            return false;
        }
}
