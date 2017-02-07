package com.example.a47276138y.bicingapp.api;

import android.net.Uri;
import android.util.Log;

import com.example.a47276138y.bicingapp.Station;
import com.example.a47276138y.bicingapp.network_utils.NetworkConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by 47276138y on 31/01/17.
 */

public class BicingAPI {

    final static private String STATIONS_INFO_URL = "http://wservice.viabicing.cat/v2/stations";


    /**This method creates a URL.
     * @return URL
     */
    public static ArrayList<Station> getStations () {

        Uri builtUri = Uri.parse(STATIONS_INFO_URL).buildUpon()
                .build();

        URL url = null;

        try {
            url = new URL(builtUri.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return doCall(url);
    }


    /**
     * It does call to API News and gets raw json to handle.
     * @param url
     * @return json response from API.
     */
    private static ArrayList<Station> doCall(URL url){

        try {
            String jsonResponse = NetworkConnection.NetworkUtils.getResponseFromHttpUrl(url);
            return convertJson(jsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * It converts raw json to objects.
     * @param jsonStations
     * @return ArrayList<Stations>
     */
    public static ArrayList<Station> convertJson(String jsonStations){

        ArrayList<Station> stations = new ArrayList<>();

        try {
            JSONObject data = new JSONObject(jsonStations);

            JSONArray jsonArray = data.getJSONArray("stations");

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonStation = jsonArray.getJSONObject(i);

                Station station = new Station();

                station.setId(jsonStation.getString("id"));
                station.setType(jsonStation.getString("type"));
                station.setAltitude(jsonStation.getString("latitude"));
                station.setLongitude(jsonStation.getString("longitude"));
                station.setStreetName(jsonStation.getString("streetName"));
                station.setStreetNumber(jsonStation.getString("streetNumber"));
                station.setAltitude(jsonStation.getString("altitude"));
                station.setSlots(jsonStation.getString("slots"));
                station.setBike(jsonStation.getString("bikes"));
                station.setStatus(jsonStation.getString("status"));

                stations.add(station);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return stations;

    }


}
