package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-17
 **/
public class CalBaseballPoints {

    public int calPoints(String[] ops) {
        int[] points = new int[ops.length];

        int index = 0;
        for (String op : ops) {
            if ("+".equals(op)) {
                points[index] = points[index - 1] + points[index - 2];
                index++;
            } else if ("C".equalsIgnoreCase(op)) {
                points[index - 1] = 0;
                index--;
            } else if ("D".equalsIgnoreCase(op)) {
                points[index] = 2 * points[index - 1];
                index++;
            } else {
                points[index] = Integer.parseInt(op);
                index++;
            }
        }

        int sum = 0;
        for (int point : points) {
            sum += point;
        }
        return sum;
    }

}
