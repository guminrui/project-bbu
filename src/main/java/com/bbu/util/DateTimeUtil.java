package com.bbu.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
        public static String systime(){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String dateStr = simpleDateFormat.format(date);
            return dateStr;
        }
}
