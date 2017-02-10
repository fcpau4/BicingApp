package com.example.a47276138y.bicingapp;

import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.infowindow.InfoWindow;

/**
 * Created by 47276138y on 10/02/17.
 */

public class PopUp extends InfoWindow {

    /**
     * @param layoutResId the id of the view resource.
     * @param mapView     the mapview on which is hooked the view
     */
    public PopUp(int layoutResId, MapView mapView) {
        super(layoutResId, mapView);
    }

    @Override
    public void onOpen(Object item) {

    }

    @Override
    public void onClose() {

    }
}
