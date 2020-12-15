package local.algorithm.leetcode;

public class EquationsPossible {

    public boolean equationsPossible(String[] equations) {
        int[] unionSet = new int[26];
        for (int i = 0; i < 26; i++) {
            unionSet[i] = i;
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                mergeUnionSet(unionSet, equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int leftRoot = findRoot(unionSet, equation.charAt(0) - 'a');
                int rightRoot = findRoot(unionSet, equation.charAt(3) - 'a');
                if (leftRoot == rightRoot) {
                    return false;
                }
            }
        }
        return true;
    }

    private void mergeUnionSet(int[] unionSet, int first, int second) {
        int firstRoot = findRoot(unionSet, first);
        int secondRoot = findRoot(unionSet, second);
        unionSet[secondRoot] = firstRoot;
    }

    private int findRoot(int[] unionSet, int node) {
        if (unionSet[node] == node) {
            return node;
        }
        return findRoot(unionSet, unionSet[node]);
    }
}
