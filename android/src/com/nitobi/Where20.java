package com.nitobi;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ZoomControls;
import android.graphics.drawable.Drawable;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.google.android.maps.MapView;
import com.google.android.maps.MapActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Where20 extends MapActivity {

	LinearLayout linearLayout;
	MapView mapView;
	
	List<Overlay> mapOverlays;
	Drawable droidDrawable;
	Drawable barDrawable;
	BarOverlay meOverlay;
	BarOverlay beerOverlay;
	GpsListener geoListener;
	
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
		this.droidDrawable = this.getResources().getDrawable(R.drawable.androidmarker);
		this.barDrawable = this.getResources().getDrawable(R.drawable.beer);
		meOverlay = new BarOverlay(droidDrawable);
		beerOverlay = new BarOverlay(barDrawable);
		
		geoListener = new GpsListener(this,30000,this);
		double lat = geoListener.getLocation().getLatitude();
		double lon = geoListener.getLocation().getLongitude();
		Log.d("WHERE20","Self geo: (" + lat + ", " + lon + ")");
		// Get the location from the GpsListener, convert to microdegrees and create a GeoPoint.
		GeoPoint myPosition = new GeoPoint((int) (geoListener.getLocation().getLatitude()*1E6),(int) (geoListener.getLocation().getLongitude()*1E6));
		meOverlay.addOverlay(new OverlayItem(myPosition, "foo", "bar"));
		String request = "http://local.yahooapis.com/LocalSearchService/V3/localSearch?appid=YahooDemo&query=beer&latitude=" + lat + "&longitude=" + lon + "&radius=35&output=xml";
		YQLParser yql = new YQLParser(request);
		try {
			yql.parse();
			ArrayList<Place> response = yql.getPlaces();
			int numElements = response.size();
			Log.d("WHERE20","Response size: " + numElements);
			for (int i = 0; i < numElements; i++) {
				Place curPlace = response.get(i);
				Log.d("WHERE20","Parsing new result, name: " + curPlace.name + ", geos: (" + curPlace.geo.lat + ", " + curPlace.geo.lng + ")");				
				int geoLat = (int)(curPlace.geo.lat*1E6);
				int geoLng = (int)(curPlace.geo.lng*1E6);
				GeoPoint barPosition = new GeoPoint(geoLat,geoLng);
				beerOverlay.addOverlay(new OverlayItem(barPosition,curPlace.name,curPlace.name));
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mapOverlays.add(meOverlay);
		mapOverlays.add(beerOverlay);
    }
    
    @Override
    protected boolean isRouteDisplayed() {
    	return false;
    }
}