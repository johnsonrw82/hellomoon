package com.jrw82.android.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by johnsonrw82 on 4/12/2015.
 */
public class AudioPlayer {
    private MediaPlayer mMediaPlayer;
    private boolean isCompleted = true;  // flag to indicate that playback has been stopped and released

    /**
     * Stop media playback and release resources
     */
    public void stop() {
        isCompleted = true;
        if (mMediaPlayer != null ) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    /**
     * Is the media player playing? True if so, false otherwise
     * @return true if the player is playing, false otherwise
     */
    public boolean isPlaying() {
        boolean result = false;
        if ( mMediaPlayer != null )
            result = mMediaPlayer.isPlaying();

        return result;
    }

    /**
     * Play method will begin audio playback, or pause based on the state of the media player
     * @param c the context requesting the playback
     */
    public void play(Context c) {
        if ( isCompleted ) {
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

            isCompleted = false;
        }
        // if not complete, and playing - pause
        else if (isPlaying()) {
            pause();
        }
        // not complete, and not playing - resume
        else {
            resume();
        }
    }

    // helper function to resume playback
    private void resume() {
        mMediaPlayer.start();
    }

    // helper function to pause playback
    private void pause() {
        mMediaPlayer.pause();
    }
}
