package com.example.srinivas.fragmentdemo;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.app.FragmentManager fragmentManager = getFragmentManager();
        SampleFragment fragment = new SampleFragment();
        Fragment2 fragment2 = new Fragment2();

        fragmentManager.beginTransaction().add(R.id.frame1,fragment,"SampleFragment").commit();
        fragmentManager.beginTransaction().add(R.id.frame2,fragment2,"Fragment2").commit();

fragmentManager.beginTransaction().remove(fragment2).commit();



    }
}
