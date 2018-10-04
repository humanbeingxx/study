package local.jcore;

import org.testng.annotations.Test;

/**
 * @author xiaoshuang.cui
 * @date 2018/9/28 下午8:28
 **/
public class ClassNewSeqTest {

    @Test
    public void testNoCreate() {
        ClassNewSeq.justForClassUsage();
    }

    @Test
    public void test() {
        new ClassNewSeq();
    }

    @Test
    public void testNum() {
        System.out.println(ClassNewSeq.num);
    }
}