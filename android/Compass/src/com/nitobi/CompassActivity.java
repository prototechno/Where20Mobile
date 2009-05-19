package com.nitobi;

import android.app.Activity;
import android.content.Context;
import android.graphics.*;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;

public class CompassActivity extends Activity implements SensorEventListener {

	private SensorManager mSensorManager;
    private SampleView mView;
    private float[] mValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        mView = new SampleView(this);
        setContentView(mView);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        mSensorManager.registerListener((SensorEventListener)this, mSensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD).get(0), SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onStop()
    {
        mSensorManager.unregisterListener((SensorEventListener)this);
        super.onStop();
    }

    public void onAccuracyChanged(int sensor, int accuracy) {
        // TODO Auto-generated method stub

    }

	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
        mValues = event.values;
        if (mView != null) {
            mView.invalidate();
        }
	}
    
    private class SampleView extends View {
        private Paint   mPaint = new Paint();
        private Path    mPath = new Path();

        public SampleView(Context context) {
            super(context);

            // Construct a wedge-shaped path
            mPath.moveTo(0, -50);
            mPath.lineTo(-20, 60);
            mPath.lineTo(0, 50);
            mPath.lineTo(20, 60);
            mPath.close();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint = mPaint;

            canvas.drawColor(Color.WHITE);

            paint.setAntiAlias(true);
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.FILL);

            int w = canvas.getWidth();
            int h = canvas.getHeight();
            int cx = w / 2;
            int cy = h / 2;

            canvas.translate(cx, cy);
            if (mValues != null) {            
                canvas.rotate(-mValues[0]);
            }
            canvas.drawPath(mPath, mPaint);
        }
    }
}