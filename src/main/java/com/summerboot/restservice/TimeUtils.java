package com.summerboot.restservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtils {
    public static void changeFormatTime() throws ParseException {
        String input = "2022-01-01T12:00:00Z";
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = inputFormat.parse(input);
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String output = outputFormat.format(date);
        System.out.println(output);
    }

    public static void main(String[] args) {
        System.out.println("".startsWith("SMS_"));
    }
}
