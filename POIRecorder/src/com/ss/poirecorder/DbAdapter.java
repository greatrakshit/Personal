
package com.ss.poirecorder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbAdapter extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME="poi_db";
	private static final int DATABASE_VERSION = 1;
	private SQLiteDatabase mDb;
	private final Context mCtx;
	private Cursor mCursor;
	
	private static String LOG_TAG = "DbAdapter";
	
	public static final String TABLE_TOLLBOOTHS = "Tollbooths";
	public static final String TABLE_FACILITIES = "Facilities";
	public static final String TABLE_HIGHWAY_SEGMENTS = "Highway_Segments";
	public static final String TABLE_MILEPOSTS = "Mileposts";
	
	private static final String ROW_ID = "_id";
	
	private static final String TOLLBOOTH_SECTION_ID = "section_id";
	private static final String TOLLBOOTH_NUM_OF_LANES =  "num_lanes";
	private static final String TOLLBOOTH_COLLECTION_TARGET =  "collection_target";
	private static final String TOLLBOOTH_CURRENT_COLLECTION =  "current_collection";
	private static final String TOLLBOOTH_LATITUDE =  "latitude";
	private static final String TOLLBOOTH_LONGITUDE = "longitude";
	private static final String TOLLBOOTH_UPLOADED_BY_USER =  "uploaded_by_user";
	private static final String TOLLBOOTH_TIMESTAMP = "collection_date";  //format dd-MM-YYYY hh:mm
	
	private static final String FACILITIES_TYPE = "type";
	private static final String FACILITIES_NAME = "name";
	private static final String FACILITIES_OWNER_NAME = "owner_name";
	private static final String FACILITIES_ADDRESS1 = "address1";
	private static final String FACILITIES_ADDRESS2 = "address2";
	private static final String FACILITIES_ADDRESS3 = "address3";
	private static final String FACILITIES_ADDRESS4 = "address4";
	private static final String FACILITIES_ADDRESS5 = "address5";
	private static final String FACILITIES_CITY = "city";
	private static final String FACILITIES_STATE = "state";
	private static final String FACILITIES_PINCODE = "pincode";
	private static final String FACILITIES_PHONE1 = "phone1";
	private static final String FACILITIES_PHONE2 = "phone2";
	private static final String FACILITIES_LATITUDE =  "latitude";
	private static final String FACILITIES_LONGITUDE = "longitude";
	private static final String FACILITIES_UPLOADED_BY_USER =  "uploaded_by_user";
	private static final String FACILITIES_TIMESTAMP = "collection_date"; //format dd-MM-YYYY hh:mm
	
	private static final String HIGHWAY_SEGMENTS_TYPE = "type";
	private static final String HIGHWAY_SEGMENTS_MARKER_TYPE = "marker_type";
	private static final String HIGHWAY_SEGMENTS_NAME = "name";
	private static final String HIGHWAY_SEGMENTS_OWNER_NAME = "owner_name";
	private static final String HIGHWAY_SEGMENTS_CONTACT_NUMBER = "contact_number";
	private static final String HIGHWAY_SEGMENTS_LINESTRING =  "linestring";
	//private static final String HIGHWAY_SEGMENTS_LATITUDE =  "latitude";
	//private static final String HIGHWAY_SEGMENTS_LONGITUDE = "longitude";
	private static final String HIGHWAY_SEGMENTS_UPLOADED_BY_USER =  "uploaded_by_user";
	private static final String HIGHWAY_SEGMENTS_TIMESTAMP = "collection_date";  //format dd-MM-YYYY hh:mm
	
	private static final String MILEPOSTS_LATITUDE = "latitude";
	private static final String MILEPOSTS_LONGITUDE = "longitude";
	private static final String MILEPOSTS_UPLOADED_BY_USER =  "uploaded_by_user";
	private static final String MILEPOSTS_TIMESTAMP = "collection_date";  //format dd-MM-YYYY hh:mm
	
	private static final String CREATE_TABLE_TOLLBOOTH = "create table "+TABLE_TOLLBOOTHS+
													" ("+ROW_ID +" integer primary key autoincrement, "+
													TOLLBOOTH_SECTION_ID +" text not null, "+
													TOLLBOOTH_NUM_OF_LANES +" text not null, "+
													TOLLBOOTH_COLLECTION_TARGET +" text not null, "+
													TOLLBOOTH_CURRENT_COLLECTION +" text not null, "+
													TOLLBOOTH_LATITUDE +" text not null, "+
													TOLLBOOTH_LONGITUDE +" text not null, "+
													TOLLBOOTH_UPLOADED_BY_USER +" text not null, "+
													TOLLBOOTH_TIMESTAMP +" text not null);";
	
	private static final String CREATE_TABLE_FACILITIES = "create table "+TABLE_FACILITIES+
													" ("+ROW_ID +" integer primary key autoincrement, "+
													FACILITIES_TYPE +" text not null, "+
													FACILITIES_NAME +" text not null, "+
													FACILITIES_OWNER_NAME +" text not null, "+
													FACILITIES_ADDRESS1 +" text not null, "+
													FACILITIES_ADDRESS2 +" text not null, "+
													FACILITIES_ADDRESS3 +" text not null, "+
													FACILITIES_ADDRESS4 +" text not null, "+
													FACILITIES_ADDRESS5 +" text not null, "+
													FACILITIES_CITY +" text not null, "+
													FACILITIES_STATE +" text not null, "+
													FACILITIES_PINCODE +" text not null, "+
													FACILITIES_PHONE1 +" text not null, "+
													FACILITIES_PHONE2 +" text not null, "+
													FACILITIES_LATITUDE +" text not null, "+
													FACILITIES_LONGITUDE +" text not null, "+
													FACILITIES_UPLOADED_BY_USER +" text not null, "+
													FACILITIES_TIMESTAMP +" text not null);";
	
	private static final String CREATE_TABLE_HIGHWAY_SEGMENTS = "create table "+TABLE_HIGHWAY_SEGMENTS+
													" ("+ROW_ID +" integer primary key autoincrement, "+
													HIGHWAY_SEGMENTS_TYPE +" text not null, "+
													HIGHWAY_SEGMENTS_MARKER_TYPE +" text not null, "+
													HIGHWAY_SEGMENTS_NAME +" text not null, "+
													HIGHWAY_SEGMENTS_OWNER_NAME +" text not null, "+
													HIGHWAY_SEGMENTS_CONTACT_NUMBER +" text not null, "+
													HIGHWAY_SEGMENTS_LINESTRING +" text not null, "+
