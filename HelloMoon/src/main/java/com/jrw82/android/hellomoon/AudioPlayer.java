package com.jrw82.android.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by johnsonrw82 on 4/12/2015.
 */
public class AudioPlayer {
    private MediaPlayer mMediaPlayer;

    public void stop() {
        if (mMediaPlayer != null ) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    public void play(Context c) {
        stop(); // force a stop

        // create the player with specified media and context, and play
        mMediaPlayer = MediaPlayer.create(c, R.raw.one_small_step);
        mMediaPlayer.start();

        // set completion listener
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop(); // call stop when complete
            }
        });
    }
}
