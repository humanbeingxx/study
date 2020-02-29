package local.algorithm.leetcode;

public class RotateSquare {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return;
        }
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            rotateLevel(matrix, i, i, n - i - 1, n - i -1);
        }
    }

    private void rotateLevel(int[][] matrix, int startX, int startY, int endX, int endY) {
        for (int i = 0; i < endX - startX ; i++) {
            //up
            int tempRight = matrix[i + startY][endY];
            matrix[i + startY][endY] = matrix[startX][startY + i];

            //right
            int tempDown = matrix[endX][endY - i];
            matrix[endX][endY - i] = tempRight;

            //down
            int tempLeft = matrix[endX - i][startY];
            matrix[endX - i][startY] = tempDown;

            //left
            matrix[startX][startY + i] = tempLeft;
        }
    }
}
