Add the IBAction to the header file

	- (IBAction)mapIt:(id)sender;

Add the IBAction to the implementation

	- (IBAction)mapIt:(id)sender {
	}

Connect them up in Interface Builder

	NSString *name = @"bar";

	NSString *latlong = @"-33.874559,151.219575";

	NSString *url = [NSString stringWithFormat: @"http://maps.google.com/maps?q=%@&mrt=yp&ll=%@",
				 [name stringByAddingPercentEscapesUsingEncoding:NSUTF8StringEncoding],
				 [latlong stringByAddingPercentEscapesUsingEncoding:NSUTF8StringEncoding]];	

	[[UIApplication sharedApplication] openURL:[NSURL URLWithString:url]];