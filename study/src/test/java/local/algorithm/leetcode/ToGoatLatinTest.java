package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-27
 **/
public class ToGoatLatinTest {

    @Test
    public void testToGoatLatin() {
        String result = new ToGoatLatin().toGoatLatin("I speak Goat Latin");
        assertEquals(result, "Imaa peaksmaaa oatGmaaaa atinLmaaaaa");

        result = new ToGoatLatin().toGoatLatin("The quick brown fox jumped over the lazy dog");
        assertEquals(result, "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa");
    }
}