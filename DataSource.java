package com.example.mysqliteexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DataSource {

  private SQLiteDatabase database;
	private DatabaseHandler dbhelper;
	private String[] allcolumns = {DatabaseHandler.TV_ID, DatabaseHandler.TV_NAME};
	
	public DataSource(Context context) {
		// TODO Auto-generated constructor stub
		dbhelper = new DatabaseHandler(context);
	}
	
	public void open(){
		database = dbhelper.getReadableDatabase();
	}
}
