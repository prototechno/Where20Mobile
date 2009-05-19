package com.nitobi;

import java.util.ArrayList;
import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MapViewActivity extends MapActivity {
	
	private MapView mapView;
	private MapController mapController;
	private List<Overlay> mapOverlays;
	private Drawable drawable;
	private BarOverlay barOverlay;
	private LocationManager locationManager;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mapView = (MapView)findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);        
        mapView.setSatellite(true);
        
        mapController = mapView.getController();

        mapOverlays = mapView.getOverlays();
		drawable = this.getResources().getDrawable(R.drawable.beer);
		barOverlay = new BarOverlay(drawable);

		locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
		
		Button btn = (Button)findViewById(R.id.button);
		btn.setOnClickListener( new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

				double lat = location.getLatitude();
				double lng = location.getLongitude();
				
				mapController.setCenter(new GeoPoint((int)(lat*1E6),(int)(lng*1E6)));
				mapController.setZoom(13);

				String request = "http://local.yahooapis.com/LocalSearchService/V3/localSearch?appid=YahooDemo&query=beer&latitude=" + String.valueOf(lat) + "&longitude=" + String.valueOf(lng) + "&radius=35&output=xml";
				YQLParser yql = new YQLParser(request);
				try {
					yql.parse();
					ArrayList<Place> response = yql.getPlaces();
					for (int i = 0; i < response.size(); i++) {
						Place curPlace = response.get(i);
						int geoLat = (int)(curPlace.lat*1E6);
						int geoLng = (int)(curPlace.lng*1E6);
						GeoPoint barPosition = new GeoPoint(geoLat,geoLng);
						barOverlay.addOverlay(new OverlayItem(barPosition,curPlace.name,curPlace.name));
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
				}
				mapOverlays.add(barOverlay);
			}
		});
    }
    
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}