package com.ss.poirecorder;

import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;

public class SplashActivity extends Activity {

	Handler splashHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
    }    

    @Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
        splashHandler = new Handler();
        splashHandler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
		        if(gpsIsEnabled()){
		        	startActivity(new Intent(SplashActivity.this, LoginActivity.class));
		        	finish();
		        } else 
		        	buildAlertMessageNoGps();
			}
		}, 3000);
	}
    
	private boolean gpsIsEnabled() {
		// TODO Auto-generated method stub
      	final LocationManager manager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );
	    if (manager.isProviderEnabled( LocationManager.GPS_PROVIDER)) 
	    	return true;
	     else 
	    	return false;	    
	}
    
    private void buildAlertMessageNoGps() {
		  
   	    final AlertDialog.Builder builder = new AlertDialog.Builder(this);
   	    builder.setMessage(getResources().getString(R.string.enableGPS))
   	           .setCancelable(false)
   	           .setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
   	               public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
   	                   startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
   	               }
   	           })
   	           .setNegativeButton(getResources().getString(R.string.exit), new DialogInterface.OnClickListener() {
   	               public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
   	                    dialog.cancel();
   	                    finish();
   	               }
   	           });
   	    final AlertDialog alert = builder.create();
   	    alert.show();
   	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash, menu);
        return true;
    }
}
