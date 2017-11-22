package com.example.srinivas.registrationapp;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText uname,pass,phoneNo;
    Button submit,reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname = (EditText) findViewById(R.id.nameET);
        pass = (EditText) findViewById(R.id.passwordET);
        phoneNo = (EditText) findViewById(R.id.phoneNoET);
        submit = (Button) findViewById(R.id.submitBTN);
        reset = (Button) findViewById(R.id.resetBTN);

        submit.setOnClickListener(this);
        reset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

            switch (id){
                case R.id.submitBTN:

                    if (uname.getText().toString().isEmpty()){
                        uname.setError("Please enter name");
                    }else if(pass.getText().toString().isEmpty()) {
                        pass.setError("Please enter password");
                    }else if (phoneNo.getText().toString().isEmpty()) {
                        //just practice
                        Toast.makeText(getApplicationContext(),"Please enter phone no",Toast.LENGTH_SHORT).show();
                    }else{
                        Intent intent = new Intent(MainActivity.this,DashboardActivity.class);
                        intent.putExtra("name",uname.getText().toString());
                        intent.putExtra("phoneno",phoneNo.getText().toString());
                        startActivity(intent);
                    }
                    break;
                case R.id.resetBTN:

                    uname.setText("");
                    pass.setText("");
                    phoneNo.setText("");
                    break;

                }
            }



}
