package local.algorithm.leetcode;

import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 15:15
 */
public class DayOfWeekTest {

    @Test
    public void testDayOfTheWeek() {
        String day = DayOfWeek.dayOfTheWeek(1, 1, 1971);
        System.out.println(day);

        day = DayOfWeek.dayOfTheWeek(2, 1, 1971);
        System.out.println(day);

        day = DayOfWeek.dayOfTheWeek(31, 1, 1971);
        System.out.println(day);

        day = DayOfWeek.dayOfTheWeek(1, 2, 1971);
        System.out.println(day);

        day = DayOfWeek.dayOfTheWeek(1, 1, 1972);
        System.out.println(day);
    }

    @Test
    public void testDayOfTheWeek2() {
        String day = DayOfWeek.dayOfTheWeek(15, 12, 2019);
        System.out.println(day);
    }

    @Test
    public void testDayOfTheWeek3() {
        String day = DayOfWeek.dayOfTheWeek(25, 12, 2019);
        System.out.println(day);
    }

    @Test
    public void testDayOfTheWeek4() {
        String day = DayOfWeek.dayOfTheWeek(28, 2, 2019);
        System.out.println(day);
    }
}