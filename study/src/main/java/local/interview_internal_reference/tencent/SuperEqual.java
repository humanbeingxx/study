package local.interview_internal_reference.tencent;

import java.lang.reflect.Field;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/7/9 0:35
 */
public class SuperEqual {

    @Override
    public int hashCode() {
        Field[] fields = this.getClass().getDeclaredFields();
        int hashcode = 0;
        for (Field field : fields) {
            try {
                Object val = field.get(this);
                hashcode += val == null ? 0 : val.hashCode();
            } catch (IllegalAccessException e) {
                throw new RuntimeException();
            }
        }
        return hashcode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object val1 = field.get(this);
                Object val2 = field.get(obj);
                if (!val1.equals(val2)) {
                    return false;
                }
            }
            return super.equals(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException();
        }

    }


}
