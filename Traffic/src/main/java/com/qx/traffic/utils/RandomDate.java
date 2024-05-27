package com.qx.traffic.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDate {
    private static String startDateStr = "2024-05-01 00:00";
    private static String endDateStr = "2024-05-31 23:59";
    private static String format = "yyyy-MM-dd HH:mm";

    public RandomDate() {
    }

    public RandomDate(String startDateStr, String endDateStr, String format) {
        RandomDate.startDateStr = startDateStr;
        RandomDate.endDateStr = endDateStr;
        RandomDate.format = format;
    }

    /**
     * 生成随机日期
     * @return
     */
    public static  Date generateRandomDate() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);

            long startMillis = startDate.getTime();
            long endMillis = endDate.getTime();
            long randomMillisSinceEpoch = ThreadLocalRandom.current().nextLong(startMillis, endMillis);

            Date randomDate = new Date(randomMillisSinceEpoch);

            return randomDate;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
