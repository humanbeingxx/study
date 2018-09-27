package local.jcore.err;

import org.testng.annotations.Test;

/**
 * @author xiaoshuang.cui
 * @date 2018/9/26 下午8:28
 **/
public class ClassDefErrorTest {

    @Test
    public void test() throws InterruptedException {
        new Thread(MyClassUser::use).start();
        Thread.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException {
//        new Thread(MyClassUser::use).start();
//        Thread.sleep(1000);
        try {
            MyClassUser.use();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.out.println("*****************");

        try {
            MyClassUser.use();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.out.println(MyClassUser.name);;
    }
}
