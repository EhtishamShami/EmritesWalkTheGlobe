package com.example.abubakernazir.emirateswalktheglobe;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class VirtualTourFragment extends Fragment {
    public VirtualTourFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rotView=inflater.inflate(R.layout.fragment_virtual_tour, container, false);
        WebView mywebview = (WebView) rotView.findViewById(R.id.WebView);
        WebSettings webSettings = mywebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
    //    webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);

       mywebview.getSettings().setBuiltInZoomControls(true);

       mywebview.getSettings().setDisplayZoomControls(true);
        mywebview.setVerticalScrollBarEnabled(false);
        mywebview.setHorizontalScrollBarEnabled(false);
        mywebview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }


        });
        mywebview.setWebViewClient(new WebViewClient() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                if(request.getUrl().toString().contains("")){}

                return true;
            }

        });
        mywebview.loadUrl("http://servue.ae/health/index.php/api/view_WebView_VirtualTours/9");
        return rotView;
    }
}
