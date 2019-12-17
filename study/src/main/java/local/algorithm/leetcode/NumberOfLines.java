package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-17
 **/
public class NumberOfLines {

    public int[] numberOfLines(int[] widths, String S) {
        int lineNum = 1;
        int currentLeft = 100;
        for (char c : S.toCharArray()) {
            int width = widths[c - 'a'];
            if (currentLeft < width) {
                currentLeft = 100 - width;
                lineNum++;
            } else {
                currentLeft = currentLeft - width;
            }
        }
        return new int[]{lineNum, 100 - currentLeft};
    }
}
