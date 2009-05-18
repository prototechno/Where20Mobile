//
//  MapUriAppDelegate.h
//  MapUri
//
//  Created by Dave Johnson on 17/05/09.
//  Copyright __MyCompanyName__ 2009. All rights reserved.
//

#import <UIKit/UIKit.h>

@class MapUriViewController;

@interface MapUriAppDelegate : NSObject <UIApplicationDelegate> {
    UIWindow *window;
    MapUriViewController *viewController;
}

@property (nonatomic, retain) IBOutlet UIWindow *window;
@property (nonatomic, retain) IBOutlet MapUriViewController *viewController;

@end

