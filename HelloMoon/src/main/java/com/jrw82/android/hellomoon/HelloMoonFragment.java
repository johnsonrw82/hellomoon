package com.jrw82.android.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by johnsonrw82 on 4/11/2015.
 */
public class HelloMoonFragment extends Fragment {
    private AudioPlayer mAudioPlayer = new AudioPlayer();

    private Button mPlayButton;
    private Button mStopButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);

        mPlayButton = (Button)v.findViewById(R.id.hellomoon_playButton);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // if the player is playing, change text of the button
                if (!mAudioPlayer.isPlaying()) {
                    mPlayButton.setText(R.string.hellomoon_pause);
                }
                else {
                    mPlayButton.setText(R.string.hellomoon_play);
                }
                // request play operation
                mAudioPlayer.play(getActivity());
            }
        });

        mStopButton = (Button)v.findViewById(R.id.hellomoon_stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAudioPlayer.stop();
                mPlayButton.setText(R.string.hellomoon_play);
            }
        });

        return v;
    }

    // stop the player when the fragment is destroyed
    @Override
    public void onDestroy() {
        super.onDestroy();
        mAudioPlayer.stop();
    }
}
