Create LocationManager project with LocationManagerActivity

Add the private location manager object

	private LocationManager mLocationManager;

Add the onStart code - note that LocationManager.GPS_PROVIDER could be NETWORK_PROVIDER

@Override
public void onStart() {
	super.onStart();
    this.mLocationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
    this.mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 0, this);
}

Add the onStop code

@Override
public void onStop() {
	super.onStop();
	this.mLocationManager.removeUpdates(this);
}

Compile and we will get errors of course

Make LocationManagerActivity implment LocationListener

	public class LocationManagerActivity extends Activity implements LocationListener {

Hover over the error and generate the method stubs

Now we need somewhere to put the location

Open "res/layout/main.xml" and add a TextView

	<TextView android:text="TextView01" android:id="@+id/TextView01" android:layout_width="wrap_content" android:layout_height="fill_parent"></TextView>

Now go back to our activity and implement the onLocationChanged method

public void onLocationChanged(Location location) {
	((TextView)this.findViewById(R.id.TextView01))
		.setText(String.valueOf(location.getLatitude()) + ", " + String.valueOf(location.getLongitude()));
}

Finally if we run this we will get errors  because of permissions

Add the following to our manifest.xml

<uses-permission android:name="android.permission.ACCESS_GPS" />
<uses-permission android:name="android.permission.ACCESS_ASSISTED_GPS" />
<uses-permission android:name="android.permission.ACCESS_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.INTERNET" />

