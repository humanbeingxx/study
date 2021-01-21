package local.interview_internal_reference.byhunter;

import com.google.common.collect.Lists;

import java.util.List;

public class PrimeInN {

    public List<Integer> primeInN(int n) {
        List<Integer> result = Lists.newArrayList();
        boolean[] numbers = new boolean[n + 2];
        for (int index = 2; index <= n; index++) {
            if (!numbers[index]) {
                result.add(index);
                int forwardIndex = index;
                while (forwardIndex <= n) {
                    numbers[forwardIndex] = true;
                    forwardIndex += index;
                }
            }
        }
        return result;
    }
}
