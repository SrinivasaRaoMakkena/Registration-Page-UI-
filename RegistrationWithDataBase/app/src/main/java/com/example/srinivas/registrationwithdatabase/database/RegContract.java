package com.example.srinivas.registrationwithdatabase.database;

import android.provider.BaseColumns;

/**
 * Created by Srinivas on 6/16/2017.
 */

public final class RegContract {


    public static final class RegDetails implements BaseColumns {

        public static final String TABLE_NAME = "Customer";
        public static final String NAME = "name";
        public static final String USER_NAME = "userName";
        public static final String PASSWORD = "password";
        public static final String EMAIL = "email";
       // private static final String _ID = BaseColumns._ID;



    }
}
