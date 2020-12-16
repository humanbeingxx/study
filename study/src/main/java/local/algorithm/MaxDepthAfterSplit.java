package local.algorithm;

public class MaxDepthAfterSplit {

    public int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];
        boolean shouldA = true;
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                if (shouldA) {
                    result[i] = 0;
                    shouldA = false;
                } else {
                    result[i] = 1;
                    shouldA = true;
                }
            } else {
                if (shouldA) {
                    result[i] = 1;
                    shouldA = false;
                } else {
                    result[i] = 0;
                    shouldA = true;
                }
            }
        }
        return result;
    }
}
