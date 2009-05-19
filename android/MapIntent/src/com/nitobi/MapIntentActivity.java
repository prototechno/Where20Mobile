package com.nitobi;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MapIntentActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btn = (Button)findViewById(R.id.Button01);
        btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
		        final Intent myIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:38.899533,-77.036476"));
		        startActivity(myIntent);
			}
        });
    }
}