package com.example.srinivas.interfragmentcommunication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FragmentA extends Fragment {

    TextView number1,number2;
    Button sendToA;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_a,container,false);

        number1 = (TextView) view.findViewById(R.id.num1A);

        number2 = (TextView) view.findViewById(R.id.num2A);
        sendToA = (Button) view.findViewById(R.id.sendTOMain);
        sendToA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
sendTOMain();
            }
        });

        return view;


    }

    public void sendTOMain(){
        MyListener listener = (MyListener) getActivity();

        listener.add(Integer.valueOf(number1.getText().toString()),Integer.valueOf(number2.getText().toString()));
    }




}
