package se.tap2.testrobovm;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.UIButton;
import org.robovm.apple.uikit.UIButtonType;
import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControlState;
import org.robovm.apple.uikit.UIEvent;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.block.VoidBlock;

/**
 * Created by antongravestam on 2/12/14.
 */
public class SomeViewController extends UIViewController {

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        final UIButton button = UIButton.create(UIButtonType.RoundedRect);
        button.setFrame(new CGRect(115.0f, 121.0f, 91.0f, 37.0f));

        button.setTitle("Child", UIControlState.Normal);

        button.addOnTouchUpInsideListener(new UIControl.OnTouchUpInsideListener() {
            @Override
            public void onTouchUpInside(UIControl control, UIEvent event) {
                button.setTitle("Child #", UIControlState.Normal);


                getParentViewController().dismissViewController(true, new Runnable() {
                    @Override
                    public void run() {

                    }
                });


            }
        });

        getView().addSubview(button);
    }
}
