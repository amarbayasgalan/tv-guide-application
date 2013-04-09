package com.example.mysqliteexample;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {
  
	public static final String DATABASE_NAME = "TVGUIDE";
	public static final String TV_TABLE="tv_table";
	public static final String TV_ID="tv_id";
	public static final String TV_NAME="tv_name";
	
	public static final String HUTULBUR_TABLE="hutulbur_table";
	public static final String HUTULBUR_ID="hutulbur_id";
	public static final String HUTULBUR_NAME="hutulbur_name";
	public static final String HUTULBUR_TIME="hutulbur_time";
	public static final String HUTULBUR_ALERT="hutulbur_alert";
	public static final String HUTULBUR_TV_ID="hutulbur_tv_id";
	
	public static final int DATABASE_VERSION = 1;
	private static final String TV_DATABASE_CREATE = "create table " + TV_TABLE + " (" + TV_ID + " integer primary key autoincrement, " + TV_NAME + " text not null);";
	private static final String HUTULBUR_DATABASE_CREATE = "create table "
			+HUTULBUR_TABLE+" ("+HUTULBUR_ID +" integer primary key autoincrement, "+HUTULBUR_NAME +" text, "+HUTULBUR_TIME+" text, "+HUTULBUR_ALERT +" boolen, "+HUTULBUR_TV_ID +" integer, FOREIGN KEY ("+TV_ID+") REFERENCES  "+HUTULBUR_TABLE+" ("+HUTULBUR_TV_ID+"));";
		
	public DatabaseHandler (Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db){
		    Log.v("TV Table create", TV_DATABASE_CREATE);
		    Log.v("HUTULBUR Table create", HUTULBUR_DATABASE_CREATE);
			db.execSQL(TV_DATABASE_CREATE);
			db.execSQL(HUTULBUR_DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.w(DatabaseHandler.class.getName(),
				"Upgrading database from version "+oldVersion+" to "
				+newVersion+" , which will destroy all old data");
				db.execSQL("DROP TABLE IF EXISTS "+TV_TABLE);
				db.execSQL("DROP TABLE IF EXISTS "+HUTULBUR_TABLE);
				onCreate(db);
	}
	
	public void addTV(TV tv) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(TV_NAME, tv.getTV_NAME()); // Contact Name
 
        // Inserting Row
        db.insert(TV_TABLE, null, values);
        db.close(); // Closing database connection
    }

	public TV getTV (int tv_id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TV_TABLE, new String[] { TV_ID,
                TV_NAME}, TV_ID + "=?",
                new String[] { String.valueOf(tv_id) }, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        TV tv = new TV(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));
        // return contact
        return tv;
    }
	
	// Getting All Contacts
    public List<TV> getAllTVs() {
        List<TV> contactList = new ArrayList<TV>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TV_TABLE;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                TV tv = new TV();
                tv.setTV_ID(Integer.parseInt(cursor.getString(0)));
                tv.setTV_NAME(cursor.getString(1));
                // Adding contact to list
                contactList.add(tv);
            } while (cursor.moveToNext());
        }
 
        // return contact list
        return contactList;
    }
    
	public int updateTV(TV tv) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(TV_NAME, tv.getTV_NAME());
 
        // updating row
        return db.update(TV_TABLE, values, TV_ID + " = ?",
                new String[] { String.valueOf(tv.getTV_ID()) });
    }
	
	 // Deleting single contact
    public void deleteTV(TV tv) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TV_TABLE, TV_ID + " = ?", new String[] { String.valueOf(tv.getTV_ID()) });
        db.close();
    }
}
