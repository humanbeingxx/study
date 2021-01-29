package local.algorithm.nowcoder;

import java.util.Arrays;

public class SearchTreePreToIn {

    public int[] pre2In(int[] preorder) {
        int[] inorder = new int[preorder.length];
        rec(preorder, 0, preorder.length - 1, inorder, 0);
        return inorder;
    }

    private void rec(int[] preorder, int start, int end, int[] inorder, int preLeftCount) {
        if (start > end) {
            return;
        }
        if (start == end) {
            inorder[preLeftCount] = preorder[start];
            return;
        }
        int root = preorder[start];
        int pos = searchPos(preorder, start + 1, end, root);
        if (pos < 0) {
            pos = -pos - 1;
        }
        int leftCount = pos - start - 1;
        inorder[preLeftCount + leftCount] = root;
        rec(preorder, start + 1, pos - 1, inorder, preLeftCount);
        rec(preorder, pos, end, inorder, preLeftCount + leftCount + 1);
    }

    private int searchPos(int[] preorder, int start, int end, int key) {
        int low = start, high = end, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (preorder[mid] == key) {
                return mid;
            } else if (preorder[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -low - 1;
    }
}
