package com.jrw82.android.hellomoon;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by johnsonrw82 on 4/12/2015.
 */
public class VideoViewFragment extends Fragment {
    public static final String EXTRA_VIDEO_URI = "com.jrw82.android.hellomoon.VideoViewFragment.video_uri";
    private VideoView mVideoView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.hello_moon_video, parent, false);

        // get the video uri from the intent
        Uri videoUri = getActivity().getIntent().getParcelableExtra(EXTRA_VIDEO_URI);

        // get the video view
        mVideoView = (VideoView)v.findViewById(R.id.hellomoon_videoView);

        // create a media controller
        MediaController mc = new MediaController(getActivity());
        // set media controller
        mVideoView.setMediaController(mc);

        // set the video URI
        mVideoView.setVideoURI(videoUri);

        // set size based on display metrics
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

        // height/width
        int height = dm.heightPixels;
        int width = dm.widthPixels;

        // set min size
        mVideoView.setMinimumHeight(height);
        mVideoView.setMinimumWidth(width);

        // start the video
        mVideoView.start();

        return v;
    }
}
