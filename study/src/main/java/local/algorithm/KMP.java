package local.algorithm;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/9/2 下午4:54
 **/
public class KMP {

    public static int search(String search, String from) {
        if (search.length() < 1 || from.length() < 1) {
            return -1;
        }
        int[] nexts = getNext(search);

        int indexOfSearch = 0;
        int indexOfFrom = 0;

        for (;indexOfFrom < from.length();indexOfFrom++) {
            while (indexOfSearch > 0 && from.charAt(indexOfFrom) != search.charAt(indexOfSearch)) {
                indexOfSearch = nexts[indexOfSearch - 1];
            }
            if (from.charAt(indexOfFrom) == search.charAt(indexOfSearch)) {
                indexOfSearch++;
            }
            if (indexOfSearch == search.length()) {
                return indexOfFrom - search.length() + 1;
            }
        }

        return -1;
    }

    protected static int[] getNext(String str) {
        char[] p = str.toCharArray();
        int[] next = new int[p.length];
        next[0] = 0;
        for (int q = 1, k = 0; q < p.length; ++q) {
            while (k > 0 && p[q] != p[k]) {
                k = next[k - 1];
            }
            if (p[q] == p[k]) {
                k++;
            }
            next[q] = k;
        }
        return next;
    }
}
