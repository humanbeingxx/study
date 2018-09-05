package local.algorithm;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.collections.CollectionUtils;

import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author xiaoshuang.cui
 * @date 2018/9/5 下午8:52
 **/
public class ConsistentHashWithFake {

    private final static Random RANDOM = new Random();

    private List<HashNode> hashNodes = Lists.newArrayList();

    public List<HashNode> getHashNodes() {
        return hashNodes;
    }

    public ConsistentHashWithFake(List<String> nodes) {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(nodes));
        Set<HashNode> set = Sets.newTreeSet();
        for (String node : nodes) {
            set.add(new HashNode(node, false));
        }
        hashNodes.addAll(set);
        supplyFakeNodes();
    }

    private void supplyFakeNodes() {
        List<HashNode> trueNodeList = hashNodes.stream().filter((Predicate<HashNode>) input -> !input.isFake).collect(Collectors.toList());
        TreeSet<HashNode> trueNodeSet = Sets.newTreeSet(trueNodeList);
        for (HashNode hashNode : trueNodeList) {
            trueNodeSet.addAll(makeFakeNodes(hashNode.identity, 10));
        }
        hashNodes.clear();
        hashNodes.addAll(trueNodeSet);
    }

    public void addNode(String newNode) {
        addNode(new HashNode(newNode, false));
        supplyFakeNodes();
    }

    private void addNode(HashNode node) {
        int hashCode = node.code;
        for (int i = 0; i < hashNodes.size(); i++) {
            if (hashNodes.get(i).code > hashCode){
                hashNodes.add(i, node);
                return;
            }
        }
        hashNodes.add(node);
    }

    public void removeNode(String oldNode) {
        Iterator<HashNode> iterator = hashNodes.iterator();
        while (iterator.hasNext()) {
            HashNode next =  iterator.next();
            if (next.code == oldNode.hashCode()) {
                iterator.remove();
                break;
            }
        }
        supplyFakeNodes();
    }

    private List<HashNode> makeFakeNodes(String trueNodeName, int times) {
        List<HashNode> result = Lists.newArrayList();
        for (int i = 1; i < times + 1; i++) {
            result.add(new HashNode(trueNodeName + "_fake#" + i, true));
        }
        return result;
    }

    public String hashTo(String searcher) {
        int hashCode = searcher.hashCode();
        for (int i = 0; i < hashNodes.size() - 1; i++) {
            HashNode current = hashNodes.get(i);
            HashNode next = hashNodes.get(i + 1);
            if (current.code < hashCode && next.code >= hashCode) {
                return next.identity.replaceAll("_fake#\\d+", "");
            }
        }
        return hashNodes.get(0).identity;
    }

    private int hashNode(String node) {
        return unionHash(node) % Integer.MAX_VALUE;
    }

    private int unionHash(String value) {
        return Math.abs(value.hashCode());
    }

    private class HashNode implements Comparable<HashNode> {

        private String identity;
        private int code;
        private boolean isFake;

        public HashNode(String identity) {
            this.identity = identity;
            isFake = false;
        }

        public HashNode(String identity, boolean isFake) {
            this.identity = identity;
            this.code = hashNode(identity);
            this.isFake = isFake;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            HashNode hashNode = (HashNode) o;
            return code == hashNode.code;
        }

        @Override
        public int hashCode() {

            return Objects.hash(code);
        }

        @Override
        public int compareTo(HashNode o) {
            return Integer.compare(this.code, o.code);
        }

        @Override
        public String toString() {
            return "HashNode{" +
                    "identity='" + identity + '\'' +
                    ", code=" + code +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ConsistentHashWithFake{" +
                "hashNodes=" + hashNodes +
                '}';
    }
}
