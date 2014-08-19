package se.tap2.robovmhybrid;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.TextView;
import se.tap2.testrobovm.IpCallback;
import se.tap2.testrobovm.MyIpResolver;

public class MyIpActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.text);

        MyIpResolver.getMyIp(new IpCallback() {
            @Override
            public void onIpReply(final String ipOrNull) {
                textView.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("Your IP: " + ipOrNull);
                    }
                });
            }
        });
    }

}
