package local.algorithm.leetcode;

import local.algorithm.leetcode.QuadTreeIntersect.Node;
import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2019-12-24
 **/
public class QuadTreeIntersectTest {

    @Test
    public void testIntersect1() {
        Node t1 = new Node(true, false,
                new Node(true, true, null, null, null, null),
                new Node(true, true, null, null, null, null),
                new Node(false, true, null, null, null, null),
                new Node(false, true, null, null, null, null));
        Node t2 = new Node(true, false,
                new Node(true, true, null, null, null, null),
                new Node(true, false,
                        new Node(false, true, null, null, null, null),
                        new Node(false, true, null, null, null, null),
                        new Node(true, true, null, null, null, null),
                        new Node(true, true, null, null, null, null)),
                new Node(true, true, null, null, null, null),
                new Node(false, true, null, null, null, null));

        Node result = new QuadTreeIntersect().intersect(t1, t2);
        System.out.println(result);
    }

    @Test
    public void testIntersect2() {
        Node t1 = new Node(true, false,
                new Node(true, true, null, null, null, null),
                new Node(true, false,
                        new Node(false, true, null, null, null, null),
                        new Node(true, true, null, null, null, null),
                        new Node(true, true, null, null, null, null),
                        new Node(true, true, null, null, null, null)),
                new Node(false, true, null, null, null, null),
                new Node(false, true, null, null, null, null));
        Node t2 = new Node(true, false,
                new Node(true, true, null, null, null, null),
                new Node(true, false,
                        new Node(false, true, null, null, null, null),
                        new Node(false, true, null, null, null, null),
                        new Node(false, true, null, null, null, null),
                        new Node(true, true, null, null, null, null)),
                new Node(true, true, null, null, null, null),
                new Node(false, true, null, null, null, null));

        Node result = new QuadTreeIntersect().intersect(t1, t2);
        System.out.println(result);
    }
}