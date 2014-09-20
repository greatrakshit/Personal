
package com.ss.poirecorder;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbAdapter extends SQLiteOpenHelper {
	
	final static String DATABASE_NAME = "poi_db";
	final static int VERSION = 1;
	
	private static String LOG_TAG = null;
	
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
	private static final String HIGHWAY_SEGMENTS_LATITUDE =  "latitude";
	private static final String HIGHWAY_SEGMENTS_LONGITUDE = "longitude";
	private static final String HIGHWAY_SEGMENTS_UPLOADED_BY_USER =  "uploaded_by_user";
	private static final String HIGHWAY_SEGMENTS_TIMESTAMP = "collection_date";  //format dd-MM-YYYY hh:mm
	
	private static final String MILEPOSTS_LATITUDE = "latitude";
	private static final String MILEPOSTS_LONGITUDE = "longitude";
	private static final String MILEPOSTS_UPLOADED_BY_USER =  "uploaded_by_user";
	private static final String MILEPOSTS_TIMESTAMP = "timestamp";  //format dd-MM-YYYY hh:mm
	
	public DbAdapter(Context context){
		super(context, DATABASE_NAME, null,
				VERSION);		
		LOG_TAG = getClass().getSimpleName();
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
