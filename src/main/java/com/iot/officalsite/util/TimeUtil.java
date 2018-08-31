package com.iot.officalsite.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 李攀 on 2018/1/8.
 */
public class TimeUtil {

    public String time(String start_date, String end_date) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String now = dateFormat.format(new Date());
        try {
            Date now2 = dateFormat.parse(now);
            Date start_date1 = dateFormat.parse(start_date);
            Date end_date1 = dateFormat.parse(end_date);
            Calendar c = Calendar.getInstance();
            c.setTime(end_date1);
            c.add(Calendar.DATE, 1);
            Integer number1 = now2.compareTo(start_date1);
            Integer number2 = now2.compareTo(c.getTime());
            if (number1 > 0 && number2 < 0) {
                return "true";
            }
            return "false";
        } catch (ParseException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
