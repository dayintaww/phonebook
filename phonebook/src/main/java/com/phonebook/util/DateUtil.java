package com.phonebook.util;

import java.sql.Date;

public class DateUtil {
    public static Date getCurrentDate() {
        long millis = System.currentTimeMillis();
        return new java.sql.Date(millis);
    }
}
