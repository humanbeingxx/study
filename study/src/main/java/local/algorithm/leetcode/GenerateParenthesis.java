package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-02-06
 **/
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        int sum = 1;
        temp.append("(");
        generate(n - 1, n, sum, result, temp);
        return result;
    }

    private void generate(int leftCount, int rightCount, int sum, List<String> result, StringBuilder temp) {
        if (leftCount == 0 && rightCount == 0) {
            result.add(temp.toString());
            return;
        }
        if (leftCount > 0) {
            temp.append("(");
            generate(leftCount - 1, rightCount, sum + 1, result, temp);
            temp.setLength(temp.length() - 1);
        }
        if (rightCount > 0 && sum > 0) {
            temp.append(")");
            generate(leftCount, rightCount - 1, sum - 1, result, temp);
            temp.setLength(temp.length() - 1);
        }
    }
}
