package local.jcore;

import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/28 下午5:32
 **/
public class GenericTest {

    class A implements Comparable<A> {

        @Override
        public int compareTo(A o) {
            return 0;
        }
    }

    class B extends A {
    }

    @Test
    public void test1() {
        List<List<List<A>>> param1 = Lists.newArrayList();
        param1.add(Lists.newArrayList());
        param1.get(0).add(Lists.newArrayList(new A()));
        test2(param1);

        List<List<List<B>>> param2 = Lists.newArrayList();
        param2.add(Lists.newArrayList());
        param2.get(0).add(Lists.newArrayList(new B()));
        test2(param2);
    }

    private <T extends Comparable<? super T>> void test2(List<List<List<T>>> param) {
        param.get(0).get(0).get(0);
    }

    @Test
    public void test() {
        String result = testReturn();
        System.out.println(result);
    }

    private String testReturn() {
        try {
            return beforeReturn();
        } finally {
            return beforeFinally();
        }
    }

    private String beforeReturn() {
        System.out.println("before return");
        return "by return";
    }

    private String beforeFinally() {
        System.out.println("before finally");
        return "by finally";
    }
}
