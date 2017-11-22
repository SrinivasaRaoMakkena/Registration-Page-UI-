package com.example.srinivas.interfragmentcommunication;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MyListener{
        static  int num1,num2;

    FragmentManager manager = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragA();
        addFragB();
    }





    public void addFragA(){
        FragmentA fragmentA = new FragmentA();

        manager.beginTransaction().add(R.id.frameA,fragmentA,"fragA").commit();

    }
    public void addFragB(){
        FragmentB fragmentB = new FragmentB();
      //  FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.frameB,fragmentB,"fragB").commit();

    }
    public void dataFromAtoB(View view) {
        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragB");
fragmentB.addTwoNumbers(num1,num2);
//        Bundle bundle = new Bundle();
//        bundle.putInt("num1",num1);
//        bundle.putInt("num2",num2);


       // fragmentB.setArguments(bundle);



    }


    @Override
    public void add(int a, int b) {
        num1=a;
        num2=b;





    }
}
