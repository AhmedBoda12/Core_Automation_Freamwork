package com.boda.utils;

public class TimeManager {

    public static String getTimeStamp() {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
    }

    public static String getCurrentTime() {
        return String.valueOf(System.currentTimeMillis());
    }

}
