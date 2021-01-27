package local.algorithm.nowcoder;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MinWindowTest {

    @Test
    public void testMinWindow1() {
        String result = new MinWindow().minWindow("ABCCAAEDE", "BDE");
        System.out.println(result);
    }

    @Test
    public void testMinWindow2() {
        String result = new MinWindow().minWindow("ABCCAAEDE", "ABDEE");
        System.out.println(result);
    }

    @Test
    public void testMinWindow3() {
        String result = new MinWindow().minWindow("XDOYEZODEYXNZ", "XYZ");
        System.out.println(result);
    }

    @Test
    public void testMinWindow4() {
        String result = new MinWindow().minWindow("wyqaalfdtavrmkvrgbrmauenibfxrzjpzzqzlveexayjkvdsyueboloymtvfugvtgnutkyzhaztlvwdvqkwgvmejhbpdimwqbslnrkutkpehnkefwblrprcxvtaffzxitivmssgehklvwqastojihmhcfkhnlexemtrhnxlujxrgpuyiikspycufodubisfwnydaxrwhqqpfkppuzjlzlfhbjbcttkriixkiohpexgjjvafxjqyvyfyjhbccltlvsvdgeumdavoyxtvhmtekzctidxkqsxmlvrrzmefobtmznhizdmlcoemudwkvuyirscqegvsjrfkgoshrgsvvyhrbgdycehtwjlcrjucabpgsjnjqhhnfqeiwhgalptjyflpoiuqjjwdslpiswvxobfljnnwdhgdortezpulysoqddbxbwuqabdjqqhtzpxpjsvkjrvhjmzoralvzhlzkqkbgrwijvzspvcymafymfmfhaaghnfsdrvmlruuntmcqqbdqideprkxrmfbanvfeqrphnlwjxbzqcegmhnczxbslitnvotaemroadkjclksppzeyoiznlsytnopchritiyvlleqypiqgjugxeikpclipzxtgoebxcxkpdaoulecuajueretvpbkqbgwrkaooxbeaduvoaxlaifgblzwdcjtfpsxbsnrrovturokrovtycbcqcytfjomygj",
                "baxtr");
        System.out.println(result);
    }

    @Test
    public void testMinWindow5() {
        String result = new MinWindow().minWindow("aa",
                "aa");
        System.out.println(result);
    }
}