package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 233. 数字 1 的个数
 *
 * @author cuixiaoshuang
 * @date 2019-12-20
 **/
public class CountDigitOne {

    Map<Integer, Integer> oneCount = new HashMap<>();

    {
        oneCount.put(1, 1);
        oneCount.put(10, 2);
        int i = 100;
        for (; i < Integer.MAX_VALUE / 10; i *= 10) {
            oneCount.put(i, (oneCount.get(i / 10) - 1) * 10 + i / 10 + 1);
        }
        oneCount.put(i, (oneCount.get(i / 10) - 1) * 10 + i / 10 + 1);
    }

    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        if (oneCount.containsKey(n)) {
            return oneCount.get(n);
        }
        int pos = 1;
        while (n / pos > 1) {
            pos *= 10;
        }
        return rec(n, pos);
    }

    int rec(int num, int pos) {
        if (num == 0) {
            return 0;
        }
        if (num < 10) {
            return 1;
        }
        if (num < pos) {
            return rec(num, pos / 10);
        }
        int kn = num / pos;
        int left = num % pos;
        if (kn == 1) {
            return calc10(kn, pos) + rec(left, pos / 10) + left;
        } else {
            return calc10(kn, pos) + rec(left, pos / 10);
        }
    }

    int calc10(int kn, int pos) {
        if (pos == 0) {
            return 0;
        }
        if (kn == 1) {
            return oneCount.get(pos * kn);
        }
        return pos + kn * (oneCount.get(pos) - 1);
    }
}
