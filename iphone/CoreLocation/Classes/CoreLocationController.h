//
//  CoreLocationController.h
//  CoreLocation
//
//  Created by Dave Johnson on 16/05/09.
//  Copyright 2009 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>


@interface CoreLocationController : NSObject <CLLocationManagerDelegate> {
	CLLocationManager *locationManager;
	id delegate;
}

@property (nonatomic, retain) CLLocationManager *locationManager;  
@property (nonatomic, assign) id delegate;

- (void)locationManager:(CLLocationManager *)manager didUpdateToLocation:(CLLocation *)newLocation fromLocation:(CLLocation *)oldLocation;

- (void)locationManager:(CLLocationManager *)manager didFailWithError:(NSError *)error;

@end
