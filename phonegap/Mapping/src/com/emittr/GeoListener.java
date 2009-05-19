package com.emittr;

import android.content.Context;
import android.location.Location;
import android.webkit.WebView;

public class GeoListener {
	String id;
	String successCallback;
	String failCallback;
    GpsListener mGps; 
    NetworkListener mNetwork;
    Context mCtx;
    private WebView mAppView;
	
	int interval;
	
	GeoListener(String i, Context ctx, int time, WebView appView)
	{
		id = i;
		interval = time;
		mCtx = ctx;
        mGps = new GpsListener(mCtx, interval, this);
        mNetwork = new NetworkListener(mCtx, interval, this);
        mAppView = appView;
	}
	
	void success(Location loc)
	{
		//acc, alt, altacc, head, vel
		String args = loc.getLatitude() + ", " + loc.getLongitude() + ", " + loc.getAccuracy() + ", " + loc.getAltitude() + ", 0, " + loc.getBearing() + ", " + loc.getSpeed();
		/*
		 * We only need to figure out what we do when we succeed!
		 */
		if(id != "global")
		{
			mAppView.loadUrl("javascript:navigator.geolocation.success(" + id + ", " + args + ")");
		}
		else
		{
			mAppView.loadUrl("javascript:navigator.geolocation.gotCurrentPosition(" + args + ")");
			this.stop();
		}
	}
	
	void fail()
	{
		// Do we need to know why?  How would we handle this?
		mAppView.loadUrl("javascript:GeoLocation.fail(" + id + ")");
	}
	
	// This stops the listener
	void stop()
	{
		mGps.stop();
		mNetwork.stop();
	}

	public Location getCurrentLocation() {
		Location loc = mGps.getLocation();
		if (loc == null)
			loc = mNetwork.getLocation();
		return loc;
	}
}
