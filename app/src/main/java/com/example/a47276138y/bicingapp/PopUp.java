package com.example.a47276138y.bicingapp;

import android.widget.ImageButton;
import android.widget.RelativeLayout;

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
        RelativeLayout  layout = (RelativeLayout) mView.findViewById(R.id.bubble_layout);
        ImageButton bt_img = (ImageButton) mView.findViewById(R.id.bt_star);
    }

    @Override
    public void onClose() {

    }
}
