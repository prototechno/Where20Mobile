package com.nitobi;

import javax.microedition.location.Location;
import javax.microedition.location.LocationListener;
import javax.microedition.location.LocationProvider;

import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.container.MainScreen;

import net.rim.device.api.ui.component.TextField;

/*
import net.rim.device.api.system.Application;
import net.rim.device.api.system.*;
import net.rim.device.api.system.Alert;
import net.rim.blackberry.api.invoke.*;
*/

public class LocationProviderApp extends UiApplication implements LocationListener {

    public static void main(String[] args) {
    	LocationProviderApp app = new LocationProviderApp();
        app.enterEventDispatcher();
    }

    private MainScreen _mainScreen;
    private TextField _textField;
    private LocationProvider _locationProvider;
    
    /**
     * Constructor.
     */
    private LocationProviderApp() {
 
    	_mainScreen = new MainScreen();
 
        _textField = new TextField(0);
        _mainScreen.add(_textField);
        
        pushScreen(_mainScreen);
        
        try {
        	_locationProvider = LocationProvider.getInstance(null);
        	_locationProvider.setLocationListener(this, 1, 1, 1);
        } catch(Exception ex) {
        	System.out.println("########### could not get location provider");
        }
    }

    private void onClose() {
    	_locationProvider.reset();
        _locationProvider.setLocationListener(null, -1, -1, -1);
    }
    
    private void updateLocation(double lat, double lng)
    {
    	System.out.println("######### updateLocation");
    	_textField.setText(String.valueOf(lat) + ", " + String.valueOf(lng));
    }
    
	public void locationUpdated(LocationProvider provider, Location location) {
		// TODO Auto-generated method stub
		System.out.println("######### locationUpdated");
		if(location.isValid())
        {
            double longitude = location.getQualifiedCoordinates().getLongitude();
            double latitude = location.getQualifiedCoordinates().getLatitude();

            synchronized(this)
            {
                // Now set this somewhere and make it available to the JavaScript
            	LocationProviderApp.this.updateLocation(latitude, longitude);
            }
        }
	}

	public void providerStateChanged(LocationProvider provider, int newState) {
		// TODO Auto-generated method stub
		
	}
     
     /*
    private void updateLocation(double lat, double lng, float speed, float alt, float head)
    {
        System.out.println("**** update location: " + String.valueOf(lat) + ", " + String.valueOf(lng));
        this._lat = lat;
        this._lng = lng;
        this._locationReady = true;
    }
      */
     
     /*
if (_getLocation && _locationReady) {
         cookie += "geolocation: {lat:" + String.valueOf(this._lat) + ",lng:" + String.valueOf(this._lng)+"},";
         _locationReady = false;
             _locationProvider.reset();
             _locationProvider.setLocationListener(null, -1, -1, -1);
       }
      */
}
