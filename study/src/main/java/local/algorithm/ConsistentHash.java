package local.algorithm;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.collections.CollectionUtils;

import java.util.*;

/**
 * Copyright © 2018 QUNAR.COM. All rights reserved.
 *
 * @author xiaoshuang.cui
 * @date 2018/9/5 下午8:52
 **/
public class ConsistentHash {

    private List<HashNode> hashNodes = Lists.newArrayList();

    protected ConsistentHash() {
    }

    public ConsistentHash(List<String> nodes) {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(nodes));
        Set<HashNode> set = Sets.newTreeSet();
        for (String node : nodes) {
            set.add(new HashNode(node, hashNode(node)));
        }
        hashNodes.addAll(set);
    }

    public void addNode(String newNode) {
        int hashCode = unionHash(newNode);
        for (int i = 0; i < hashNodes.size(); i++) {
            if (hashNodes.get(i).code > hashCode){
                hashNodes.add(i, new HashNode(newNode, hashNode(newNode)));
                return;
            }
        }
        hashNodes.add(new HashNode(newNode, hashNode(newNode)));
    }

    public void removeNode(String oldNode) {
        Iterator<HashNode> iterator = hashNodes.iterator();
        while (iterator.hasNext()) {
            HashNode next =  iterator.next();
            if (next.code == unionHash(oldNode)) {
                iterator.remove();
                return;
            }
        }
    }

    public String hashTo(String searcher) {
        int hashCode = unionHash(searcher);
        for (int i = 0; i < hashNodes.size() - 1; i++) {
            HashNode current = hashNodes.get(i);
            HashNode next = hashNodes.get(i + 1);
            if (current.code < hashCode && next.code >= hashCode) {
                return next.identity;
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

    @AllArgsConstructor
    @Getter
    private class HashNode implements Comparable<HashNode> {

        private String identity;
        private int code;

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
        return "ConsistentHash{" +
                "hashNodes=" + hashNodes +
                '}';
    }
}
