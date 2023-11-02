package com.goxome.crosshair;

class Constants {


    // json {"url":"http://192.168.205.33:8080/Hello/app_v3.0.1_Other_20150116.apk","versionCode":2,"updateMessage":"Version update information"}

    static final String APK_DOWNLOAD_URL = "url";
    static final String APK_UPDATE_CONTENT = "updateMessage";
    static final String APK_VERSION_CODE = "versionCode";


    static final int TYPE_NOTIFICATION = 2;

    static final int TYPE_DIALOG = 1;

    static final String TAG = "UpdateChecker";

// Add you json url or ip address here 

    static final String UPDATE_URL = "https://raw.githubusercontent.com/Goxome/FPS-Crosshair/main/Server-Config/update.json";
}
