package com.thearktech.slidescape.notifications;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.thearktech.slidescape.entity.Event;

import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Aurelian Cotuna on 4/29/17.
 */

public class SlideScapeMessagingService extends FirebaseMessagingService {

    private static final String TAG = "SlideScapeMessagingServ";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        try {
            JSONObject jsonpObject = new JSONObject(remoteMessage.getData());
            Event event = new ObjectMapper().readValue(jsonpObject.toString(), Event.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
