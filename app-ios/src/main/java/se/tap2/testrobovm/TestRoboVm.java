package se.tap2.testrobovm;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegate;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIWindow;


public class TestRoboVm extends UIApplicationDelegateAdapter {

    private UIWindow window = null;
    private int clickCount = 0;

    @Override
    public boolean didFinishLaunching(UIApplication application,
            NSDictionary launchOptions) {
  


        window = new UIWindow(UIScreen.getMainScreen().getBounds());
//        window.setBackgroundColor(UIColor.lightGrayColor());
//        window.addSubview(button);
        window.setRootViewController(new MyViewController());
        window.makeKeyAndVisible();
        
        return true;
    }

    public static void main(String[] args) {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(args, null, TestRoboVm.class);
        pool.drain();
    }
}