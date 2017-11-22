package com.example.srinivas.fragmenttoactivitycommunication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class BlankFragment extends Fragment {

TextView num1,num2;
    Button sendData;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_blank, container, false);
        num1 = (TextView) view.findViewById(R.id.num1);
        num2 = (TextView) view.findViewById(R.id.num2);
        sendData = (Button) view.findViewById(R.id.click2);
        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyInterface mainActivity = (MyInterface) getActivity();
                if (num1.getText().toString()!= "" && num2.getText().toString()!="") {
                    mainActivity.add(Integer.valueOf(num1.getText().toString()), Integer.valueOf(num2.getText().toString()));
                }
            }
        });
        return  view;
    }


//    public void sendDataToHost(View view) {
//
//
//    }



}
