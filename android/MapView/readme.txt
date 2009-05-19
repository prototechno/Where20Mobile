Create a new application called MapView with a MapViewActivity

Setup the manifest.xml

	<uses-permission android:name="android.permission.ACCESS_GPS" />
	<uses-permission android:name="android.permission.ACCESS_ASSISTED_GPS" />
	<uses-permission android:name="android.permission.ACCESS_LOCATION" />
	<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
	<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
	<uses-permission android:name="android.permission.INTERNET" />
    
    <application android:icon="@drawable/icon" android:label="@string/app_name"
    	android:theme="@android:style/Theme.NoTitleBar">
    	<uses-library android:name="com.google.android.maps" />

Edit "res/layout/main.xml" and add the MapView

	<com.google.android.maps.MapView
    	android:id="@+id/mapview"
    	android:layout_width="fill_parent"
    	android:layout_height="fill_parent"
    	android:clickable="true"
    	android:apiKey="08qb-XALtcp-stIGtALunnfnQOIJYFV2Pc-IOcA"
	/>

Make the MapViewActivity extend MapActivity

	public class MapActivity extends MapActivity {

Hover over MapActivity and add the import statement then hover over MapViewActivity and create unimplemented methods

Add a private members called mapView and mapOverlays

	private MapView mapView;
	private MapController mapController;
	private List<Overlay> mapOverlays;

Hover over everything and import them

Change onCreate to setup the map

	mapView = (MapView)findViewById(R.id.mapview);
	mapView.setBuiltInZoomControls(true);        
	mapView.setSatellite(true);
	mapController = mapView.getController();	

Now we want to add some overlays.

Create another private member called drawable.

	private Drawable drawable;

Hover over Drawable and import it

Now add the overlay code to onCreate

	mapOverlays = mapView.getOverlays();
	drawable = this.getResources().getDrawable(R.drawable.beer);
	barOverlay = new BarOverlay(drawable);

Now there will be two errors, first there is no drawable named androidmarker and second there is no class called BarOverlay nor a member called barOverlay

Drag in the androidmarker png from the desktop

Add the private member barOverlay

	private BarOverlay barOverlay;

Create the BarOverlay class making it extend from com.google.android.maps.ItemizedOverlay

Autogenerate the constructor and the methods that need to be implemented

Create the following private member in BarOverlay

	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();

In the BarOverlay constructor wrap the drawable in the boundCenterBottom

	super(boundCenterBottom(marker));

Implement BarOverlay.size

	return mOverlays.size();

Implement BarOverlay.createItem

	return mOverlays.get(i);

Add the BarOverlay.addOverlay method

	public void addOverlay(OverlayItem overlay) {
    	mOverlays.add(overlay);
    	populate();
	}

Create the following private member in MapViewActivity

	private LocationManager locationManager;

Hover over LocationManager and import it

At the bottom of onCreate put in 

	locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);

Now edit the layout.xml and change it to relative layout

	<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"

Add a button to the layout

	<Button
		android:id="@+id/button"
		android:layout_width="fill_parent"
		android:layout_height="wrap_content"
		android:text="Map bars!"
	/>

And update the position of the map view

	android:layout_below="@id/button"

Add the button click handler to the onCreate

	Button btn = (Button)findViewById(R.id.button);
	btn.setOnClickListener( new OnClickListener() {
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		
		}
	});

Create Place.java

	public class Place {
		public String name = "";
		public double lat = 0;
		public double lng = 0;
		public Place(String n) {
			this.name = n;
		}
	}

Find YQLParser.java

Now we can implement that onclick handler

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
