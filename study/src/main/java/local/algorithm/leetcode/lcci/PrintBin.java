package local.algorithm.leetcode.lcci;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/22 19:34
 */
public class PrintBin {

    public String printBin(double num) {
        double posValue = 0.5;
        StringBuilder sb = new StringBuilder("0.");
        while (num != 0 && sb.length() <= 32) {
            if (num >= posValue) {
                num -= posValue;
                sb.append(1);
            } else {
                sb.append(0);
            }
            posValue /= 2;
        }
        if (sb.length() > 32) {
            return "ERROR";
        } else {
            return sb.toString();
        }
    }
}
