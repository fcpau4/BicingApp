package com.example.a47276138y.bicingapp;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.a47276138y.bicingapp.api.BicingAPI;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.osmdroid.api.IMapController;
import org.osmdroid.bonuspack.clustering.RadiusMarkerClusterer;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.Overlay;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class BicingStationsActivityFragment extends Fragment {

        private double latBCN = 41.23;
        private double lonBCN = 2.09;
        private MapView map;
        private IMapController mapController;
        private ArrayList<Station> stations;

        public BicingStationsActivityFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.fragment_bicing_stations, container, false);

            map = (MapView) view.findViewById(R.id.map);

            stations = new ArrayList<Station>();

            initializeMap();
            setZoom();

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("message");


            return view;
        }


        private void setZoom() {
            GeoPoint startPoint = new GeoPoint(latBCN,  lonBCN);
            mapController = map.getController();
            mapController.setZoom(9);
            mapController.setCenter(startPoint);
        }


        private void initializeMap(){
            map.setTileSource(TileSourceFactory.MAPNIK);
            map.setBuiltInZoomControls(true);
            map.setMultiTouchControls(true);
        }


        @Override
        public void onStart() {
            super.onStart();
            GetStationsTask task = new GetStationsTask();
            task.execute();
        }


        private class GetStationsTask extends AsyncTask<Void, Void, ArrayList<Station>> {
        @Override

        protected ArrayList<Station> doInBackground(Void... voids) {

            stations = BicingAPI.getStations();

            return stations;
        }



        @Override
        protected void onPostExecute(ArrayList<Station> stations) {

            for (Station station : stations) {

                Marker marker = new Marker(map);
                GeoPoint point = new GeoPoint(
                        Double.parseDouble(station.getLatitude()),
                        Double.parseDouble(station.getLongitude()),
                        Double.parseDouble(station.getAltitude())
                );

                marker.setPosition(point);
                marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
                marker.setTitle("Available: " + station.getBike() + "\n" +
                        "Station: " + station.getStreetName());

                if(station.getType().equals("BIKE-ELECTRIC")){
                    marker.setIcon(getResources().getDrawable(R.drawable.electric));
                }else{
                    marker.setIcon(getResources().getDrawable(R.drawable.regular));
                }

                map.getOverlays().add(marker);

            }


            map.invalidate();
        }
    }


}
