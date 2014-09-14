package com.ss.poirecorder;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

public class TollBoothActivity extends DialogFragment implements FusedLocationListener.LocationListener{
	private FusedLocationListener FS;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
		LayoutInflater inflater = getActivity().getLayoutInflater();
		
		builder.setView(inflater.inflate(R.layout.activity_toll_booth, null)).setPositiveButton(R.string.save, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		}).setNegativeButton(R.string.cancel, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				getDialog().cancel();
			}
		});
		return builder.create();
	}

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
			FS = FusedLocationListener.getInstance(getActivity(), this);
			FS.start();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/* Location Listener Ends Here */
	}
	
	
}
