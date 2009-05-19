Create a new application CompassActivity

Add property SensorManager

	private SensorManager mSensorManager;

onCreate instantiate the sensor manager

	mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
	
Make the CompassActivity implement SensorEventListener

	public class CompassActivity extends Activity implements SensorEventListener {

Hover over SensorEventListener and create the required stubs

Implement onResume

	@Override
	protected void onResume()
	{
    	super.onResume();
    	mSensorManager.registerListener((SensorEventListener)this, mSensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD).get(0), SensorManager.SENSOR_DELAY_GAME);
	}

To make sure that things are working well we should also implement onStop

	@Override
	protected void onStop()
	{
    	mSensorManager.unregisterListener((SensorEventListener)this);
    	super.onStop();
		}

Emulator "telnet localhost 5554"