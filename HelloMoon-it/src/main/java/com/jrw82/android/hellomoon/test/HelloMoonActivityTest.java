package com.jrw82.android.hellomoon.test;

import android.test.ActivityInstrumentationTestCase2;
import com.jrw82.android.hellomoon.*;

public class HelloMoonActivityTest extends ActivityInstrumentationTestCase2<HelloMoonActivity> {

    public HelloMoonActivityTest() {
        super(HelloMoonActivity.class);
    }

    public void testActivity() {
        HelloMoonActivity activity = getActivity();
        assertNotNull(activity);
    }
}

