package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LexicalOrderN {

        public List<Integer> lexicalOrder(int n) {
            List<Integer> result = new ArrayList<>();
            for (int i = 1; i <= 9; i++) {
                rec(i, n, result);
            }
            return result;
        }

        private void rec(int num, int n, List<Integer> result) {
            if (num > n) {
                return;
            }
            result.add(num);
            for (int i = 0; i <= 9; i++) {
                rec(num * 10 + i, n, result);
            }
        }
}
