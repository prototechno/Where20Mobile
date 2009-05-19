Create a new project called MapIntent with a MapIntentActivity

Open "res/layout/main.xml" and add a Button to it that will launch our map

Add the following code to the MapIntentActivity onCreate method

	Button btn = (Button)findViewById(R.id.Button01);
	btn.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
        	final Intent myIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:38.899533,-77.036476"));
        	startActivity(myIntent);
			}
	});

The URI should be formatted according to:

	geo:latitude,longitude
	geo:latitude,longitude?z=zoom
	geo:0,0?q=my+street+address
	geo:0,0?q=business+near+city

We can also change it to use streetview

	google.streetview:cbll=lat,lng&cbp=1,yaw,,pitch,zoom&mz=mapZoom