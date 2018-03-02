package com.priwil.tamilantv;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    MediaController mediaC;
    VideoView videov;

    String videopath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videov=(VideoView)findViewById(R.id.videoView);
        mediaC=new MediaController(this);
        videopath="https://firebasestorage.googleapis.com/v0/b/flairs-6fa83.appspot.com/o/Video%2FCSE%2Fyear3%2FCompiler%20Design%2FCD%20Lecture%201.mp4?alt=media&token=62d4322b-3bde-4e48-b3c1-f20a8e64109b";
        Uri uri= Uri.parse(videopath);
        videov.setVideoURI(uri);
        videov.setMediaController(mediaC);
        mediaC.setAnchorView(videov);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        videov.start();

    }
    private RelativeLayout.LayoutParams paramsNotFullscreen; //if you're using RelativeLatout

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);


        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) //To fullscreen
        {
            paramsNotFullscreen=(RelativeLayout.LayoutParams)videov.getLayoutParams();
            RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(paramsNotFullscreen);
            params.setMargins(0, 0, 0, 0);
            params.height= ViewGroup.LayoutParams.MATCH_PARENT;
            params.width=ViewGroup.LayoutParams.MATCH_PARENT;
            params.addRule(RelativeLayout.CENTER_IN_PARENT);
            videov.setLayoutParams(params);

        }
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            videov.setLayoutParams(paramsNotFullscreen);
        }
    }

}
