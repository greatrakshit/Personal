package com.ss.poirecorder;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;

public class PoiDialog extends DialogFragment {
	
	
	private static final int facilities = 0;
	private static final int highway_segments = 1;
	private static final int milepost = 2;
	private static final int toll_booth = 3;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
		builder.setTitle(R.string.choose_poi).setItems(R.array.poi_list, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				switch(which){
				case toll_booth:
					Intent tollBooth = new Intent(getActivity(), TollBoothForm.class);
					startActivity(tollBooth);
					break;
				case facilities:
					DialogFragment facilitiesDialog = new FacilitiesDialog();
					facilitiesDialog.show(getFragmentManager(), "facilities");
					break;
				case highway_segments:
					Intent highwaySegment = new Intent(getActivity(), HighwaySegmentForm.class);
					startActivity(highwaySegment);
					break;
				case milepost:
					break;
				}
			}
		});
		return builder.create();
	}
	
}
