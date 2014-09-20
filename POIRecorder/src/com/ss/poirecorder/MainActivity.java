package com.ss.poirecorder;

import java.lang.reflect.Field;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.location.Location;
import android.os.Bundle;
import android.app.Activity;
import android.app.DialogFragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;

public class MainActivity extends Activity implements FusedLocationListener.LocationListener{

	private GoogleMap map;
	private static LatLng googleLatLon;
	private FusedLocationListener FS;
	private boolean zoomIsInitialized = false;
	private static String TAG;
	//private Button buttonAddPOI;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle(getResources().getString(R.string.app_name));
		
		TAG = getClass().getSimpleName();
		
		map = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
		
		/* View Configuration to force activity to display Overflow Menu 
		 * Works on the Samsung Galaxy S3 and S4, but not on the LG G2 */
	    try {
	        ViewConfiguration config = ViewConfiguration.get(this);
	        Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
	        if(menuKeyField != null) {
	            menuKeyField.setAccessible(true);
	            menuKeyField.setBoolean(config, false);
	        }
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	    /* View Configuration Ends Here */
	}
	
	

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d(TAG, "MainActivity Paused");
		FS.stop();
		FS = null;
	}



	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d(TAG, "MainActivity Resumed");
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
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.menu_addPoi:
			//startActivity(new Intent(MainActivity.this, PoiDialog.class));
			showPoiListDialog();
			break;
		case R.id.menu_uploadToServer:
			break;
		case R.id.menu_logout:
			finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	private void showPoiListDialog() {
		// TODO Auto-generated method stub
		DialogFragment poiDialog = new PoiDialog();
		poiDialog.show(getFragmentManager(), "poi");
	}

	@Override
	public void onReceiveLocation(Location location) {
		// TODO Auto-generated method stub
		
		/* Location received from FusedLocationListener class
		 * Shows received location on map */
		Log.d(getClass().getSimpleName(), "Location Received by MainActivity");
		googleLatLon = new LatLng(location.getLatitude(), location.getLongitude());
		map.clear();
		map.addMarker(new MarkerOptions().position(googleLatLon).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
		if(!zoomIsInitialized){
			CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(googleLatLon, 10);
			map.animateCamera(yourLocation);
			zoomIsInitialized = true;
		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}	
	
	
}
