package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-02-12
 **/
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        List<Integer> newAdd = new ArrayList<>();

        result.add(0);
        for (int i = 0; i < n; i++) {
            int add = 1 << i;
            for (int j = result.size() - 1; j >= 0; j--) {
                newAdd.add(result.get(j) + add);
            }
            result.addAll(newAdd);
            newAdd.clear();
        }

        return result;
    }

}
