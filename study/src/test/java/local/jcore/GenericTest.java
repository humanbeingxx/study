package local.jcore;

import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
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

    private <T extends CharSequence> void getRealTypeInMethod(List<T> list) {
        for (TypeVariable<? extends Class<? extends List>> typeParameter : list.getClass().getTypeParameters()) {
            System.out.println(typeParameter.getName());
        }
        ParameterizedType type = (ParameterizedType)list.getClass().getGenericSuperclass();
        System.out.println(type.getRawType().getTypeName());
        for (Type actualTypeArgument : type.getActualTypeArguments()) {
            System.out.println(actualTypeArgument.getTypeName());
        }
    }

    private void getFieldType(Field field) {
        ParameterizedType genericType = (ParameterizedType)field.getGenericType();
        System.out.println(genericType.getActualTypeArguments()[0].getTypeName());
        System.out.println(field.getType().getTypeName());
    }

    private List<String> listAsField = new ArrayList<>();

    @Test
    public void testRealType() throws NoSuchFieldException {
        List<String> list = Lists.newArrayList();
        list.add("test");

        System.out.println("*********** get in other method ***********");
        getRealTypeInMethod(list);

        System.out.println("*********** get here ***********");
        ParameterizedType genericSuperclass = (ParameterizedType)list.getClass().getGenericSuperclass();
        for (Type actualTypeArgument : genericSuperclass.getActualTypeArguments()) {
            System.out.println(actualTypeArgument.getTypeName());
        }

        Field field = GenericTest.class.getDeclaredField("listAsField");
        getFieldType(field);
    }
}
