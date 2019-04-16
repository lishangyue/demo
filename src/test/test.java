package test;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class test {
    private boolean authenticationl;

    public boolean isAuthenticationl() {
        return authenticationl;
    }

    public void setAuthenticationl(boolean authenticationl) {
        this.authenticationl = authenticationl;
    }

    public static void main(String[] args) throws ParseException {
        /*String s = "2018/09/12 17:30:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date =sdf.parse(s);
        System.out.println(date.getTime());
        System.out.println(new Date().getTime());
        MyStudyEnum e = MyStudyEnum.DATA_SOURCE_COURSE;
        System.out.println(e.equals(MyStudyEnum.DATA_SOURCE_COURSE));
        Set<String> set = new HashSet<>();
        set.add("1");
        System.out.println(set.contains("1"));*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化输出日期
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int num = 6;
        for (int i = 1; i < num; i++) {
            calendar.add(Calendar.MONTH, -i+3);
            Date date = calendar.getTime();
            System.out.println(sdf.format(date));
        }
    }

    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isPhone(String phone) {
        String regexPhone = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        String regexTellQu = "^([0-9]{3,4}-)?[0-9]{7,8}$";
        String regexTell = "^[0-9]{7,8}$";
        if (phone.length() == 11) {
            Pattern p = Pattern.compile(regexPhone);
            Matcher m = p.matcher(phone);
            return m.matches();
        } else if (phone.length() == 13 || phone.length() == 12) {
            Pattern p = Pattern.compile(regexTellQu);
            Matcher m = p.matcher(phone);
            return m.matches();
        } else if (phone.length() == 7 || phone.length() == 8) {
            Pattern p = Pattern.compile(regexTell);
            Matcher m = p.matcher(phone);
            return m.matches();
        } else {
            return false;
        }
    }

    public static String getPercent(int x, int total) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format((float) x / (float) total * 100);
        return result + "%";
    }

    public static Date getYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    public static List<String> dateToMonth(Long startDate, Long endDate) {
        List<String> dates = new ArrayList<>();
        if (startDate != null && endDate == null) {
            Date monthDate = new Date(startDate);
            LocalDate monthLocal = dateToLocalDate(monthDate);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(monthLocal.getYear()).append(".").append(monthLocal.getMonthValue());
            dates.add(stringBuilder.toString());
            return dates;
        }
        // 没有开始时间从2010年1月开始
        if (startDate != null && endDate == null) {
            startDate = 1262275200000L;
        }
        if (startDate != null && endDate != null) {
            validateDate(startDate, endDate);
            Date start = new Date(startDate);
            Date end = new Date(endDate);

            LocalDate startLocal = dateToLocalDate(start);
            LocalDate endLocal = dateToLocalDate(end);

            while (true) {
                dates.add(startLocal.getYear() + "." + startLocal.getMonthValue());
                if (startLocal.getYear() == endLocal.getYear() &&
                        startLocal.getMonthValue() == endLocal.getMonthValue()) {
                    break;
                }
                startLocal = startLocal.plusMonths(1);
            }
            return dates;
        }

        if (startDate == null && endDate == null) {
            LocalDate startLocal = LocalDate.now();
            dates.add(startLocal.getYear() + "." + startLocal.getMonthValue());
        }
        return dates;
    }

    public static Date localDateToDate(LocalDate localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zoneId).toInstant();
        return Date.from(instant);
    }

    public static LocalDate dateToLocalDate(Date date) {
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = date.toInstant();
        LocalDate localDate = LocalDateTime.ofInstant(instant, zoneId)
                .toLocalDate().with(TemporalAdjusters.firstDayOfMonth());
        return localDate;
    }

    public static void validateDate(Long startDate, Long endDate) {
        if (endDate < startDate) {
            System.out.println("-------------------出错了");
        }
    }
}
