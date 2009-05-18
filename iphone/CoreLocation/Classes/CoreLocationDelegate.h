//
//  CoreLocationDelegate.h
//  CoreLocation
//
//  Created by Dave Johnson on 16/05/09.
//  Copyright 2009 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>


@protocol CoreLocationDelegate
@required
-(void)locationUpdate:(CLLocation *)location;
-(void)locationError:(NSError *)error;
@end
