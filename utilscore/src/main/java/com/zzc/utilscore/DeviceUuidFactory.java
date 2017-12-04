package com.zzc.utilscore;

import android.Manifest;
import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

public class DeviceUuidFactory {
    private static volatile UUID uuid;

    private DeviceUuidFactory() {
    }

    public static UUID getUuid(Context context) {
        if (uuid == null) {
            synchronized (DeviceUuidFactory.class) {
                if (uuid == null) {
                    final String id = SpUtils.getString(context, Constants.NET_KEY_DEVICE_ID, null);
                    if (id != null) {
                        // Use the ids previously computed and stored in the prefs file
                        uuid = UUID.fromString(id);
                    } else {
                        final String androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
                        // Use the Android ID unless it's broken, in which case fallback on deviceId,
                        // unless it's not available, then fallback on a random number which we store
                        // to a prefs file
                        try {
                            if (!"9774d56d682e549c".equals(androidId)) {
                                uuid = UUID.nameUUIDFromBytes(androidId.getBytes("utf8"));
                            } else {
                                if (AppUtils.checkPermission(context, Manifest.permission.READ_PHONE_STATE)) {
                                    final String deviceId = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
                                    uuid = deviceId != null ? UUID.nameUUIDFromBytes(deviceId.getBytes("utf8")) : UUID.randomUUID();
                                } else {
                                    uuid = UUID.fromString(Installation.id(context));
                                }
                            }
                        } catch (UnsupportedEncodingException e) {

                        }
                        // Write the value out to the prefs file
                        SpUtils.putString(context, Constants.NET_KEY_DEVICE_ID, uuid.toString());
                    }
                }
            }
        }
        return uuid;
    }
}