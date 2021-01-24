package local.interview_internal_reference.byhunter;

public class NQueue {

    public boolean[][] put(int n) {
        boolean[][] result = new boolean[n][n];
        if (putRec(result, n - 1)) {
            return result;
        }
        return null;
    }

    private boolean putRec(boolean[][] result, int index) {
        if (index < 0) {
            return true;
        }
        for (int i = 0; i < result.length; i++) {
            if (!checkPos(index, i, result)) {
                continue;
            }
            result[index][i] = true;
            if (putRec(result, index - 1)) {
                return true;
            }
            result[index][i] = false;
        }
        return false;
    }

    private boolean checkPos(int i, int j, boolean[][] result) {
        for (int k = 0; k < result.length; k++) {
            if (k != i && result[k][j]) {
                return false;
            }
        }
        int ii = i - 1, jj = j - 1;
        while (ii >= 0 && jj >= 0) {
            if (result[ii--][jj--]) {
                return false;
            }
        }
        ii = i + 1;
        jj = j - 1;
        while (ii < result.length && jj >= 0) {
            if (result[ii++][jj--]) {
                return false;
            }
        }
        ii = i - 1;
        jj = j + 1;
        while (ii >= 0 && jj < result.length) {
            if (result[ii--][jj++]) {
                return false;
            }
        }
        ii = i + 1;
        jj = j + 1;
        while (ii < result.length && jj < result.length) {
            if (result[ii++][jj++]) {
                return false;
            }
        }
        return true;
    }
}
