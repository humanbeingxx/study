package local.algorithm.leetcode.lcci;

import java.util.ArrayList;
import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/20 18:13
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        collect(0, 0, n, temp, result);
        return result;
    }

    private void collect(int left, int right, int n, StringBuilder temp, List<String> result) {
        if (left == n && right == n) {
            result.add(temp.toString());
            return;
        }
        if (left > right) {
            temp.append(')');
            collect(left, right + 1, n, temp, result);
            temp.deleteCharAt(temp.length() - 1);
        }
        if (left < n) {
            temp.append('(');
            collect(left + 1, right, n, temp, result);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
