package com.example.a47276138y.bicingapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.Projection;
import org.osmdroid.views.overlay.Overlay;

/**
 * Created by 47276138y on 06/02/17.
 */

public class MapOverlays extends Overlay{


    @Override
    public void draw(Canvas canvas, MapView osmv, boolean shadow) {
        Projection projection = osmv.getProjection();
        GeoPoint geoPoint = new GeoPoint(41.23, 2.09);

        if (shadow == false)
        {

            Point centro = new Point();
            projection.toPixels(geoPoint, centro);

            Paint p = new Paint();

            Bitmap bm = BitmapFactory.decodeResource(
                    osmv.getResources(),
                    R.drawable.punter1);

            canvas.drawBitmap(bm, centro.x - bm.getWidth(),
                    centro.y - bm.getHeight(), p);
        }
    }
}

