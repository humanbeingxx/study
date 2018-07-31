package local.other;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xiaoshuang.cui
 * @date 2018/7/23 上午10:50
 **/
public class SeriTest {

    @Test
    public void test() throws IOException, ClassNotFoundException {
        final MyObject myObject = new MyObject();
        myObject.singleValue = "this is single";
        myObject.multiValue = new InnerObject[]{new InnerObject("value1"), new InnerObject("value2")};
        myObject.listValue = new ArrayList<>();
        myObject.listValue.add(new InnerObject("value3"));
        myObject.listValue.add(new InnerObject("value4"));

        final FileOutputStream fos = new FileOutputStream(new File("/Users/xiaoshuang.cui/temp/object_output"));
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos)) {
            objectOutputStream.writeObject(myObject);
        }

        final FileInputStream fis = new FileInputStream(new File("/Users/xiaoshuang.cui/temp/object_output"));
        try (ObjectInputStream objectInputStream = new ObjectInputStream(fis)) {
            final Object o = objectInputStream.readObject();
            System.out.println(o);
        }
    }

    @Test
    public void testArrayInList() throws NoSuchFieldException, IllegalAccessException {
        final ArrayList<String> list = Lists.newArrayList("a", "b", "c");
        Object[] array = getArray(list);
        System.out.println(Arrays.toString(array));
        list.remove("c");
        System.out.println(Arrays.toString(array));
    }

    private Object[] getArray(ArrayList<String> list) throws NoSuchFieldException, IllegalAccessException {
        final Field elementData = ArrayList.class.getDeclaredField("elementData");
        elementData.setAccessible(true);
        return (Object[]) elementData.get(list);
    }
}
