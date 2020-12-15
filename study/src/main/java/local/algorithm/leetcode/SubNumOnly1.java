package local.algorithm.leetcode;

public class SubNumOnly1 {

    private int base = 1000000007;

    public int numSub(String s) {
        String[] split = s.split("0+");
        long count = 0;
        for (String sp : split) {
            count += ((long)sp.length()) * (((long)sp.length()) + 1) / 2;
        }
        return (int) (count % base);
    }
}
