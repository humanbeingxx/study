package local.algorithm;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class WeightedRoundRobinTest {

    @Test
    public void testNext() {
        WeightedRoundRobin<Integer> robin = new WeightedRoundRobin<Integer>(
                Lists.newArrayList(
                        new WeightedRoundRobin.Node<>(0, 5),
                        new WeightedRoundRobin.Node<>(0, 1),
                        new WeightedRoundRobin.Node<>(0, 1),
                        new WeightedRoundRobin.Node<>(0, 1),
                        new WeightedRoundRobin.Node<>(0, 1)
                )
        );
        List<WeightedRoundRobin.Node<Integer>> result = Lists.newArrayList();
        for (int i = 0; i < 90; i++) {
            result.add(robin.next());
        }
        System.out.println(result.stream().map(WeightedRoundRobin.Node::getWeight).map(Object::toString).collect(Collectors.joining(",")));
        assertEquals(result.stream().map(WeightedRoundRobin.Node::getWeight).filter(integer -> integer == 5).count(), 50);
        assertEquals(result.stream().map(WeightedRoundRobin.Node::getWeight).filter(integer -> integer == 1).count(), 40);
    }
}