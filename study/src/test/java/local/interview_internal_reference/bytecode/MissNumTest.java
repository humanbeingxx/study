package local.interview_internal_reference.bytecode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MissNumTest {

    @Test
    public void testFindMissNum() {
        int result = new MissNum().findMissNum();
        System.out.println(result);
//        System.out.println(Integer.MIN_VALUE);
    }
}