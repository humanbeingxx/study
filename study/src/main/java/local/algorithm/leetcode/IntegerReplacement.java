package local.algorithm.leetcode;

public class IntegerReplacement {

    public int integerReplacement(int n) {
        int count = 0;
        long value = n;
        while (value > 1) {
            if ((value & 1) == 0) {
                value >>= 1;
                count++;
            } else {
                if (value == 3) {
                    count += 2;
                    break;
                } else {
                    if ((value & 0b10) == 0b10) {
                        value += 1;
                    } else {
                        value -= 1;
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
