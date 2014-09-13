package com.ss.poirecorder;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbAdapter extends SQLiteOpenHelper {
	
	final static String DATABASE_NAME = "poi_db";
	final static int VERSION = 1;
	
	public DbAdapter(Context context){
		super(context, DATABASE_NAME, null,
				VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
	
	public Cursor insertPoiRecord(String records){
		return null;		
	}
	
	public Cursor fetchAllPoiRecords(){
		return null;		
	}
	
	public Cursor fetchPoiRecord(int record_no){
		return null;		
	}

	public int deletePoiRecords(int record_no){
		int records_deleted = 0;
		return records_deleted;		
	}
}
