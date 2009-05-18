//
//  CoreLocationViewController.h
//  CoreLocation
//
//  Created by Dave Johnson on 16/05/09.
//  Copyright __MyCompanyName__ 2009. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface CoreLocationViewController : UIViewController <CLLocationManagerDelegate> {
	CLLocationManager *locationManager;
	IBOutlet UILabel *locationLabel;
}

@property (nonatomic, retain) CLLocationManager *locationManager;

- (void)locationManager:(CLLocationManager *)manager didUpdateToLocation:(CLLocation *)newLocation fromLocation:(CLLocation *)oldLocation;

- (void)locationManager:(CLLocationManager *)manager didFailWithError:(NSError *)error;

@end

