//
//  Where20ViewController.h
//  Where20
//
//  Created by Dave Johnson on 10/05/09.
//  Copyright __MyCompanyName__ 2009. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <MapKit/MapKit.h>

@interface Where20ViewController : UIViewController {
	MKMapView *mapView;
}

- (IBAction)showInfo;

@end

