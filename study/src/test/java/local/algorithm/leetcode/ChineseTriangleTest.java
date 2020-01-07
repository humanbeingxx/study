package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-01-07
 **/
public class ChineseTriangleTest {

    @Test
    public void testGenerate() {
        List<List<Integer>> generate = new ChineseTriangle().generate(3);
        System.out.println(generate);

        generate = new ChineseTriangle().generate(4);
        System.out.println(generate);

        generate = new ChineseTriangle().generate(5);
        System.out.println(generate);
    }

    @Test
    public void testGetRow() {
        List<Integer> row = new ChineseTriangle().getRow(1);
        System.out.println(row);

        row = new ChineseTriangle().getRow(10);
        System.out.println(row);

        row = new ChineseTriangle().getRow(30);
        System.out.println(row);
    }
}