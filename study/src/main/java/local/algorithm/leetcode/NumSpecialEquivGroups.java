package local.algorithm.leetcode;

import java.util.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-18
 **/
public class NumSpecialEquivGroups {

    class CharCount {
        Map<Character, Integer> odd = new HashMap<>();
        Map<Character, Integer> even = new HashMap<>();

        public void put(char c, int index) {
            if (index % 2 == 1) {
                put(c, odd);
            } else {
                put(c, even);
            }
        }

        private void put(char c, Map<Character, Integer> map) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CharCount charCount = (CharCount) o;
            return Objects.equals(odd, charCount.odd) &&
                    Objects.equals(even, charCount.even);
        }

        @Override
        public int hashCode() {
            return Objects.hash(odd, even);
        }
    }

    public int numSpecialEquivGroups(String[] A) {
        Map<CharCount, List<String>> groups = new HashMap<>();
        for (String a : A) {
            CharCount charCount = countChar(a);
            if (groups.containsKey(charCount)) {
                groups.get(charCount).add(a);
            } else {
                List<String> countList = new ArrayList<>();
                countList.add(a);
                groups.put(charCount, countList);
            }
        }
        return groups.size();
    }

    private CharCount countChar(String a) {
        CharCount charCount = new CharCount();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            charCount.put(c, i);
        }
        return charCount;
    }

}
