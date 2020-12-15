package local.interview_internal_reference.meituan;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class DeepCopy {

    @SuppressWarnings("unchecked")
    public static <T> T deepCopy(T source) throws Exception {
        if (source == null || isOriginalType(source.getClass())) {
            return source;
        } else if (isArray(source.getClass())) {
            return (T) copyArray(source, source);
        }
        Class<T> clazz = (Class<T>) source.getClass();
        T ins = instantiate(clazz);
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Object sourceVal = field.get(source);
            if (isOriginalType(field.getType())) {
                field.set(ins, sourceVal);
            } else if (isArray(field.getType())) {
                field.set(ins, copyArray(sourceVal, source));
            } else {
                if (sourceVal == source) {
                    field.set(ins, sourceVal);
                } else {
                    field.set(ins, deepCopy(sourceVal));
                }
            }
        }
        return ins;
    }

    private static Object copyArray(Object sourceVal, Object origin) throws Exception {
        if (sourceVal == null) {
            return null;
        }
        Class<?> componentType = sourceVal.getClass().getComponentType();
        int length = Array.getLength(sourceVal);

        Object result = Array.newInstance(componentType, length);
        if (isOriginalType(componentType)) {
            for (int i = 0; i < length; i++) {
                Object obj = Array.get(sourceVal, i);
                Array.set(result, i, obj);
            }
        } else {
            for (int i = 0; i < length; i++) {
                Object obj = Array.get(sourceVal, i);
                if (isSame(obj, origin)) {
                    Array.set(result, i, obj);
                } else {
                    Array.set(result, i, deepCopy(obj));
                }
            }
        }
        return result;
    }

    private static <T> T instantiate(Class<T> clazz) throws Exception {
        Constructor<T> constructor = clazz.getConstructor();
        return constructor.newInstance();
    }

    private static boolean isOriginalType(Class clazz) {
        return clazz == int.class;
    }

    private static boolean isArray(Class clazz) {
        return clazz.isArray();
    }

    private static boolean isSame(Object obj, Object origin) {
        return obj == origin;
    }
}
