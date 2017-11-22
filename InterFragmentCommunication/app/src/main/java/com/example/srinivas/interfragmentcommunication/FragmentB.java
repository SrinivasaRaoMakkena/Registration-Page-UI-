package com.example.srinivas.interfragmentcommunication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ShareCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class FragmentB extends Fragment {
TextView result;
    int results;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_b,container,false);
        result = (TextView) view.findViewById(R.id.result);


        return  view;


    }
public void addTwoNumbers(int a, int b){
results= a+b;
    result.setText(Integer.toString(results));

}




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //addTwoNumbers();
    }
}
