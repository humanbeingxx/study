package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 15:01
 */
public class DayOfWeek {

    static int firstDay = 5;

    static Map<String, Integer> dict = new HashMap<>();

    static Map<Integer, String> weekDict = new HashMap<>();

    static {
        weekDict.put(1, "Monday");
        weekDict.put(2, "Tuesday");
        weekDict.put(3, "Wednesday");
        weekDict.put(4, "Thursday");
        weekDict.put(5, "Friday");
        weekDict.put(6, "Saturday");
        weekDict.put(0, "Sunday");

        int start = firstDay - 1;
        for (int i = 1971; i <= 2100; i++) {
            for (int j = 1; j <= 12; j++) {
                start = calculateEachDay(start, i, j, dict);
            }
        }
    }

    public static String dayOfTheWeek(int day, int month, int year) {
        return weekDict.get(dict.get(key(year, month, day)));
    }

    static int calculateEachDay(int start, int year, int month, Map<String, Integer> dict) {
        int days = 0, dayOfWeek = start;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            days = 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            days = 30;
        } else if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            days = 29;
        } else {
            days = 28;
        }
        for (int i = 1; i <= days; i++) {
            dayOfWeek = (dayOfWeek + 1) % 7;
            String key = key(year, month, i);
            dict.put(key, dayOfWeek);
        }
        return dayOfWeek;
    }

    static String key(int year, int month, int day) {
        return String.format("%4d-%02d-%02d", year, month, day);
    }
}
