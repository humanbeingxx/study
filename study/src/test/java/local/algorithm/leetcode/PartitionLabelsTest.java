package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static org.testng.Assert.*;

public class PartitionLabelsTest {

    @Test
    public void testPartitionLabels1() {
        List<Integer> result = new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(result);
    }

    @Test
    public void testPartitionLabels2() {
        List<Integer> result = new PartitionLabels().partitionLabels("abcdefg");
        System.out.println(result);
    }

    @Test
    public void testPartitionLabelsRandom() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append((char)(random.nextInt(26) + 'a'));
        }
        System.out.println(sb);
        List<Integer> result = new PartitionLabels().partitionLabels(sb.toString());
        System.out.println(result);
    }
}