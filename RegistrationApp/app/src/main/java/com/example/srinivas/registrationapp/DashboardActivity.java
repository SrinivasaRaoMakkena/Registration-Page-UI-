package com.example.srinivas.registrationapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DashboardActivity extends AppCompatActivity {
TextView welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        welcome = (TextView) findViewById(R.id.welcomeET);
        Intent intent = getIntent();
        welcome.setText("Welcome "+intent.getStringExtra("name"));
        Toast.makeText(getApplicationContext(),"Your Phone Number: "+intent.getStringExtra("phoneno"),Toast.LENGTH_SHORT).show();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Go to Registration Page", Snackbar.LENGTH_LONG)
//
//        .setAction("Action", null).show();

                Intent intent = new Intent(DashboardActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }

}
