package local.other;

import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author xiaoshuang.cui
 * @date 2018/8/3 上午11:49
 **/
public class ModCountTest {

    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("a");
            System.out.println(getArray(list).length);
        }
        System.out.println("add end");

        list.clear();
        System.out.println(getArray(list).length);
    }

    private Object[] getArray(ArrayList list) throws NoSuchFieldException, IllegalAccessException {
        final Field array = ArrayList.class.getDeclaredField("elementData");
        array.setAccessible(true);
        return (Object[]) array.get(list);
    }
}
