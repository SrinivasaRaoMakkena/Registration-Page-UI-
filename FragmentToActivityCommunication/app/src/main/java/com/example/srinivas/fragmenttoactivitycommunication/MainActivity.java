package com.example.srinivas.fragmenttoactivitycommunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements MyInterface{

  TextView result1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // b= (Button) findViewById(R.id.click1);
        result1 = (TextView) findViewById(R.id.result);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                text.setText(""+result);
//            }
//        });
    }

    @Override
    public void add(int a, int b) {
        int result = a+b;

        result1.setText("Result:"+result);

    }


}
