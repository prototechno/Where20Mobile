package com.nitobi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ZoomControls;
import android.graphics.drawable.Drawable;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.google.android.maps.MapView;
import com.google.android.maps.MapActivity;
import java.util.List;

public class Where20 extends MapActivity {

	LinearLayout linearLayout;
	MapView mapView;
	
	List<Overlay> mapOverlays;
	Drawable drawable;
	BarOverlay barOverlay;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);        
        mapView.setSatellite(true);
        mapView.setTraffic(true);
        mapView.setStreetView(true);

        mapOverlays = mapView.getOverlays();
		this.drawable = this.getResources().getDrawable(R.drawable.androidmarker);
		barOverlay = new BarOverlay(drawable);
		
		barOverlay.addOverlay(new OverlayItem(new GeoPoint(49240000,-120120000), "foo", "bar"));
		mapOverlays.add(barOverlay);
    }
    
    @Override
    protected boolean isRouteDisplayed() {
    	return false;
    }
}