package com.jrw82.android.hellomoon;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.VideoView;
import com.jrw82.android.lib.SingleFragmentActivity;


/**
 * Created by johnsonrw82 on 4/12/2015.
 */
public class VideoPlayerActivity extends SingleFragmentActivity {
    private static final String TAG = "VideoPlayerActivity";

    @Override
    protected Fragment createFragment() {
        Log.d(TAG, "Fragment created");
        return new VideoViewFragment();
    }
}
