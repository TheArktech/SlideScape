package com.thearktech.slidescape.service;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by tudor on 4/29/17.
 */

public class InternetStateListener extends BroadcastReceiver {
    private static final String TAG = InternetStateListener.class.getSimpleName();

    // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 0; // 1 -> 10 meters
    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 0; // 1 -> 1 minute

    @Override
    public void onReceive(final Context context, Intent intent) {
        Log.d(TAG, "Network state changed");

        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean internetActive = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        if (!internetActive) {
            Log.d(TAG, "No internet");
            return;
        }

        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "No permission for location");
            return;
        }

        Log.d(TAG, "gps provider enabled: " + lm.isProviderEnabled(LocationManager.GPS_PROVIDER));
        Log.d(TAG, "network provider enabled: " + lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER));

        String provider;
        if (lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            provider = LocationManager.GPS_PROVIDER;
        } else if (lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            provider = LocationManager.NETWORK_PROVIDER;
        } else {
            Log.d(TAG, "No provider enabled");
            return;
        }

        Log.d(TAG, "requestLocationUpdates");
        lm.requestLocationUpdates(provider, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                double longitude = location.getLongitude();
                Log.d(TAG, "onLocationChanged: ");
                double latitude = location.getLatitude();

                Geocoder gcd = new Geocoder(context, Locale.getDefault());
                try {
                    List<Address> locations = gcd.getFromLocation(latitude, longitude, 1);
                    Log.d(TAG, "Locations received: " + locations.size());
                    if (locations.size() < 1) {
                        Log.d(TAG, "No location found");
                        return;
                    }
                    Address addr = locations.get(0);
                    Log.d(TAG, "Addr = " + addr.getLocality());
                } catch (IOException e) {
                    Log.d(TAG, "Error: " + e.getMessage(), e);
                    e.printStackTrace();
                }
                // subscribe to firebase
                // TODO
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                Log.d(TAG, "onStatusChanged: ");
            }

            @Override
            public void onProviderEnabled(String provider) {
                Log.d(TAG, "onProviderEnabled: ");
            }

            @Override
            public void onProviderDisabled(String provider) {
                Log.d(TAG, "onProviderDisabled: " + provider);
            }
        });
        lm.getLastKnownLocation(provider);
    }
}
