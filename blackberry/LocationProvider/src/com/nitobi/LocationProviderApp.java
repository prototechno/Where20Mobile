package com.nitobi;

import javax.microedition.location.Location;
import javax.microedition.location.LocationListener;
import javax.microedition.location.LocationProvider;

import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.container.MainScreen;

import net.rim.device.api.ui.component.TextField;

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
        }
    }
    
	public void locationUpdated(LocationProvider provider, Location location) {
		// TODO Auto-generated method stub
		if(location.isValid())
        {
            double longitude = location.getQualifiedCoordinates().getLongitude();
            double latitude = location.getQualifiedCoordinates().getLatitude();

            synchronized(this)
            {
                // Now set this somewhere and make it available to the JavaScript
            	LocationProviderApp.this._textField.setText(String.valueOf(latitude) + ", " + String.valueOf(longitude));
            }
        }
	}

	public void providerStateChanged(LocationProvider provider, int newState) {
		// TODO Auto-generated method stub
		
	}
}
