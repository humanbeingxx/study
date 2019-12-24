package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-24
 **/
public class QuadTreeIntersect {

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    public Node intersect(Node quadTree1, Node quadTree2) {
        return rec(quadTree1, quadTree2);
    }

    private Node rec(Node t1, Node t2) {
        if (t1.isLeaf && t1.val) {
            return t1;
        }
        if (t2.isLeaf && t2.val) {
            return t2;
        }
        if (t1.isLeaf && t2.isLeaf) {
            return t1;
        }
        if (!t1.isLeaf && t2.isLeaf) {
            return t1;
        }
        if (t1.isLeaf) {
            return t1;
        }

        // !t1.isLeaf && !t1.isLeaf

        t1.topLeft = rec(t1.topLeft, t2.topLeft);
        t1.topRight = rec(t1.topRight, t2.topRight);
        t1.bottomLeft = rec(t1.bottomLeft, t2.bottomLeft);
        t1.bottomRight = rec(t1.bottomRight, t2.bottomRight);

        return t1;
    }
}
