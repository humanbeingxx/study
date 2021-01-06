package local.algorithm;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class FindItineraryTest {

    @Test
    public void testFindItinerary1() {
        List<String> result = new FindItinerary().findItinerary(Lists.newArrayList(
                Lists.newArrayList("MUC", "LHR"),
                Lists.newArrayList("JFK", "MUC"),
                Lists.newArrayList("SFO", "SJC"),
                Lists.newArrayList("LHR", "SFO")
        ));
        assertEquals(result, Lists.newArrayList("JFK", "MUC", "LHR", "SFO", "SJC"));
    }

    @Test
    public void testFindItinerary2() {
        List<String> result = new FindItinerary().findItinerary(Lists.newArrayList(
                Lists.newArrayList("JFK", "SFO"),
                Lists.newArrayList("JFK", "ATL"),
                Lists.newArrayList("SFO", "ATL"),
                Lists.newArrayList("ATL", "JFK"),
                Lists.newArrayList("ATL", "SFO")
        ));
        System.out.println(result);
        assertEquals(result, Lists.newArrayList("JFK", "ATL", "JFK", "SFO", "ATL", "SFO"));
    }

    @Test
    public void testFindItinerary3() {
        List<String> result = new FindItinerary().findItinerary(Lists.newArrayList(
                Lists.newArrayList("JFK", "SFO"),
                Lists.newArrayList("JFK", "ATL"),
                Lists.newArrayList("SFO", "ATL"),
                Lists.newArrayList("ATL", "JFK"),
                Lists.newArrayList("ATL", "SFO")
        ));
        System.out.println(result);
        assertEquals(result, Lists.newArrayList("JFK", "ATL", "JFK", "SFO", "ATL", "SFO"));
    }

    @Test
    public void testFindItinerary4() {
        List<String> result = new FindItinerary().findItinerary(Lists.newArrayList(
                Lists.newArrayList("JFK", "B"),
                Lists.newArrayList("JFK", "A"),
                Lists.newArrayList("B", "C"),
                Lists.newArrayList("C", "D"),
                Lists.newArrayList("A", "X"),
                Lists.newArrayList("D", "JFK")
        ));
        System.out.println(result);
        assertEquals(result, Lists.newArrayList("JFK", "B", "C", "D", "JFK", "A", "X"));
    }

    @Test
    public void testFindItinerary5() {

        List<String> result = new FindItinerary().findItinerary(Lists.newArrayList(
                Lists.newArrayList("EZE", "AXA"),
                Lists.newArrayList("TIA", "ANU"),
                Lists.newArrayList("ANU", "JFK"),
                Lists.newArrayList("JFK", "ANU"),
                Lists.newArrayList("ANU", "EZE"),
                Lists.newArrayList("TIA", "ANU"),
                Lists.newArrayList("AXA", "TIA"),
                Lists.newArrayList("TIA", "JFK"),
                Lists.newArrayList("ANU", "TIA"),
                Lists.newArrayList("JFK", "TIA")
        ));
        System.out.println(result);
        assertEquals(result, Lists.newArrayList("JFK", "ANU", "EZE", "AXA", "TIA", "ANU", "JFK", "TIA", "ANU", "TIA", "JFK"));
    }
}