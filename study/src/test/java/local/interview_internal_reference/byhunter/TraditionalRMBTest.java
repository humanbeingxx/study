package local.interview_internal_reference.byhunter;

import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

public class TraditionalRMBTest {

    @Test
    public void testTranslate() {
        Random random = new Random();
        TraditionalRMB func = new TraditionalRMB();
        for (int i = 0; i < 10; i++) {
            int amount = random.nextInt(90000) + 10000;
            System.out.println(amount);
            System.out.println(func.translate(amount));
        }

        for (int i = 0; i < 10; i++) {
            int amount = random.nextInt(9000) + 1000;
            System.out.println(amount);
            System.out.println(func.translate(amount));
        }

        for (int i = 0; i < 10; i++) {
            int amount = random.nextInt(900) + 100;
            System.out.println(amount);
            System.out.println(func.translate(amount));
        }
    }
}