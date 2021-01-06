package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/22 15:59
 */
public class AlienSorted {

    public boolean isAlienSorted(String[] words, String order) {
        int[] indices = new int[26];
        for (int i = 0; i < order.length(); i++) {
            indices[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isOrdered(words[i], words[i + 1], indices)) {
                return false;
            }
        }
        return true;
    }

    boolean isOrdered(String a, String b, int[] indices) {
        for (int i = 0; i < a.length(); i++) {
            if (i >= b.length()) {
                return false;
            }
            int indexA = indices[a.charAt(i) - 'a'];
            int indexB = indices[b.charAt(i) - 'a'];
            if (indexA < indexB) {
                return true;
            } else if (indexA > indexB) {
                return false;
            }
        }
        return true;
    }
}
