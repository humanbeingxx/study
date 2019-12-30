package local.algorithm.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class ReverseWords {

    public String reverseWords(String s) {
        return Arrays.stream(s.split(" "))
                .map(e -> new StringBuilder(e).reverse().toString())
                .collect(Collectors.joining(" "));
    }
}
