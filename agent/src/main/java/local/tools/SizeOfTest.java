package local.tools;

import java.io.File;

/**
 * @author cuixiaoshuang
 * @date 2019-05-22
 **/
public class SizeOfTest {

    public static void main(String[] args) {
        System.out.println(ObjectSizeOf.sizeOf(1));
        System.out.println(ObjectSizeOf.sizeOf(new File("")));
    }
}
