package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathInZigZagTree {

    public List<Integer> pathInZigZagTree(int label) {
        int level = 0, levelMaxVal = 1;
        while (label > levelMaxVal) {
            level++;
            levelMaxVal = (levelMaxVal + 1) * 2 - 1;
        }
        List<Integer> result = new ArrayList<>();
        result.add(label);
        int preNode, preLevelMin, preLevelMax;
        while (level > 0) {
            preLevelMin = (levelMaxVal + 1) / 4;
            preLevelMax = (levelMaxVal + 1) / 2 - 1;
            if (label % 2 == 0) {
                preNode = label / 2;
            } else {
                preNode = (label - 1) / 2;
            }
            preNode = preLevelMax + preLevelMin - preNode;
            result.add(preNode);
            label = preNode;
            level--;
            levelMaxVal = preLevelMax;
        }
        Collections.reverse(result);
        return result;
    }
}
