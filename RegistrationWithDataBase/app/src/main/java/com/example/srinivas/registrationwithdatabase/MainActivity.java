package com.example.srinivas.registrationwithdatabase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.srinivas.registrationwithdatabase.database.DBHelper;
import com.example.srinivas.registrationwithdatabase.database.RegContract;

public class MainActivity extends AppCompatActivity {
EditText nameET,usernameET,passwordET,emailET;
    String name,username,password,email;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.Login);
        nameET = (EditText) findViewById(R.id.name);
        usernameET = (EditText) findViewById(R.id.username);
        passwordET = (EditText) findViewById(R.id.password);
        emailET = (EditText) findViewById(R.id.email);

        name =nameET.getText().toString();
        username=usernameET.getText().toString();
        password=passwordET.getText().toString();
        email=emailET.getText().toString();






        DBHelper helper = new DBHelper(this);
        sqLiteDatabase = helper.getReadableDatabase();
      //  insertValues();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                readData();
                if (cursor != null) {
                    while (cursor.moveToNext()){
                        String user = cursor.getString(cursor.getColumnIndexOrThrow(RegContract.RegDetails.USER_NAME));
                        Log.i("usernames",user);
                        Toast.makeText(getApplicationContext(),user,Toast.LENGTH_SHORT).show();
                        if (user.equals(username)){
                            Toast.makeText(getApplicationContext(),"User already Existed",Toast.LENGTH_SHORT).show();
                        }else{
                            insertValues();
                            Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_SHORT).show();
                        }
                    }
                    cursor.close();
                }

                // Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_SHORT).show();
               // Log.i("DataBase","Inserted");
            }
        });


    }

    private void insertValues(){
        ContentValues values = new ContentValues();
//        values.put(RegContract.RegDetails.NAME,name);
//        values.put(RegContract.RegDetails.USER_NAME,username);
//        values.put(RegContract.RegDetails.PASSWORD,password);
//        values.put(RegContract.RegDetails.EMAIL,email);

        ContentValues values2 = new ContentValues();
        values.put(RegContract.RegDetails.NAME,name);
        values.put(RegContract.RegDetails.USER_NAME,username);
        values.put(RegContract.RegDetails.PASSWORD,password);
        values.put(RegContract.RegDetails.EMAIL,email);

        //sqLiteDatabase.insert(RegContract.RegDetails.TABLE_NAME,null,values);
        sqLiteDatabase.insert(RegContract.RegDetails.TABLE_NAME,null,values2);

    }

    private void readData(){

        String [] projection = {RegContract.RegDetails.NAME,RegContract.RegDetails.USER_NAME,RegContract.RegDetails.PASSWORD,RegContract.RegDetails.EMAIL};
        String selection = RegContract.RegDetails.USER_NAME+"=?";
        Log.d("User",username);
        String [] selectionArgs = {username};
//to get all records make selection and selectionArgs as null
        cursor = sqLiteDatabase.query(RegContract.RegDetails.TABLE_NAME,projection,selection,selectionArgs,null,null,null,null);
        Toast.makeText(getApplicationContext(),""+cursor.getCount(),Toast.LENGTH_SHORT).show();
    }
}
