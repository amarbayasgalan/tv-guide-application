package com.example.mysqliteexample;

import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        DataSource source = new DataSource(this);
        source.open();
 
        /**
         * CRUD Operations
         * */
        // Inserting Contacts
//        Log.d("Insert: ", "Inserting ..");
//        db.addTV(new TV(0, "MNB"));
//        db.addTV(new TV(1, "UBS"));
//        db.addTV(new TV(2, "MN25"));
//        db.addTV(new TV(3, "TV9"));
// 
        // Reading all contacts
//        Log.d("Reading: ", "Reading all contacts..");
//        List<TV> tv = db.getAllTVs();      
// 
//        for (TV cn : tv) {
//            String log = "Id: "+cn.getTV_ID()+" ,Name: " + cn.getTV_NAME();
//            // Writing Contacts to log
//        Log.d("Name: ", log);
    }
}
