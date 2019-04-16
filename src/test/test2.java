package test;

import redis.clients.jedis.Jedis;

import java.util.Calendar;
import java.util.Date;

public class test2 {
    public static void main(String[] args) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        System.out.println(date);
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +7);
        System.out.println(calendar.getTime());
        long time = calendar.getTimeInMillis()-date.getTime();
        System.out.println(time/1000/60/60/24);
    }
}
