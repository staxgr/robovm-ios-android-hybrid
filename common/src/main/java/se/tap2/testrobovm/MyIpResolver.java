package se.tap2.testrobovm;

import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executors;


/**
 * Created by antongravestam on 2/11/14.
 */
public class MyIpResolver {

    public static void getMyIp(final IpCallback ipCallback) {

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();

                Preconditions.checkNotNull(gson);

                URL url = null;
                String s = "not set";

                s = getString();

                MyIpResolver myIpResolver = gson.fromJson(s, MyIpResolver.class);

                ipCallback.onIpReply(myIpResolver.origin);

            }
        });


    }

    private static String getString() {
        URL url;
        String s = "";
        try {
            url = new URL("http://httpbin.org/ip");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            s = readStream(in);

            System.err.println(s);

        }
        finally {
            urlConnection.disconnect();
        }

        } catch (Exception e) {
            System.out.println("Error exception");
        }
        return s;
    }

    private static String readStream(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }


    private String origin;



}
