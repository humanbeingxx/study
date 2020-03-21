package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RankTeamsTest {

    @Test
    public void testRankTeams1() {
        String result = new RankTeams().rankTeams(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"});
        assertEquals(result, "ACB");
    }

    @Test
    public void testRankTeams2() {
        String result = new RankTeams().rankTeams(new String[]{"WXYZ", "XYZW"});
        assertEquals(result, "XWYZ");
    }

    @Test
    public void testRankTeams3() {
        String result = new RankTeams().rankTeams(new String[]{"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"});
        assertEquals(result, "ABC");
    }

    @Test
    public void testRankTeams4() {
        String result = new RankTeams().rankTeams(new String[]{"M", "M", "M", "M"});
        assertEquals(result, "M");
    }
}