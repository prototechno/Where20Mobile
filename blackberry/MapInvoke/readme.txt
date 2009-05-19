Create a new app called MapInvokeApp

	public class MapInvokeApp extends UiApplication {

Add the main method

	public static void main(String[] args) {
		MapInvokeApp app = new MapInvokeApp();
    	app.enterEventDispatcher();
	}

Add the constructor

	public MapInvokeApp() {
	}

Fill in the constructor

	MainScreen _mainScreen = new MainScreen();

	ButtonField button = new ButtonField("Map it!", ButtonField.CONSUME_CLICK){
        protected boolean trackwheelClick(int status, int time){
            MapInvokeApp.this.mapIt();
            return false;
        }
    };
    _mainScreen.add(button);

Implement the mapIt function

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
