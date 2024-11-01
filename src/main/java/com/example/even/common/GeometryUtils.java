package com.example.even.common;

import static java.lang.Math.cos;
import static java.lang.Math.toRadians;

public class GeometryUtils {

    private static final double METERS_PER_DEGREE_LAT = 111320;
    private static final double EARTH_RADIUS = 6378137;

    public static double[] getMapBounds(double centerLat, double centerLon, int zoom) {
        // Scale factor based on zoom level
        double scale = 1 << zoom;

        // Calculate the span in degrees for the current zoom level
        double halfSpanLatDegrees = (METERS_PER_DEGREE_LAT / scale) / METERS_PER_DEGREE_LAT;
        double halfSpanLonDegrees = (METERS_PER_DEGREE_LAT / scale) / (METERS_PER_DEGREE_LAT * cos(toRadians(centerLat)));

        // Calculate the corner coordinates
        double lowerLeftLat = centerLat - halfSpanLatDegrees;
        double lowerLeftLon = centerLon - halfSpanLonDegrees;
        double upperRightLat = centerLat + halfSpanLatDegrees;
        double upperRightLon = centerLon + halfSpanLonDegrees;

        return new double[]{lowerLeftLat, lowerLeftLon, upperRightLat, upperRightLon};
    }
}
