package com.ss.poirecorder;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;

public class FormTollBooth extends DialogFragment implements FusedLocationListener.LocationListener{
	
	private FusedLocationListener FS;
	private static boolean LOCATION_SET = false;
	EditText editTextCollectionTarget, editTextCurrentCollection;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	    // Get the layout inflater
	    LayoutInflater inflater = getActivity().getLayoutInflater();

	    // Inflate and set the layout for the dialog
	    // Pass null as the parent view because its going in the dialog layout
	    builder.setView(inflater.inflate(R.layout.activity_toll_booth, null))
	    // Add action buttons
	           .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	                   // sign in the user ...
	               }
	           })
	           .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	            	   FormTollBooth.this.getDialog().cancel();
	               }
	           });      
	    return builder.create();
	}
	
	@Override
	public void onReceiveLocation(Location location) {
		// TODO Auto-generated method stub
		((TextView) getActivity().findViewById(R.id.textViewDisplayCurrentLocation)).setText(String.valueOf(location.getLatitude())+getResources().getString(R.string.degree)+" N"+
				" "+String.valueOf(location.getLongitude())+getResources().getString(R.string.degree)+" E");
		LOCATION_SET = true;
	}	
	
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d(getClass().getSimpleName(), "TollboothActivity onStart");
		/* Starting Location Listener to fetch user's location */
		
		try {			
			FS = FusedLocationListener.getInstance(getActivity(), this);
			FS.start();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/* Location Listener Ends Here */
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		LOCATION_SET = false;
		Log.d(getClass().getSimpleName(), "TollboothActivity onStop");
		FS.stop();
	}

}
