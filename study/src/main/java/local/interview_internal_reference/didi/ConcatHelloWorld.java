package local.interview_internal_reference.didi;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/7/7 2:36
 */
public class ConcatHelloWorld {

    private static char[] target = "helloworld".toCharArray();

    public boolean canConcat(String[] words) {
        boolean[] used = new boolean[words.length];
        return tryConcat(words, used, 0);
    }

    private boolean tryConcat(String[] words, boolean[] used, int startIndex) {
        if (startIndex == target.length) {
            return true;
        }
        for (int i = 0; i < words.length; i++) {
            if (!used[i] && startWith(words[i], startIndex)) {
                used[i] = true;
                boolean next = tryConcat(words, used, startIndex + words[i].length());
                if (next) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    private boolean startWith(String prefix, int startIndex) {
        if (prefix.length() > target.length - startIndex) {
            return false;
        }
        for (int i = 0; i < prefix.length(); i++) {
            if (prefix.charAt(i) != target[startIndex + i]) {
                return false;
            }
        }
        return true;
    }
}
