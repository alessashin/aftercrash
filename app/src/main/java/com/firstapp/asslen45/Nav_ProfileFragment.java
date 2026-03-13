package com.firstapp.asslen45;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Nav_ProfileFragment extends Fragment {

    private static final String CHANNEL_ID = "channel_id";

    public Nav_ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav__profile, container, false);

        Button btnPushNotification = view.findViewById(R.id.btn_push_notification);

        if (btnPushNotification != null) {
            btnPushNotification.setOnClickListener(v -> showNotification());
        }

        return view;
    }

    private void showNotification() {
        if (getActivity() == null) return;

        NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

        if (notificationManager != null) {
            // Required for Android 8.0 (Oreo) and higher
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "My Channel", NotificationManager.IMPORTANCE_DEFAULT);
                notificationManager.createNotificationChannel(channel);
            }

            NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity(), CHANNEL_ID)
                    .setSmallIcon(R.drawable.nav_message_24)
                    .setContentTitle("BOOMBOCLAT!")
                    .setContentText("Aslen is connected successfully <3 ")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setAutoCancel(true);

            notificationManager.notify(1, builder.build());
        }
    }
}