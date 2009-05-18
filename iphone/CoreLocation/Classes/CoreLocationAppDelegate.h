//
//  CoreLocationAppDelegate.h
//  CoreLocation
//
//  Created by Dave Johnson on 16/05/09.
//  Copyright __MyCompanyName__ 2009. All rights reserved.
//

#import <UIKit/UIKit.h>

@class CoreLocationViewController;

@interface CoreLocationAppDelegate : NSObject <UIApplicationDelegate> {
    UIWindow *window;
    CoreLocationViewController *viewController;
}

@property (nonatomic, retain) IBOutlet UIWindow *window;
@property (nonatomic, retain) IBOutlet CoreLocationViewController *viewController;

@end

