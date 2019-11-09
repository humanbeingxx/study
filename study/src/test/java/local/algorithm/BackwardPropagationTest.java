package local.algorithm;

import org.testng.annotations.Test;

import java.math.BigDecimal;

/**
 * @author cuixiaoshuang
 * @date 2019-10-23
 **/
public class BackwardPropagationTest {

    @Test
    public void testDefault() {
        BackwardPropagation.Structure structure = new BackwardPropagation.Structure();
        System.out.println(structure.out_o1());
        System.out.println(structure.out_o2());
        System.out.println(structure.totalException());

        for (int i = 0; i < 1000 && structure.totalException().compareTo(new BigDecimal("0.00000001")) <= 0; i++) {
            structure.fix_round();
        }

        System.out.println();
        System.out.println();
        System.out.println(structure.w1);
        System.out.println(structure.w2);
        System.out.println(structure.w3);
        System.out.println(structure.w4);
        System.out.println(structure.w5);
        System.out.println(structure.w6);
        System.out.println(structure.w7);
        System.out.println(structure.w8);
    }


}