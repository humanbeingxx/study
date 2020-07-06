package local.interview_internal_reference.didi;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/7/7 2:36
 */
public class ConcatHelloWorld {

    private static char[] target = "helloworld".toCharArray();

    public boolean canConcat(String[] words) {
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
