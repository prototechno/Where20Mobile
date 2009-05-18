1. Create new XCode project
2. Add the CoreLocation framework to the project
3. Add the headers to the "Other Sources/CoreLocation_prefix.pch" file
	
	#import <CoreLocation/CoreLocation.h>

4. In the CoreLocationViewController.h file specify a CoreLocationManager instance

	CLLocationManager *locationManager;

6. Add an accessor for the locationManager in the header file

	@property (nonatomic, retain) CLLocationManager *locationManager;  

7. Synthesize the property in the m file

	@synthesize locationManager;

8. In the CoreLocationViewController.m file release the manager in dealloc

	[self.locationManager release];

9. Initialize the locationManager in the m file

	- (void)viewDidLoad {
	    [super viewDidLoad];
		self.locationManager = [[[CLLocationManager alloc] init] autorelease];
		self.locationManager.delegate = self;
		[self.locationManager startUpdatingLocation];
	}

10. In the CoreLocationViewController.h file make the CoreLocationViewController class implement the CLLocationManagerDelegate

	@interface CoreLocationViewController : UIViewController <CLLocationManagerDelegate> {

11. Specify the signature in the header file

	- (void)locationManager:(CLLocationManager *)manager didUpdateToLocation:(CLLocation *)newLocation fromLocation:(CLLocation *)oldLocation;
	- (void)locationManager:(CLLocationManager *)manager didFailWithError:(NSError *)error;

12. Specify the implementation in the m file

	- (void)locationManager:(CLLocationManager *)manager didUpdateToLocation:(CLLocation *)newLocation fromLocation:(CLLocation *)oldLocation { }
	- (void)locationManager:(CLLocationManager *)manager didFailWithError:(NSError *)error { }

13. Almost there. Now we just need to visualize the results.

14. In the header file create a Label member

	IBOutlet UILabel *locationLabel;

15. Now open the CoreLocationViewController.xib file in interface builder

16. Drag a Label control onto the View from the Object Library

17. Control click on the "File's Owner" icon and drag the dot on the locationLable to the Labe control in the View

Look into desiredAccuracy, distanceFilter etc.
Look into how to convert numbers etc to strings.