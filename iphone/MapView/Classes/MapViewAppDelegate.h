//
//  MapViewAppDelegate.h
//  MapView
//
//  Created by Dave Johnson on 17/05/09.
//  Copyright __MyCompanyName__ 2009. All rights reserved.
//

#import <UIKit/UIKit.h>

@class MapViewViewController;

@interface MapViewAppDelegate : NSObject <UIApplicationDelegate> {
    UIWindow *window;
    MapViewViewController *viewController;
}

@property (nonatomic, retain) IBOutlet UIWindow *window;
@property (nonatomic, retain) IBOutlet MapViewViewController *viewController;

@end

