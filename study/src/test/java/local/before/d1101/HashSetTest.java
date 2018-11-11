package local.before.d1101;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/31 下午10:32
 **/
public class HashSetTest {

    class MyObject {
        Integer num;

        public MyObject(Integer num) {
            this.num = num;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyObject myObject = (MyObject) o;
            return Objects.equals(num, myObject.num);
        }

        @Override
        public int hashCode() {

            return Objects.hash(num);
        }
    }

    @Test
    public void test() {
        HashSet<MyObject> set = new HashSet<>();

        Integer i1 = new Integer(1);
        MyObject o1 = new MyObject(i1);
        set.add(o1);
        Integer i2 = new Integer(1);
        MyObject o2 = new MyObject(i2);
        set.add(o2);

    }
}
