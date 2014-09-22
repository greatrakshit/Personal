package com.ss.poirecorder;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class FormTollBooth extends Activity implements FusedLocationListener.LocationListener{
	
	private FusedLocationListener FS;
	private static boolean LOCATION_SET = false;
	EditText editTextCollectionTarget, editTextCurrentCollection;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toll_booth);
		
		editTextCollectionTarget = (EditText) findViewById(R.id.editTextCollectionTarget);
		editTextCurrentCollection = (EditText) findViewById(R.id.editTextCurrentCollection);
		
		editTextCollectionTarget.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub

			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				if(s.length()>0)
					s = s.insert(0, "Rs. ");				
			}
		});
	}


	@Override
	public void onReceiveLocation(Location location) {
		// TODO Auto-generated method stub
		((TextView)findViewById(R.id.textViewDisplayCurrentLocation)).setText(String.valueOf(location.getLatitude())+getResources().getString(R.string.degree)+" N"+
				" "+String.valueOf(location.getLongitude())+getResources().getString(R.string.degree)+" E");
		LOCATION_SET = true;
	}	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		/* Starting Location Listener to fetch user's location */
		
		try {			
			FS = FusedLocationListener.getInstance(getApplicationContext(), this);
			FS.start();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/* Location Listener Ends Here */
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		LOCATION_SET = false;
		Log.d(getClass().getSimpleName(), "TollboothActivity Paused");
		FS.stop();
	}
}
