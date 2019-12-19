package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cuixiaoshuang
 * @date 2019-12-19
 **/
public class ReadBinaryWatch {

    public List<String> readBinaryWatch(int num) {
        Set<String> result = new HashSet<>();
        if (num > 8) {
            return new ArrayList<>();
        }
        int hourCanUse = Math.min(num, 3);
        for (int i = 0; i <= hourCanUse; i++) {
            Set<Integer> hours = new HashSet<>();
            Set<Integer> minutes = new HashSet<>();
            compose(0, i, 3, hours, 12);
            compose(0, num - i, 6, minutes, 60);
            for (Integer hour : hours) {
                for (Integer minute : minutes) {
                    result.add(String.format("%d:%02d", hour, minute));
                }
            }
        }
        return new ArrayList<>(result);
    }

    void compose(int num, int numOfBinary, int len, Set<Integer> result, int boundary) {
        if (numOfBinary == 0 && num < boundary) {
            result.add(num);
            return;
        }
        int pos = 0b000001;
        for (int i = 0; i <= len; i++) {
            if ((num & pos) == pos) {
                pos <<= 1;
                continue;
            }
            compose(num | pos, numOfBinary - 1, len, result, boundary);
            pos <<= 1;
        }
    }
}
