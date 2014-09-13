package com.ss.poirecorder;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class POIActivity extends Activity {

	private Spinner spinnerPoiType;
	private SpinnerAdapter poiAdapter;
	private DbAdapter mDbHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		setTitle("Add Point Of Interest");
		setContentView(R.layout.activity_poi);
		
		mDbHelper = new DbAdapter(this);
		mDbHelper.getWritableDatabase();
		
		spinnerPoiType = (Spinner)findViewById(R.id.spinnerPoiType);
	}
	
	public void save(View v){
		Toast.makeText(getApplicationContext(), "POI Saved", Toast.LENGTH_LONG).show();
		finish();
	}
	
	public void close(View v){
		finish();
	}
	
	private void savePoiRecord(String records){
		mDbHelper.insertPoiRecord(records);
	}
	
	public void uploadToServer(View v){
		new UploadPoiRecords().execute();
	}
	
	public class UploadPoiRecords extends AsyncTask<Void, Void, Void>{

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
