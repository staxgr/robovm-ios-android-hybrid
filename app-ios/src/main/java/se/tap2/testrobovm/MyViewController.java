package se.tap2.testrobovm;


import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSOperationQueue;
import org.robovm.apple.uikit.UIButton;
import org.robovm.apple.uikit.UIButtonType;
import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControlState;
import org.robovm.apple.uikit.UIEvent;
import org.robovm.apple.uikit.UIModalPresentationStyle;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.block.VoidBlock;

/**
 * Created by antongravestam on 2/12/14.
 */
public class MyViewController extends UIViewController {

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        System.err.println("viewDidLoad");

        final UIButton button = UIButton.create(UIButtonType.RoundedRect);
        button.setFrame(new CGRect(15.0f, 121.0f, 200f, 37.0f));


        updateIp(button);

        button.addOnTouchUpInsideListener(new UIControl.OnTouchUpInsideListener() {
            @Override
            public void onTouchUpInside(UIControl control, UIEvent event) {
                updateIp(button);
            }
        });

        getView().addSubview(button);
    }

    private void updateIp(final UIButton button) {


        button.setTitle("Getting IP", UIControlState.Normal);

        MyIpResolver.getMyIp(new IpCallback() {
            @Override
            public void onIpReply(final String ip) {

                NSOperationQueue.getMainQueue().addOperation(new Runnable() {
                    @Override
                    public void run() {
                        button.setTitle("Your IP: " + ip, UIControlState.Normal);
                    }
                });

            }
        });
    }
}
