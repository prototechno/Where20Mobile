//
//  CoreLocationController.m
//  CoreLocation
//
//  Created by Dave Johnson on 16/05/09.
//  Copyright 2009 __MyCompanyName__. All rights reserved.
//

#import "CoreLocationController.h"


@implementation CoreLocationController

@synthesize locationManager;
@synthesize delegate;

- (id)init {
	self = [super init];
	self.locationManager = [[[CLLocationManager alloc] init] autorelease];
	self.locationManager.delegate = self;
//	self.locationManager.desiredAccuracy = CLLocationAccuracy.best;
//	self.locationManager.distanceFilter = 100;
	return self;
}

- (void)locationManager:(CLLocationManager *)manager didUpdateToLocation:(CLLocation *)newLocation fromLocation:(CLLocation *)oldLocation {
	[self.delegate locationUpdate: newLocation];
}

- (void)locationManager:(CLLocationManager *)manager didFailWithError:(NSError *)error {
	[self.delegate locationError: error];
}

- (void)dealloc {
    [self.locationManager release];
    [super dealloc];
}

@end
