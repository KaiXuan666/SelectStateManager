package com.yun.sample.utils;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by KaiXuan on 2016/4/14.
 */
public class Times {

    /**
     * 根据日期获得星期
     *
     * @param date
     * @param type 0为星期几，1则返回周几
     * @return
     */
    public static String[] getWeekOfDate(Date date, int type) {
        String[] weekDaysName = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        String[] weekZhouName = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        String[] weekDaysCode = {"0", "1", "2", "3", "4", "5", "6"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        String[] week = new String[7];
        for (int x = 0; x < 7; x++) {
            week[x] = type == 0 ? weekDaysName[(intWeek + x) % 7] : weekZhouName[(intWeek + x) % 7];
        }
        return week;
    }

    /**
     * 获取未来七天都是几月几日
     *
     * @param date
     * @param type 0，04-12，1，04月12日
     * @return
     */
    public static String[] getMMDDDate(Date date, int type) {
        String[] str = new String[7];
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        SimpleDateFormat simpleDateFormat =
                type == 0 ? new SimpleDateFormat("MM-dd") : new SimpleDateFormat("M月dd日");

        for (int x = 0; x < 7; x++) {
            date = calendar.getTime();
            str[x] = simpleDateFormat.format(date);
            calendar.add(calendar.DATE, 1);
        }
        return str;
    }
}
