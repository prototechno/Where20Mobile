//
//  MapUriAppDelegate.m
//  MapUri
//
//  Created by Dave Johnson on 17/05/09.
//  Copyright __MyCompanyName__ 2009. All rights reserved.
//

#import "MapUriAppDelegate.h"
#import "MapUriViewController.h"

@implementation MapUriAppDelegate

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
