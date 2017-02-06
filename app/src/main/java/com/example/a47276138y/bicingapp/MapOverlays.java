package com.example.a47276138y.bicingapp;

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

    //http://www.sgoliver.net/blog/mapas-en-android-iii-overlays-capas/

    private double latitude = 60.169;
    private double longitude = 24.935;


    @Override
    public void draw(Canvas canvas, MapView osmv, boolean shadow) {
        Projection projection = osmv.getProjection();
        GeoPoint geoPoint = new GeoPoint(latitude, longitude);

        if (shadow == false)
        {
            Point centro = new Point();
            projection.toPixels(geoPoint, centro);

            //Definimos el pincel de dibujo
            Paint p = new Paint();
            p.setColor(Color.BLUE);

            //Marca Ejemplo 1: Círculo y Texto
            canvas.drawCircle(centro.x, centro.y, 5, p);
            canvas.drawText("Helsinki", centro.x+10, centro.y+5, p);
        }
    }
}

