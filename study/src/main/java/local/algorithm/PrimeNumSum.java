package local.algorithm;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/3 23:06
 */
public class PrimeNumSum {

    public static long sum(int end) {
        if (end <= 1) {
            return -1;
        }
        long sum = 2;
        List<Integer> save = Lists.newArrayList(2);

        outer :for (int i = 3; i <= end; i++) {
            for (Integer integer : save) {
                if (i % integer == 0) {
                    continue outer;
                }
            }
            save.add(i);
        }

        return save.stream().reduce((i, k) -> i + k).get();
    }
}
