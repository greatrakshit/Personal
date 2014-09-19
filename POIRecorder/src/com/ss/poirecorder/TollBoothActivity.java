package com.ss.poirecorder;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

public class TollBoothActivity extends Activity implements FusedLocationListener.LocationListener{
	private FusedLocationListener FS;


	@Override
	public void onReceiveLocation(Location location) {
		// TODO Auto-generated method stub
		Log.d(getClass().getSimpleName(), "Location Received by TollBooth");
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d(getClass().getSimpleName(), "TollBooth Paused");
		FS.stop();
	}

	@Override
	public void onResume() {
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
	
	
}
