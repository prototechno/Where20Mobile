package com.nitobi;

import net.rim.blackberry.api.invoke.Invoke;
import net.rim.blackberry.api.invoke.MapsArguments;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.container.MainScreen;

public class MapInvokeApp extends UiApplication {

	public static void main(String[] args) {
		MapInvokeApp app = new MapInvokeApp();
        app.enterEventDispatcher();
    }

	private MainScreen _mainScreen;
	
	public MapInvokeApp() {
		MainScreen _mainScreen = new MainScreen();

		ButtonField button = new ButtonField("Map it!", ButtonField.CONSUME_CLICK){
            protected boolean trackwheelClick(int status, int time){
                MapInvokeApp.this.mapIt();
                return false;
            }
        };
        _mainScreen.add(button);

		pushScreen(_mainScreen);
	}
	
	public void mapIt() {
		String route = "<lbs>" + 
				"<location lat='-7569792' lon='4542349' address='Ottawa, ON, CANADA'/>" + 
				"<location lat='-7938675' lon='4367022' address='Toronto, ON, CANADA'/>" + 
			"</lbs>";
		Invoke.invokeApplication(
                Invoke.APP_TYPE_MAPS, 
                new MapsArguments(MapsArguments.ARG_LOCATION_DOCUMENT, 
                route)); 
	}
}
