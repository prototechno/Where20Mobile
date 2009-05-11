//
//  Where20AppDelegate.h
//  Where20
//
//  Created by Dave Johnson on 10/05/09.
//  Copyright __MyCompanyName__ 2009. All rights reserved.
//

#import <UIKit/UIKit.h>

@class Where20ViewController;

@interface Where20AppDelegate : NSObject <UIApplicationDelegate> {
    UIWindow *window;
    Where20ViewController *viewController;
}

@property (nonatomic, retain) IBOutlet UIWindow *window;
@property (nonatomic, retain) IBOutlet Where20ViewController *viewController;

@end

