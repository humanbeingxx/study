package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class ConvertToBase7 {

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int absNum = Math.abs(num);
        while (absNum != 0) {
            int left = absNum % 7;
            sb.append(left);
            absNum /= 7;
        }
        sb.reverse();
        if (num < 0) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }
}