//													HIGHWAY_SEGMENTS_LATITUDE +" text not null, "+
//													HIGHWAY_SEGMENTS_LONGITUDE +" text not null, "+
													HIGHWAY_SEGMENTS_UPLOADED_BY_USER +" text not null, "+
													HIGHWAY_SEGMENTS_TIMESTAMP +" text not null);";

	private static final String CREATE_TABLE_MILEPOSTS = "create table "+TABLE_TOLLBOOTHS+
													" ("+ROW_ID +" integer primary key autoincrement, "+
													MILEPOSTS_LATITUDE +" text not null, "+
													MILEPOSTS_LONGITUDE +" text not null, "+
													MILEPOSTS_UPLOADED_BY_USER +" text not null, "+
													MILEPOSTS_TIMESTAMP +" text not null);";
	
	
	public DbAdapter(Context context){
		super(context, DATABASE_NAME, null,
				DATABASE_VERSION);
		mCtx = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE_FACILITIES);
		db.execSQL(CREATE_TABLE_HIGHWAY_SEGMENTS);
		db.execSQL(CREATE_TABLE_MILEPOSTS);
		db.execSQL(CREATE_TABLE_TOLLBOOTH);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int v1, int v2) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_FACILITIES);
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_HIGHWAY_SEGMENTS);
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_MILEPOSTS);
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_TOLLBOOTHS);
		onCreate(db);
	}
	
	public long createTollboothAccount(String section_id, String num_lanes, String collection_target, 
									String current_collection, String latitude, String longitude,
										String uploaded_by_user, String collection_date){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(TOLLBOOTH_SECTION_ID, section_id);
		cv.put(TOLLBOOTH_NUM_OF_LANES, num_lanes);
		cv.put(TOLLBOOTH_COLLECTION_TARGET, collection_target);
		cv.put(TOLLBOOTH_CURRENT_COLLECTION, current_collection);
		cv.put(TOLLBOOTH_LATITUDE, latitude);
		cv.put(TOLLBOOTH_LONGITUDE, longitude);
		cv.put(TOLLBOOTH_UPLOADED_BY_USER, uploaded_by_user);
		cv.put(TOLLBOOTH_TIMESTAMP, collection_date);
		return db.insert(TABLE_TOLLBOOTHS, null, cv);		
	}
	
	
	public long createFacilityAccount(String type, String name, String owner_name, String address1, String address2, String address3, String address4,
										String address5, String city, String state, String pincode, String phone1, String phone2, String latitude, 
										String longitude, String uploaded_by_user, String collection_date){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(FACILITIES_TYPE, type);
		cv.put(FACILITIES_NAME, name);
		cv.put(FACILITIES_OWNER_NAME, owner_name);
		cv.put(FACILITIES_ADDRESS1, address1);
		cv.put(FACILITIES_ADDRESS2, address2);
		cv.put(FACILITIES_ADDRESS3, address3);
		cv.put(FACILITIES_ADDRESS4, address4);
		cv.put(FACILITIES_ADDRESS5, address5);
		cv.put(FACILITIES_CITY, city);
		cv.put(FACILITIES_STATE, state);
		cv.put(FACILITIES_PINCODE, pincode);
		cv.put(FACILITIES_PHONE1, phone1);
		cv.put(FACILITIES_PHONE2, phone2);
		cv.put(FACILITIES_LATITUDE, latitude);
		cv.put(FACILITIES_LONGITUDE, longitude);
		cv.put(FACILITIES_UPLOADED_BY_USER, uploaded_by_user);
		cv.put(FACILITIES_TIMESTAMP, collection_date);
		return db.insert(TABLE_FACILITIES, null, cv);		
	}
	
	public long createHighwaySegmentAccount(String type, String marker_type, String name, String owner_name, String contact_number,
											String linestring, String uploaded_by_user, String collection_date){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(HIGHWAY_SEGMENTS_TYPE, type);
		cv.put(HIGHWAY_SEGMENTS_MARKER_TYPE, marker_type);
		cv.put(HIGHWAY_SEGMENTS_NAME, name);
		cv.put(HIGHWAY_SEGMENTS_OWNER_NAME, owner_name);
		cv.put(HIGHWAY_SEGMENTS_CONTACT_NUMBER, contact_number);
		cv.put(HIGHWAY_SEGMENTS_LINESTRING, linestring);
		cv.put(HIGHWAY_SEGMENTS_UPLOADED_BY_USER, uploaded_by_user);
		cv.put(HIGHWAY_SEGMENTS_TIMESTAMP, collection_date);
		return db.insert(TABLE_HIGHWAY_SEGMENTS, null, cv);		
	}
	
	public long createMilepostAccount(String latitude, String longitude, String uploaded_by_user, String collection_date){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(MILEPOSTS_LATITUDE, latitude);
		cv.put(MILEPOSTS_LONGITUDE, longitude);
		cv.put(MILEPOSTS_UPLOADED_BY_USER, uploaded_by_user);
		cv.put(MILEPOSTS_TIMESTAMP, collection_date);
		return db.insert(TABLE_MILEPOSTS, null, cv);		
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
