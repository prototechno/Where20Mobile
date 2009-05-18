//
//  CoreLocationAppDelegate.m
//  CoreLocation
//
//  Created by Dave Johnson on 16/05/09.
//  Copyright __MyCompanyName__ 2009. All rights reserved.
//

#import "CoreLocationAppDelegate.h"
#import "CoreLocationViewController.h"

@implementation CoreLocationAppDelegate

@synthesize window;
@synthesize viewController;


- (void)applicationDidFinishLaunching:(UIApplication *)application {    
    
    // Override point for customization after app launch    
    [window addSubview:viewController.view];
    [window makeKeyAndVisible];
}


- (void)dealloc {
    [viewController release];
    [window release];
    [super dealloc];
}


@end
