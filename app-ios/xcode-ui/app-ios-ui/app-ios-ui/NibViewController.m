//
//  NibViewController.m
//  app-ios-ui
//
//  Created by Anton Gravestam on 8/20/14.
//  Copyright (c) 2014 Anton Gravestam. All rights reserved.
//

#import "NibViewController.h"

@interface NibViewController ()

- (IBAction)onValueChange:(id)sender;
@property (weak, nonatomic) IBOutlet UILabel *label;

@property (weak, nonatomic) IBOutlet UISlider *slider;
@end

@implementation NibViewController

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


- (IBAction)onValueChange:(id)sender {
}
@end
