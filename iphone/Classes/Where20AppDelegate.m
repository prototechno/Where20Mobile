//
//  Where20AppDelegate.m
//  Where20
//
//  Created by Dave Johnson on 10/05/09.
//  Copyright __MyCompanyName__ 2009. All rights reserved.
//

#import "Where20AppDelegate.h"
#import "Where20ViewController.h"

@implementation Where20AppDelegate

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
