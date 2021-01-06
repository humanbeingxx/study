package local.interview_internal_reference.meituan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;
import org.testng.annotations.Test;

public class DeepCopyTest {

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class MyDeepCopy {

        private int num;
        private int[] nums;
        private MyDeepCopy copy;
        private MyDeepCopy[] copies;

    }

    @Test
    public void testDeepCopy() throws Exception {
        MyDeepCopy myDeepCopy1 = new MyDeepCopy(123, new int[]{1, 2, 3}, null, null);
        MyDeepCopy myDeepCopy2 = new MyDeepCopy(456, new int[]{4, 5, 6}, null, null);
        MyDeepCopy myDeepCopy3 = new MyDeepCopy(789, new int[]{7, 8, 9}, null, null);
        MyDeepCopy[] copies = {myDeepCopy1, myDeepCopy2};
        MyDeepCopy myDeepCopyX = new MyDeepCopy(456, new int[]{4, 5, 6}, myDeepCopy3, copies);
        MyDeepCopy myDeepCopyResult = DeepCopy.deepCopy(myDeepCopyX);
        System.out.println(myDeepCopyResult);
    }

    @Test
    public void testDeepCopyThis() throws Exception {
        MyDeepCopy myDeepCopy = new MyDeepCopy(123, new int[]{1, 2, 3}, null, null);
        myDeepCopy.copy = myDeepCopy;
        myDeepCopy.copies = new MyDeepCopy[]{myDeepCopy, myDeepCopy};
        MyDeepCopy result = DeepCopy.deepCopy(myDeepCopy);
        System.out.println(result);
    }

    @Test
    public void testBeanUtils() throws Exception {
        MyDeepCopy myDeepCopy = new MyDeepCopy(123, new int[]{1, 2, 3}, null, null);
        myDeepCopy.copy = myDeepCopy;
        myDeepCopy.copies = new MyDeepCopy[]{myDeepCopy, myDeepCopy};
        MyDeepCopy result = (MyDeepCopy) BeanUtils.cloneBean(myDeepCopy);
        System.out.println(result);
    }
}