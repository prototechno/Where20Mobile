package com.nitobi;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class LocationManagerActivity extends Activity implements LocationListener {
	
	private LocationManager mLocationManager;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);
	}

    @Override
    public void onStart() {
    	super.onStart();
        this.mLocationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        this.mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 0, this);
    }

    @Override
    public void onStop() {
    	super.onStop();
    	this.mLocationManager.removeUpdates(this);
    }
    
	public void onLocationChanged(Location location) {
		((TextView)this.findViewById(R.id.TextView01))
			.setText(String.valueOf(location.getLatitude()) + ", " + String.valueOf(location.getLongitude()));
	}

	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
	}

	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
	}
}