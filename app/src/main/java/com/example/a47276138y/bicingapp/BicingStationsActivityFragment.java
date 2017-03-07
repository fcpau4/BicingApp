package com.example.a47276138y.bicingapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
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
            mapController.setZoom(12);
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
                marker.setTitle("\nSTATION NAME: " + station.getStreetName() + "\n" + "BIKES AVAILABLE: " + station.getBike() + "\n");



                if(station.getType().equals("BIKE-ELECTRIC")){


                    if(station.getPercentage()>=90){
                        marker.setIcon(getResources().getDrawable(R.drawable.electric));
                    }else if(station.getPercentage() >65 && station.getPercentage() < 90){
                        marker.setIcon(getResources().getDrawable(R.drawable.electric_three_quarters));
                    }else if(station.getPercentage()>40 && station.getPercentage()<=65 ){
                        marker.setIcon(getResources().getDrawable(R.drawable.half_electric));
                    }else if(station.getPercentage()>15 && station.getPercentage() <=40 ){
                        marker.setIcon(getResources().getDrawable(R.drawable.electric_one_quarter));
                    }else if(station.getPercentage()<=0 || station.getPercentage()<=15){
                        marker.setIcon(getResources().getDrawable(R.drawable.electric_empty));
                    }

                }else{
                    if(station.getPercentage()>=90){
                        marker.setIcon(getResources().getDrawable(R.drawable.regular));
                    }else if(station.getPercentage() >=65 && station.getPercentage() < 89){
                        marker.setIcon(getResources().getDrawable(R.drawable.regular_three_quarters));
                    }else if(station.getPercentage()>40 && station.getPercentage()<=65 ){
                        marker.setIcon(getResources().getDrawable(R.drawable.regular_half));
                    }else if(station.getPercentage()>15 && station.getPercentage() <=40 ){
                        marker.setIcon(getResources().getDrawable(R.drawable.regular_one_quarter));
                    }else if(station.getPercentage()<=0 || station.getPercentage()<=15){
                        marker.setIcon(getResources().getDrawable(R.drawable.regular_empty));
                    }
                }
                map.getOverlays().add(marker);
            }

            map.invalidate();
        }
    }



}
