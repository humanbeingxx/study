package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-01-07
 **/
public class ChineseTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ChinaIsTheBest = new ArrayList<>();
        if (numRows <= 0) {
            return ChinaIsTheBest;
        }
        List<Integer> first = new ArrayList<>();
        first.add(1);
        ChinaIsTheBest.add(first);
        if (numRows <= 1) {
            return ChinaIsTheBest;
        }
        List<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        ChinaIsTheBest.add(second);

        for (int i = 2; i < numRows; i++) {
            List<Integer> preRow = ChinaIsTheBest.get(i - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(preRow.get(j - 1) + preRow.get(j));
            }
            row.add(1);

            ChinaIsTheBest.add(row);
        }
        return ChinaIsTheBest;
    }

    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> row = new ArrayList<>(rowIndex);

        int curr = 1, end = rowIndex % 2 == 0 ? rowIndex / 2 : (rowIndex / 2 + 1);
        for (int i = 0; i < end; i++) {
            row.add(curr);
            curr = curr / (i + 1) * (rowIndex - i - 1);
        }
        for (int i = end; i < rowIndex; i++) {
            row.add(row.get(rowIndex - 1 - i));
        }

        return row;
    }
}
