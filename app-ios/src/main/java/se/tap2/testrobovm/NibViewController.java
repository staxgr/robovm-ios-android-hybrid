package se.tap2.testrobovm;

import org.robovm.apple.uikit.UIButton;
import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UISlider;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.objc.annotation.Property;
import org.robovm.objc.annotation.TypeEncoding;
import org.robovm.rt.bro.annotation.Callback;

/**
 * Created by antongravestam on 8/20/14.
 */
@CustomClass("NibViewController")
public class NibViewController extends UIViewController {


    private UISlider slider;
    private UILabel label;

    public NibViewController() {
        super("NibViewController", null);
    }

    @SuppressWarnings("unused")
    @Callback
    @BindSelector("onValueChange:")
    private static void onValueChange(NibViewController self, Selector sel, UISlider slider) {
        self.updateLabel();
    }

    private void updateLabel() {
        label.setText("" + slider.getValue());
    }


    @SuppressWarnings("unused")
    @TypeEncoding("v@:@")
    @Property
    public void setSlider(UISlider slider) {
        this.slider = slider;
    }

    @SuppressWarnings("unused")
    @TypeEncoding("v@:@")
    @Property
    public void setLabel(UILabel label) {
        this.label = label;
    }
}
