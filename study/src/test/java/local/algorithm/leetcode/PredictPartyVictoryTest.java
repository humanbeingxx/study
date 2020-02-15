package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2020-02-15
 **/
public class PredictPartyVictoryTest {

    @Test
    public void testPredictPartyVictory1() {
        String result = new PredictPartyVictory().predictPartyVictory("RD");
        assertEquals(result, "Radiant");
    }

    @Test
    public void testPredictPartyVictory2() {
        String result = new PredictPartyVictory().predictPartyVictory("RDD");
        assertEquals(result, "Dire");
    }

    @Test
    public void testPredictPartyVictory3() {
        String result = new PredictPartyVictory().predictPartyVictory("RDRDRDD");
        assertEquals(result, "Radiant");
    }

    @Test
    public void testPredictPartyVictory4() {
        String result = new PredictPartyVictory().predictPartyVictory("DDRRR");
        assertEquals(result, "Dire");
    }
}