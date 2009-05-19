Download Ganymede

Download the JDE eclipse plugin

Copy the JDE eclipse plugin into the eclipse folder

Create a new project called LocationProviderApp

Make LocationProviderApp extend UiApplication

	public class LocationProviderApp extends UiApplication

Add a blank constructor

	private LocationProviderApp() {

Add the main function where things all start in a RIM app

public static void main(String[] args) {
	LocationProviderApp app = new LocationProviderApp();
    app.enterEventDispatcher();
}

Add the private members 

	private MainScreen _mainScreen;
	private TextField _textField;

Create the UI now in the constructor

	_mainScreen = new MainScreen();

	_textField = new TextField(0);
	_mainScreen.add(_textField);

	pushScreen(_mainScreen);

Now make the LocationProviderApp implement LocationListener

	public class LocationProviderApp extends UiApplication implements LocationListener {

Put in the method stubs for the interface

Add a private LocationProvider to the class

	private LocationProvider _locationProvider;

Instantiate the locationProvider in the constructor

	try {
		_locationProvider = LocationProvider.getInstance(null);
		_locationProvider.setLocationListener(this, 10, 1, 1);
	} catch(Exception ex) {
	}

Fill in the locationUpdate method

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

Run the simulator