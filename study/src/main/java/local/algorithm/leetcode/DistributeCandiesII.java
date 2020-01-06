package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2020-01-06
 **/
public class DistributeCandiesII {

    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int index = 0, start = 1;

        while (candies > 0) {
            result[index++] += Math.min(start, candies);
            candies -= start;
            start++;
            if (index == num_people) {
                index = 0;
            }
        }
        return result;
    }

    public int[] distributeCandies2(int candies, int num_people) {
        int[] result = new int[num_people];
        int fullTimes = 0;
        while (true) {
            int left = candies - num_people * (fullTimes + 1) * (num_people * (fullTimes + 1) + 1) / 2;
            if (left >= 0) {
                fullTimes++;
            } else {
                candies = candies - num_people * fullTimes * (num_people * fullTimes + 1) / 2;
                break;
            }
        }

        for (int i = 0; i < num_people; i++) {
            result[i] = (i + 1) * fullTimes + num_people * fullTimes * (fullTimes - 1) / 2;
        }

        int start = 1 + fullTimes * num_people;
        for (int i = 0; i < num_people && candies > 0; i++) {
            result[i] += Math.min(candies, start);
            candies -= start;
            start++;
        }
        return result;
    }
}
