package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-20
 **/
public class DayOfYear {

    int[] months = {0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int dayOfYear(String date) {
        String[] split = date.split("-");
        int year = Integer.valueOf(split[0]);
        int month = Integer.valueOf(split[1]);
        int day = Integer.valueOf(split[2]);
        int month2 = 0;
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            month2 = 29;
        } else {
            month2 = 28;
        }
        return dayPass(month, month2) + day;
    }

    private int dayPass(int month, int month2) {
        int pass = 0;
        for (int i = 1; i < month ; i++) {
            if (i == 2) {
                pass += month2;
            } else {
                pass += months[i];
            }
        }
        return pass;
    }
}
