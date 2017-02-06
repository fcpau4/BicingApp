package com.example.a47276138y.bicingapp;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a47276138y.bicingapp.api.BicingAPI;

import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Overlay;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class BicingStationsActivityFragment extends Fragment {

    private MapView map;
    private IMapController mapController;

    public BicingStationsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bicing_stations, container, false);

        MapView map = (MapView) view.findViewById(R.id.map);
        initializeMap();
        setZoom();

        List<Overlay> overlay = map.getOverlays();
        MapOverlays mapOverlays = new MapOverlays();
        overlay.add(mapOverlays);



        return view;
    }




    private void setZoom() {

        GeoPoint startPoint = new GeoPoint(60.169,  24.935);
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
        GetStatonsTask task = new GetStatonsTask();
        task.execute();
    }

    private class GetStatonsTask extends AsyncTask<Void, Void, ArrayList<Station>> {
        @Override

        protected ArrayList<Station> doInBackground(Void... voids) {

            ArrayList<Station> stations = BicingAPI.getStations();

            Log.w("XXXXX", stations.toString());

            return stations;
        }
    }
}
