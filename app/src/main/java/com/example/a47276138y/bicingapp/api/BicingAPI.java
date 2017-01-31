package com.example.a47276138y.bicingapp.api;

import android.net.Uri;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 47276138y on 31/01/17.
 */

public class BicingAPI {

    final static private String STATIONS_INFO_URL = "http://wservice.viabicing.cat/v2/stations";


    /**This method creates a URL.
     * @return URL
     */
    public static URL BuiltINFOStationsUrl() {

        Uri builtUri = Uri.parse(STATIONS_INFO_URL).buildUpon()
                .build();

        URL url = null;

        try {
            url = new URL(builtUri.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
